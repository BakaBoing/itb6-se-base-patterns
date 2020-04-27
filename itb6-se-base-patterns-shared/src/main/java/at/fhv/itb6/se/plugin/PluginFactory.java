package at.fhv.itb6.se.plugin;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PluginFactory {
    private static Properties _props;
    private static String _classpath;
    private static String _externalPluginDirectory;

    static {
        loadProperties();
        _classpath = "at.fhv.itb6.se.plugin.generators";
        _externalPluginDirectory = "plugins";
    }

    public static void loadProperties() {
        _props = new Properties();
        try {
            String propsFile = System.getProperty("plugins");
            _props.load(new FileInputStream(propsFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object getPlugin(Class iface) {
        Object newInstance;
        String implName = _props.getProperty(iface.getSimpleName());
        if (implName == null) {
            throw new RuntimeException(
                    "Implementation not specified for " + iface.getName() + " in PluginFactory properties.");
        }
        try {
            String classWithPath = String.join(".", _classpath, implName);
            try {
                newInstance = Class.forName(classWithPath).newInstance();
            } catch (ClassNotFoundException ex) {
                newInstance = ExternalJarLoader.LoadClass(_externalPluginDirectory, classWithPath);
            }
        } catch (Exception ex) {
            throw new RuntimeException("Factory unable to construct instance of " + iface.getName());
        }

        return newInstance;
    }
}
