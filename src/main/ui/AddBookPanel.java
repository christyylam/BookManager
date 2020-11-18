package ui;

import model.Book;
import model.BookCollection;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class AddBookPanel extends JPanel implements ActionListener {
    private JLabel nameLabel;
    private JLabel authorLabel;
    private JLabel ratingLabel;
    private JLabel reviewLabel;
    private JTextField nameTxt;
    private JTextField authorTxt;
    private JTextField ratingTxt;
    private JTextField reviewTxt;
    private JButton addBookButton;

    //EFFECTS: constructs the AddBook panel
    public AddBookPanel() {
        setBackground(new Color(240, 248, 255));
        setPreferredSize(new Dimension(200, 200));
        setLayout(new GridLayout(0, 1, 0, 5));
        addLabelsAndText();
        createAddBookButton();
    }

    //MODIFIES: this
    //EFFECTS: adds all JLabels and JTextFields onto panel
    public void addLabelsAndText() {
        add(nameLabel = new JLabel("Name"));
        add(nameTxt = new JTextField());
        add(authorLabel = new JLabel("Author"));
        add(authorTxt = new JTextField());
        add(ratingLabel = new JLabel("Rating /5"));
        add(ratingTxt = new JTextField());
        add(reviewLabel = new JLabel("Review"));
        add(reviewTxt = new JTextField());
    }

    //MODIFIES: this
    //EFFECTS: creates Add Book Button
    public void createAddBookButton() {
        addBookButton = new JButton("Add Book");
        add(addBookButton);
        addBookButton.addActionListener(this);
    }

    //MODIFIES: ViewBookCollectionPanel
    //EFFECTS: adds book with user input name, author, rating, review into book Collection
    //shows error message when numberformatexception is caught, shows error message if any fields are empty,
    //shows error message when rating<0 or rating>5
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addBookButton) {
            try {
                String name = nameTxt.getText();
                String author = authorTxt.getText();
                String review = reviewTxt.getText();
                int rating = Integer.parseInt(ratingTxt.getText());
                if (nameTxt.getText().isEmpty() || authorTxt.getText().isEmpty() || reviewTxt.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Must fill in all fields!");
                } else if (rating < 0 || rating > 5) {
                    JOptionPane.showMessageDialog(this, "Rating is not between 0-5!");
                } else {
                    String entry = createEntry(name, author, review, rating);
                    Book b = new Book(name, author, rating, review);
                    LoadSavePanel.bookCollection.addBook(b);
                    ViewBookCollectionPanel.model.add(0, entry);
                    playSoundEffect();
                    setTxtFieldsNull();
                }
            } catch (NumberFormatException a) {
                JOptionPane.showMessageDialog(this, "Invalid Input! A number from 0-5 must be entered in Rating");
            }
        }
    }

    public String createEntry(String name, String author, String review, int rating) {
        String entry = "\"" + name + "\"" + " by " + author + ", Rating: "
                + rating + " , Review: " + review;
        return entry;
    }

    //MODIFIES: this
    //EFFECTS: sets text fields back to null
    public void setTxtFieldsNull() {
        nameTxt.setText(null);
        authorTxt.setText(null);
        ratingTxt.setText(null);
        reviewTxt.setText(null);
    }

    //MODIFIES: this
    //EFFECTS:
    public void playSoundEffect() {
        File file = new File("./data/magicwand.wav");
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Sound effect file not found");
        }
    }


}
