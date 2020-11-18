package ui;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class BookManagerAppFrame extends JFrame {
    private AddBookPanel bookPanel;
    private ViewBookCollectionPanel collectionPanel;
    private LoadSavePanel loadSavePanel;


    //Constructs main window
    //EFFECTS: sets up window where BookManagerApp will be run
    public BookManagerAppFrame() {
        super("Book Manager");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,500);
        setLayout(new BorderLayout());
        setVisible(true);
        centreOnScreen();
        getContentPane().setBackground(new Color(240,255,255));
        bookPanel = new AddBookPanel();
        add(bookPanel, BorderLayout.EAST);
        collectionPanel = new ViewBookCollectionPanel();
        add(collectionPanel, BorderLayout.CENTER);
        add(loadSavePanel = new LoadSavePanel(), BorderLayout.SOUTH);

        setVisible(true);
    }

    // CITATION: https://github.students.cs.ubc.ca/CPSC210/B02-SpaceInvadersBase.git
    // Centres frame on desktop
    // modifies: this
    // effects:  location of frame is set so frame is centred on desktop
    private void centreOnScreen() {
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((screen.width - getWidth()) / 2, (screen.height - getHeight()) / 2);
    }


}
