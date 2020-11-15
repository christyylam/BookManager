package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        setBackground(new Color(240,248,255));
        setPreferredSize(new Dimension(200, 200));
        setLayout(new GridLayout(0, 1, 0, 5));
        add(nameLabel = new JLabel("Name"));
        add(nameTxt = new JTextField());
        add(authorLabel = new JLabel("Author"));
        add(authorTxt = new JTextField());
        add(ratingLabel = new JLabel("Rating"));
        add(ratingTxt = new JTextField());
        add(reviewLabel = new JLabel("Review"));
        add(reviewTxt = new JTextField());
        addBookButton = new JButton("Add Book");
        add(addBookButton);
        addBookButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addBookButton) {
            String name = nameTxt.getText();
            String author = authorTxt.getText();
            String review = reviewTxt.getText();

        }

    }

}
