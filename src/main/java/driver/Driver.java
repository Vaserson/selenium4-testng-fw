package driver;

import constants.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Objects;

public final class Driver {

    private Driver() {}

    private static WebDriver driver;

    private static ThreadLocal<WebDriver> dr = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return dr.get();
    }

    public static void setDriver(WebDriver driverRef) {
        dr.set(driverRef);
    }

    public static void unload() {
        dr.remove();
    }

    public static void initDriver() {
//        if (driver == null) {
        if (Objects.isNull(driver)) {
            System.setProperty("webdriver.chrome.driver", Constants.getChromedriverpath());
            driver = new ChromeDriver();

            setDriver(driver);
            getDriver().get("https://phptravels.com/");
        }
    }

    public static void quitDriver() {
//        if (driver != null) {
        if (Objects.nonNull(getDriver())) {
            getDriver().quit();
//            driver = null;
            unload();
        }
    }

}
