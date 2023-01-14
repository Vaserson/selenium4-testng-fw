package listeners;

import org.testng.annotations.*;

public class Runner {

    @BeforeSuite
    public void setUpSuite() {
        System.out.println("before suite in Runner");
    }
    @AfterSuite
    public void tearDownSuite() {
        System.out.println("after suite in Runner");
    }

    @BeforeMethod
    public void setUp() {
        System.out.println("before method in Runner");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("after method in Runner");
    }

    @Test
    public void test1() {
        System.out.println("Test1");
    }

    @Test
    public void test2() {
        System.out.println("Test2");
    }

    @Test
    public void test3() {
        System.out.println("Test3");
    }
}
