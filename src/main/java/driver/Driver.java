package driver;

import constants.Constants;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.ReadPropertyFile;

import java.io.IOException;
import java.util.Objects;

public final class Driver {

    private Driver() {}

    public static void initDriver() throws IOException {
//        if (DriverManager.getDriver() == null) {
        if (Objects.isNull(DriverManager.getDriver())) {
            System.setProperty("webdriver.chrome.driver", Constants.getChromedriverpath());
            DriverManager.setDriver(new ChromeDriver());
            DriverManager.getDriver().get(ReadPropertyFile.getProperty("url"));
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