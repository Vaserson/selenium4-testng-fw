package constants;

import enums.ConfigProperty;
import utils.PropertyUtils;

public final class Constants {

    private Constants() {}

    private static final String CHROMEDRIVERPATH = "src/test/resources/Drivers/chromedriver";
    private static final String GECKODRIVERPATH = "src/test/resources/Drivers/geckodriver";
    private static final String JSONCONFIGFILEPATH = "src/main/java/utils/properties.json";
    private static final int EXPLICITWAIT = 10;
    private static final String EXTENTREPORTFOLDERPATH = "extent-report-output/";
    private static final String TESTDATAPATH = "src/test/resources/excel/testData.xlsx";
    private static  String extentReportFilePath = "";


    public static String getExtentReportFilePath() throws Exception {
        if (extentReportFilePath.isEmpty()) {
            extentReportFilePath = createReportPath();
        }
        return extentReportFilePath;
    }

    private static String createReportPath() throws Exception {
        if (PropertyUtils.get(ConfigProperty.OVERRIDEREPORTS).equalsIgnoreCase("no")) {
            return EXTENTREPORTFOLDERPATH + System.currentTimeMillis() + "_index.html";
        } else {
            return EXTENTREPORTFOLDERPATH + "index.html";
        }
    }

    public static String getChromeDriverPath() {
        return CHROMEDRIVERPATH;
    }

    public static String getGeckoDriverPath() {
        return GECKODRIVERPATH;
    }

    public static String getJsonConfigFilePath() {
        return JSONCONFIGFILEPATH;
    }


    public static int getExplicitwait() {
        return EXPLICITWAIT;
    }


    public static String getTestDataPath() {
        return TESTDATAPATH;
    }
}
