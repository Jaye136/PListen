package model.handlers;

import model.data.collections.Playlist;
import model.data.plain.Song;

public class PlayHandler {
    
    private Playlist queue;

    public void start() {
        queue = new Playlist();
    }

    // REQUIRES: all song.getLink() values that are links start with https://.
    // Otherwise assume they are files
    // MODIFIES: this
    // EFFECTS: "play" the first song in a queue, remove it afterwards
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
    // EFFECTS: (setter) replace current queue with given song
    public void playSongNow(Song song) {
    }

    // MODIFIES: this
    // EFFECTS: (setter) replace current queue with playlist
    public void playPlaylistNow(Playlist songs) {
    }

    // MODIFIES: this
    // EFFECTS: add song to front of queue
    public void nextAddSong(Song song) {
    }

    // MODIFIES: this
    // EFFECTS: add song to back of queue
    public void queueAddSong(Song song) {
    }

    // MODIFIES: this
    // EFFECTS: add all songs of given playlist to front of queue
    public void nextAddSongs(Playlist songs) {
    }

    // MODIFIES: this
    // EFFECTS: add all songs of given playlist to back of queue
    public void queueAddSongs(Playlist songs) {
    }

    // EFFECTS: getter
    public Playlist getQueue() {
        return null;
    }
}
