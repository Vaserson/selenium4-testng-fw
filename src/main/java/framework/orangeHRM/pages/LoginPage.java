package framework.orangeHRM.pages;

import driver.DriverManager;
import org.openqa.selenium.By;

public final class LoginPage {

    private final By fldLogin = new By.ByName("username");
    private final By fldPassword = new By.ByName("password");
    private final By btnSubmit = new By.ByXPath("//button[@type='submit']");


    public LoginPage enterUsername(String username) {
        DriverManager.getDriver().findElement(fldLogin).sendKeys(username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        DriverManager.getDriver().findElement(fldPassword).sendKeys(password);
        return this;
    }

    public HomePage clickSubmitBtn() {
        DriverManager.getDriver().findElement(btnSubmit).click();
        return new HomePage();
    }

    public String getTitle() {
        return DriverManager.getDriver().getTitle();
    }

}
