package framework.orangeHRM.pages;

import framework.BasePage;
import org.openqa.selenium.By;

public final class LoginPage extends BasePage {

    private final By fldLogin = new By.ByName("username");
    private final By fldPassword = new By.ByName("password");
    private final By btnSubmit = new By.ByXPath("//button[@type='submit']");


    public String getTitle() {
        return getPageTitle();
    }

    public LoginPage enterUsername(String username) {
        sendKeys(fldLogin, username);
//        DriverManager.getDriver().findElement(fldLogin).sendKeys(username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        sendKeys(fldPassword, password);
//        DriverManager.getDriver().findElement(fldPassword).sendKeys(password);
        return this;
    }

    public HomePage clickSubmitBtn() {
        click(btnSubmit);
//        DriverManager.getDriver().findElement(btnSubmit).click();
        return new HomePage();
    }
}