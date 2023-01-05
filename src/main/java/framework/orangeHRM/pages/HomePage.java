package framework.orangeHRM.pages;

import framework.BasePage;
import org.openqa.selenium.By;

public final class HomePage extends BasePage {

    private final By lnkName = new By.ByXPath("//p[@class='oxd-userdropdown-name']");
    private final By lnkLogout = new By.ByLinkText("Logout");


    public HomePage clickName() {
        click(lnkName);
//        DriverManager.getDriver().findElement(lnkName).click();
        return this;
    }

    public LoginPage clickLogoutBtn() {
        click(lnkLogout);
//        DriverManager.getDriver().findElement(lnkLogout).click();
        return new LoginPage();
    }

}
