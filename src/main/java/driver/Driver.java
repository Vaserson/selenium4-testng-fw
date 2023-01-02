package driver;

import constants.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Objects;

public final class Driver {

    private Driver() {}

    private static WebDriver driver;

    public static void initDriver() {
//        if (driver == null) {
        if (Objects.isNull(driver)) {
            System.setProperty("webdriver.chrome.driver", Constants.getChromedriverpath());
            driver = new ChromeDriver();

            DriverManager.setDriver(driver);
            DriverManager.getDriver().get("https://phptravels.com/");
        }
    }

    public static void quitDriver() {
//        if (driver != null) {
        if (Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
//            driver = null;
            DriverManager.unload();
        }
    }

}
