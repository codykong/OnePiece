//package com.xten.op.balkimo.classloader
//
//import java.io._
//import java.net.MalformedURLException
//import java.net.URL
//import java.nio.file.Path
//import java.nio.file.Paths
//import java.util._
//import java.util.jar.JarEntry
//import java.util.jar.JarFile
//
///**
//  * Created with IntelliJ IDEA.
//  * User: kongqingyu
//  * Date: 2017/7/13
//  * Time: 下午4:06
//  */
//object PackagedProgram {
//  /**
//    * Takes all JAR files that are contained in this program's JAR file and extracts them
//    * to the system's temp directory.
//    *
//    * @return The file names of the extracted temporary files.
//    * @throws ProgramInvocationException Thrown, if the extraction process failed.
//    */
//    @throws[ProgramInvocationException]
//    def extractContainedLibraries(jarFile: URL): util.List[File] = {
//      val rnd = new Random
//      var jar = null
//      try {
//        jar = new JarFile(new File(jarFile.toURI))
//        val containedJarFileEntries = new util.ArrayList[JarEntry]
//        val entries = jar.entries
//        while ( {
//          entries.hasMoreElements
//        }) {
//          val entry = entries.nextElement
//          val name = entry.getName
//          if (name.length > 8 && name.startsWith("lib/") && name.endsWith(".jar")) containedJarFileEntries.add(entry)
//        }
//        if (containedJarFileEntries.isEmpty) Collections.emptyList
//        else { // go over all contained jar files
//          val extractedTempLibraries = new util.ArrayList[File](containedJarFileEntries.size)
//          val buffer = new Array[Byte](4096)
//          var incomplete = true
//          try {
//            var i = 0
//            while ( {
//              i < containedJarFileEntries.size
//            }) {
//              val entry = containedJarFileEntries.get(i)
//              var name = entry.getName
//              name = name.replace(File.separatorChar, '_')
//              var tempFile = null
//              try {
//                tempFile = File.createTempFile(rnd.nextInt(Integer.MAX_VALUE) + "_", name)
//                tempFile.deleteOnExit()
//              } catch {
//                case e: IOException =>
//                  throw new ProgramInvocationException("An I/O error occurred while creating temporary file to extract nested library '" + entry.getName + "'.", e)
//              }
//              extractedTempLibraries.add(tempFile)
//              // copy the temp file contents to a temporary File
//              var out = null
//              var in = null
//              try {
//                out = new FileOutputStream(tempFile)
//                in = new BufferedInputStream(jar.getInputStream(entry))
//                var numRead = 0
//                while ( {
//                  (numRead = in.read(buffer)) != -1
//                }) out.write(buffer, 0, numRead)
//              } catch {
//                case e: IOException =>
//                  throw new ProgramInvocationException("An I/O error occurred while extracting nested library '" + entry.getName + "' to temporary file '" + tempFile.getAbsolutePath + "'.")
//              } finally {
//                if (out != null) out.close()
//                if (in != null) in.close()
//              }
//              {
//                i += 1; i - 1
//              }
//            }
//            incomplete = false
//          } finally if (incomplete) deleteExtractedLibraries(extractedTempLibraries)
//          extractedTempLibraries
//        }
//      } catch {
//        case t: Throwable =>
//          throw new ProgramInvocationException("Unknown I/O error while extracting contained jar files.", t)
//      } finally if (jar != null) try jar.close()
//      catch {
//        case t: Throwable =>
//      }
//    }
//
//  def deleteExtractedLibraries(tempLibraries: util.List[File]): Unit = {
//    import scala.collection.JavaConversions._
//    for (f <- tempLibraries) {
//      f.delete
//    }
//  }
//
//  @throws[ProgramInvocationException]
//  private def loadMainClass(className: String, cl: ClassLoader) = {
//    var contextCl = null
//    try {
//      contextCl = Thread.currentThread.getContextClassLoader
//      Thread.currentThread.setContextClassLoader(cl)
//      Class.forName(className, false, cl)
//    } catch {
//      case e: ClassNotFoundException =>
//        throw new ProgramInvocationException("The program's entry point class '" + className + "' was not found in the jar file.", e)
//      case e: ExceptionInInitializerError =>
//        throw new ProgramInvocationException("The program's entry point class '" + className + "' threw an error during initialization.", e)
//      case e: LinkageError =>
//        throw new ProgramInvocationException("The program's entry point class '" + className + "' could not be loaded due to a linkage failure.", e)
//      case t: Throwable =>
//        throw new ProgramInvocationException("The program's entry point class '" + className + "' caused an exception during initialization: " + t.getMessage, t)
//    } finally if (contextCl != null) Thread.currentThread.setContextClassLoader(contextCl)
//  }
//}
//
//class PackagedProgram @throws[ProgramInvocationException]
//@throws[MalformedURLException]
//(val jarFilePath: String, val entryPointClassName: String) // load the entry point class
////        this.mainClass = loadMainClass(entryPointClassName, userCodeClassLoader);
//{
//  val jarFile = new File(jarFilePath)
//  val jarPath: Path = Paths.get(jarFilePath)
//  try jarFileURL = jarFile.getAbsoluteFile.toURI.toURL
//  catch {
//    case e1: MalformedURLException =>
//      throw new IllegalArgumentException("The jar file path is invalid.")
//  }
//  // now that we have an entry point, we can extract the nested jar files (if any)
//  this.extractedTempLibraries = PackagedProgram.extractContainedLibraries(jarFileURL)
//  this.userCodeClassLoader = JobWithJars.buildUserCodeClassLoader(getAllLibraries, classpaths, getClass.getClassLoader)
//  final private var jarFileURL = null
//  final private var extractedTempLibraries = null
//  final private val classpaths = new util.ArrayList[URL]
//  private var userCodeClassLoader = null
//
//  def this(jarFilePath: String) {
//    this(jarFilePath, null)
//  }
//
//  /**
//    * Returns all provided libraries needed to run the program.
//    */
//  def getAllLibraries: util.List[URL] = {
//    val libs = new util.ArrayList[URL](this.extractedTempLibraries.size + 1)
//    if (jarFileURL != null) libs.add(jarFileURL)
//    import scala.collection.JavaConversions._
//    for (tmpLib <- this.extractedTempLibraries) {
//      try libs.add(tmpLib.getAbsoluteFile.toURI.toURL)
//      catch {
//        case e: MalformedURLException =>
//          throw new RuntimeException("URL is invalid. This should not happen.", e)
//      }
//    }
//    libs
//  }
//
//  /**
//    * Gets the {@link ClassLoader} that must be used to load user code classes.
//    *
//    * @return The user code ClassLoader.
//    */
//  def getUserCodeClassLoader: ClassLoader = this.userCodeClassLoader
//
//  //    public String getMainClassName() {
//  //        return this.mainClass.getName();
//  //    }
//  //    public Class<?> getMainClass() {
//  //        return this.mainClass;
//  //    }
//}