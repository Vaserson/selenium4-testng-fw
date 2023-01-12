package constants;

public final class Constants {

    private Constants() {}

    private static final String CHROMEDRIVERPATH = "src/test/resources/Drivers/chromedriver";
    private static final String JSONCONFIGFILEPATH = "src/main/java/utils/properties.json";
    private static final int EXPLICITWAIT = 10;

    public static String getChromedriverpath() {
        return CHROMEDRIVERPATH;
    }

    public static String getJsonConfigFilePath() {
        return JSONCONFIGFILEPATH;
    }


    public static int getExplicitwait() {
        return EXPLICITWAIT;
    }
}
