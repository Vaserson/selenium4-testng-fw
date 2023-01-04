package constants;

public final class Constants {

    private Constants() {}

    private static final String CHROMEDRIVERPATH = "src/test/resources/Drivers/chromedriver";

    public static String getChromedriverpath() {
        return CHROMEDRIVERPATH;
    }
}
