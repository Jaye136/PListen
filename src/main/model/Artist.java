package model;

import java.util.List;

public class Artist {
    String name;
    List<Album> createdAlbums;
    List<Song> createdSongs;

    // EFFECTS: construct a new artist with the given name, with no albums or songs yet
    public Artist(String creator) {
    }

    // REQUIRES: artist has no other songs with the same title
    // EFFECTS: search this for the first song with the given title. If
    // true, call gotSong to return song, otherwise fail
    public Boolean searchSongFromArtist(String songTitle) {
        return false;
    }

    // EFFECTS: return the found song
    private Song gotSong(Song lastSearchedSong) {
        return null;
    }

    public String getName() {
        return "";
    }

    public List<Album> getAlbums() {
        return null;
    }

    public List<Song> createdSongs() {
        return null;
    }
    
}
