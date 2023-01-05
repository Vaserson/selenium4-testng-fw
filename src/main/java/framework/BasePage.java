package framework;

import constants.Constants;
import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected String getPageTitle() {
        return DriverManager.getDriver().getTitle();
    }

    protected void click(By by) {
        explicitlyWaitToBeClickable(by);
        DriverManager.getDriver().findElement(by).click();
    }

    protected void sendKeys(By by, String value) {
        explicitlyWaitToBeClickable(by);
        DriverManager.getDriver().findElement(by).sendKeys(value);
    }

    private void explicitlyWaitToBeClickable(By by) {
        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(Constants.getExplicitwait()))
                .until(ExpectedConditions.elementToBeClickable(by));
    }
}
