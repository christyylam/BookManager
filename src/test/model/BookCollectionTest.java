package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

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
    public void testContainsDoesNotContain(){
        Book b = new Book("To Kill a MockingBird", "Harper Lee",  "Loved it");
        assertFalse(testCollection.contains(b));
    }

    @Test
    public void testContainsDoesContain(){
        Book b = new Book("To Kill a MockingBird", "Harper Lee",  "Loved it");
        testCollection.addBook(b);
        assertTrue(testCollection.contains(b));
    }

    @Test
    public void testAddBookNotInCollection(){
        Book b = new Book("To Kill a MockingBird", "Harper Lee",  "Loved it");
        assertFalse(testCollection.contains(b));
        assertTrue(testCollection.addBook(b));
        assertTrue(testCollection.contains(b));
    }

    @Test
    public void testAddBookAlreadyInCollection(){
        Book b = new Book("To Kill a MockingBird", "Harper Lee",  "Loved it");
        testCollection.addBook(b);
        assertTrue(testCollection.contains(b));
        assertFalse(testCollection.addBook(b));
    }

    @Test
    public void testRemoveBookNotInCollection(){
        Book b = new Book("To Kill a MockingBird", "Harper Lee", "Loved it");
        Book a = new Book("Harry Potter", "JK Rowling", "so good!");
        testCollection.addBook(b);
        assertFalse(testCollection.removeBook(a));
        assertFalse(testCollection.contains(a));
    }

    @Test
    public void testRemoveBookInCollection(){
        Book b = new Book("To Kill a MockingBird", "Harper Lee", "Loved it");
        Book a = new Book("Harry Potter", "JK Rowling", "so good!");
        testCollection.addBook(a);
        testCollection.addBook(b);
        assertTrue(testCollection.removeBook(b));
        assertFalse(testCollection.contains(b));
        assertTrue(testCollection.contains(a));
    }


}
