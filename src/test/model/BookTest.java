package model;

import exceptions.InvalidRatingException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    public void testConstructorValidRatingEdgeCaseOne() {
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
    public void testConstructorValidRatingEdgeCaseTwo() {
        try {
            Book testBook = new Book("To Kill a MockingBird", "Harper Lee", 0, "Loved it");
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
    public void testConstructorValidRatingMiddleCase() {
        try {
            Book testBook = new Book("To Kill a MockingBird", "Harper Lee", 3, "Loved it");
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
    public void testConstructorInvalidRatingGreaterThanFive() {
        try {
            Book testBook = new Book("To Kill a MockingBird", "Harper Lee", 7, "Loved it");
            fail("InvalidRatingException not thrown");
        } catch (InvalidRatingException e) {
            //expected
        }
    }

    @Test
    public void testConstructorInvalidRatingLessThanZero() {
        try {
            Book testBook = new Book("To Kill a MockingBird", "Harper Lee", -1, "Loved it");
            fail("InvalidRatingException not thrown");
        } catch (InvalidRatingException e) {
            //expected
        }
    }


    @Test
    public void testSetRatingValidEdgeCaseOne() {
        int i = 5;
        try {
            Book testBook = new Book("To Kill a MockingBird", "Harper Lee", 2, "Loved it");
            assertEquals(2, testBook.getRating());
            testBook.setRating(i);
            //expected
            assertEquals(5, testBook.getRating());
        } catch (InvalidRatingException e) {
            fail("InvalidRatingException not expected");
        }
    }

    @Test
    public void testSetRatingValidEdgeCaseTwo() {
        int i = 0;
        try {
            Book testBook = new Book("To Kill a MockingBird", "Harper Lee", 2, "Loved it");
            assertEquals(2, testBook.getRating());
            testBook.setRating(i);
            //expected
            assertEquals(0, testBook.getRating());
        } catch (InvalidRatingException e) {
            fail("InvalidRatingException not expected");
        }
    }

    @Test
    public void testSetRatingValidMiddleCase() {
        int i = 3;
        try {
            Book testBook = new Book("To Kill a MockingBird", "Harper Lee", 2, "Loved it");
            assertEquals(2, testBook.getRating());
            testBook.setRating(i);
            //expected
            assertEquals(3, testBook.getRating());
        } catch (InvalidRatingException e) {
            fail("InvalidRatingException not expected");
        }
    }

    @Test
    public void testSetRatingInvalidRatingGreaterThanFive() {
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

    @Test
    public void testSetRatingInvalidRatingLessThanZero() {
        int i = -1;
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
