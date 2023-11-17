package api.test;

import api.endpoints.UserEndpoint_properties;
import api.payloads.User;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class UserTest_properties {
    Faker faker;
    User userPayload;
@BeforeTest
    public void setUp(){
    faker= new Faker();
    userPayload = new User();
    userPayload.setId(faker.idNumber().hashCode());
    userPayload.setUsername(faker.name ().username());
    userPayload.setFirstName(faker.name().firstName());
    userPayload.setLastname(faker.name().lastName());
    userPayload.setEmail(faker.internet().emailAddress());
    userPayload.setPassword(faker.internet().password(5,10));
    userPayload.setPhone(faker.phoneNumber().cellPhone());
    }
@Test(priority=1)
    public void postUser(){
    Response response = UserEndpoint_properties.createUser(userPayload);
    response.then().log().all();

    Assert.assertEquals(response.getStatusCode(),200);
    }
    @Test(priority=2)
    public void testGetUserByName(){
        Response response =UserEndpoint_properties.readUser(userPayload.getUsername());
        System.out.println(this.userPayload.getUsername());
        System.out.println(userPayload.getUsername());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
    }
    @Test(priority=3)
    public void updateByName(){
        userPayload.setFirstName(faker.name().firstName());
        Response response = UserEndpoint_properties.updateUser(this.userPayload.getUsername(),userPayload);
        System.out.println("Before update");
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);

        //after update
        Response responseafter = UserEndpoint_properties.readUser(this.userPayload.getUsername());
        responseafter.then().log().body().statusCode(200);
        System.out.println("after update"+responseafter.asString());

    }
@Test(priority=4)
   public void deleteUserdata() throws IOException {
       Response response =UserEndpoint_properties.deleteUser(this.userPayload.getUsername());
       response.then().log().all();
       Assert.assertEquals(response.getStatusCode(),200);

    }
}
