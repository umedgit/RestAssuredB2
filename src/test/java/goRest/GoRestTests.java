package goRest;

import goRest.pojo.User;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GoRestTests {

    @Test
    public void extractingListOfUsers() {
        List<User> userList = given()
                .when()
                .get("https://gorest.co.in/public-api/users")
                .then()
                .extract().response().jsonPath().getList("data", User.class);

        for (User user : userList) {
            System.out.println(user);
        }
    }
    @Test
    public void extractingListOfUsersAsArray() {
        User[] userList = given()
                .when()
                .get("https://gorest.co.in/public-api/users")
                .then()
                .extract().response().jsonPath().getObject("data", User[].class);

        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void extractingOneUser() {
        User user = given()
                .when()
                .get("https://gorest.co.in/public-api/users")
                .then()
                .extract().response().jsonPath().getObject("data[2]", User.class);

        System.out.println(user);
    }
}
