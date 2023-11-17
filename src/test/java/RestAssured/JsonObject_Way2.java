package RestAssured;

import io.restassured.RestAssured;
import org.json.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class JsonObject_Way2 {
    @Test
    void using_JsonObject(){
        JSONObject json= new JSONObject();
        json.put("name","steve");
        json.put("id","278");
        json.put("age","150 years");

        JSONArray ary =new JSONArray();
        ary.put("java");
        ary.put("selenium");
        json.put("skills",ary);

        RestAssured.given()
                .baseUri("http://localhost:3000")
                .header("Content-Type","application/json")
                .body(json.toJSONString())
                .when()
                .post("/employees")
                .then()
                .statusCode(201).log().all();
    }
}
