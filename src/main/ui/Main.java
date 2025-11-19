package ui;

import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;
import model.handlers.Library;
import model.handlers.PlayHandler;
import ui.gui.MainWindow;

@ExcludeFromJacocoGeneratedReport
public class Main {

    static Boolean undecided;
    static Library library;
    static PlayHandler playHandler;

    public static void main(String[] args) {
        library = new Library();
        library.loadDefault();
        playHandler = new PlayHandler();
        playHandler.start();
        new MainWindow();

        Options optionsMenuLoad = new Options();
        undecided = true;
        while (undecided) {
            optionsMenuLoad.startView();
        }
        System.out.println("\n----------------------");
        System.out.println("\nPListen has been closed successfully.");
    }

    // EFFECTS: getter for the playHandler so that it can be accessed
    // by GUI (package protection bypass). Not used elsewhere
    public static PlayHandler getPlayHandler() {
        return playHandler;
    }

    // EFFECTS: getter for the library so that it can be accessed
    // by GUI (package protection bypass). Not used elsewhere
    public static Library getLibrary() {
        return library;
    }

    // EFFECTS: setter for the library so that it can be loaded in the
    // GUI (package protection bypass). Not used elsewhere
    public static void setLibrary(Library loadData) {
        library = loadData;
    }
}
