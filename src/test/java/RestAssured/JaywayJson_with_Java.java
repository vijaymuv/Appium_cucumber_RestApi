package RestAssured;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class JaywayJson_with_Java {
//    @Test
    void jaywayJson() throws IOException {
        //need to parse ever time
        File f = new File("src/test/resources/Jayway_jsonFile.json");
        List<Object> data = JsonPath.read(f, "$..firstName");
        for (Object name:data) {
            System.out.println(name);
        }
    }
    //@Test
    void jaywayJson2() throws IOException {
        //no need to parse ever time
        InputStream f = new FileInputStream("src/test/resources/Jayway_jsonFile.json");
        Object paredjson= Configuration.defaultConfiguration().jsonProvider().parse(f.readAllBytes());
        List<Object> datas=JsonPath.read(paredjson,"$..firstName");
        List<Object> lstname=JsonPath.read(paredjson,"$..lastName");
        for (Object lastname:lstname) {System.out.println(lastname);
        }
    }
    @Test
    void jaywayJson3() throws Exception {

        //fluent api is most preferred way
        InputStream f = new FileInputStream("C:\\Users\\Friday\\IdeaProjects\\Api_TestNg\\src\\test\\resources\\Jayway_jsonFile.json");
        DocumentContext context = JsonPath.parse(f);
        Object read = context.read("$.employees.employee[0].lastName");
        System.out.println(read);
        Configuration configuration = Configuration.defaultConfiguration();
        Object read1 = JsonPath
                .using(configuration)
                .parse(f)
                .read("$.employees.employee[0].lastName");
        System.out.println(read1);
    }
}
