package driver;

import constants.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Objects;

public class Driver {

    public static WebDriver driver;

    public static void initDriver() {
//        if (driver == null) {
        if (Objects.isNull(driver)) {
            System.setProperty("webdriver.chrome.driver", Constants.getChromedriverpath());
            driver = new ChromeDriver();

            driver.get("https://phptravels.com/");
        }
    }

    public static void quitDriver() {
//        if (driver != null) {
        if (Objects.nonNull(driver)) {
            driver.quit();
            driver = null;
        }
    }

}
