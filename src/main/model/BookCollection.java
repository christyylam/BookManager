package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BookCollection implements Writable {
    private String name;
    private ArrayList<Book> bookCollection;

    //constructor
    //EFFECTS: creates a new empty BookCollection
    public BookCollection(String name) {
        this.name = name;
        bookCollection = new ArrayList<>();
    }

    //EFFECTS: gets the name of BookCollection
    public String getName() {
        return name;
    }

    // EFFECTS: returns list of Books in BookCollection
    public List<Book> getBookCollection() {
        return Collections.unmodifiableList(bookCollection);
    }

    // MODIFIES: this
    //EFFECTS: adds book to BookCollection if it's not already in BookCollection and returns true
    // if book is already in the collection, does not add it to collection and returns false instead
    public boolean addBook(Book b) {
        for (Book c : bookCollection) {
            if (c.getName().equals(b.getName())
                    && c.getAuthor().equals(b.getAuthor())) {
                return false;
            }
        }
        bookCollection.add(b);
        return true;
    }

    //MODIFIES: this
    //EFFECTS: removes book from BookCollection if it is already in Bookcollection and returns true
    // if book is not in the BookCollection, return false
    public boolean removeBook(Book b) {
        if (bookCollection.contains(b)) {
            bookCollection.remove(b);
            return true;
        } else {
            return false;
        }
    }

    //EFFECTS: returns book at the index specified
    public Book getBookAtIndex(int i) {
        return bookCollection.get(i);
    }

    //EFFECTS: returns true if BookCollection contains Book b
    //returns false otherwise
    public boolean doesContain(Book b) {
        return bookCollection.contains(b);
    }

    //EFFECTS: returns number of books in bookcollection
    public int numBooks() {
        return bookCollection.size();
    }


    //CITATION: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("books", booksToJson());
        return json;
    }

    //EFFECTS: returns books in this bookcollection as a JSON array
    private JSONArray booksToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Book b : bookCollection) {
            jsonArray.put(b.toJson());
        }
        return jsonArray;
    }

}
