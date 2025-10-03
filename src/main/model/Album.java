package model;

import java.util.List;

public class Album { // not belonging to artist, since two artists can work on album
    String name;
    List<Song> songsInAlbum;

    // EFFECTS: construct a new album with the given title, with no songs in it
    public Album(String title) {
    }

    // REQUIRES: album has no other songs with the same title
    // EFFECTS: search given artist for the first song with the given title. If
    // true, call gotSong to return song, otherwise fail
    public Boolean getSongFromAlbum(Album songAlbum, String songTitle) {
        return false;
    }

    // EFFECTS: return the found song
    private Song gotSong(Song lastSearchedSong) {
        return null;
    }

    public String getName() {
        return "";
    }

    public List<Song> getSongsList() {
        return null;
    }
}
