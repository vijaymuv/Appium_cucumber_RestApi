package RestAssured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Map;

public class Cookies_ {
//    @Test
    void cookies_(){
        Response response = RestAssured
                .given()
                .when()
                .get("https://google.com");
//                .then()
//                .cookie("AEC","Ad49MVGMxeFgFe9kDnybsjLkVednuiqR55qQ66ImHOayG8VNO4ooTakAKNQ")
//                .log().all();

        String cookie = response.getCookie("AEC");
        System.out.println("value of cookies: "+cookie);

        Map<String, String> cookies1 = response.getCookies();
        for (String cookie1: cookies1.keySet()) {
            System.out.println(cookie1+" "+response.getCookie(cookie1));
        }

    }
    @Test
    void headers(){
    RestAssured
                .given()
                .when()
                .get("https://google.com")
                .then().header("Content-Type","text/html; charset=ISO-8859-1")
            .header("Content-Encoding","gzip");
    }
}
