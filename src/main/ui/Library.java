package ui;

import java.util.ArrayList;
import java.util.List;

import model.Song;

public class Library {
    private List<Song> songLibrary;

    // EFFECTS: create a new library with no songs
    public Library() {
        songLibrary = new ArrayList<Song>();
    }

    // EFFECTS: temporary function to add default songs into library
    // (in phase 2, will read from user file)
    public void startLibrary() {
    }


}
