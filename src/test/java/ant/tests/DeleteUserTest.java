package ant.tests;

import org.junit.jupiter.api.Test;

import static ant.Specs.request;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;
import static io.restassured.http.ContentType.JSON;

public class DeleteUserTest {
    @Test
    void deleteUser() {
        given()
                .spec(request)
                .when()
                .delete("users/2")
                .then()
                .log().all()
                .statusCode(204);
    }
}
