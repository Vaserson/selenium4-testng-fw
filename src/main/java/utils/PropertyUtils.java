package utils;

import enums.ConfigProperty;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

public final class PropertyUtils {

    private PropertyUtils() {}
    private static Properties property = new Properties();
    private static final Map<String, String> CONFIGMAP = new HashMap<>();

    static {
        try {
            FileInputStream file = new FileInputStream("src/main/resources/orangeHRM.properties");
            property.load(file);
            for(Map.Entry<Object, Object> entry : property.entrySet()) {
                CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String get(ConfigProperty key) throws Exception {
        if (Objects.isNull(key) || Objects.isNull(CONFIGMAP.get(key.name().toLowerCase()))) {
            throw new Exception("No " + key + " property found");
        }
        return CONFIGMAP.get(key.name().toLowerCase());
    }

    public static String getProperty(String key) throws Exception {
        if (Objects.isNull(property.getProperty(key)) || Objects.isNull(key)) {
            throw new Exception("No " + key + " property found");
        }
        return property.getProperty(key);
    }
}