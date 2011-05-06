import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.objectweb.asm.ClassReader;

import sun.misc.URLClassPath;

public class JrePackageFinder {
    public static void main(String[] args) {
        
        ClassLoader classLoader = JrePackageFinder.class.getClassLoader().getParent();
        
        Set<String> packageNames = new TreeSet<String>();                
        
        while (classLoader != null) {        
            if (classLoader instanceof URLClassLoader) {                                
                URLClassLoader urlClassLoader = (URLClassLoader)classLoader;
                URL[] urls = urlClassLoader.getURLs();
                processUrls(urls, packageNames);
            } else {
                System.out.println("Cannot examine class loader " + classLoader);
            }
            
            classLoader = classLoader.getParent();
        }                
        
        try {
            String[] paths = System.getProperty("sun.boot.class.path").split(System.getProperty("path.separator"));
            URL[] urls = new URL[paths.length];
            for (int i=0; i<paths.length; i++) {
                urls[i] = new URL("file:/" + paths[i]);
            }
            processUrls(urls, packageNames);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }                
        
        Iterator<String> packageNamesIterator = packageNames.iterator();
        
        while (packageNamesIterator.hasNext()) {
            if (packageNamesIterator.next().startsWith("java.")) {
                packageNamesIterator.remove();
            }
        }               
        
        for (String packageName : packageNames) {
            System.out.println(packageName);
        }                                
    }

    private static void processUrls(URL[] urls, Set<String> packageNames) {
        for (URL url : urls) {
            try {
                File file = new File(url.toURI());
                if (file.exists() && file.getName().endsWith(".jar")) {
                    try {
                        processJar(file, packageNames);
                    } catch (IOException e) {
                        System.out.println("Failed to process jar " + file);
                        e.printStackTrace(System.out);
                    }
                }
            } catch (URISyntaxException urise) {
                urise.printStackTrace(System.out);
            }
        }
    }
    
    private static void processJar(File file, Set<String> packageNames) throws IOException {
        JarFile jar = new JarFile(file);
        Enumeration<JarEntry> entries = jar.entries();
        
        while (entries.hasMoreElements()) {
            JarEntry entry = entries.nextElement();
            if (entry.getName().endsWith(".class")) {
                processClass(jar, entry, packageNames);
            }
        }
    }
    
    private static void processClass(JarFile jar, JarEntry entry, Set<String> packageNames) throws IOException {
        ClassReader reader = new ClassReader(jar.getInputStream(entry));
        String packageName = getPackageName(reader.getClassName());
        if (packageName != null) {
            packageNames.add(packageName);
        }
    }
    
    private static String getPackageName(String className) {
        int index = className.lastIndexOf('/');
        if (index > 0) {
            return className.substring(0, index).replace('/', '.');            
        }
        return null;
    }
}
