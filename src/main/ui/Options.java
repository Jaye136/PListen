package ui;

import java.util.Scanner;

import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;
import model.data.exceptions.SongNotFoundException;
import model.data.plain.Song;

@ExcludeFromJacocoGeneratedReport
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

        startViewDisplay();

        select = userInput.nextLine();

        if (ckop("View library") || dop("l")) {
            longLine();
            libraryOptions();
        } else if (ckop("View playlists") || dop("p")) {
            longLine();
            playlistOptions();
        } else if (ckop("Queue Options") || dop("q")) {
            longLine();
            queueOptions();
        } else if (ckop("Quit Program") || dop("qq")) {
            longLine();
            Main.undecided = false;
        } else if (ckop("konamicode") && !debugMode) {
            debugMode = true;
            print("\nNice!");
            longLine();
        } else {
            notValid();
        }
    }

    private void startViewDisplay() {
        print("\nEnter all options exactly.");
        print("  > View library");
        print("  > View playlists");
        print("  > Queue Options");
        print("  > Quit program\n");
    }

    // EFFECTS: show options in the library menu
    private void libraryOptions() {
        print("\nEnter all options exactly.");
        print("  > New Song+");
        print("  > Search Library");
        print("  > List of Songs");
        print("  > Back\n");

        select = userInput.nextLine();

        if (ckop("New Song+") || dop("n")) {
            longLine();
            newSongMenu();
        } else if (ckop("Search Library") || dop("s")) {
            print("\nTODO");
        } else if (ckop("List of Songs") || dop("l")) {
            longLine();
            viewSongs();
        } else if (ckop("Back") || dop("b")) {
            backButton();
            startView();
        } else {
            notValid();
        }
        libraryOptions();
    }

    private void playlistOptions() {
        print("\nNew Playlist+");
        print("TODO\n");
    }

    private void newSongMenu() {
        print("\nEnter the name of your song\n");
        String title = userInput.nextLine();

        print("\nEnter the link of your song\n");
        String link = userInput.nextLine();

        Main.library.addToLibrary(title, link);

        print("Added succesfully!");
        longLine();
        libraryOptions();
    }

    private void viewSongs() {
        for (Song song : Main.library.getSongLibrary()) {
            print(song.getTitle() + " by " + song.getCreator().getName() + " || " + song.getDuration() + " seconds");
        }
        print("\nEnter the index of the song to add it to the queue.");
        print("  > Back\n");

        select = userInput.nextLine();

        if (ckop("Back") || dop("b")) {
            backButton();
            libraryOptions();
        } else {
            try {
                songInfoOptions(Main.library.searchSong(select));
            } catch (SongNotFoundException e) {
                notValid();
            }
        }
        viewSongs();
    }

    private void songInfoOptions(Song song) {

        songInfoDisplay(song);

        select = userInput.nextLine();

        if (ckop("Play next") || dop("n")) {
            Main.playHandler.nextAddSong(song);
            print("\nSuccessfully added to queue!");
            longLine();
            viewSongs();
        } else if (ckop("Add to queue") || dop("a")) {
            Main.playHandler.queueAddSong(song);
            longLine();
            print("\nSuccessfully added to queue!");
        } else if (ckop("Back") || dop("b")) {
            backButton();
            viewSongs();
        } else {
            notValid();
        }
        songInfoOptions(song);
    }

    private void songInfoDisplay(Song song) {
        print("\nTitle: " + song.getTitle());
        print("Sourced from: " + song.getLink());
        print("Created by: " + song.getCreator().getName());
        print("In album: " + song.getAlbum().getName());
        print("In genre: " + song.getSongGenre().toString());
        print("Song duration: " + song.getDuration());
        print("Liked song?: " + song.getLikedStatus().toString());

        print("\nEnter all options exactly.");
        print("  > Play next");
        print("  > Add to queue");
        print("  > Back\n");
    }

    private void queueOptions() {
        print("\nEnter all options exactly.");
        print("  > Play queue");
        print("  > View queue");
        print("  > Back\n");

        select = userInput.nextLine();

        if (ckop("Play queue") || dop("p")) {
            print("\nTODO");
        } else if (ckop("View queue") || dop("v")) {
            viewSongsQueue();
        } else if (ckop("Back") || dop("b")) {
            backButton();
            startView();
        } else {
            notValid();
        }
        queueOptions();
    }

    private void viewSongsQueue() {
        if (Main.playHandler.getQueue().isEmpty()) {
            print("No songs in the queue");
        } else {
            for (Song song : Main.playHandler.getQueue()) {
                print(song.getTitle() + " by " + song.getCreator().getName() + " || " + song.getDuration()
                        + " seconds");
            }
        }
        print("\n  > Back\n");

        select = userInput.nextLine();

        if (ckop("Back") || dop("b")) {
            backButton();
            queueOptions();
        }
        viewSongsQueue();
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
        print("\n----------------------");
    }

    // EFFECTS: shortcut for invalid user input
    private void notValid() {
        print("\nNot a valid option!");
        longLine();
    }

    // EFFECTS: shortcut to handle back button being pressed
    private void backButton() {
        print("\nHeading back to the previous menu...");
        longLine();
    }
}
