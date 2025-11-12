package ui.gui;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;

@ExcludeFromJacocoGeneratedReport
public class MainWindow extends JFrame {
    static final String DARKEST = "#1B1B1C";
    static final String DARKER = "#232325";
    static final String DARK = "#2a2b2d";
    static final String DAIKON = "#F2F2F3";

    private int frameSizeX;
    private int frameSizeY;
    private JFrame mainWindow;
    private JPanel disPlay;
    private JPanel menuPanel;
    private JPanel infoPanel;

    // EFFECTS: construct an instance of the application
    public MainWindow() {
        frameSizeX = 1000;
        frameSizeY = 600;
        initialise();
    }

    // MODIFIES: this
    // EFFECTS: the main window for the application. Display size is set and
    // cannot be changed for sake of alignment consistency
    private void initialise() {
        mainWindow = new JFrame();
        mainWindow.setTitle("PListen");
        mainWindow.setDefaultCloseOperation(EXIT_ON_CLOSE);
        mainWindow.setLayout(null);
        mainWindow.setSize(frameSizeX, frameSizeY);
        mainWindow.getContentPane().setBackground(Color.decode(DARKEST));

        disPlayPanel();
        optMenuPanel();
        infoPagePanel();

        mainWindow.setResizable(false);
        mainWindow.setVisible(true);
    }

    // MODIFIES: this
    // EFFECTS: display the next song in the queue that will be played
    private void disPlayPanel() {
        disPlay = new DisPlay();
        mainWindow.add(disPlay);
    }

    // MODIFIES: this
    // EFFECTS: format a display for the left panel of the application, which
    // contains all option buttons
    private void optMenuPanel() {
        menuPanel = new MenuPanel();
        mainWindow.add(menuPanel);
    }

    // MODIFIES: this
    // EFFECTS: format the info display for the right panel of the application,
    // which holds all library and selected song information
    private void infoPagePanel() {
        infoPanel = new InfoPanel();
        mainWindow.add(infoPanel);
    }

    public static String getDarkest() {
        return DARKEST;
    }

    public static String getDarker() {
        return DARKER;
    }

    public static String getDark() {
        return DARK;
    }

    public static String getDaikon() {
        return DAIKON;
    }

}

// Routing buttons refactoring proposal (instead of true/false setting)
// DO NOT USE!!!!!!!!!!!

// BackButtonPressed, ExistButtonPressed, implements RouteButtonPressed

// methodCallingMethodInUI() throws RouteButtonPressed {
// doingThings();
// doingThings();
// doingThings();
// if (enterMethodInUI.isPressed()) {
// try {
// methodInUI()
// } catch (BackButtonPressed e) {
// methodCallingMethodInUI();
// }
// } else if (backButton.isPressed()) {
// throw new BackButtonPressed e; // caught, handled in caller method (this)
// } else if (exitButton.isPressed()) {
// throw new ExitButtonPressed e; // not caught, propogates up until main
// }
// }

// methodInUI() throws BackButtonPressed {
// if (backIsPressed()) {
// throw new BackButtonPressed e;
// }
// }