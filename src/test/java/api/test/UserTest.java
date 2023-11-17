package api.test;
import api.endpoints.UserEndPoints;
import api.payloads.User;
import api.utilities.Allure_report;
import com.github.javafaker.Faker;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.testng.Assert;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
@Listeners({Allure_report.class})
public class UserTest{
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

    @Description("creating a user profile")
    @Epic("EP001")
    @Feature("feature:post json feature")
    @Story("posting personal info into website")
    @Step("verify creating a user")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority=1,description = "verifying creating an user ")
    public void createAnUser(){
    Response response = UserEndPoints.createUser(this.userPayload);
    response.then().log().all();
    System.out.println("completed");
    Assert.assertEquals(response.getStatusCode(),200);
    }

    @Description("Getting a user profile")
    @Epic("EP002")
    @Feature("feature:Getting json feature")
    @Story("Getting personal info from website")
    @Step("verify Getting a user")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority=2)
    public void testGetUserByName(){
        Response response =UserEndPoints.readUser(this.userPayload.getUsername());
        response.then().log().all();
        System.out.println("completed 2 ");
        Assert.assertEquals(response.getStatusCode(),200);
    }

    @Description("updating a user profile")
    @Epic("EP003")
    @Feature("feature:updating json feature")
    @Story("updating personal info from website")
    @Step("verify updating a user")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority=3)
    public void updateByName(){
        userPayload.setFirstName(faker.name().firstName());
        Response response = UserEndPoints.updateUser(this.userPayload.getUsername(),userPayload);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);

        //after update
        Response responseafter = UserEndPoints.readUser(this.userPayload.getUsername());
        responseafter.then().log().body().statusCode(200);
        System.out.println("after update"+responseafter.asString());

    }

    @Description("deleting a user profile")
    @Epic("EP004")
    @Feature("feature:deleting json feature")
    @Story("deleting personal info from website")
    @Step("verify deleting a user")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority=4)
   public void deleteUserdata() throws IOException {
       Response response =UserEndPoints.deleteUser(this.userPayload.getUsername());
//       response.then().log().all();
//       System.out.println("completed 2 ");
//       Assert.assertEquals(response.getStatusCode(),270);

    }

}
