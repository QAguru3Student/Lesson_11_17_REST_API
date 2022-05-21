package ant.tests;

import ant.lombok.LombokUserData;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.http.ContentType.JSON;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static ant.Specs.request;
import static ant.Specs.responseSpec;


public class GetListUsersTest {

    @Test
    void getMyUser() {
        int actualPage =
                given()
                        .spec(request)
                        .get("unknown")
                        .then()
                        .spec(responseSpec)
                        .extract().path("total_pages");
        System.out.println(actualPage);
        int expectedPage = 2;
        assertEquals  (expectedPage, actualPage);
    }

    @Test
    void getData() {
        LombokUserData data =
                given()
                        .spec(request)
                        .when()
                        .get("/users?page=2")
                        .then()
                        .spec(responseSpec)
                        .extract().as(LombokUserData.class);
        System.out.println(data);

    }
}

