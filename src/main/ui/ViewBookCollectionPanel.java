package ui;

import model.Book;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewBookCollectionPanel extends JPanel implements ActionListener {
    private JLabel bookCollLabel;
    private JList<Book> bookCollList;
    static DefaultListModel<String> model = new DefaultListModel<>();
    private JButton removeButton;

    //EFFECTS: constructs the view book collection panel
    public ViewBookCollectionPanel() {
        setBackground(new Color(255, 240, 245));
        setPreferredSize(new Dimension(300, 250));
        setLayout(new BorderLayout());
        bookCollLabel = new JLabel("My Book Collection");
        createBookCollectionList();
        createRemoveButton();
    }

    //MODIFIES: this
    //EFFECTS: constructs and adds the remove button on panel
    public void createRemoveButton() {
        removeButton = new JButton("Remove Selected");
        add(removeButton, BorderLayout.SOUTH);
        removeButton.addActionListener(this);
    }

    //MODIFIES: this
    //EFFECTS: constructs and adds book collection list onto panel
    public void createBookCollectionList() {
        bookCollList = new JList(model);
        bookCollList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        JScrollPane scrollPane = new JScrollPane(bookCollList);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        add(scrollPane, BorderLayout.CENTER);
        add(bookCollLabel, BorderLayout.NORTH);
    }


    //MODIFIES: this
    //EFFECTS: removes selected book from book collection if remove button is pressed
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == removeButton) {
            try {
                int index = bookCollList.getSelectedIndex();
                Book b = LoadSavePanel.bookCollection.getBookAtIndex(index);
                LoadSavePanel.bookCollection.removeBook(b);
                model.remove(bookCollList.getSelectedIndex());
            } catch (ArrayIndexOutOfBoundsException a) {
                JOptionPane.showMessageDialog(null, "No Book Selected!");
            }
        }
    }
}


