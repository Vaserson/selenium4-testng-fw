package demo.listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerClass implements ITestListener, ISuiteListener {

    @Override
    public void onStart(ISuite iSuite) {
        System.out.println("before suite in Listener");
    }

    @Override
    public void onFinish(ISuite iSuite) {
        System.out.println("after suite in Listener");
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("before method in Listener");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("after method PASS in Listener");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("after method FAIL in Listener");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("after method SKIPPED in Listener");
    }

}
