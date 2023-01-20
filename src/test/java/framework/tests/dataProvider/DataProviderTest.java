package framework.tests.dataProvider;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public final class DataProviderTest {

    @Test(enabled = false) // Only one test as a total tests result, After first fail left data are stops testing
    public void test1() {
        String[] strings = {"Vasyl", "Mariia", "Iryna", "Eugen"};
        for (int i = 0; i < strings.length; i++) {
            System.out.println(strings[i] + " login");
            System.out.println(strings[i] + " password");
            System.out.println("click Login btn");
            Assert.assertTrue(false);
        }
    }

    @Test(dataProvider = "getData") // 4 tests will run even if 1 of them will fail
    public void test2(String name) {
        System.out.println(name + " login");
        System.out.println(name + " password");
        System.out.println("click Login btn");
//        Assert.assertTrue(Objects.nonNull(name));
        Assert.assertFalse(name.equals("Mariia"));
    }

    @Test(dataProvider = "getDataInEmployeeClass", dataProviderClass = Employee.class) // 4 tests will run even if 1 of them will fail
    public void test3(Employee emp) {
        System.out.println(emp.getName() + " login");
        System.out.println(emp.getName() + " password");
        System.out.println("click Login btn");
//        Assert.assertTrue(Objects.nonNull(name));
        Assert.assertFalse(emp.getName().equals("Mariia"));
    }

    @DataProvider
    public Object[][] getData() {
        return new Object[][]{
                {"Vasyl"},
                {"Eugen"},
                {"Mariia"},
                {"Iryna"}
        };
    }




    @Test(dataProvider = "getDataMethodName") // 4 tests will run even if 1 of them will fail
    public void stringTest(String str) {
        System.out.println(str + " stringTest");
        System.out.println(str + " stringTest");
        System.out.println("stringTest");
//        Assert.assertTrue(Objects.nonNull(name));
        Assert.assertFalse(str.equals("Mariia"));
    }

    @Test(dataProvider = "getDataMethodName") // 4 tests will run even if 1 of them will fail
    public void intTest(int i) {
        System.out.println(i + " intTest");
        System.out.println(i + " intTest");
        System.out.println("intTest");
//        Assert.assertTrue(Objects.nonNull(name));
        Assert.assertFalse(i == 69);
    }


    @DataProvider
    public Object[][] getDataMethodName(Method m) {
        if (m.getName().equalsIgnoreCase("stringTest")) {
            return new Object[][]{
                    {"Vasyl"},
                    {"Eugen"},
                    {"Mariia"},
                    {"Iryna"}
            };
        } else if (m.getName().equalsIgnoreCase("intTest")) {
            return new Object[][]{
                    {35},
                    {24},
                    {69},
                    {84}
            };
        }
        return null;
    }

}