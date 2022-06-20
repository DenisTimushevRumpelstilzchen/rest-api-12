package tests;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

import static org.hamcrest.Matchers.is;


public class SelenoidTests {
    /*
        1. make request to https://selenoid.autotests.cloud/status
        2. get response {"total":20,"used":0,"queued":0,"pending":0,"browsers":
            {"chrome":{"100.0":{},"99.0":{}},"firefox":{"97.0":{},"98.0":{}},"opera":{"84.0":{},"85.0":{}}}}
        3. check total is 20
     */

    @Test
    void checkTotal() {
        given()
                .when()
                .get("https://selenoid.autotests.cloud/status")
                .then()
                .body("total", is(20));
    }

    @Test
    void checkWithoutGivenTotal() {
        get("https://selenoid.autotests.cloud/status")
                .then()
                .body("total", is(20));
    }
}
