package framework;

import driver.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import reports.ExtentReport;

import java.io.IOException;

public class BaseTest {

    protected BaseTest() {}

    // Not a good place for keeping Report setup
/*    @BeforeSuite
    public void beforeSuite() {
        *//* ------------- SetUp ------------- *//*
        ExtentReports extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("index.html");
        extent.attachReporter(spark);

        spark.config().setTheme(Theme.DARK);
        spark.config().setDocumentTitle("Automation Report");
        spark.config().setReportName("Report Training");
        *//* ----------- SetUp ends ----------- *//*
    }*/
    @BeforeSuite
    public void beforeSuite() {
        ExtentReport.initReports();
    }

    @AfterSuite
    public void afterSuite() throws IOException {
        ExtentReport.flushReports();
    }


    @BeforeMethod
    protected void setUp() throws Exception {
        Driver.initDriver();
    }

    @AfterMethod
    protected void tearDown() {
        Driver.quitDriver();
    }
}