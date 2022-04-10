package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class GreetingResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/hello")
          .then()
             .statusCode(200)
             .body(is("Hello RESTEasy"));
    }

    /*@Test
    public void testExtensionsIdEndpoint() {
        given()
            .when().get("/history/one?identifikator=b17d479c8839cb08")
            .then()
            .statusCode(200)
            .body("$.size()", is(1));
    }*/

}