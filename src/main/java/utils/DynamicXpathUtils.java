package utils;

public final class DynamicXpathUtils {

    private DynamicXpathUtils(){}

    public static String getXpath(String xpath, String value) {
//        return xpath.replace("%replaceable%", value);
        return String.format(xpath, value);
    }

    public static String getXpath(String xpath, String value1, String value2) {
//        return xpath.replace("%replaceable1%", value1).replace("%replaceable2%", value2);
        return String.format(xpath, value1, value2);
    }
}
