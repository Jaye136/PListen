package ui;

import model.handlers.Library;
import model.handlers.PlayHandler;

public class Main {

    static Boolean undecided;
    static Library library;
    static PlayHandler playHandler;

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
