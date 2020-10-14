package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    private Book testBook;

    @BeforeEach
    public void setUp() {
        testBook = new Book("To Kill a MockingBird", "Harper Lee", "Loved it");
    }

    @Test
    public void testConstructor(){
        assertEquals("To Kill a MockingBird", testBook.getName());
        assertEquals ("Harper Lee", testBook.getAuthor());
        assertEquals ("Loved it", testBook.getReview());
    }
}