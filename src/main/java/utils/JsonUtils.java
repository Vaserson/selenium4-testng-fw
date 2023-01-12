package utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import constants.Constants;
import enums.ConfigProperty;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

public class JsonUtils {

    private JsonUtils() {}
    private static Map<String, String> CONFIGMAP = new HashMap<>();

    static {
        try {
            CONFIGMAP = new ObjectMapper().readValue(new File(Constants.getJsonConfigFilePath()), new TypeReference<>() {});
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

    public static String get(String key) throws Exception {
        if (Objects.isNull(key) || Objects.isNull(CONFIGMAP.get(key.toLowerCase()))) {
            throw new Exception("No " + key + " property found");
        }
        return CONFIGMAP.get(key.toLowerCase());
    }

}
