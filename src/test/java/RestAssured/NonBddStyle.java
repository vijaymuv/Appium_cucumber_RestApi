package RestAssured;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.io.PrintStream;

public class NonBddStyle {

//    @Test
    void get_NonBdd() {
        RestAssured.baseURI = "http://localhost:3000/";
        RequestSpecification reqSpec = RestAssured.given();
        Response response = reqSpec.request(Method.GET, "employees");
        System.out.println(response.asPrettyString());
        System.out.println(response.statusCode());
        System.out.println(response.statusLine());

    }
//    @Test
    void post_NonBdd(){
        RestAssured.baseURI="http://localhost:3000/";
        RequestSpecification requestSpecification=RestAssured.given()
                .header("Content-Type","application/json")
                .body("{\n" +
                        "    \"name\": \"morpheus\",\n" +
                        "    \"job\": \"leader\",\n" +
                        "    \"id\": \"100\",\n" +
                        "    \"email\": \"morpheus@gmail.com\",\n" +
                        "    \"createdAt\": \"2023-05-08T10:36:39.867Z\"\n" +
                        "  }");
        Response response = requestSpecification.request(Method.POST, "employees");
        System.out.println(response.asPrettyString());
        System.out.println(response.statusCode());
        System.out.println(response.statusLine());
    }
//    @Test
    void put_NonBdd(){
        RestAssured.baseURI="http://localhost:3000/";
        RequestSpecification requestSpec = RestAssured.given().
                header("Content-Type", "application/json")
                .body("{\"age\": \"1000\"}");
        Response response = requestSpec.request(Method.PATCH, "employees/NAgjPSk");
        System.out.println(response.asPrettyString());
        System.out.println(response.statusCode());
        System.out.println(response.statusLine());
    }
    @Test
    void delete_NonBdd(){
        RestAssured.baseURI="http://localhost:3000/";
        RequestSpecification requestSpec = RestAssured.given();
        Response response = requestSpec.request(Method.DELETE, "employees/i60fU8l");
        System.out.println(response.asPrettyString());
        System.out.println(response.statusCode());
        System.out.println(response.statusLine());
        PrintStream out = System.out;out.println("hi");
    }
}

//NAgjPSk