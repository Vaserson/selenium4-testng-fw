package demo.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {

    // if returns true - the method will be rerun

    // May be applied on the test level (@Test(retryAnalyzer=Retry.class)
        // For all enabled tests (for example in AnnotationTransformer) (annotation.setRetryAnalyzer(Retry.class);)
            // !!! DO NOT COMBINE WITH (annotation.setInvocationCount)
    // Generates testNG-failed.xml in test-output

    int counter = 0;
    int limit = 2;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (counter < limit) {
            counter++;
            return true;
        }
        return false;
    }
}
