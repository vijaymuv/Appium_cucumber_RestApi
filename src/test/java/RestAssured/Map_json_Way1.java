package RestAssured;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Map_json_Way1 {
    @Test
    void Using_map_jsonObject_Creation(){
        Map<String,Object> body=new HashMap<>();
        body.put("name","clark");
        body.put("age","1000");

        List<String> arr =new ArrayList<String>();
        arr.add("rest api");
        arr.add("postman");
        body.put("Skills",arr);
        System.out.println(body);

        RestAssured.given()
                .baseUri("http://localhost:3000")
                .header("Content-Type","application/json")
                .body(body)
                .log()
                .all()
                .when()
                .post("/employees")
                .then()
                .log()
                .all();
    }
}
