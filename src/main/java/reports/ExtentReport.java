package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class ExtentReport {
    private static ExtentReports extent;
    public static ExtentTest test;

    private ExtentReport(){}

    public static void initReports() {
        if (Objects.isNull(extent)) {
        extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("index.html");
        extent.attachReporter(spark);

        spark.config().setTheme(Theme.DARK);
        spark.config().setDocumentTitle("Automation Report");
        spark.config().setReportName("Report Training");
        }
    }

    public static void createTest(String testName) {
        test = extent.createTest(testName);
    }

    public static void flushReports() throws IOException {
        if (Objects.nonNull(extent)) {
        extent.flush();
        Desktop.getDesktop().browse(new File("index.html").toURI()); // Opens in default system browser
        }
    }
}
