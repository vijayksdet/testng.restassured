package api.testcases;

import api.endpoints.UserCrudOperations;
import api.payload.User;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class userTests {
    Faker faker;
    User userPayload;

    @BeforeClass
    public void generateTestData() {
        faker = new Faker();
        userPayload = new User();
        userPayload.setId(faker.idNumber().hashCode());
        userPayload.setUsername(faker.name().username());
        userPayload.setFirstName(faker.name().firstName());
        userPayload.setLastName(faker.name().lastName());
        userPayload.setEmail(faker.internet().safeEmailAddress());
        userPayload.setPassword(faker.internet().password());
        userPayload.setPhone(faker.phoneNumber().cellPhone());
    }

    @Test(priority = 1)

    public void createUserTest(){
        Response response =  UserCrudOperations.createUser(userPayload);
        response.then().log().all();
        Assert.assertEquals(200,response.getStatusCode());
    }
    
    @Test (priority=2)
    public  void getUserTest(){
        Response response =  UserCrudOperations.getUser(userPayload.getUsername());
        response.then().log().all();
        Assert.assertEquals(200,response.getStatusCode());
        Assert.assertEquals(response.jsonPath().get("username"),userPayload.getUsername());
    }

    @Test(priority=3)
    public  void UpdateUserTest(){
        userPayload.setPhone(faker.phoneNumber().cellPhone());
        Response response =  UserCrudOperations.puttUser(userPayload.getUsername(), userPayload);
        response.then().log().all();
        Assert.assertEquals(200,response.getStatusCode());
    }

    @Test(priority=4)
    public void deleteUserTest(){
        Response response =  UserCrudOperations.deleteUser(userPayload.getUsername());
        response.then().log().all();
        Assert.assertEquals(200,response.getStatusCode());
    }

}
