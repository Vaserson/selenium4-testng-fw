package driver;

import constants.Constants;
import enums.ConfigProperty;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.JsonUtils;
import utils.PropertyUtils;

import java.time.Duration;
import java.util.Objects;

public final class Driver {

    private Driver() {}

    public static void initDriver(String browser) throws Exception {
        if (Objects.isNull(DriverManager.getDriver())) {
            if (browser.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver", Constants.getChromeDriverPath());
                DriverManager.setDriver(new ChromeDriver());
            } else if (browser.equalsIgnoreCase("firefox")) {
                System.setProperty("webdriver.gecko.driver", Constants.getGeckoDriverPath());
                DriverManager.setDriver(new FirefoxDriver());
            }
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