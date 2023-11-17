package RestAssured;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class BddStyle {
//    @Test
    void get_Bdd() {
        given()
                .baseUri("http://localhost:3000/").when().get("employees").prettyPrint();
    }
//    @Test
    void post_Bdd() {
        given()
                .baseUri("http://localhost:3000/")
                .header("Content-Type","application/json")
                .body(" {\n" +
                "    \"id\": 30,\n" +
                "    \"first_name\": \"Tailor S\",\n" +
                "    \"last_name\": \"Wayne \",\n" +
                "    \"email\": \"Tailor@codingthesmartway.com\"\n" +
                "  }")
                .when()
                .post("employees")
                .prettyPrint();

    }
//@Test
    void putBdd(){
        given().baseUri("http://localhost:3000/")
                .header("Content-Type","application/json")
                .body(" {\"first_name\": \"Wayne\",\n" +
                "    \"last_name\": \"Bruce\",\n" +
                "    \"email\": \"Bruce@codingthesmartway.com\"}")
                .when()
                .put("employees/1")
                .prettyPrint();

    }
    @Test
    void deletebdd(){
        given().baseUri("http://localhost:3000/")
                .when()
                .delete("employees/MuUjAro").
                then().statusCode(200);

    }
}
