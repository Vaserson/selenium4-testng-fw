package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public final class ReadPropertyFile {

    private ReadPropertyFile() {}

    public static String getProperty(String key) throws IOException {
        Properties property = new Properties();
        FileInputStream file = new FileInputStream("src/main/resources/config.properties");
        property.load(file);
        return property.getProperty(key);
    }
}
