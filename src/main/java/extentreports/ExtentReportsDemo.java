package extentreports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ExtentReportsDemo {

    @Test
    public void test1() throws IOException {
        /* ------------- SetUp ------------- */
        ExtentReports extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("index.html");
        extent.attachReporter(spark);

        spark.config().setTheme(Theme.DARK);
        spark.config().setDocumentTitle("Automation Report");
        spark.config().setReportName("Report Training");
        /* ----------- SetUp ends ----------- */


        ExtentTest test1 = extent.createTest("First test");
        test1.pass("first extent test PASS");

        ExtentTest test2 = extent.createTest("Second test");
        test2.fail("second extent test FAIL");


        /* ------------- TearDown ------------- */
        extent.flush();
        Desktop.getDesktop().browse(new File("index.html").toURI()); // Opens in default system browser
        /* ----------- TearDown ends ----------- */

    }
}
