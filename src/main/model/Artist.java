package model;

import java.util.List;

public class Artist {
    private String name;
    private List<Album> albums;
    private List<Song> songs;
    private Song lastSearchedSong;

    // EFFECTS: construct a new artist with the given name, with no albums or songs yet
    public Artist(String name) {
    }

    // EFFECTS: return the song found using canGetSongFromArtist, else do nothing
    public Song searchSong(String title) {
        return null;
    }

    // REQUIRES: artist has no other songs with the same title
    // EFFECTS: search this for the first song with the given title. If
    // true, song exists, otherwise fail
    private Boolean canGetSongFromArtist() {
        return false;
    }

    // MODIFIES: this
    // EFFECTS: setter
    public void setName(String name) {
    }

    // REQUIRES: artist made album
    // MODIFIES: this
    // EFFECTS: add the given album to album list
    public void addAlbum(Album album) {
    }

    // REQUIRES: album list is not empty
    // MODIFIES: this
    // EFFECTS: remove the given album from album list
    public void removeAlbum(Album album) {
    }

    // REQUIRES: artist made song
    // MODIFIES: this
    // EFFECTS: add the given song to song list
    public void addSong(Song song) {
    }

    // REQUIRES: song list is not empty
    // MODIFIES: this
    // EFFECTS: remove the given song from song list
    public void removeSong(Song song) {
    }

    // EFFECTS: getter
    public String getName() {
        return "";
    }

    // EFFECTS: getter
    public List<Album> getAlbums() {
        return null;
    }

    // EFFECTS: getter
    public List<Song> getSongs() {
        return null;
    }
    
}
