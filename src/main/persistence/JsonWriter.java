package persistence;

import model.BookCollection;
import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.*;

public class JsonWriter {
    private static final int TAB = 4;
    private PrintWriter writer;
    private String destination;

    //CITATION: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git
    //EFFECTS: constructs writer to write the destination file
    public JsonWriter(String destination) {
        this.destination = destination;
    }

    //MODIFIES: this
    //EFFECTS: opens writer; throws FileNotFoundException
    public void open() throws FileNotFoundException {
        writer = new PrintWriter(new File(destination));
    }

    // MODIFIES: this
    // EFFECTS: writes JSON representation of bookcollection to file
    public void write(BookCollection bc) {
        JSONObject json = bc.toJson();
        saveToFile(json.toString(TAB));
    }

    // MODIFIES: this
    // EFFECTS: closes writer
    public void close() {
        writer.close();
    }

    // MODIFIES: this
    // EFFECTS: writes string to file
    private void saveToFile(String json) {
        writer.print(json);
    }
}
