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

    @Test
    public void logTest() {
        given()
                .log().all()  // print out everything about the request
                .when()
                .get("http://api.zippopotam.us/us/90210")
                .then()
                .log().all() // print out everything about the response
        ;
    }

    @Test
    public void checkingResponseBody() {
        given()
                .when()
                .get("http://api.zippopotam.us/us/07652")
                .then()
                .log().all()
                .body("places[0].state", equalTo("New Jersey"))
        ;
    }

    @Test
    public void checkingResponseBodyWithSpaceFields() {
        given()
                .when()
                .get("http://api.zippopotam.us/us/07652")
                .then()
                .log().all()
                .body("places[0].'place name'", equalTo("Paramus"))
        ;
    }

    @Test
    public void checkingSizeOfArray() {
        given()
                .when()
                .get("http://api.zippopotam.us/us/07652")
                .then()
                .log().body()
                .body("places", hasSize(1))
        ;
    }

    @Test
    public void chainingTest2() {
        given()
                .when()
                .get("http://api.zippopotam.us/us/07652")
                .then()
                .log().body()
                .statusCode(200) // assertion checks
                .contentType(ContentType.JSON) // assertion checks
                .body("places", hasSize(1))
                .body("places[0].state", equalTo("New Jersey"))
                .body("places[0].'place name'", equalTo("Paramus"))
        ;
    }
}
