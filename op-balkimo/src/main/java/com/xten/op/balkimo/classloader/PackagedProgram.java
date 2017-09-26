package com.xten.op.balkimo.classloader;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * Created with IntelliJ IDEA.
 * User: kongqingyu
 * Date: 2017/7/13
 * Time: 下午4:06
 */
public class PackagedProgram {

    // abwaimaicd
    private final URL jarFileURL;

    private final List<File> extractedTempLibraries;

    private final List<URL> classpaths = new ArrayList<>();

    private ClassLoader userCodeClassLoader;

//    private final Class<?> mainClass;


    public PackagedProgram(String jarFilePath, String entryPointClassName) throws ProgramInvocationException, MalformedURLException {

        File jarFile = new File(jarFilePath);
        Path jarPath = Paths.get(jarFilePath);
        try {
            jarFileURL = jarFile.getAbsoluteFile().toURI().toURL();
        } catch (MalformedURLException e1) {
            throw new IllegalArgumentException("The jar file path is invalid.");
        }

        // now that we have an entry point, we can extract the nested jar files (if any)
        this.extractedTempLibraries = extractContainedLibraries(jarFileURL);
        this.userCodeClassLoader = JobWithJars.buildUserCodeClassLoader(getAllLibraries(), classpaths, getClass().getClassLoader());

        // load the entry point class
//        this.mainClass = loadMainClass(entryPointClassName, userCodeClassLoader);
    }



    public PackagedProgram(String jarFilePath) throws ProgramInvocationException, MalformedURLException  {
        this(jarFilePath,null);
    }


    /**
     * Takes all JAR files that are contained in this program's JAR file and extracts them
     * to the system's temp directory.
     *
     * @return The file names of the extracted temporary files.
     * @throws ProgramInvocationException Thrown, if the extraction process failed.
     */
    public static List<File> extractContainedLibraries(URL jarFile) throws ProgramInvocationException {

        Random rnd = new Random();

        JarFile jar = null;
        try {
            jar = new JarFile(new File(jarFile.toURI()));
            final List<JarEntry> containedJarFileEntries = new ArrayList<JarEntry>();

            Enumeration<JarEntry> entries = jar.entries();
            while (entries.hasMoreElements()) {
                JarEntry entry = entries.nextElement();
                String name = entry.getName();

                if (name.length() > 8 && name.startsWith("lib/") && name.endsWith(".jar")) {
                    containedJarFileEntries.add(entry);
                }
            }

            if (containedJarFileEntries.isEmpty()) {
                return Collections.emptyList();
            }
            else {
                // go over all contained jar files
                final List<File> extractedTempLibraries = new ArrayList<File>(containedJarFileEntries.size());
                final byte[] buffer = new byte[4096];

                boolean incomplete = true;

                try {
                    for (int i = 0; i < containedJarFileEntries.size(); i++) {
                        final JarEntry entry = containedJarFileEntries.get(i);
                        String name = entry.getName();
                        name = name.replace(File.separatorChar, '_');

                        File tempFile;
                        try {
                            tempFile = File.createTempFile(rnd.nextInt(Integer.MAX_VALUE) + "_", name);
                            tempFile.deleteOnExit();
                        }
                        catch (IOException e) {
                            throw new ProgramInvocationException(
                                    "An I/O error occurred while creating temporary file to extract nested library '" +
                                            entry.getName() + "'.", e);
                        }

                        extractedTempLibraries.add(tempFile);

                        // copy the temp file contents to a temporary File
                        OutputStream out = null;
                        InputStream in = null;
                        try {


                            out = new FileOutputStream(tempFile);
                            in = new BufferedInputStream(jar.getInputStream(entry));

                            int numRead = 0;
                            while ((numRead = in.read(buffer)) != -1) {
                                out.write(buffer, 0, numRead);
                            }
                        }
                        catch (IOException e) {
                            throw new ProgramInvocationException("An I/O error occurred while extracting nested library '"
                                    + entry.getName() + "' to temporary file '" + tempFile.getAbsolutePath() + "'.");
                        }
                        finally {
                            if (out != null) {
                                out.close();
                            }
                            if (in != null) {
                                in.close();
                            }
                        }
                    }

                    incomplete = false;
                }
                finally {
                    if (incomplete) {
                        deleteExtractedLibraries(extractedTempLibraries);
                    }
                }

                return extractedTempLibraries;
            }
        }
        catch (Throwable t) {
            throw new ProgramInvocationException("Unknown I/O error while extracting contained jar files.", t);
        }
        finally {
            if (jar != null) {
                try {
                    jar.close();
                } catch (Throwable t) {}
            }
        }
    }

    public static void deleteExtractedLibraries(List<File> tempLibraries) {
        for (File f : tempLibraries) {
            f.delete();
        }
    }

    /**
     * Returns all provided libraries needed to run the program.
     */
    public List<URL> getAllLibraries() {
        List<URL> libs = new ArrayList<URL>(this.extractedTempLibraries.size() + 1);

        if (jarFileURL != null) {
            libs.add(jarFileURL);
        }
        for (File tmpLib : this.extractedTempLibraries) {
            try {
                libs.add(tmpLib.getAbsoluteFile().toURI().toURL());
            }
            catch (MalformedURLException e) {
                throw new RuntimeException("URL is invalid. This should not happen.", e);
            }
        }

        return libs;
    }

    /**
     * Gets the {@link ClassLoader} that must be used to load user code classes.
     *
     * @return The user code ClassLoader.
     */
    public ClassLoader getUserCodeClassLoader() {
        return this.userCodeClassLoader;
    }

    private static Class<?> loadMainClass(String className, ClassLoader cl) throws ProgramInvocationException {
        ClassLoader contextCl = null;
        try {
            contextCl = Thread.currentThread().getContextClassLoader();
            Thread.currentThread().setContextClassLoader(cl);
            return Class.forName(className, false, cl);
        }
        catch (ClassNotFoundException e) {
            throw new ProgramInvocationException("The program's entry point class '" + className
                    + "' was not found in the jar file.", e);
        }
        catch (ExceptionInInitializerError e) {
            throw new ProgramInvocationException("The program's entry point class '" + className
                    + "' threw an error during initialization.", e);
        }
        catch (LinkageError e) {
            throw new ProgramInvocationException("The program's entry point class '" + className
                    + "' could not be loaded due to a linkage failure.", e);
        }
        catch (Throwable t) {
            throw new ProgramInvocationException("The program's entry point class '" + className
                    + "' caused an exception during initialization: "+ t.getMessage(), t);
        } finally {
            if (contextCl != null) {
                Thread.currentThread().setContextClassLoader(contextCl);
            }
        }
    }

//    public String getMainClassName() {
//        return this.mainClass.getName();
//    }

//    public Class<?> getMainClass() {
//        return this.mainClass;
//    }

}
