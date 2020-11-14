package ui;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookManagerAppFrame extends JFrame implements ActionListener {
    private MenuPanel menu;
    JButton button;

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
        menu = new MenuPanel();
        add(menu, BorderLayout.NORTH);
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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            System.out.println("Poo");
        }
    }




}
