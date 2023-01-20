package framework.tests.annotationsDemo;

import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class AnnotationsTests {

    @Test(description = "value of a parameter. Try to get in runtime using reflection")
    public void testingTest(Method m) {
        System.out.println(m.getAnnotation(Test.class).description());
    }

}
