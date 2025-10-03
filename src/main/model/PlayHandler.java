package model;

public class PlayHandler {
    private static Playlist playNext;
    
    public PlayHandler() {
    }

    public void start() {
        this.playNext = new Playlist("queue");
    }

    // REQUIRES: all song.getLink() values that are links start with https://.
    // Otherwise assume they are files
    // MODIFIES: this
    // EFFECTS: "play" songs in queue one at a time, remove them afterwards
    // (since queue is temporary). If song is link, return BingBong, if song is
    // file, return BingBing

    // NOTE:
    // Since we were told not to go external calls for this project, this
    // is just a 'proof of concept' of what this project would theoretically
    // do with the given values
    public String playSongQueue() {
        return "BingBong!!";
    }

    // MODIFIES: this
    // EFFECTS: replace current queue with given song
    public void playSongNow(Song song) {
    }

    // MODIFIES: this
    // EFFECTS: replace current queue with playlist
    public void playPlaylistNow(Playlist songs) {
    }

    // MODIFIES: this
    // EFFECTS: add song to front of queue
    public void queueAddSong(Song song) {
    }

    // MODIFIES: this
    // EFFECTS: add song to back of queue
    public void nextAddSong(Song song) {
    }

    // MODIFIES: this
    // EFFECTS: add all songs of given playlist to front of queue
    public void queueAddSongs(Playlist songs) {
    }

    // MODIFIES: this
    // EFFECTS: add all songs of given playlist to back of queue
    public void nextAddSongs(Playlist songs) {
    }
}
