package ui.gui;

import java.awt.font.TextAttribute;

import javax.swing.JButton;
import javax.swing.JLabel;

import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;
import ui.gui.components.ButtonStyle;
import ui.gui.components.LabelStyle;
import ui.gui.components.PanelStyle;

@ExcludeFromJacocoGeneratedReport
public class MenuPanel extends PanelStyle {
    private JLabel viewLibrary;
    private JLabel viewLine;
    private JButton newSong;
    private JButton searchLibrary;
    private JLabel sepLineOne;
    private JButton viewPlaylists;
    private JButton viewQueue;
    private JLabel sepLineTwo;
    private JButton saveLoadButton;
    
    // EFFECTS: a constructor for the button menu in the option panel
    public MenuPanel() {
        super(MainWindow.DARK, 7, 15, 235, 485);
        setUpLabels();
        setUpButtons();
    }

    // MODIFIES: this
    // EFFECTS: set up labels in the menu
    private void setUpLabels() {
        viewLibrary = new LabelStyle("View library...", 13, 15, -12, 100, 50);
        viewLine = new LabelStyle("_____________", 13, 11, -11, 100, 50);
        sepLineOne = new LabelStyle("____________________________", 13, 16, 97, 300, 20);
        sepLineTwo = new LabelStyle("____________________________", 13, 16, 201, 300, 20);
        viewLibrary.setEnabled(false);
        viewLine.setEnabled(false);
        sepLineOne.setEnabled(false);
        sepLineTwo.setEnabled(false);
        add(viewLibrary);
        add(viewLine);
        add(sepLineOne);
        add(sepLineTwo);
    }

    // MODIFIES: this
    // EFFECTS: set up the main buttons in the menu. Pressing one of these
    // buttons will refresh the panel with the corresponding buttons in that
    // category
    // eg. 'save/load data' -> 'save library' and 'load library'
    private void setUpButtons() {
        newSong = new ButtonStyle("New song+", 25, 30, 13, 175, 30);
        searchLibrary = new ButtonStyle("Search library...", 25, 63, 13, 175, 30);
        viewPlaylists = new ButtonStyle("View playlists...", 15, 132, 13, 205, 30);
        viewQueue = new ButtonStyle("View the queue...", 15, 166, 13, 205, 30);
        saveLoadButton = new ButtonStyle("Save/load data", 15, 236, 13, 205, 30);
        add(newSong);
        add(searchLibrary);
        add(viewPlaylists);
        add(viewQueue);
        add(saveLoadButton);
    }
}
