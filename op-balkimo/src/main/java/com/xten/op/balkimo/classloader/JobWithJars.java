package com.xten.op.balkimo.classloader;


import java.net.URL;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: kongqingyu
 * Date: 2017/7/13
 * Time: 下午4:12
 */
public class JobWithJars {

    public static ClassLoader buildUserCodeClassLoader(List<URL> jars, List<URL> classpaths, ClassLoader parent) {
        URL[] urls = new URL[jars.size() + classpaths.size()];
        for (int i = 0; i < jars.size(); i++) {
            urls[i] = jars.get(i);
        }
        for (int i = 0; i < classpaths.size(); i++) {
            urls[i + jars.size()] = classpaths.get(i);
        }
        return new UserCodeClassLoader(urls, parent.getParent());
    }

    public static ClassLoader buildUserAppClassLoader(List<URL> jars, List<URL> classpaths, ClassLoader parent) {
        URL[] urls = new URL[jars.size() + classpaths.size()];
        for (int i = 0; i < jars.size(); i++) {
            urls[i] = jars.get(i);
        }
        for (int i = 0; i < classpaths.size(); i++) {
            urls[i + jars.size()] = classpaths.get(i);
        }


        return new UserCodeClassLoader(urls, parent.getParent());
    }
}
