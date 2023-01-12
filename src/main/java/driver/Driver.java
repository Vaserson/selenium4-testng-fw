package driver;

import constants.Constants;
import enums.ConfigProperty;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.JsonUtils;
import utils.PropertyUtils;

import java.time.Duration;
import java.util.Objects;

public final class Driver {

    private Driver() {}

    public static void initDriver() throws Exception {
        if (Objects.isNull(DriverManager.getDriver())) {
            System.setProperty("webdriver.chrome.driver", Constants.getChromedriverpath());
            DriverManager.setDriver(new ChromeDriver());
            DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//            DriverManager.getDriver().get(JsonUtils.get(ConfigProperty.URL));
            DriverManager.getDriver().get(PropertyUtils.get(ConfigProperty.URL));
        }
    }

    public static void quitDriver() {
        if (Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }
}