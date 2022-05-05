package tests;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PostRegisterUnssuccefulTest {
    @Test
    void postRegisterUnssucceful() {
        String email = "{ \"email\": \"sydney@fife\"}";
        String response =
        given()
                .contentType(JSON)
                .body(email)
                .when()
                .post("https://reqres.in/api/register")
                .then()
                .statusCode(400)
                .body("error", is("Missing password"))
                .extract().response().asString();
        System.out.println(response);

    }
}
