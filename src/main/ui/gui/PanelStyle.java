package ui.gui;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JPanel;

public class PanelStyle extends JPanel {
    private static final int borderStepX = 10;
    private static final int borderStepY = 5;
    private JPanel customPanel;

    public PanelStyle(String hex, int coordX, int coordY, int width, int height) {
        customPanel = new JPanel();
        customPanel.setLayout(new FlowLayout(FlowLayout.LEFT, borderStepX, borderStepY));
        customPanel.setBackground(Color.decode(hex));
        customPanel.setBounds(coordX, coordY, width, height);
    }

    public JPanel getPanel() {
        return customPanel;
    }
}
