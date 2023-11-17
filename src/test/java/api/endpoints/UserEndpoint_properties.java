package api.endpoints;

import api.payloads.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.ResourceBundle;

import static io.restassured.RestAssured.given;

public class UserEndpoint_properties {
    static ResourceBundle routes = ResourceBundle.getBundle("routes");
    static void getURl() {
        //create method to get values from properties file
       // ResourceBundle routes = ResourceBundle.getBundle("routes");

    }
    public static Response createUser(User payload){
        String postUrl = routes.getString("post_url");
//        String postUrl = getURl().getString("post_url");
        Response response =given()
            .contentType(ContentType.JSON)
            .accept(ContentType.JSON)
            .body(payload)
            .when()
            .post(postUrl);
    return response;
}
    public static Response readUser(String userName){
        String getURL = routes.getString("get_url");
        Response response= given()
                .pathParam("username",userName)
                .when()
                .get(getURL);
        return response;
    }
    public static Response updateUser(String userName, User payload){

        String putUrl = routes.getString("update_url");
        Response response =given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .pathParam("username",userName)
                .body(payload)
                .when()
                .put(putUrl);

        return response;
    }
    public static Response deleteUser(String userName){
        String deleteUrl = routes.getString("delete_url");
        Response response= given()
                .pathParam("username",userName)
                .when()
                .delete(deleteUrl);

        return response;
    }
}
