package constants;

public final class Constants {

    private Constants() {}

    private static final String CHROMEDRIVERPATH = "src/test/resources/Drivers/chromedriver";
    private static final int EXPLICITWAIT = 10;

    public static String getChromedriverpath() {
        return CHROMEDRIVERPATH;
    }

    public static int getExplicitwait() {
        return EXPLICITWAIT;
    }
}
