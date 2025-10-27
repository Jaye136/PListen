package ui;

import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;
import model.handlers.Library;
import model.handlers.PlayHandler;

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

        Options optionsMenuLoad = new Options();
        undecided = true;
        while (undecided) {
            optionsMenuLoad.startView();
        }
        System.out.println("\n----------------------");
        System.out.println("\nPListen has been closed successfully.");
    }
}
