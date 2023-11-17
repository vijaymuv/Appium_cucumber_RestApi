package RestAssured;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.annotations.Test;

import java.io.FileReader;

public class JsonFile_Reading {
    @Test
    void readingJsonFile() throws Exception {
        JSONParser parser=new JSONParser();
        FileReader reader = new FileReader("PostJson.json");
        Object objparse = parser.parse(reader);
        JSONObject json = (JSONObject) objparse;
        json.get("email");
        System.out.println(json.get("email").toString());
    }
}
