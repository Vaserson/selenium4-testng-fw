package framework.dataProviderTest;

import org.testng.annotations.DataProvider;

public class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @DataProvider
    public static Object[][] getDataInEmployeeClass() {
        return new Object[][]{
                {new Employee("Vasyl", 33)},
                {new Employee("Mariia", 25)},
                {new Employee("Iryna", 26)}

        };
    }

}
