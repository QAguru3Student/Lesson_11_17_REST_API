package ant.tests;

import org.junit.jupiter.api.Test;
import static ant.Specs.request;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class PostCreateNewUserTest {
    @Test
    void postCreateNewUser() {
        String newUser = "{\"name\": \"morpheus\"," +
                "\"job\": \"leader\"}";
        given()
                .spec(request)
                .body(newUser)
                .when()
                .post("users")
                .then()
                .log().all()
                .statusCode(201)
                .body("job" , is("leader"));
    }
}
