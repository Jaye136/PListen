package model.data.collections;

public class Playlist extends Collection {

    // REQUIRES: playlist.setName() is the next line
    // EFFECTS: construct a playlist with with no songs yet
    public Playlist() {
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
    
}
