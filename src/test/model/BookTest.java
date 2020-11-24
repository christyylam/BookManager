package model;

import exceptions.InvalidRatingException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    public void testConstructorValidRating() {
        try {
            Book testBook = new Book("To Kill a MockingBird", "Harper Lee", 5, "Loved it");
            //expected
            assertEquals("To Kill a MockingBird", testBook.getName());
            assertEquals("Harper Lee", testBook.getAuthor());
            assertEquals(5, testBook.getRating());
            assertEquals("Loved it", testBook.getReview());
        } catch (InvalidRatingException e) {
            fail("InvalidRatingException not expected");
        }
    }

    @Test
    public void testConstructorInvalidRating() {
        try {
            Book testBook = new Book("To Kill a MockingBird", "Harper Lee", 7, "Loved it");
            fail("InvalidRatingException not thrown");
        } catch (InvalidRatingException e) {
            //expected
        }
    }


    @Test
    public void testSetRatingValid() {
        int i = 2;
        try {
            Book testBook = new Book("To Kill a MockingBird", "Harper Lee", 5, "Loved it");
            assertEquals(5, testBook.getRating());
            testBook.setRating(i);
            //expected
            assertEquals(2, testBook.getRating());
        } catch (InvalidRatingException e) {
            fail("InvalidRatingException not expected");
        }
    }

    @Test
    public void testSetRatingInvalidRating() {
        int i = 10;
        try {
            Book testBook = new Book("To Kill a MockingBird", "Harper Lee", 5, "Loved it");
            assertEquals(5, testBook.getRating());
            testBook.setRating(i);
            fail("InvalidRatingException not thrown");
            assertEquals(2, testBook.getRating());
        } catch (InvalidRatingException e) {
            //expected
        }
    }
}
