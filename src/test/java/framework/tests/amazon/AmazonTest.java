package framework.tests.amazon;

import framework.BaseTest;
import framework.pages.amazon.AmazonHomePage;
import org.testng.annotations.Test;

import java.util.Map;

public final class AmazonTest extends BaseTest {

    private AmazonTest(){}

    @Test
    public void testAmazon(Map<String, String> data) {
        String title = new AmazonHomePage()
                .clickHamburger()
                .clickComputers()
                .clickComputerComponents()
                .getTitle();
        System.out.println("title = " + title);
    }

}
