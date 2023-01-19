package listeners;

import enums.ConfigProperty;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import utils.PropertyUtils;

public class RetryFailedTests implements IRetryAnalyzer {

    private int count = 0;
    private int retries = 1;

    @Override
    public boolean retry(ITestResult iTestResult) {
/*        if (count < retries) {
            count++;
            return true;
        }*/ // OR just
        boolean retry = false;
        try {
            if (PropertyUtils.get(ConfigProperty.RETRYFAILEDTESTS).equalsIgnoreCase("yes")) {
                retry = count < retries;
                count++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retry;
    }
}
