package RestAssured;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.spi.mapper.JacksonMappingProvider;
import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;


public class Deserilization_Json {
//    @Test
    void deserilization_Json() throws IOException {

        String json ="{\n" +
                "  \"name\": \"Clark\",\n" +
                "  \"age\": \"100\",\n" +
                "  \"email\": \"Clark@gmail.com\"\n" +
                "}";
        ObjectMapper mapper = new ObjectMapper();
        PojoJson pojoJson = mapper.readValue(json, PojoJson.class);
        System.out.println(pojoJson.getName());
        System.out.println(pojoJson.getAge());
    }
//    @Test
    void deserilizationUsing_Jayway_Json() throws IOException {

        String json ="{\n" +
                "  \"name\": \"Clark\",\n" +
                "  \"age\": \"100\",\n" +
                "  \"email\": \"Clark@gmail.com\"\n" +
                "}";

        JacksonMappingProvider mappingProvider=new JacksonMappingProvider();
        Configuration configuration = Configuration.builder().mappingProvider(mappingProvider).build();

        PojoJson pojoJson = JsonPath.using(configuration).parse(json).read("$", PojoJson.class);
        System.out.println(pojoJson.getName());

    }
//    @Test
    void usingRestAssured_json() throws IOException {

        String json ="{\n" +
                "  \"name\": \"Clark\",\n" +
                "  \"age\": \"100\",\n" +
                "  \"email\": \"Clark@gmail.com\"\n" +
                "}";

        io.restassured.path.json.JsonPath path = io.restassured.path.json.JsonPath.from(json);
        PojoJson js = path.getObject("$", PojoJson.class);
        System.out.println(js.getName());

    }
    //with as function json to java conversion

    @Test
    void withAs_func(){
        Map<String, Object> response = RestAssured.given().baseUri("http://localhost:3000/")
                .when()
                .get("employees/100")
                .then().extract().body().as(new TypeRef<Map<String, Object>>() {

                });
        System.out.println(response);
        System.out.println(response.get("name"));
    }
}
