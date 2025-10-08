package model.handlers;

import java.util.ArrayList;
import java.util.List;

import model.data.collections.Album;
import model.data.collections.Artist;
import model.data.plain.Song;

public class Library {
    private List<Song> songLibrary;
    public static Album unknownAlbum;
    public static Artist unknownArtist;

    // EFFECTS: create a new library with no songs
    public Library() {
        unknownAlbum = new Album("unknown");
        unknownArtist = new Artist("unknown");
        songLibrary = new ArrayList<Song>();
    }

    // MODIFIES: this
    // EFFECTS: temporary function to add default songs into library
    // (in phase 2, will read from user file)
    public void startLibrary() {
    }

    // MODIFIES: this
    // EFFECTS: add a song to list of available songs in program
    // (temporary, not saved as user data yet)
    public void addToLibrary(Song song) {
    }

    // EFFECTS: getter (only for testing)
    public List<Song> getSongLibrary() {
        return songLibrary;
    }

}
