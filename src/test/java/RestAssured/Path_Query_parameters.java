package RestAssured;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class Path_Query_parameters {

    @Test
    void path_Query_parameters(){
        RestAssured
                .given()
                .pathParams("mypath","users")  //path parameters
                .queryParam("page","2")           //query parameters
                .queryParam("id","5")             //query parameters

                .when()
                .get("https://reqres.in/api/{mypath}")
                .prettyPrint();
    }

}
