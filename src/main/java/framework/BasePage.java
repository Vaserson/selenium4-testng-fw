package framework;

import driver.DriverManager;
import enums.WaitStrategy;
import factories.ExplicitWaitFactory;
import org.openqa.selenium.By;
import reports.ExtentLogger;

public class BasePage {

    protected String getPageTitle() {
        return DriverManager.getDriver().getTitle();
    }

    protected void click(By by, WaitStrategy waitStrategy, String elementName) {
        ExplicitWaitFactory.performExplicitWait(by, waitStrategy).click();
        ExtentLogger.pass(elementName + " is clicked");
    }

    protected void sendKeys(By by, String value, WaitStrategy waitStrategy, String elementName) {
        ExplicitWaitFactory.performExplicitWait(by, waitStrategy).sendKeys(value);
        ExtentLogger.pass(value + " is set to the " + elementName + " element.");
    }
}