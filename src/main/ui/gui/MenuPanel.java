package ui.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;

import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;
import persistence.LibraryLoader;
import persistence.LibraryWriter;
import ui.Main;
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
    private JLabel saveLoadSuccess;
    private JLabel saveLoadError;
    private JButton saveButton;
    private JButton loadButton;
    private JButton saveLoadBackButton;

    // EFFECTS: a constructor for the button menu in the option panel
    public MenuPanel() {
        super(MainWindow.DARK, 7, 15, 235, 485);
        setUpLabels();
        setUpButtons();
    }

    // MODIFIES: this
    // EFFECTS: set up labels in the menu
    private void setUpLabels() {
        viewLibrary = new LabelStyle("View library...", 13, 15, -11, 100, 50);
        viewLine = new LabelStyle("_____________", 13, 11, -10, 150, 50);
        sepLineOne = new LabelStyle("____________________________", 13, 16, 99, 300, 20);
        sepLineTwo = new LabelStyle("____________________________", 13, 16, 203, 300, 20);
        saveLoadSuccess = new LabelStyle("successfully.", 15, -164, 417);
        saveLoadError = new LabelStyle("<html>An error occured while trying<br>to perform this action.</html>", 15,
                -132, 405);
        viewLibrary.setEnabled(false);
        viewLine.setEnabled(false);
        sepLineOne.setEnabled(false);
        sepLineTwo.setEnabled(false);
        saveLoadSuccess.setVisible(false);
        saveLoadError.setVisible(false);
        add(viewLibrary);
        add(viewLine);
        add(sepLineOne);
        add(sepLineTwo);
        add(saveLoadSuccess);
        add(saveLoadError);
    }

    // MODIFIES: this
    // EFFECTS: set up the main buttons in the menu. Pressing one of these
    // buttons will refresh the panel with the corresponding buttons in that
    // category
    // eg. 'save/load data' -> 'save library' and 'load library'
    private void setUpButtons() {
        newSong = new ButtonStyle("New song+", 25, 32, 13, 175, 30);
        searchLibrary = new ButtonStyle("Search library...", 25, 65, 13, 175, 30);
        viewPlaylists = new ButtonStyle("View playlists...", 15, 134, 13, 205, 30);
        viewQueue = new ButtonStyle("View the queue...", 15, 168, 13, 205, 30);
        saveLoadButton = new ButtonStyle("Save/load data", 15, 238, 13, 205, 30);
        saveButton = new ButtonStyle("Save data", 25, 32, 13, 175, 30);
        loadButton = new ButtonStyle("Load data", 25, 65, 13, 175, 30);
        saveLoadBackButton = new ButtonStyle("< Back", 15, 134, 13, 205, 30);
        enterNewSong();
        searchQuery();
        playlistDisplay();
        queueDisplay();
        saveAndLoadOptions();
    }

    // MODIFIES: this
    // EFFECTS: create a new song, and add it to the library
    private void enterNewSong() {
        newSong.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new songEditCreateWindow();
            }
        });
        add(newSong);
    }

    // MODIFIES: this
    // EFFECTS; no UI functionality added for searching yet
    private void searchQuery() {
        searchLibrary.setEnabled(false);
        add(searchLibrary);
    }

    // MODIFIES: this
    // EFFECTS: no functionality added for playlists yet
    private void playlistDisplay() {
        viewPlaylists.setEnabled(false);
        add(viewPlaylists);
    }

    // MODIFIES: this
    // EFFECTS: view the current queue in the infopanel
    private void queueDisplay() {
        // TODO
        add(viewQueue);
    }

    // MODIFIES: this
    // EFFECTS: hide/unhide all main option buttons to allow for inner option
    // display
    private void hideAllMain(Boolean hide) {
        sepLineTwo.setVisible(!hide);
        newSong.setEnabled(!hide);
        newSong.setVisible(!hide);
        //searchLibrary.setEnabled(!hide);
        searchLibrary.setVisible(!hide);
        //viewPlaylists.setEnabled(!hide);
        viewPlaylists.setVisible(!hide);
        viewQueue.setEnabled(!hide);
        viewQueue.setVisible(!hide);
        saveLoadButton.setEnabled(!hide);
        saveLoadButton.setVisible(!hide);
    }

    // MODIFIES: this
    // EFFECTS: change the sidebar menu to show loading and saving options
    private void saveAndLoadOptions() {
        saveLoadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewLibrary.setText("Save/load data...");
                viewLine.setText("_______________");
                hideAllMain(true);
                saveButton.setVisible(true);
                saveButton.setEnabled(true);
                loadButton.setVisible(true);
                loadButton.setEnabled(true);
                saveLoadBackButton.setEnabled(true);
                saveLoadBackButton.setVisible(true);
            }
        });
        saveFunctionality();
        loadFunctionality();
        saveLoadBack();
        add(saveLoadButton);
    }

    // EFFECTS: adds support for library saving
    // NOTE: time delay code taken from stackexchange forum
    // https://stackoverflow.com/questions/16596428/removing-a-jlabel-after-10-seconds?rq=3
    private void saveFunctionality() {
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LibraryWriter writer = new LibraryWriter("./data/librarySave.json");
                try {
                    writer.writeJson(Main.getLibrary());
                    persistenceVictory("Saved");
                } catch (IOException exception) {
                    persistenceFailure();
                }
            }
        });
        saveButton.setVisible(false);
        saveButton.setEnabled(false);
        add(saveButton);
    }

    // EFFECTS: adds support for library loading
    // NOTE: time delay code taken from stackexchange forum
    // https://stackoverflow.com/questions/16596428/removing-a-jlabel-after-10-seconds?rq=3
    private void loadFunctionality() {
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LibraryLoader loader = new LibraryLoader("./data/librarySave.json");
                try {
                    Main.setLibrary(loader.readJson());
                    MainWindow.infoPanel.updateShown();
                    persistenceVictory("Loaded");
                } catch (IOException exception) {
                    persistenceFailure();
                }
            }
        });
        loadButton.setVisible(false);
        loadButton.setEnabled(false);
        add(loadButton);
    }

    // MODIFIES: this
    // EFFECTS: display victory (save or load was successful)
    private void persistenceVictory(String whatDid) {
        saveLoadSuccess.setText(whatDid + " successfully.");
        saveLoadSuccess.setVisible(true);
        int delay = 800;
        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveLoadSuccess.setVisible(false);
            }
        };
        new javax.swing.Timer(delay, taskPerformer).start();
    }

    // MODIFIES: this
    // EFFECTS: notify user that saving/loading failed
    private void persistenceFailure() {
        saveLoadError.setVisible(true);
        int delay = 800;
        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveLoadError.setVisible(false);
            }
        };
        new javax.swing.Timer(delay, taskPerformer).start();
    }

    // MODIFIES: this
    // EFFECTS: exit out of the sidebar menu and stop showing saving/loading options
    private void saveLoadBack() {
        saveLoadBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewLibrary.setText("View library...");
                viewLine.setText("_____________");
                saveButton.setVisible(false);
                saveButton.setEnabled(false);
                loadButton.setVisible(false);
                loadButton.setEnabled(false);
                saveLoadBackButton.setEnabled(false);
                saveLoadBackButton.setVisible(false);
                hideAllMain(false);
            }
        });
        saveLoadBackButton.setEnabled(false);
        saveLoadBackButton.setVisible(false);
        add(saveLoadBackButton);
    }
}
