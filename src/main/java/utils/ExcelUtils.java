package utils;

import constants.Constants;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ExcelUtils {
    private ExcelUtils() {
    }

    public static List<Map<String, String>> getTestData(String sheetName) {
        List<Map<String, String>> list = null;

        try (FileInputStream fs = new FileInputStream(Constants.getTestDataPath())) {
            XSSFWorkbook wb = new XSSFWorkbook(fs);
            XSSFSheet sheet = wb.getSheet(sheetName);

            int lastRowNum = sheet.getLastRowNum();
            int lastColumn = sheet.getRow(0).getLastCellNum();

            Map<String, String> map;
            list = new ArrayList<>();

            for (int i = 1; i <= lastRowNum; i++) {
                map = new HashMap<>();
                for (int j = 0; j < lastColumn; j++) {
                    String key = sheet.getRow(0).getCell(j).getStringCellValue();
                    String value = sheet.getRow(i).getCell(j).getStringCellValue();
                    map.put(key, value);
                }
                list.add(map);
            }
        } catch (FileNotFoundException e) {
            StackTraceElement[] a = e.getStackTrace();
            a[0] = new StackTraceElement("utils.ExcelUtils", "getTestData", "ExcelUtils.java", 23);
            e.setStackTrace(a);
            throw new RuntimeException("Excel file not found", e);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
