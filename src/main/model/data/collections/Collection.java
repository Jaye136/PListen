package model.data.collections;

import java.util.List;

import model.data.plain.Song;

public abstract class Collection {

    protected String name;
    protected List<Song> songs;
    private Song lastSearchedSong;

    // EFFECTS: return the song found using canGetSongFromCollection, else do
    // nothing
    public Song searchSong(String title) {
        return null;
    }

    // REQUIRES: collection has no other songs with the same title
    // EFFECTS: search collection for the first song with the given title. If
    // true, song exists, otherwise fail
    private Boolean canGetSongFromCollection() {
        return false;
    }

    // REQUIRES: for Album && Artist, song.collection() == collection
    // for playlists, none (assumes nothing)
    // MODIFIES: this
    // EFFECTS: add the given song to song list
    public void addSong(Song song) {
    }

    // REQUIRES: song list of collection is not empty
    // MODIFIES: this
    // EFFECTS: remove the given song from song list
    public void removeSong(Song song) {
    }

    // MODIFIES: this
    // EFFECTS: setter
    public void setName(String name) {
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