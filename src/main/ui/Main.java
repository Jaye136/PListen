package ui;

import model.handlers.Library;
import model.handlers.PlayHandler;

public class Main {

    static Boolean undecided;
    public static Library library;
    public static PlayHandler playHandler;

    public static void main(String[] args) {
        library = new Library();
        playHandler = new PlayHandler();
        playHandler.start();

        Options optionsMenuLoad = new Options();
        undecided = true;
        while (undecided) {
            optionsMenuLoad.startView();
        }
        System.out.println("\nPListen has been closed successfully.");
    }
}
