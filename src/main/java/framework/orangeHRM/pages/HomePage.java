package framework.orangeHRM.pages;

import enums.WaitStrategy;
import framework.BasePage;
import org.openqa.selenium.By;
import reports.ExtentReport;

public final class HomePage extends BasePage {

    private final By lnkName = new By.ByXPath("//p[@class='oxd-userdropdown-name']");
    private final By lnkLogout = new By.ByLinkText("Logout");


    public HomePage clickName() {
        click(lnkName, WaitStrategy.PRESENCE);
        ExtentReport.test.pass("welcome CLICKED");
        return this;
    }

    public LoginPage clickLogoutBtn() {
        click(lnkLogout, WaitStrategy.CLICKABLE);
        ExtentReport.test.pass("logout CLICKED");
        return new LoginPage();
    }
}