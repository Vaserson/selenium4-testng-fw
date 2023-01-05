package framework.orangeHRM.pages;

import driver.DriverManager;
import org.openqa.selenium.By;

public final class HomePage {

    private final By lnkName = new By.ByXPath("//p[@class='oxd-userdropdown-name']");
    private final By lnkLogout = new By.ByLinkText("Logout");


    public HomePage clickName() {
        DriverManager.getDriver().findElement(lnkName).click();
        return this;
    }

    public LoginPage clickLogoutBtn() {
        DriverManager.getDriver().findElement(lnkLogout).click();
        return new LoginPage();
    }

}
