package RestAssured;

import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
public class PostUsingExternalJsonFile {

    @Test
    void postUsingExternalJsonFile(){
        File file = new File("PostJson.json");
        given().baseUri("http://localhost:3000/")
                .header("Content-Type","application/json")
                .body(file)
                .when()
                .post("employees").prettyPrint();

    }

}
