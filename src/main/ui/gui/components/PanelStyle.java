package ui.gui.components;

import java.awt.Color;

import javax.swing.JPanel;

import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;

// CLASS DOCUMENTATION: construction abstraction for panel formattings

@ExcludeFromJacocoGeneratedReport
public abstract class PanelStyle extends JPanel {

    public PanelStyle(String hex, int coordX, int coordY, int width, int height) {
        setLayout(null);
        setBackground(Color.decode(hex));
        setBounds(coordX, coordY, width, height);
    }
}
