package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    private Book testBook;

    @BeforeEach
    public void setUp() {
        testBook = new Book("To Kill a MockingBird", "Harper Lee", 5,"Loved it");
    }

    @Test
    public void testConstructor(){
        assertEquals("To Kill a MockingBird", testBook.getName());
        assertEquals ("Harper Lee", testBook.getAuthor());
        assertEquals(5, testBook.getRating());
        assertEquals ("Loved it", testBook.getReview());
    }

    @Test
    public void testSetRating(){
        int i = 2;
        assertEquals(0, testBook.getRating());
        testBook.setRating(i);
        assertEquals(2, testBook.getRating());
    }
}