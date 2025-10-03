package model;

import java.util.List;

public class Artist extends Collection {
    
    private List<Album> albums;

    // EFFECTS: construct a new artist with the given name, with no albums or songs yet
    public Artist(String name) {
    }

    // REQUIRES: one of album.getArtists() == this
    // MODIFIES: this
    // EFFECTS: add the given album to album list
    public void addAlbum(Album album) {
    }

    // REQUIRES: album list is not empty
    // MODIFIES: this
    // EFFECTS: remove the given album from album list
    public void removeAlbum(Album album) {
    }

    // EFFECTS: getter
    public List<Album> getAlbums() {
        return null;
    }
    
}
