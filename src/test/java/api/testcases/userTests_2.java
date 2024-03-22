package api.testcases;

import api.endpoints.UserCrudOperations;
import api.utilities.jsonReader;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import api.payload.User;

public class userTests_2 {
    User userPayload;
    @Test(priority = 1)
    public void createUserTest_2(){
        String baseDir= System.getProperty("user.dir");
        userPayload =jsonReader.readJson(baseDir+"/src/test/java/api/payload/userData.json",User.class);
        Response response =  UserCrudOperations.createUser(userPayload);
        response.then().log().all();
        Assert.assertEquals(200,response.getStatusCode());
    }


    @Test (priority=2)
    public  void getUserTest_2(){
        Response response =  UserCrudOperations.getUser(userPayload.getUsername());
        response.then().log().all();
        Assert.assertEquals(200,response.getStatusCode());
        Assert.assertEquals(response.jsonPath().get("username"),userPayload.getUsername());
    }

    @Test(priority=3)
    public  void UpdateUserTest_2(){
        userPayload.setPhone("99090900");
        Response response =  UserCrudOperations.puttUser(userPayload.getUsername(), userPayload);
        response.then().log().all();
        Assert.assertEquals(200,response.getStatusCode());
    }

    @Test(priority=4)
    public void deleteUserTest_2(){
        Response response =  UserCrudOperations.deleteUser(userPayload.getUsername());
        response.then().log().all();
        Assert.assertEquals(200,response.getStatusCode());
    }

    ///Users/vgopalam/Personal/Java Projects/vijayksdk.testng.restassured/src/test/java/api/payload/userData.json


}
