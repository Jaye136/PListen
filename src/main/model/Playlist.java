package model;

import java.util.List;

public class Playlist {
    private String title;
    private List<Song> songs;

    // EFFECTS: construct a playlist with the given name with no songs yet
    public Playlist(String title) {
    }

    // MODIFIES: this
    // EFFECTS: add the given song to this
    public void addSong(Song song) {
    }

    // REQUIRES: song list is not empty
    // MODIFIES: this
    // EFFECTS: remove given song from this
    public void removeSong(Song song) {
    }

    // MODIFIES: song in this
    // EFFECTS: mass like or unlike all songs in the playlist
    // t: mass like, f: mass unlike
    public void massOpinion(Boolean liked) {
    }

    // EFFECTS: return the duration of the whole playlist (or just the songs that
    // have a set duration)
    public int playlistDuration() {
        return 0;
    }

    // EFFECTS: list all songs in the playlist
    public String whatSongs() {
        return "";
    }
    
    // MODIFIES: this
    // EFFECTS: setter
    public void setTitle() {
    }

    // EFFECTS: getter
    public void getTitle() {
    }

    // EFFECTS: getter
    public void getSongs() {
    }
}
