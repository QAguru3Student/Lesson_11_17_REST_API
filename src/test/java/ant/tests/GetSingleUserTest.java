package ant.tests;

import org.junit.jupiter.api.Test;

import static ant.Specs.request;
import static ant.Specs.responseSpec;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.is;

public class GetSingleUserTest {
    @Test
    void getSingleUser() {
        given()
                .spec(request)
                .when()
                .get("users/2")
                .then()
                .spec(responseSpec)
                .body("data.email", is("janet.weaver@reqres.in"));
    }
}
