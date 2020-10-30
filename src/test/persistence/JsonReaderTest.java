package persistence;

import model.Book;
import model.BookCollection;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

//CITATION: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git
public class JsonReaderTest extends JsonTest {

    @Test
    public void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            BookCollection bc = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            //pass
        }
    }

    @Test
    public void testReaderEmptyBookCollection(){
        JsonReader reader = new JsonReader("./data/testReaderEmptyBookCollection.json");
        try {
            BookCollection bc = reader.read();
            assertEquals("My Book Collection", bc.getName());
            assertEquals(0, bc.numBooks());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralBookCollection() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralBookCollection.json");
        try {
            BookCollection bc = reader.read();
            assertEquals("My Book Collection", bc.getName());
            List<Book> books = bc.getBookCollection();
            assertEquals(2, books.size());
            checkBook("To Kill a Mockingbird", "Harper Lee", "Loved it", 5, books.get(0));
            checkBook("Harry Potter", "JK Rowling", "good", 5, books.get(1));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }



}
