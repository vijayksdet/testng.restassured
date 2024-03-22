package api.endpoints;
import api.payload.User;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserCrudOperations {
    public  static Response createUser(User payload){
        Response response = RestAssured.given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .when()
                .body(payload)
                .post(UserEndPoints.baseURL+UserEndPoints.postEndpoint);
        return response;
    }

    public  static  Response getUser(String userName){
        Response response = RestAssured.given()
                .accept(ContentType.JSON)
                .pathParam("username",userName)
                .when()
                .get(UserEndPoints.baseURL+UserEndPoints.getEndpoint);
        return response;
    }

    public  static  Response puttUser(String userName,User payLoad){
        Response response = RestAssured.given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .pathParam("username",userName)
                .body(payLoad)
                .when()
                .put(UserEndPoints.baseURL+UserEndPoints.putEndpoint);
        return response;
    }

    public  static  Response deleteUser(String userName){
        Response response = RestAssured.given()
                .accept(ContentType.JSON)
                .pathParam("username",userName)
                .when()
                .delete(UserEndPoints.baseURL+UserEndPoints.deleteEndpoint);
        return response;
    }
}
