package framework;

import driver.DriverManager;
import enums.WaitStrategy;
import factories.ExplicitWaitFactory;
import org.openqa.selenium.By;

public class BasePage {

    protected String getPageTitle() {
        return DriverManager.getDriver().getTitle();
    }

    protected void click(By by, WaitStrategy waitStrategy) {
        ExplicitWaitFactory.performExplicitWait(by, waitStrategy).click();
    }

    protected void sendKeys(By by, String value, WaitStrategy waitStrategy) {
        ExplicitWaitFactory.performExplicitWait(by, waitStrategy).sendKeys(value);
    }
}