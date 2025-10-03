package ui;

import java.util.Scanner;

public class Options {

    private String select;
    private Scanner userInput;
    private Boolean debugMode; // reduce typing while testing UI

    public Options() {
        userInput = new Scanner(System.in);
        debugMode = false;
    }

    // EFFECTS: welcome user, show available options
    public void startView() {
        print("Enter all options exactly.");
        print("  > View library");
        print("  > View playlists");

        select = userInput.nextLine();

        if (ckop("View library") || dop("l")) {
            longLine();
            libraryOptions();
        } else if (ckop("View playlists") || dop("p")) {
            longLine();
            playlistOptions();
        } else if (ckop("konamicode")) {
            debugMode = true;
            print("Nice!");
        } else {
            notValid();
        }
    }

    // EFFECTS: show options in the library menu
    private void libraryOptions() {
        print("Enter all options exactly.");
        print("  > New Song+");
        print("  > Search Library");
        print("  > Back");

        select = userInput.nextLine();

        if (ckop("New Song+") || dop("n")) {
            print("TODO");
        }
        else if (ckop("Search Library") || dop("s")) {
            print("TODO");
        }
        else if (ckop("Back") || dop("b")) {
            backButton();
            startView();
        } else {
            notValid();
            libraryOptions();
        }
    }

    private void playlistOptions() {
        print("New Playlist+");
        print("TODO");
    }



    // TEXT UTILITY FUNCTIONS

    // EFFECTS: shortcut to print
    private void print(String str) {
        System.out.println(str);
    }

    // EFFECTS: shortcut to check option
    private Boolean ckop(String str) {
        return select.equals(str);
    }

    // EFFECTS: shortcut for debug mode check option
    private Boolean dop(String str) {
        return ckop(str) && debugMode;
    }

    // EFFECTS: shortcut for formatting
    private void longLine() {
        print("----------------------");
    }

    // EFFECTS: shortcut for invalid user input
    private void notValid() {
        print("Not a valid option!");
        longLine();
    }

    // EFFECTS: shortcut to handle back button being pressed
    private void backButton() {
        print("Heading back to the previous menu...");
        longLine();
    }
}
