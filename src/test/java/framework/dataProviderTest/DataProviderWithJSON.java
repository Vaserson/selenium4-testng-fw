package framework.dataProviderTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class DataProviderWithJSON {

    @DataProvider
    public Object[][] getDataGPT() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File("src/test/java/framework/dataProviderTest/configGPT.json"), Object[][].class);
    }

    @Test(dataProvider = "getDataGPT", dataProviderClass = JSONObject.class)
    public void testGPT(String username, String password, String fname, String lname) {
        System.out.println(username + " Test");
        System.out.println(password + " Test");
        System.out.println(fname + " Test");
        System.out.println(lname + " Test");
        Assert.assertFalse(fname.equals("Mariia"));
    }

/*    @DataProvider
    public Object[][] getData1() throws IOException {
        HashMap<String, String> map1 = new ObjectMapper()
                .readValue(new File("src/test/java/framework/dataProviderTest/config1.json"),
                        new TypeReference<>() {
                        });

        HashMap<String, String> map2 = new ObjectMapper()
                .readValue(new File("src/test/java/framework/dataProviderTest/config2.json"),
                        new TypeReference<>() {});

        return new Object[][] {
                {map1, map2},
                {}
        };
    }*/

}
