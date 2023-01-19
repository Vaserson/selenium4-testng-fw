package framework.orangeHRM.tests;

import framework.BaseTest;
import framework.orangeHRM.pages.HomePage;
import framework.orangeHRM.pages.LoginPage;
import listeners.RetryFailedTests;
import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import reports.ExtentReport;
import utils.DataProviderUtils;

import java.util.Map;

public final class LoginTests extends BaseTest {

    private LoginTests(){}

    @DataProvider(name = "LoginTestDataProvider", parallel = true) //!!! Set thread count in the testNG.xml <suite name="Suite" data-provider-thread-count="3">
    public Object[][] getData() {
        return new Object[][] {
                {"Admin", "admin123"}/*,
                {"Admin", "admin123"},
                {"Admin123", "admin"},
                {"Admin", "admin123"},
                {"Admin", "admin123"}*/
        };
    }

    @Test(dataProvider = "getData", dataProviderClass = DataProviderUtils.class, retryAnalyzer = RetryFailedTests.class)
    public void loginTest0(Map<String, String> data) {

//        ExtentReport.createTest("loginLogoutTest"); // Move to BaseTest and get method name dynamically

        LoginPage loginPage = new LoginPage();
        loginPage.enterUsername(data.get("username"))
                .enterPassword(data.get("password"))
                .clickSubmitBtn()
                .clickName()
                .clickLogoutBtn();
    }

    @Test(dataProvider = "getData", dataProviderClass = DataProviderUtils.class, retryAnalyzer = RetryFailedTests.class)
    public void loginTest1(Map<String, String> data) {

        LoginPage loginPage = new LoginPage();
        loginPage.enterUsername(data.get("username"))
                .enterPassword(data.get("password"))
                .clickSubmitBtn()
                .clickName()
                .clickLogoutBtn();
    }

    @Test(dataProvider = "getData", dataProviderClass = DataProviderUtils.class, retryAnalyzer = RetryFailedTests.class)
    public void loginTest2(Map<String, String> data) {

        LoginPage loginPage = new LoginPage();
        loginPage.enterUsername(data.get("username"))
                .enterPassword(data.get("password"))
                .clickSubmitBtn()
                .clickName()
                .clickLogoutBtn();
    }

/*    @Test(dataProvider = "LoginTestDataProvider")
    public void loginTest2(String username, String password) {
        LoginPage loginPage = new LoginPage();
        HomePage homePage = loginPage
                .enterUsername(username).enterPassword(password).clickSubmitBtn();
        homePage
                .clickName().clickLogoutBtn();
    }

    @Test(dataProvider = "LoginTestDataProvider")
    public void loginTest3(String username, String password) {
        String title = new LoginPage()
                .enterUsername(username).enterPassword(password).clickSubmitBtn()
                .clickName().clickLogoutBtn()
                .getTitle();

        System.out.println("Title is: " + title);

        Assertions.assertThat(title)
                .containsIgnoringCase("OrangeHRM");
    }*/

}