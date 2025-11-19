package ui.gui.components;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.JTextField;

import ui.gui.MainWindow;

import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;

// CLASS DOCUMENTATION: construction abstraction for text field formattings

@ExcludeFromJacocoGeneratedReport
public class TextFieldStyle extends JTextField {

    // EFFECTS: constructor for specific style of JTextField (for consistency)
    public TextFieldStyle(String msg, int coordX, int coordY, int fontSize, int width, int height) {
        setText(msg);
        setFont(new Font("SansSerif", Font.BOLD, fontSize));
        setCaretColor(Color.decode(MainWindow.getDaikon()));
        setForeground(Color.decode(MainWindow.getSteel()));
        setBackground(Color.decode(MainWindow.getDarker()));
        setBounds(coordX, coordY, width, height);
        setMargin(new Insets(1, 7, 1, 7));
        setEditable(true);
        setEnabled(true);
        setFocusable(true);
    }
}
