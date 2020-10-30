package persistence;

import model.Book;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {
    protected void checkBook(String name, String author, String review, int rating, Book book) {
        assertEquals(name, book.getName());
        assertEquals(author, book.getAuthor());
        assertEquals(review, book.getReview());
        assertEquals(rating, book.getRating());
    }

}
