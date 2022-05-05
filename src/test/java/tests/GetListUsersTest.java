package tests;

import org.hamcrest.core.AnyOf;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetListUsersTest {

    @Test
    void getUser() {
        int actualPage =
                given()
                        .contentType(JSON)
                        .when()
                        .get("https://reqres.in/api/unknown")
                        .then()
                        .statusCode(200)
                        .extract().path("total_pages");
        System.out.println(actualPage);
        int expectedPage = 2;
        assertEquals  (expectedPage, actualPage);

    }

    @Test
    void getData() {
        ArrayList<HashMap> data =
                given()
                        .contentType(JSON)
                        .when()
                        .get("https://reqres.in/api/users?page=2")
                        .then()
                        .statusCode(200)
                        .extract().path("data");
        String first_name = "Michael";
        String response_first_name = data.get(0).get("first_name").toString();
        System.out.println(response_first_name);
        assertEquals  (first_name, response_first_name);
    }


}

