package ui.gui.components;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;
import ui.gui.MainWindow;

// CLASS DOCUMENTATION: construction abstraction for label formattings

@ExcludeFromJacocoGeneratedReport
public class LabelStyle extends JLabel {

    public LabelStyle(String msg, int size) {
        setText(msg);
        setFont(new Font("SansSerif", Font.BOLD, size));
        setForeground(Color.decode(MainWindow.getDaikon()));
    }
}
