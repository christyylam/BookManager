package ui;

import model.Book;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewBookCollectionPanel extends JPanel implements ActionListener {
    private JLabel bookCollLabel;
    private JList<Book> bookCollList;
    private JButton removeButton;

    //EFFECTS: constructs the view book collection panel
    public ViewBookCollectionPanel() {
        setBackground(new Color(255, 240, 245));
        setPreferredSize(new Dimension(300, 250));
        setLayout(new BorderLayout());
        bookCollLabel = new JLabel("My Book Collection");
        bookCollList = new JList<>();
        bookCollList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        bookCollList.setVisibleRowCount(-1);
        JScrollPane scrollPane = new JScrollPane(bookCollList);
        add(scrollPane);
        add(bookCollLabel, BorderLayout.NORTH);
        add(bookCollList, BorderLayout.CENTER);
        removeButton = new JButton("Remove Selected");
        add(removeButton, BorderLayout.SOUTH);
        removeButton.addActionListener(this);
    }

    public void scrollBar() {
        setPreferredSize(new Dimension(250, 250));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == removeButton) {
          //idk
        }

    }
}


