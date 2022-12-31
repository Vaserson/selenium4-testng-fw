package driver;

import constants.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {

    public static WebDriver driver;

    public static void initDriver() {
        System.setProperty("webdriver.chrome.driver", Constants.getChromedriverpath());
        driver = new ChromeDriver();

        driver.get("https://phptravels.com/");
    }

    public static void quitDriver() {
        driver.quit();
    }

}
