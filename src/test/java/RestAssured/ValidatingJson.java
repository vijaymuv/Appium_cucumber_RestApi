package RestAssured;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ValidatingJson {

//    @Test
    void validatingJson(){

        //approach 1
        // in this approach looping and conditional statement is not possible thats why we go for return type
//        given()
//                .contentType("ContentType.JSON")
//        .when()
//                .get("http://localhost:3000/employees")
//                .then()
//                .statusCode(200)
//                .header("Content-Type","application/json; charset=utf-8")
//                .body("employees[0].last_name",equalTo("Bruce"));
////                .body("[0].last_name",equalTo("Bruce"));

        //approach 2
        Response response = given()
                .contentType("ContentType.JSON")
                .when()
                .get("http://localhost:3000/employees");
        Assert.assertEquals(response.getStatusCode(),200);
        Assert.assertEquals(response.header("Content-Type"),"application/json; charset=utf-8");
        Assert.assertEquals(response.jsonPath().get("[0].last_name").toString(),"Bruce");

    }
    @Test
void testJsonBody(){
    Response response = given()
            .contentType(ContentType.JSON)
            .when()
            .get("http://localhost:3000/emp");

//converting response to json object
        JSONObject json1;
        json1 = new JSONObject(response.asString());
        for (int i = 0; i <json1.getJSONArray("emp").length() ; i++) {
        String firstname = json1.getJSONArray("emp").getJSONObject(i).get("first_name").toString();
        System.out.println(firstname);
    }

}

}
