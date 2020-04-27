package at.fhv.itb6.se.plugin;

import java.io.IOException;
import java.util.Properties;

public class PluginFactory {
    private static Properties _props;

    static{
        loadProperties();
    }

    public static void loadProperties(){
        _props = new Properties();
        try{
            String propsFile = System.getProperty("plugins");
            _props.load(ClassLoader.getSystemResourceAsStream(propsFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object getPlugin(Class iface){
        String implName = _props.getProperty(iface.getSimpleName());
        if(implName == null){
            throw new RuntimeException(
                    "Implementation not specified for " + iface.getName() + " in PluginFactory properties.");
        }
        try{
            return Class.forName("at.fhv.itb6.se.plugin.generators." + implName).newInstance();
        } catch (Exception ex) {
            throw new RuntimeException("Factory unable to construct instance of " + iface.getName());
        }
    }
}
