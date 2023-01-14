package framework.orangeHRM.pages;

import enums.WaitStrategy;
import framework.BasePage;
import org.openqa.selenium.By;
import reports.ExtentLogger;
import reports.ExtentManager;
import reports.ExtentReport;

public final class HomePage extends BasePage {

    private final By lnkName = new By.ByXPath("//p[@class='oxd-userdropdown-name']");
    private final By lnkLogout = new By.ByLinkText("Logout");


    public HomePage clickName() {
        click(lnkName, WaitStrategy.PRESENCE, "Name link");
//        ExtentLogger.pass("name CLICKED"); // Moved to BasePage
//        ExtentManager.getExtentTest().pass("name CLICKED");
        return this;
    }

    public LoginPage clickLogoutBtn() {
        click(lnkLogout, WaitStrategy.CLICKABLE, "Logout button");
//        ExtentLogger.pass("logout CLICKED");// Moved to BasePage
//        ExtentManager.getExtentTest().pass("logout CLICKED");
        return new LoginPage();
    }
}