package RestAssured;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

public class Authorization_authentication {


    // Authentication valid user and password name
    //Authorization means access
//    @Test
    void authenticationBasic_Auth(){
        RestAssured.given().auth().basic("postman","password")
                .when()
                .get("https://postman-echo.com/basic-auth")
                .then()
                .body("authenticated",equalTo(true)).log().all();
    }
//    @Test
    void digest_Auth(){
        RestAssured.given().auth().digest("postman","password")
                .when()
                .get("https://postman-echo.com/basic-auth")
                .then()
                .body("authenticated",equalTo(true)).log().all();
    }
//    @Test
    void preemptive_Auth(){
        RestAssured.given().auth().preemptive().basic("postman","password")
                .when()
                .get("https://postman-echo.com/basic-auth")
                .then()
                .body("authenticated",equalTo(true)).log().all();
    }
//    @Test
    void brearerToken(){
        String token="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";
       RestAssured.given()
               .headers("Authorization","Bearer "+token)
               .when().get("https://api.github.com/user/repos")
               .then()
               .statusCode(200)
               .log().all();
    }

//    @Test
    void oAuth2Token(){
        RestAssured.given().auth().oauth2("Bearer ya29.a0AWY7CkluDPKdc2OIOIujbmRJRbD8KknQF41SfUtTjVjqSSZvKEgxpl5pseMYDinf18NQ-2XC75UPDuQSZ55YN5-7UPIAYQhhdS1-euntgJVzBE4AgnDeBzE56bhsoCmKS4LPI5WJ0Zh1gRcHDKCsTUa4yvjWaCgYKAWwSARASFQG1tDrpuc6JLrOVVbztY8Cm68OZfQ0163")
        .when().get("https://gmail.googleapis.com/gmail/v1/users/vijaymvu@gmail.com/messages/188012f23912eeff").then()
        .statusCode(200).log().all();
    }

    @Test
    void apiKey_Token(){
        RestAssured.given()
                .queryParam("q","chennai")
                .queryParam("appid","ccd9ad5b7f5ac229314d1b8a090169ca")
                 .when()
                .get("https://api.openweathermap.org/data/2.5/weather").then().log().all();
    }

}
