package ui;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class BookManagerAppGui extends JFrame {
    private AddBookPanel bookPanel;
    private ViewBookCollectionPanel collectionPanel;
    private LoadSavePanel loadSavePanel;
    private HeaderPanel headerPanel;


    //Constructs main window
    //EFFECTS: sets up window where BookManagerApp will be run
    public BookManagerAppGui() {
        super("Book Manager");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(650,650);
        setLayout(new BorderLayout());
        setVisible(true);
        centreOnScreen();
        getContentPane().setBackground(new Color(240,255,255));
        bookPanel = new AddBookPanel();
        add(bookPanel, BorderLayout.EAST);
        collectionPanel = new ViewBookCollectionPanel();
        add(collectionPanel, BorderLayout.CENTER);
        loadSavePanel = new LoadSavePanel();
        add(loadSavePanel, BorderLayout.SOUTH);
        headerPanel = new HeaderPanel();
        add(headerPanel, BorderLayout.NORTH);

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
