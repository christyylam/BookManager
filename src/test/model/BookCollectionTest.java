package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class BookCollectionTest {
    private BookCollection testCollection;

    @BeforeEach
    public void setUp() {
        testCollection = new BookCollection();
    }

    @Test
    public void testDoesContainsDoesNot(){
        Book b = new Book("To Kill a MockingBird", "Harper Lee",  "Loved it");
        assertFalse(testCollection.doesContain(b));
    }

    @Test
    public void testDoesContainsDoes(){
        Book b = new Book("To Kill a MockingBird", "Harper Lee",  "Loved it");
        testCollection.addBook(b);
        assertTrue(testCollection.doesContain(b));
    }

    @Test
    public void testAddBookNotInCollection(){
        Book b = new Book("To Kill a MockingBird", "Harper Lee",  "Loved it");
        assertFalse(testCollection.doesContain(b));
        assertTrue(testCollection.addBook(b));
        assertTrue(testCollection.doesContain(b));
    }

    @Test
    public void testAddBookAlreadyInCollection(){
        Book b = new Book("To Kill a MockingBird", "Harper Lee",  "Loved it");
        assertFalse(testCollection.doesContain(b));
        assertTrue(testCollection.addBook(b));
        assertTrue(testCollection.doesContain(b));
        assertFalse(testCollection.addBook(b));
    }

    @Test
    public void testRemoveBookNotInCollection(){
        Book b = new Book("To Kill a MockingBird", "Harper Lee", "Loved it");
        Book a = new Book("Harry Potter", "JK Rowling", "so good!");
        testCollection.addBook(b);
        assertFalse(testCollection.removeBook(a));
        assertFalse(testCollection.doesContain(a));
    }

    @Test
    public void testRemoveBookInCollection(){
        Book b = new Book("To Kill a MockingBird", "Harper Lee", "Loved it");
        Book a = new Book("Harry Potter", "JK Rowling", "so good!");
        testCollection.addBook(a);
        testCollection.addBook(b);
        assertTrue(testCollection.removeBook(b));
        assertFalse(testCollection.doesContain(b));
        assertTrue(testCollection.doesContain(a));
    }

    @Test
    public void testGetBookCollection(){
        Book b = new Book("To Kill a MockingBird", "Harper Lee", "Loved it");
        Book a = new Book("Harry Potter", "JK Rowling", "so good!");
        testCollection.addBook(a);
        testCollection.addBook(b);
        for(Book c: testCollection.getBookCollection()) {
            assertTrue(testCollection.doesContain(c));
        }
    }


}
