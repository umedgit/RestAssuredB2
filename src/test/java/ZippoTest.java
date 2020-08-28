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
}
