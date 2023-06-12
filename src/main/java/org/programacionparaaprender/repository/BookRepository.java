package org.programacionparaaprender.repository;

import java.util.List;
import java.util.Optional;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.programacionparaaprender.models.Book;
import jakarta.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class BookRepository {

    @ConfigProperty(name="books.genre", defaultValue = "Sci-Fi")
	private String genre;

    public Optional<Book> getBook(final String id){
        return getAllBooks().stream().filter(book -> book.id == Long.parseLong(id)).findFirst();
    }

    public int getCount(){
        return getAllBooks().size();
    }

    public List<Book> getAllBooks(){
        Book book1 = new Book();
        book1.id = 1L;
        book1.title = "Understanding Quarkus";
        book1.autor = "Antonio";
        book1.yearOfPublication = 2020;
        book1.genre = genre;
        Book book2;
        book2 = new Book();
        book2.id = 2L;
        book2.title = "Practising Quarkus";
        book2.autor = "Antonio";
        book2.yearOfPublication = 2020;
        book2.genre = "IT";
        Book book3;
        book3 = new Book();
        book3.id = 3L;
        book3.title = "Effective Java";
        book3.autor = "Josh Bloch";
        book3.yearOfPublication = 2001;
        book3.genre = "IT";
        Book book4;
        book4 = new Book();
        book4.id = 4L;
        book4.title = "Thinking in Java";
        book4.autor = "Bruce Eckel";
        book4.yearOfPublication = 1998;
        book4.genre = "IT";
        return List.of(book1, book2, book3, book4);
    }
}
