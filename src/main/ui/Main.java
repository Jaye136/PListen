package ui;

import model.handlers.Library;
import model.handlers.PlayHandler;

public class Main {

    private static Boolean undecided;
    public static Library library;
    public static PlayHandler playHandler;

    public static void main(String[] args) {
        library = new Library();
        library.startLibrary();
        playHandler = new PlayHandler();

        Options optionsMenuLoad = new Options();
        undecided = true;
        while (undecided) {
            optionsMenuLoad.startView();
        }
    }
}
