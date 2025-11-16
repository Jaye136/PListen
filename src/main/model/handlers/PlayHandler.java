package model.handlers;

import java.util.ArrayList;
import java.util.List;

import model.data.collections.Playlist;
import model.data.plain.Song;

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
        queue.remove(0);
        if (playThis.startsWith("https://")) {
            return "BingBing!!";
        } else {
            return "BingBong!!";
        }
    }

    // MODIFIES: this
    // EFFECTS: (setter) replace current queue with given song
    public void playSongNow(Song song) {
        queue = new ArrayList<Song>();
        this.songs = queue;
        queue.add(song);
    }

    // MODIFIES: this
    // EFFECTS: (setter) replace current queue with playlist
    public void playPlaylistNow(Playlist songs) {
        queue = songs.getSongs();
    }

    // MODIFIES: this
    // EFFECTS: add song to front of queue
    public void nextAddSong(Song song) {
        queue.add(0, song);
    }

    // MODIFIES: this
    // EFFECTS: add song to back of queue (using the more recognisable name based on
    // the unique behaviours/functionalities of song list)
    public void queueAddSong(Song song) {
        queue.add(song);
    }

    // MODIFIES: this
    // EFFECTS: add all songs of given playlist to front of queue
    public void nextAddSongs(Playlist songs) {
        List<Song> songsToAdd = songs.getSongs();
        int songSizeIndex = songsToAdd.size() - 1;
        while (songSizeIndex >= 0) {
            queue.add(0, songsToAdd.get(songSizeIndex));
            songSizeIndex = songSizeIndex - 1;
        }
    }

    // MODIFIES: this
    // EFFECTS: add all songs of given playlist to back of queue
    public void queueAddSongs(Playlist songs) {
        List<Song> songsToAdd = songs.getSongs();
        for (Song song : songsToAdd) {
            queue.add(song);
        }
    }

    // EFFECTS: getter (using the more recognisable name based on the unique
    // behaviours/functionalities of song list)
    public List<Song> getQueue() {
        return queue;
    }
}
