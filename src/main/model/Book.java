package model;

import exceptions.InvalidRatingException;
import org.json.JSONObject;
import org.omg.CORBA.DynAnyPackage.Invalid;
import persistence.Writable;

public class Book implements Writable {
    private String name;            // book's name
    private String author;          // book's author
    private int rating;             // book's rating out of 5
    private String review;          // book's review

    // EFFECTS: creates new book with given name, rating (from 0-5) and review
    // throws InvalidRatingException if rating is not between 0-5
    public Book(String name, String author, int rating, String review) throws InvalidRatingException {
        this.name = name;
        this.author = author;
        this.review = review;
        if (!(0 <= rating && rating <= 5)) {
            throw new InvalidRatingException("Invalid Rating!");
        } else {
            this.rating = rating;
        }
    }

    //GETTERS AND SETTERS
    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getRating() {
        return rating;
    }

    public String getReview() {
        return review;
    }

    public void setRating(int i) throws InvalidRatingException {
        if (!(0 <= i && i <= 5)) {
            throw new InvalidRatingException("Invalid Rating!");
        } else {
            this.rating = i;
        }
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("author", author);
        json.put("review", review);
        json.put("rating", rating);
        return json;
    }

}
