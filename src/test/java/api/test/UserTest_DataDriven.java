package api.test;

import api.endpoints.UserEndPoints;
import api.payloads.User;
import api.utilities.DataDriven;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserTest_DataDriven {
    User user;

    @Test(priority = 1,dataProvider = "data", dataProviderClass = DataDriven.class)
    void testPost(String id,String username,String firstname, String lastname,String email,String passsword, String phone){

        user = new User();
        user.setId(Integer.parseInt(id));
        user.setUsername(username);
        user.setFirstName(firstname);
        user.setLastname(lastname);
        user.setEmail(email);
        user.setPassword(passsword);
        user.setPhone(phone);
        // post crud opreations
        Response res = UserEndPoints.createUser(user);
        int statusCode = res.getStatusCode();
        System.out.println(statusCode);
        Assert.assertEquals(statusCode,200);

        // get crud operations
        Response res1 = UserEndPoints.readUser(this.user.getUsername());
        res1.then().log().all();

    }

    @Test(priority = 2,dataProvider = "userdata", dataProviderClass = DataDriven.class)
    void deleteData(String username){
        Response res1 = UserEndPoints.deleteUser(username);
        res1.then().log().all();
        Assert.assertEquals(res1.getStatusCode(),200);
    }

}
