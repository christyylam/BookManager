package model;

import java.util.ArrayList;

public class BookCollection {
    private ArrayList<Book> bookCollection;

    //constructor
    //EFFECTS: creates a new empty BookCollection
    public BookCollection() {
        this.bookCollection = new ArrayList<>();
    }

    //getter
    // EFFECTS: returns list of Books in BookCollection
    public ArrayList<Book> getBookCollection() {
        return bookCollection;
    }

    // MODIFIES: this
    //EFFECTS: adds book to BookCollection if it's not already in Bookcollection and returns true
    // if book is already in the collection, does not add it to collection and returns false instead
    public boolean addBook(Book b) {
        if (!bookCollection.contains(b)) {
            bookCollection.add(b);
            return true;
        } else {
            return false;
        }
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

    //EFFECTS: returns true if BookCollection contains Book b
    //returns false otherwise
    public boolean contains(Book b) {
        return bookCollection.contains(b);
    }


}
