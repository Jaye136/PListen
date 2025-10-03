package ui;

import model.PlayHandler;

public class Main {

    private static Boolean undecided;

    public static void main(String[] args) {
        Library library = new Library();
        library.startLibrary();
        PlayHandler playHandler = new PlayHandler();
        playHandler.start();

        Options optionsMenuLoad = new Options();
        undecided = true;
        while (undecided) {
            optionsMenuLoad.startView();
        }
    }
}
