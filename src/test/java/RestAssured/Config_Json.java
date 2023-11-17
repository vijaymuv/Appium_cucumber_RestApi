package RestAssured;

//import com.jayway.jsonpath.Configuration;
//import com.jayway.jsonpath.JsonPath;
//import com.jayway.jsonpath.Option;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Option;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

public class Config_Json {
    @Test
    void config_Json() throws FileNotFoundException {

        Configuration configuration = Configuration.defaultConfiguration();
        configuration= configuration.addOptions(Option.REQUIRE_PROPERTIES);
        // configuration= configuration.addOptions(Option.SUPPRESS_EXCEPTIONS);
        // configuration= configuration.addOptions(Option.ALWAYS_RETURN_LIST);  //in this line if any key is not in json it will return null.
        InputStream f = new FileInputStream("C:\\Users\\Friday\\IdeaProjects\\Api_TestNg\\src\\test\\resources\\Jayway_jsonFile.json");
        List<Object> read = JsonPath.using(configuration).parse(f).read("$.employees.employee[*].work");
        System.out.println(read);

    }
}
