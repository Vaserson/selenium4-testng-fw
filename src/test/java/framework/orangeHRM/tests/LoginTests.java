package framework.orangeHRM.tests;

import framework.BaseTest;
import framework.orangeHRM.pages.HomePage;
import framework.orangeHRM.pages.LoginPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public final class LoginTests extends BaseTest {

    private LoginTests(){}

    @DataProvider(name = "LoginTestDataProvider", parallel = true) //!!! Set thread count in the testNG.xml <suite name="Suite" data-provider-thread-count="3">
    public Object[][] getData() {
        return new Object[][] {
                {"Admin", "admin123"},
                {"Admin123", "admin"},
                {"Admin", "admin123"},
                {"Admin", "admin123"}
        };
    }

    @Test(dataProvider = "LoginTestDataProvider")
    public void loginTest1(String username, String password) {
        LoginPage loginPage = new LoginPage();
        loginPage.enterUsername(username)
                .enterPassword(password)
                .clickSubmitBtn()
                .clickName()
                .clickLogoutBtn();
    }

    @Test(dataProvider = "LoginTestDataProvider")
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
    }

}