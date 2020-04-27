package at.fhv.itb6.se.plugin;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class ExternalJarLoader {

    public static Object LoadClass(String directory, String classpath) throws ClassNotFoundException {
        File pluginsDir = new File(directory);
        if (pluginsDir.exists()) {
            for (File jar : pluginsDir.listFiles()) {
                try {
                    ClassLoader loader = URLClassLoader.newInstance(
                            new URL[]{jar.toURL()},
                            ClassLoader.getSystemClassLoader()
                    );
                    return Class.forName(classpath, true, loader).newInstance();
                } catch (ClassNotFoundException e) {
                    continue;
                } catch (MalformedURLException
                        | IllegalAccessException
                        | InstantiationException e) {
                    e.printStackTrace();
                }
            }
        }
        throw new ClassNotFoundException("Class " + classpath
                + " wasn't found in directory " + System.getProperty("user.dir") + directory);
    }
}
