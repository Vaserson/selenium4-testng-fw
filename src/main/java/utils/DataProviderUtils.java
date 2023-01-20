package utils;

import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class DataProviderUtils {
    private static List<Map<String, String>> list = new ArrayList<>();

    @DataProvider(parallel = true)
    public static Object[][] getData(Method m) {
        String testName = m.getName();
        if (list.isEmpty()) {
            list = ExcelUtils.getTestData("DATA");
        }

        List<Map<String, String>> filteredList = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).get("testname").equalsIgnoreCase(testName)) {
                if (list.get(i).get("execute").equalsIgnoreCase("yes")) {
                    filteredList.add(list.get(i));
                }
            }
        }

        // It's better not to remove anything from ArrayList (or use LinkedList), while we search by index
//        list.removeAll(filteredList); // Remove tests that was filtered before to iterate less next time

        Object[][] data = new Object[filteredList.size()][];
        for (int i = 0; i < filteredList.size(); i++) {
            Map<String, String> map = filteredList.get(i);
            data[i] = new Object[]{map};
        }
        return data;

    }
}
