package framework.tests.amazon;

import annotations.FrameworkAnnotation;
import framework.BaseTest;
import framework.pages.amazon.AmazonHomePage;
import org.testng.annotations.Test;
import reports.ExtentManager;

import java.util.Map;

public final class AmazonTest extends BaseTest {

    private AmazonTest(){}

    @FrameworkAnnotation(author = {"Iryna", "Mariia"}, category = {"Smoke", "Regression"})
    @Test
    public void testAmazon(Map<String, String> data) {

        // @FrameworkAnnotation used instead
        /*ExtentManager.getExtentTest().assignAuthor("Iryna").assignAuthor("Mariia")
                .assignCategory("Smoke").assignCategory("Regression");*/

        String title = new AmazonHomePage()
                .clickHamburger()
                .clickComputers()
                .clickSubMenuItem(data.get("menutext"))
                .getTitle();
        System.out.println("title = " + title);
    }

}
