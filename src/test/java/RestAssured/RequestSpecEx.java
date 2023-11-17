package RestAssured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RequestSpecEx {
    RequestSpecification requestSpecification;
    @BeforeClass
    void setRequestSpec(){

        requestSpecification= RestAssured.with().baseUri("http://localhost:3000/").basePath("/employees");
        RestAssured.requestSpecification=requestSpecification;
        // no neet to give .spec in every methods this will be handled by this code

    }
    @Test
    void getAllemp(){
     RestAssured.given()
             .when().get().prettyPrint();

    }
    @Test
    void getAnemp(){
        RestAssured.given()
                .when().get("/100").prettyPrint();
    }
    @Test
    void postAnemp(){
        RequestSpecification requestSpecification=RestAssured.given().
                contentType(ContentType.JSON)
                .baseUri("http://localhost:3000/employees");
        RestAssured.given()
                .spec(requestSpecification)
                .body("{\n" +
                        "    \"first_name\": \"joker 1\",\n" +
                        "    \"last_name\": \"jk 1\",\n" +
                        "    \"email\": \"joker@gmail.com\"}")
                .when().post().prettyPrint();
    }
}
