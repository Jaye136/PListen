package ui.gui.components;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.JButton;

import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;
import ui.gui.MainWindow;

// CLASS DOCUMENTATION: construction abstraction for button formattings

@ExcludeFromJacocoGeneratedReport
public class ButtonStyle extends JButton {

    public ButtonStyle(String msg, int coordX, int coordY, int fontSize, int width, int height) {
        setText(msg);
        setFont(new Font("SansSerif", Font.BOLD, fontSize));
        setForeground(Color.decode(MainWindow.getDaikon()));
        setBackground(Color.decode(MainWindow.getDarker()));
        setBounds(coordX, coordY, width, height);
        setMargin(new Insets(1, 1, 1, 1));
        setBorderPainted(false);
        setFocusPainted(false);
        setFocusable(false);
    }

}
