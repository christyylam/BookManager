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
        testCollection = new BookCollection("Christy");
    }

    @Test
    public void testDoesContainsDoesNot(){
        Book b = new Book("To Kill a Mockingbird", "Harper Lee",  "Loved it");
        assertFalse(testCollection.doesContain(b));
    }

    @Test
    public void testDoesContainsDoes(){
        Book b = new Book("To Kill a Mockingbird", "Harper Lee",  "Loved it");
        testCollection.addBook(b);
        assertTrue(testCollection.doesContain(b));
    }

    @Test
    public void testAddBookNotInCollection(){
        Book b = new Book("To Kill a Mockingbird", "Harper Lee",  "Loved it");
        assertFalse(testCollection.doesContain(b));
        assertTrue(testCollection.addBook(b));
        assertTrue(testCollection.doesContain(b));
    }

    @Test
    public void testAddBookSameNameSameAuthor(){
        Book b = new Book("To Kill a Mockingbird", "Harper Lee",  "Loved it");
        Book c = new Book ("To Kill a Mockingbird", "Harper Lee",  "Loved it");
        assertFalse(testCollection.doesContain(b));
        assertTrue(testCollection.addBook(b));
        assertFalse(testCollection.addBook(c));
    }

    @Test
    public void testAddBookSameNameDiffAuthor() {
        Book b = new Book("Book", "Harper Lee",  "Loved it");
        Book c = new Book ("Book", "JK Rowling",  "Loved it");
        assertTrue(testCollection.addBook(b));
        assertTrue(testCollection.addBook(c));
    }

    @Test
    public void testAddBookDiffNameSameAuthor() {
        Book b = new Book("Hunger Games", "Suzanne Collins",  "Loved it");
        Book c = new Book ("Catching Fire", "Suzanne Collins",  "Loved it");
        assertTrue(testCollection.addBook(b));
        assertTrue(testCollection.addBook(c));
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
