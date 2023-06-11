package org.programacionparaaprender.quarkus.starting;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;

@QuarkusTest
public class BookResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/api/books/hello")
          .then()
             .statusCode(200)
             .body(is("Hello RESTEasy"));
    }

    @Test
    public void testgetBooks() {
        given()
            .pathParam("id", 1)
          .when().get("/api/books/{id}")
          .then()
             .statusCode(200)
             .body("title",is("Understanding Quarkus"))
             .body("autor",is("Antonio"))
             .body("yearOfPublication",is(2020))
             .body("genre",is("IT")
             );
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


    @Test
    public void shouldCountAllBooks() {
        given()
          .when().get("/api/books/count")
          .then()
             .statusCode(200)
             .body(is("4"));
    }

}