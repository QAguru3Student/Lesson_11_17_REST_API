package ant.tests;

import org.junit.jupiter.api.Test;

import static ant.Specs.request;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class PostRegisterUnssuccefulTest {
    @Test
    void postRegisterUnssucceful() {
        String email = "{ \"email\": \"sydney@fife\"}";
        String response =
        given()
                .spec(request)
                .body(email)
                .when()
                .post("https://reqres.in/api/register")
                .then()
                .log().all()
                .statusCode(400)
                .body("error", is("Missing password"))
                .extract().response().asString();
        System.out.println(response);

    }
}
