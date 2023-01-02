package driver;

import org.openqa.selenium.WebDriver;

public final class DriverManager {

    private DriverManager() {}

    private static ThreadLocal<WebDriver> dr = new ThreadLocal<>();
    // With default value
/*    private static ThreadLocal<WebDriver> dr = ThreadLocal.withInitial(() -> {
        System.setProperty("webdriver.chrome.driver", Constants.getChromedriverpath());
        return new ChromeDriver();
    });*/

    public static WebDriver getDriver() {
        return dr.get();
    }

    public static void setDriver(WebDriver driverRef) {
        dr.set(driverRef);
    }

    public static void unload() {
        dr.remove(); // return back to default value withInitial()
    }
}
