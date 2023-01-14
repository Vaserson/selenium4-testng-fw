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
        try {
            ExtentLogger.pass(elementName + " is clicked", true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void sendKeys(By by, String value, WaitStrategy waitStrategy, String elementName) {
        ExplicitWaitFactory.performExplicitWait(by, waitStrategy).sendKeys(value);
        try {
            ExtentLogger.pass(value + " is set to the " + elementName + " element.", true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}