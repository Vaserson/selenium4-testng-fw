package driver;

import constants.Constants;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Objects;

public final class Driver {

    private Driver() {}

    public static void initDriver() {
//        if (DriverManager.getDriver() == null) {
        if (Objects.isNull(DriverManager.getDriver())) {
            System.setProperty("webdriver.chrome.driver", Constants.getChromedriverpath());
            DriverManager.setDriver(new ChromeDriver());
            DriverManager.getDriver().get("https://phptravels.com");
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