package ui.gui;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;
import model.logging.Event;
import model.logging.EventLog;

@ExcludeFromJacocoGeneratedReport
public class MainWindow extends JFrame {
    static final String DARKEST = "#1B1B1C";
    static final String DARKER = "#232325";
    static final String DARK = "#2a2b2d";
    static final String STEEL = "#bdbdbd";
    static final String DAIKON = "#F2F2F3";

    private int frameSizeX;
    private int frameSizeY;
    private JFrame mainWindow;
    static DisPlay disPlay;
    static MenuPanel menuPanel;
    static InfoPanel infoPanel;

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
        mainWindow.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        mainWindow.setLayout(null);
        mainWindow.setSize(frameSizeX, frameSizeY);
        mainWindow.getContentPane().setBackground(Color.decode(DARKEST));

        disPlayPanel();
        optMenuPanel();
        infoPagePanel();
        postHumously();

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

    // MODIFIES: this
    // EFFECTS: sets up a process to log all info once the window is closed
    private void postHumously() {
        mainWindow.addWindowListener(new WindowAdapter() {
            @ExcludeFromJacocoGeneratedReport
            @Override
            public void windowClosing(WindowEvent e) {
                for (Event ea : EventLog.getInstance()) {
                    System.out.println(ea.toString());
                }
                System.exit(0);
            }
        });
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

    public static String getSteel() {
        return STEEL;
    }

    public static String getDaikon() {
        return DAIKON;
    }

}