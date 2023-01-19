package listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailedTests implements IRetryAnalyzer {

    private int count = 0;
    private int retries = 1;

    @Override
    public boolean retry(ITestResult iTestResult) {
/*        if (count < retries) {
            count++;
            return true;
        }*/ // OR just
        boolean retry = count < retries;
        count++;
        return retry;
    }
}
