package basqar;

import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class CountryTest {

    private Cookies cookies;

    @BeforeClass
    public void init() {

        baseURI = "https://test.basqar.techno.study";

        Map<String, String> credentials = new HashMap<>();
        credentials.put("username", "daulet2030@gmail.com");
        credentials.put("password", "TechnoStudy123@");

        cookies = given()
                .contentType(ContentType.JSON)
                .body(credentials)
//                .body("{\"username\":\"daulet2030@gmail.com\",\"password\":\"TechnoStudy123@\",\"rememberMe\":false}")
                .when()
                .post("/auth/login")
                .then()
                .statusCode(200)
                .extract().response().detailedCookies();
    }
}
