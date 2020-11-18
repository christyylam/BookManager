package ui;

import javax.swing.*;
import javax.swing.text.View;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import model.Book;
import model.BookCollection;
import persistence.JsonReader;
import persistence.JsonWriter;

public class LoadSavePanel extends JPanel implements ActionListener {
    private JButton saveButton;
    private JButton loadButton;
    private static final String JSON_STORE = "./data/bookcollection.json";
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    static BookCollection bookCollection;


    //EFFECTS: constructs the LoadSave panel
    public LoadSavePanel() {
        setBackground(new Color(245,255,250));
        saveButton = new JButton("Save Book Collection");
        saveButton.addActionListener(this);
        loadButton = new JButton("Load Book Collection");
        loadButton.addActionListener(this);
        add(saveButton);
        add(loadButton);
        bookCollection = new BookCollection("Christy's book collection");
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == saveButton) {
            saveBookCollection();
        } else if (e.getSource() == loadButton) {
            loadBookCollection();
        }

    }

    //EFFECTS: saves the bookcollection to file
    private void saveBookCollection() {
        try {
            jsonWriter.open();
            jsonWriter.write(bookCollection);
            jsonWriter.close();
            JOptionPane.showMessageDialog(this, "Saved your book collection!");
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(this, "Unable to save");
        }
    }

    // MODIFIES: this
    // EFFECTS: loads bookcollection from file
    private void loadBookCollection() {
        try {
            bookCollection = jsonReader.read();
            for (Book b : bookCollection.getBookCollection()) {
                String name = b.getName();
                String author = b.getAuthor();
                String rating = Integer.toString(b.getRating());
                String review = b.getReview();
                String entry = createEntry(name, author, rating, review);
                ViewBookCollectionPanel.model.add(0, entry);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Unable to load book collection");
        }
    }

    public String createEntry(String name, String author, String rating, String review) {
        String entry = "\"" + name + "\"" + " by " + author + ", Rating: "
                + rating + " , Review: " + review;
        return entry;
    }

}
