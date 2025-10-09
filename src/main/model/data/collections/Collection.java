package model.data.collections;

import java.util.List;

import model.data.exceptions.SongNotFoundException;
import model.data.plain.Song;

public abstract class Collection {

    protected String name;
    protected List<Song> songs;
    private Song lastSearchedSong;

    // EFFECTS: return the song found using canGetSongFromCollection
    // otherwise, if cannot find song, throw SongNotFoundException
    public Song searchSong(String title) throws SongNotFoundException {
        if (canGetSongFromCollection(title)) {
            return lastSearchedSong;
        } else {
            throw new SongNotFoundException();
        }
    }

    // REQUIRES: collection has no other songs with the same title
    // EFFECTS: search collection for the first song with the given title. If
    // true, song exists, otherwise fail
    private Boolean canGetSongFromCollection(String title) {
        for (Song inCollect : songs) {
            if (inCollect.getTitle().equals(title)) {
                lastSearchedSong = inCollect;
                return true;
            }
        }
        return false;
    }

    // MODIFIES: this
    // EFFECTS: add the given song to song list
    public void addSong(Song song) {
        songs.add(song);
    }

    // MODIFIES: this
    // EFFECTS: remove the given song from song list
    public void removeSong(Song song) {
        songs.remove(song);
    }

    // MODIFIES: this
    // EFFECTS: setter
    public void setName(String name) {
        this.name = name;
    }

    // EFFECTS: getter
    public String getName() {
        return name;
    }

    // EFFECTS: getter
    public List<Song> getSongs() {
        return songs;
    }

}