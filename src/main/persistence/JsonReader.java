package persistence;

import exceptions.InvalidRatingException;
import model.Book;
import model.BookCollection;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;


//CITATION: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git
//Represents a reader that reads Bookcollection from JSON data stored in file
public class JsonReader {
    private String source;

    //EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    //EFFECTS: reads bookcollection from file and returns it;
    //throws IOException if an error occurs reading data from file
    public BookCollection read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseBookCollection(jsonObject);
    }

    //EFFECTS: reads source file as a string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    //EFFECTS: parses bookcollection from JSON object and returns it
    private BookCollection parseBookCollection(JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        BookCollection bc = new BookCollection(name);
        addBooks(bc, jsonObject);
        return bc;
    }

    //MODIFIES: bc
    //EFFECTS: parses books from JSON object and adds them to bookcollection
    private void addBooks(BookCollection bc, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("books");
        for (Object json : jsonArray) {
            JSONObject nextBook = (JSONObject) json;
            addBook(bc, nextBook);
        }
    }

    //MODIFIES: bc
    //EFFECTS: parses book from JSON object and adds it to bookcollection
    private void addBook(BookCollection bc, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        String author = jsonObject.getString("author");
        String review = jsonObject.getString("review");
        int rating = jsonObject.getInt("rating");
        try {
            Book book = new Book(name, author, rating, review);
            bc.addBook(book);
        } catch (InvalidRatingException e) {
            System.out.println("Invalid Rating!");;
        }
    }

}
