package tests;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.is;

public class GetSingleUserTest {
    @Test
    void getSingleUser() {
        given()
                .log().all()
                .contentType(JSON)
                .when()
                .get("https://reqres.in/api/users/2")
                .then()
                .log().all()
                .statusCode(200)
                .body("data.email", is("janet.weaver@reqres.in"));
    }
}
