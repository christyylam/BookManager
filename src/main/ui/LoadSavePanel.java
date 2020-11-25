package ui;

import model.Book;
import model.BookCollection;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LoadSavePanel extends JPanel implements ActionListener {
    private JButton saveButton;
    private JButton loadButton;
    private static final String JSON_STORE = "./data/bookcollection.json";
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    static BookCollection bookCollection;

    // EFFECTS: constructs the LoadSave panel
    public LoadSavePanel() {
        setBackground(new Color(240,255,255));
        setPreferredSize(new Dimension(100, 50));
        Border border = BorderFactory.createLineBorder(Color.WHITE, 7);
        setBorder(border);
        addSaveLoadButtons();
        bookCollection = new BookCollection("Christy's book collection");
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
    }

    //MODIFIES: this
    //EFFECTS: creates save button and load button and adds them onto the panel
    public void addSaveLoadButtons() {
        saveButton = new JButton("Save Book Collection");
        saveButton.addActionListener(this);
        loadButton = new JButton("Load Book Collection");
        loadButton.addActionListener(this);
        add(saveButton);
        add(loadButton);
    }

    //EFFECTS: runs saveBookCollection if action event is at the save button
    // runs loadBookCollection if action event is at the load button
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
            JOptionPane.showMessageDialog(null, "Saved your book collection!", "BOOK MANAGER",
                    JOptionPane.QUESTION_MESSAGE, null);
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Unable to save");
        }
    }

    // MODIFIES: this
    // EFFECTS: loads bookcollection from file
    private void loadBookCollection() {
        try {
            ViewBookCollectionPanel.model.removeAllElements();
            bookCollection = jsonReader.read();
            for (Book b : bookCollection.getBookCollection()) {
                String name = b.getName();
                String author = b.getAuthor();
                String rating = Integer.toString(b.getRating());
                String review = b.getReview();
                String entry = createEntry(name, author, rating, review);
                ViewBookCollectionPanel.model.addElement(entry);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Unable to load book collection");

        }
    }

    //EFFECTS: creates a new entry with name, author, rating, review
    public String createEntry(String name, String author, String rating, String review) {
        String entry = "\"" + name + "\"" + " by " + author + ", Rating: "
                + rating + " , Review: " + review;
        return entry;
    }

}
