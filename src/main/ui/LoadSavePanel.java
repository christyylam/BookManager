package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoadSavePanel extends JPanel implements ActionListener {
    private JButton saveButton;
    private JButton loadButton;

    public LoadSavePanel() {
        setBackground(new Color(245,255,250));
        saveButton = new JButton("Save Book Collection");
        saveButton.addActionListener(this);
        loadButton = new JButton("Load Book Collection");
        loadButton.addActionListener(this);
        add(saveButton);
        add(loadButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == saveButton) {
            //idk
        } else if (e.getSource() == loadButton) {
            //idk
        }

    }

}
