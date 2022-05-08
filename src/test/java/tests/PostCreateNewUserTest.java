package tests;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.is;

public class PostCreateNewUserTest {
    @Test
    void postCreateNewUser() {
        String newUser = "{\"name\": \"morpheus\"," +
                "\"job\": \"leader\"}";
        given()
                .log().all()
                .contentType(JSON)
                .body(newUser)
                .when()
                .post("https://reqres.in/api/users")
                .then()
                .log().all()
                .statusCode(201)
                .body("job" , is("leader"));
    }
}
