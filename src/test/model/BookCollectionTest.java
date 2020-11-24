package model;

import exceptions.InvalidRatingException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class BookCollectionTest {
    private BookCollection testCollection;

    @BeforeEach
    public void setUp() {
        testCollection = new BookCollection("Christy");
    }

    @Test
    public void testDoesContainsDoesNot() {
        try {
            Book b = new Book("To Kill a Mockingbird", "Harper Lee", 5, "Loved it");
            assertFalse(testCollection.doesContain(b));
            //expected
        } catch (InvalidRatingException e) {
            fail("InvalidRatingException was thrown");
        }
    }

    @Test
    public void testDoesContainsDoes() {
        try {
            Book b = new Book("To Kill a Mockingbird", "Harper Lee", 5, "Loved it");
            testCollection.addBook(b);
            assertTrue(testCollection.doesContain(b));
        } catch (InvalidRatingException e) {
            fail("InvalidRatingException was thrown");
        }
    }

    @Test
    public void testAddBookNotInCollection() {
        try {
            Book b = new Book("To Kill a Mockingbird", "Harper Lee", 5, "Loved it");
            assertFalse(testCollection.doesContain(b));
            assertTrue(testCollection.addBook(b));
            assertTrue(testCollection.doesContain(b));
        } catch (InvalidRatingException e) {
            fail("InvalidRatingException was thrown");
        }
    }

    @Test
    public void testAddBookSameNameSameAuthor() {
        try {
            Book b = new Book("Book", "Harper Lee", 5, "Loved it");
            Book c = new Book("Book", "JK Rowling", 5, "Loved it");
            assertFalse(testCollection.doesContain(b));
            assertTrue(testCollection.addBook(b));
            assertFalse(testCollection.addBook(c));
        } catch (InvalidRatingException e) {
            fail("InvalidRatingException was thrown");
        }
    }

    @Test
    public void testAddBookSameNameDiffAuthor() {
        try {
            Book b = new Book("Book", "Harper Lee", 5, "Loved it");
            Book c = new Book("Book", "JK Rowling", 5, "Loved it");
            assertTrue(testCollection.addBook(b));
            assertTrue(testCollection.addBook(c));
        } catch (InvalidRatingException e) {
            fail("InvalidRatingException was thrown");
        }
    }

    @Test
    public void testAddBookDiffNameSameAuthor() {
        try {
            Book b = new Book("Hunger Games", "Suzanne Collins", 5, "Loved it");
            Book c = new Book("Catching Fire", "Suzanne Collins", 5, "Loved it");
            assertTrue(testCollection.addBook(b));
            assertTrue(testCollection.addBook(c));
        } catch (InvalidRatingException e) {
            fail("InvalidRatingException was thrown");
        }
    }


    @Test
    public void testRemoveBookNotInCollection() {
        try {
            Book b = new Book("To Kill a MockingBird", "Harper Lee", 5, "Loved it");
            Book a = new Book("Harry Potter", "JK Rowling", 5, "so good!");
            testCollection.addBook(b);
            assertFalse(testCollection.removeBook(a));
            assertFalse(testCollection.doesContain(a));
        } catch (InvalidRatingException e) {
            fail("InvalidRatingException was thrown");
        }
    }

    @Test
    public void testRemoveBookInCollection() {
        try {
            Book b = new Book("To Kill a MockingBird", "Harper Lee", 5, "Loved it");
            Book a = new Book("Harry Potter", "JK Rowling", 5, "so good!");
            testCollection.addBook(a);
            testCollection.addBook(b);
            assertTrue(testCollection.removeBook(b));
            assertFalse(testCollection.doesContain(b));
            assertTrue(testCollection.doesContain(a));
        } catch (InvalidRatingException e) {
            fail("InvalidRatingException was thrown");
        }
    }

    @Test
    public void testGetBookCollection() {
        try {
            Book b = new Book("To Kill a MockingBird", "Harper Lee", 5, "Loved it");
            Book a = new Book("Harry Potter", "JK Rowling", 5, "so good!");
            testCollection.addBook(a);
            testCollection.addBook(b);
            for (Book c : testCollection.getBookCollection()) {
                assertTrue(testCollection.doesContain(c));
            }
        } catch (InvalidRatingException e) {
            fail("InvalidRatingException was thrown");
        }
    }

    @Test
    public void testGetBookAtIndex() {
        try {
            Book b = new Book("To Kill a MockingBird", "Harper Lee", 5, "Loved it");
            Book a = new Book("Harry Potter", "JK Rowling", 5, "so good!");
            testCollection.addBook(a);
            testCollection.addBook(b);
            assertEquals(b, testCollection.getBookAtIndex(1));
            assertEquals(a, testCollection.getBookAtIndex(0));
        } catch (InvalidRatingException e) {
            fail("InvalidRatingException was thrown");
        }


    }
}
