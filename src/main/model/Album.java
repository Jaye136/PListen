package model;

import java.util.List;

public class Album { // not belonging to artist, since two artists can work on album
    private String title;
    private List<Artist> creators;
    private List<Song> songs;
    private Song lastSearchedSong;

    // EFFECTS: construct a new album with the given title, with no songs in it
    public Album(String title) {
    }

    // EFFECTS: return the song found using canGetSongInAlbum, else do nothing
    public Song searchSong(String title) {
        return null;
    }
    
    // REQUIRES: album has no other songs with the same title
    // EFFECTS: search given artist for the first song with the given title. If
    // true, song exists, otherwise fail
    private Boolean canGetSongInAlbum() {
        return false;
    }

    // MODIFIES: this
    // EFFECTS: setter
    public void setName(String title) {
    }

    // MODIFIES: this
    // EFFECTS: add the given song to album
    public void addSong(Song song) {
    }

    // REQUIRES: song list is not empty
    // MODIFIES: this
    // EFFECTS: remove the given song from album
    public void removeSong(Song song) {
    }

    // EFFECTS: getter
    public String getName() {
        return "";
    }
    
    // EFFECTS: getter
    public List<Song> getSongs() {
        return null;
    }
}
