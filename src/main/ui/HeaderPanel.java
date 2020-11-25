package ui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class HeaderPanel extends JPanel {
    private JLabel titleLabel;

    //EFFECTS: constructs the AddBook panel
    //CITATION: for resizing the imageIcon I found lines 22-24 on stackOverFlow
    //https://stackoverflow.com/questions/6714045/how-to-resize-jlabel-imageicon
    //Image icon png was found here: https://www.cleanpng.com/png-book-cover-outline-clip-art-1797368/download-png.html
    public HeaderPanel() {
        setBackground(new Color(240,255,255));
        titleLabel = new JLabel("B O O K   M A N A G E R");
        titleLabel.setFont(new Font("Verdana", Font.BOLD, 30));
        titleLabel.setForeground(new Color(176,224,230));
        Border border = BorderFactory.createLineBorder(Color.WHITE, 7);
        setBorder(border);
        ImageIcon icon = new ImageIcon("./data/bookIcon.png");
        Image image = icon.getImage();
        Image newImage = image.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        icon = new ImageIcon(newImage);
        titleLabel.setIcon(icon);
        add(titleLabel);
    }
}
