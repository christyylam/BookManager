package model;

public class Book {
    private String name;            // book's name
    private String author;          // book's author
    private int rating;             // book's rating out of 5
    private String review;          // book's review

    // REQUIRES: name and author has a non-zero length
    // EFFECTS: creates new book with given name, rating and review
    public Book(String name, String author, String review) {
        this.name = name;
        this.author = author;
        this.review = review;
        this.rating = 0;
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


    public void setRating(int i) {
        this.rating = i;
    }

}
