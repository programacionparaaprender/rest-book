package org.programacionparaaprender.quarkus.starting;

import java.util.List;
import java.util.Optional;

import org.jboss.logging.Logger;
import org.programacionparaaprender.models.Book;
import org.programacionparaaprender.repository.BookRepository;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/api/books")
public class BookResource {

    @Inject
    BookRepository repository;

    @Inject
    Logger logger;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("hello")
    public String hello() {
        return "Hello RESTEasy";
    }

    @Produces(MediaType.APPLICATION_JSON)
    @GET
    @Path("{id}")
    public Optional<Book> getBook(@PathParam("id") final String id){
        logger.info("return book: " + id);
        return repository.getBook(id);
    }

    @Produces(MediaType.TEXT_PLAIN)
    @GET
    @Path("count")
    public int getCount(){
        int count;
        count = repository.getCount();
        logger.info("return count book: " + count);
        return count;
    }

    @GET
    public List<Book> getAllBooks(){
        logger.info("return all books");
        return repository.getAllBooks();
    }
}
