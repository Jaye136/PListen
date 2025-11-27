package model.handlers;

import java.util.ArrayList;
import java.util.List;

import model.data.collections.Playlist;
import model.data.plain.Song;
import model.logging.*;

// CLASS DOCUMENTATION: a queue (temporary Playlist) that is not
// saved with user data, and is cleared when the program ends. It
// 'plays' songs, and clears them from the queue one at a time.
// It has more specific add Song methods that can put songs in a
// specific order (front/back), as well as being able to replace
// its songs with an existing Playlists (without modifying the
// Playlist), and adding all songs from a Playlist to an existing
// Song queue.

public class PlayHandler extends Playlist {

    private List<Song> queue;

    // EFFECTS: instantiates new PlayHandler
    public void start() {
        queue = new ArrayList<Song>();
        this.songs = queue;
    }

    // MODIFIES: this
    // EFFECTS: "play" the first song in a queue, remove it afterwards
    // (since queue is temporary). If song is file, return BingBong, if song is
    // link, return BingBing, all song.getLink() values that are links start with
    // https://. Otherwise assume they are files

    // NOTE:
    // Since we were told not to go external calls for this project, this
    // is just a 'proof of concept' of what this project would theoretically
    // do with the given values
    public String playSongQueue() {
        String playThis = queue.get(0).getLink();
        Song played = queue.remove(0);
        EventLog.getInstance().logEvent(new Event("Played song from queue: " + played.getTitle()));
        if (playThis.startsWith("https://")) {
            return "BingBing!!";
        } else {
            return "BingBong!!";
        }
    }

    // MODIFIES: this
    // EFFECTS: (setter) replace current queue with given song
    public void playSongNow(Song song) {
        queue.clear();
        EventLog.getInstance().logEvent(new Event("Queue cleared"));
        queue.add(song);
        EventLog.getInstance().logEvent(new Event("Now playing: " + song.getTitle()));
    }

    // MODIFIES: this
    // EFFECTS: (setter) replace current queue with playlist
    public void playPlaylistNow(Playlist songs) {
        queue = songs.getSongs();
        EventLog.getInstance().logEvent(new Event("Queue cleared"));
        EventLog.getInstance().logEvent(new Event("Added " + songs.getSongs().size() + " songs to the queue"));
    }

    // MODIFIES: this
    // EFFECTS: add song to front of queue
    public void nextAddSong(Song song) {
        queue.add(0, song);
        EventLog.getInstance().logEvent(new Event("Added " + song.getTitle() + " to the front of the queue"));
    }

    // MODIFIES: this
    // EFFECTS: add song to back of queue (using the more recognisable name based on
    // the unique behaviours/functionalities of song list)
    public void queueAddSong(Song song) {
        queue.add(song);
        EventLog.getInstance().logEvent(new Event("Added " + song.getTitle() + " to the back of the queue"));
    }

    // MODIFIES: this
    // EFFECTS: add all songs of given playlist to front of queue
    public void nextAddSongs(Playlist songs) {
        queue.addAll(0, songs.getSongs());
        EventLog.getInstance()
                .logEvent(new Event("Added " + songs.getSongs().size() + " songs to the front of the queue"));
    }

    // MODIFIES: this
    // EFFECTS: add all songs of given playlist to back of queue
    public void queueAddSongs(Playlist songs) {
        queue.addAll(songs.getSongs());
        EventLog.getInstance()
                .logEvent(new Event("Added " + songs.getSongs().size() + " songs to the back of the queue"));
    }

    // EFFECTS: getter (using the more recognisable name based on the unique
    // behaviours/functionalities of song list)
    public List<Song> getQueue() {
        return queue;
    }
}
