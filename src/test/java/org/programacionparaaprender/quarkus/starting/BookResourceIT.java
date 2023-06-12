package org.programacionparaaprender.quarkus.starting;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusIntegrationTest;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusIntegrationTest
public class BookResourceIT extends BookResourceTest {
    
    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/api/books/hello")
          .then()
             .statusCode(200)
             .body(is("Hello RESTEasy"));
    }

    @Test
    public void testAllBooks() {
        given()
            .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
          .when().get("/api/books")
          .then()
             .statusCode(200)
             .body("size()", is(4));
    }
}
