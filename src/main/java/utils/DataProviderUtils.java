package utils;

import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class DataProviderUtils {

    @DataProvider
    public static Object[][] getData(Method m) {
        String testName = m.getName();

        List<Map<String, String>> list = ExcelUtils.getTestData("DATA");

        List<Map<String, String>> filteredList = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).get("testname").equalsIgnoreCase(testName)) {
                if (list.get(i).get("execute").equalsIgnoreCase("yes")) {
                    filteredList.add(list.get(i));
                }
            }
        }

        Object[][] data = new Object[filteredList.size()][];
        for (int i = 0; i < filteredList.size(); i++) {
            Map<String, String> map = filteredList.get(i);
            data[i] = new Object[]{map};
        }
        return data;

    }
}
