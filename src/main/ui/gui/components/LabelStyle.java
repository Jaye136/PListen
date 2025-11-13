package ui.gui.components;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;
import ui.gui.MainWindow;

// CLASS DOCUMENTATION: construction abstraction for label formattings

@ExcludeFromJacocoGeneratedReport
public class LabelStyle extends JLabel {

    // constructor for set position label
    public LabelStyle(String msg, int size, int coordX, int coordY, int width, int height) {
        setText(msg);
        setFont(new Font("SansSerif", Font.BOLD, size));
        setForeground(Color.decode(MainWindow.getDaikon()));
        setBounds(coordX, coordY, width, height);
    }

    // constructor for dynamic alignment label
    public LabelStyle(String msg, int size, int coordX, int coordY) {
        setText(msg);
        setFont(new Font("SansSerif", Font.BOLD, size));
        setForeground(Color.decode(MainWindow.getDaikon()));
        setSize(500, 100);
        setLocation(coordX, coordY);
        setHorizontalAlignment(SwingConstants.CENTER);  
    }
}
