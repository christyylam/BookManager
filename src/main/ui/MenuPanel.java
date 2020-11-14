package ui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class MenuPanel extends JPanel {
    private JLabel menuLbl;

    //Constructs a menu panel
    //EFFECTS: sets size and background colour of the panel
    public MenuPanel() {
        setBackground(new Color(230,230,250));
        setPreferredSize(new Dimension(250,250));
        menuLbl = new JLabel("Menu");
        menuLbl.setForeground(new Color(0,0,0));
        add(menuLbl);
    }
}
