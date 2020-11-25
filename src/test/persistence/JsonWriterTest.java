package persistence;

import exceptions.InvalidRatingException;
import model.Book;
import model.BookCollection;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

//CITATION: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git
public class JsonWriterTest extends JsonTest {

    @Test
    public void testWriterInvalidFile() {
        try {
            BookCollection bc = new BookCollection("My Book Collection");
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException not thrown");
        } catch (IOException e) {
            //expected
        }
    }

    @Test
    public void testWriterEmptyBookCollection() {
        try {
            BookCollection bc = new BookCollection("My Book Collection");
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyBookCollection.json");
            writer.open();
            writer.write(bc);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyBookCollection.json");
            bc = reader.read();
            assertEquals("My Book Collection", bc.getName());
            assertEquals(0, bc.numBooks());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    public void testWriterGeneralBookCollectionNoExceptions() {
        try {
            BookCollection bc = new BookCollection("My Book Collection");
            Book b1 = new Book("Harry Potter", "JK Rowling", 5,"good");
            Book b2 = new Book("To Kill a Mockingbird", "Harper Lee", 5,"Loved it");
            bc.addBook(b1);
            bc.addBook(b2);
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralBookCollection.json");
            writer.open();
            writer.write(bc);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralBookCollection.json");
            bc = reader.read();
            assertEquals("My Book Collection", bc.getName());
            List<Book> books = bc.getBookCollection();
            assertEquals(2, books.size());
            checkBook("Harry Potter", "JK Rowling", "good", 5, books.get(0));
            checkBook("To Kill a Mockingbird", "Harper Lee", "Loved it", 5, books.get(1));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        } catch (InvalidRatingException i) {
            fail("InvalidRatingException should not have been thrown");
        }
    }
}
