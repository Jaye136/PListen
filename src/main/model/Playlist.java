package model;

import java.util.List;

public class Playlist extends Collection {
    private String title;
    private List<Song> songs;

    // EFFECTS: construct a playlist with the given name with no songs yet
    public Playlist(String title) {
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
}
