package ui;

import model.Book;
import model.BookCollection;

import java.util.Scanner;

public class BookManagerApp {
    private BookCollection collection;

    //EFFECTS: runs the BookManager application
    public BookManagerApp() {
        runBookManager();
    }

    //MODIFIES: this
    //EFFECTS: processes user input
    //cited: from TellerApp. java
    // https://github.students.cs.ubc.ca/CPSC210/TellerApp.git
    private void runBookManager() {
        Scanner input = new Scanner(System.in);
        boolean keepGoing = true;
        String command = null;

        init();

        while (keepGoing) {
            displayMenu();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("q")) {
                keepGoing = false;
            } else {
                processCommand(command);
            }
        }
        System.out.println("Thanks for using BookManager!");
    }

    //MODIFIES: this
    //EFFECTS: processes user command
    private void processCommand(String command) {
        if (command.equals("a")) {
            doAdd();
        } else if (command.equals("v")) {
            doViewAll();
        } else if (command.equals("r")) {
            doRate();
        } else if (command.equals("rr")) {
            doViewRatingsAndReviews();
        } else {
            System.out.println("Selection is not valid");
        }
    }

    //MODIFIES: this
    //EFFECTS: initializes collection
    private void init() {
        collection = new BookCollection();
    }

    //EFFECTS: displays menu of options to user
    private void displayMenu() {
        System.out.println("Select from");
        System.out.println("\ta -> add a book and its review");
        System.out.println("\tv -> view all books in collection");
        System.out.println("\tr -> rate a book in the collection");
        System.out.println("\trr -> view ratings and reviews");
        System.out.println("\tq -> quit");
    }

    //MODIFIES: this
    //EFFECTS:
    private void doAdd() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter name of book");
        String name = input.nextLine();
        System.out.println("Enter author of book");
        String author = input.nextLine();
        System.out.println("Enter your review");
        String review = input.nextLine(); //
        Book b = new Book(name, author, review);
        collection.addBook(b);
        System.out.println(b.getName() + " " + "has been added to your collection!");
    }

    //EFFECTS: prints out list of books in the BookCollection
    private void doViewAll() {
        System.out.println("Here are the books in your collection:");
        for (Book b : collection.getBookCollection()) {
            System.out.println(b.getName() + " " + "by" + " " + b.getAuthor());
        }
    }

    //MODIFIES: this
    //EFFECTS:
    private void doRate() {
        Scanner input = new Scanner(System.in);
        doViewAll();
        System.out.println("Enter a book name to rate:");
        String name = input.nextLine();
        boolean set = false;
        for (Book b : collection.getBookCollection()) {
            if (name.equals(b.getName())) {
                System.out.println("What is your rating from 1 to 5?");
                int rating = input.nextInt();
                b.setRating(rating);
                set = true;
                break;
            } else {
                set = false;
            }
        }
        if (!set) {
            System.out.println("Sorry! That book is not in your collection");
        }
    }

    //MODIFIES
    //EFFECTS:
    private void doViewRatingsAndReviews() {
        Scanner input = new Scanner(System.in);
        doViewAll();
        System.out.println("Enter a book name to see it's rating and review");
        String name = input.nextLine();
        boolean set = false;
        for (Book b : collection.getBookCollection()) {
            if (name.equals(b.getName())) {
                System.out.println("Your rating:" + b.getRating() + "/5");
                System.out.println("Your review:" + b.getReview());
                set = true;
                break;
            } else {
                set = false;
            }
        }
        if (!set) {
            System.out.println("Sorry! That book is not in your collection");
        }
    }
}