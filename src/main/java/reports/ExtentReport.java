package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import constants.Constants;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class ExtentReport {
    private static ExtentReports extent;
//    public static ExtentTest test; // No need after ExtentManager is added

    private ExtentReport(){}

    public static void initReports() throws Exception {
        if (Objects.isNull(extent)) {
        extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter(Constants.getExtentReportFilePath());
        extent.attachReporter(spark);

        spark.config().setTheme(Theme.DARK);
        spark.config().setDocumentTitle("Automation Report");
        spark.config().setReportName("Report Training");
        }
    }

    public static void createTest(String testName) {
        /*ExtentTest test = extent.createTest(testName);
        ExtentManager.setExtentTest(test);*/ //----- OR
        ExtentManager.setExtentTest(extent.createTest(testName));
    }

    public static void flushReports() throws Exception {
        if (Objects.nonNull(extent)) {
        extent.flush();
        }
        ExtentManager.unload();
        Desktop.getDesktop().browse(new File(Constants.getExtentReportFilePath()).toURI()); // Opens in default system browser
    }
}
