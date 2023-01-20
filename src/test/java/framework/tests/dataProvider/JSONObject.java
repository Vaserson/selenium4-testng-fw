package framework.tests.dataProvider;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class JSONObject {
    private String username;
    private String password;
    private String fname;
    private String lname;
    //getters and setters

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }


/*    @DataProvider
    public JSONObject[] getDataGPT() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File("src/test/java/framework/dataProviderTest/configGPT.json"), JSONObject[].class);
    }*/
@DataProvider
public Iterator<Object[]> getDataGPT() throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    JSONObject[] jsonObjects = mapper.readValue(new File("src/test/java/framework/dataProviderTest/configGPT.json"), JSONObject[].class);
    List<Object[]> data = new ArrayList<>();
    for (JSONObject jsonObject : jsonObjects) {
        data.add(new Object[] {jsonObject.getUsername(), jsonObject.getPassword(), jsonObject.getFname(), jsonObject.getLname()});
    }
    return data.iterator();
}
}