package tests;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static listeners.CustomAllureListener.withCustomTemplates;

public class DemoWebshopTests {
   @Test
    void logInTest() {
                given()
                        .filter(withCustomTemplates())
                        .contentType("application/x-www-form-urlencoded")
                        .formParam("Email", "n.kozyrev@pik-remont.ru")
                        .formParam("Password", "12341234")
                        .when()
                        .post("http://demowebshop.tricentis.com/login")
                        .then()
                        .log().all()
                        .statusCode(302);
    }
}

