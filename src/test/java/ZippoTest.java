import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ZippoTest {
    @Test
    public void getTest() {
        given()
                // prior conditions
                .when()
                .get("http://api.zippopotam.us/us/90210") // action
                .then()
                .statusCode(200) // assertion
        ;
    }

    @Test
    public void contentTypeTest() {
        given()
                .when()
                .get("http://api.zippopotam.us/us/90210")
                .then()
                .contentType(ContentType.JSON);
    }

    @Test
    public void chainingAssertionsTest() {
        given()
                // prior conditions
                .when()
                .get("http://api.zippopotam.us/us/90210") // action
                .then() // checks comes after then()
                .statusCode(200) // assertion checks
                .contentType(ContentType.JSON) // assertion checks
        ;
    }

}
