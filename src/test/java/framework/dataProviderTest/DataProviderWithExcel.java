package framework.dataProviderTest;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class DataProviderWithExcel {

    @Test(dataProvider = "getData1") // 4 tests will run even if 1 of them will fail
//    @Test(dataProvider = "getDataHashMap") // 4 tests will run even if 1 of them will fail
    public void test1(String username, String password, String fname, String lname) {
//    public void test1(Map<String, String> map) {
        System.out.println(username + " Test");
        System.out.println(password + " Test");
        System.out.println(fname + " Test");
        System.out.println(lname + " Test");
//        Assert.assertTrue(Objects.nonNull(name));
        Assert.assertFalse(fname.equals("Mariia"));
/*        System.out.println(map.get("username") + " Test");
        System.out.println(map.get("password") + " Test");
        System.out.println(map.get("fname") + " Test");
        System.out.println(map.get("lname") + " Test");
//        Assert.assertTrue(Objects.nonNull(name));
        Assert.assertFalse(map.get("fname").equals("Mariia"));*/
    }

    @DataProvider
    public Object[][] getData1() throws IOException {
        FileInputStream fs = new FileInputStream("src/test/java/framework/dataProviderTest/testData.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fs);
        XSSFSheet sheet = workbook.getSheetAt(0);

        int rownum = sheet.getLastRowNum();
        int columnnum = sheet.getRow(0).getLastCellNum();

        Object[][] data = new Object[rownum][columnnum];
        for (int i = 1; i <= rownum; i++) {
            for (int j = 0; j < columnnum; j++) {
                Cell cell = sheet.getRow(i).getCell(j);
                //TODO setCellType(CellType.STRING); is Deprecated
                cell.setCellType(CellType.STRING);
                data[i-1][j] = sheet.getRow(i).getCell(j).getStringCellValue();
            }
        }
        return data;
    }

/*    @DataProvider
    public Object[][] getDataHashMap() throws IOException {
        FileInputStream fs = new FileInputStream("src/test/java/framework/dataProviderTest/testData.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fs);
        XSSFSheet sheet = workbook.getSheetAt(0);

        int rownum = sheet.getLastRowNum();
        int columnnum = sheet.getRow(0).getLastCellNum();

        Object[][] data = new Object[rownum][columnnum];
        Map<String, String> map;


        for (int i = 1; i <= rownum; i++) {
            map = new HashMap<>();
            for (int j = 0; j < columnnum; j++) {
                Cell cell = sheet.getRow(i).getCell(j);
                //TODO setCellType(CellType.STRING); is Deprecated
                cell.setCellType(CellType.STRING);
                String key = sheet.getRow(0).getCell(j).getStringCellValue();
                String value = sheet.getRow(i).getCell(j).getStringCellValue();
                map.put(key, value);

                data[i-1][] = map;
            }
        }
        return data;
    }*/

}
