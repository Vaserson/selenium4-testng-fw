package framework;

import constants.Constants;
import driver.DriverManager;
import enums.WaitStrategy;
import factories.ExplicitWaitFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected String getPageTitle() {
        return DriverManager.getDriver().getTitle();
    }

    protected void click(By by, WaitStrategy waitStrategy) {
        ExplicitWaitFactory.performExplicitWait(by, waitStrategy).click();
/*        explicitlyWaitToBeClickable(by);
        DriverManager.getDriver().findElement(by).click();*/
    }

    protected void sendKeys(By by, String value, WaitStrategy waitStrategy) {
        ExplicitWaitFactory.performExplicitWait(by, waitStrategy).sendKeys(value);
/*        if (waitStrategy == WaitStrategy.CLICKABLE) {
            explicitlyWaitToBeClickable(by);
        } else if (waitStrategy == WaitStrategy.PRESENCE) {
            explicitlyWaitToBePresent(by);
        } else if (waitStrategy == WaitStrategy.VISIBLE) {
            explicitlyWaitToBeVisible(by);
        } else {
        }
        DriverManager.getDriver().findElement(by).sendKeys(value);*/
    }

/*    private void explicitlyWaitToBeClickable(By by) {
        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(Constants.getExplicitwait()))
                .until(ExpectedConditions.elementToBeClickable(by));
    }

    private void explicitlyWaitToBePresent(By by) {
        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(Constants.getExplicitwait()))
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }

    private void explicitlyWaitToBeVisible(By by) {
        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(Constants.getExplicitwait()))
                .until(ExpectedConditions.visibilityOfElementLocated(by));
    }*/
}
