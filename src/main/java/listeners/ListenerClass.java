package listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import reports.ExtentLogger;
import reports.ExtentReport;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;


public class ListenerClass implements ITestListener, ISuiteListener {

    @Override
    public void onStart(ISuite iSuite) {
        try {
            ExtentReport.initReports();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onFinish(ISuite iSuite) {
        try {
            ExtentReport.flushReports();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentReport.createTest(result.getMethod().getDescription()/*getMethodName()*/);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentLogger.pass(result.getMethod().getMethodName() + " is passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        try {
            //todo "\n" doesn't work, find a way to separate method name, error and stacktrace in one Fail.
            ExtentLogger.fail(result.getMethod().getMethodName() + " is failed"
                    + "\n"
                    + result.getThrowable().toString() + "\n" // To print the error
                    + Arrays.toString(result.getThrowable().getStackTrace()) // To print the stacktrace (array)
                    , true);
/*            ExtentLogger.fail(result.getThrowable().toString()); // To print the error
            ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace())); // To print the stacktrace (array)*/
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentLogger.skip(result.getMethod().getMethodName() + " is skipped");
    }
}
