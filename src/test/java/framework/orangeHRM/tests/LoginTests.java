package framework.orangeHRM.tests;

import driver.DriverManager;
import framework.BaseTest;
import framework.orangeHRM.pages.HomePage;
import framework.orangeHRM.pages.LoginPage;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public final class LoginTests extends BaseTest {

    private LoginTests(){}

    @Test
    public void loginTest1() {
        LoginPage loginPage = new LoginPage();
        loginPage.enterUsername("Admin")
                .enterPassword("admin123")
                .clickSubmitBtn()
                .clickName()
                .clickLogoutBtn();
    }

    @Test
    public void loginTest2() {
        LoginPage loginPage = new LoginPage();
        HomePage homePage = loginPage
                .enterUsername("Admin").enterPassword("admin123").clickSubmitBtn();
        homePage
                .clickName().clickLogoutBtn();
    }

    @Test
    public void loginTest3() {
        String title = new LoginPage()
                .enterUsername("Admin").enterPassword("admin123").clickSubmitBtn()
                .clickName().clickLogoutBtn()
                .getTitle();

        System.out.println("Title is: " + title);

        Assertions.assertThat(title)
                .containsIgnoringCase("OrangeHRM");
    }

}