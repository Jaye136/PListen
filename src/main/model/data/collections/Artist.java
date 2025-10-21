package model.data.collections;

import java.util.ArrayList;
import java.util.List;

import model.data.plain.Song;

// CLASS DOCUMENT: a type of auto-managed Collection that additionally has
// a list of Albums where this object is the creator.

public class Artist extends Collection {
    
    private List<Album> albums;

    // EFFECTS: construct a new artist with the given name, with no albums or songs yet
    public Artist(String name) {
        this.name = name;
        this.songs = new ArrayList<Song>();
        this.albums = new ArrayList<Album>();
    }

    // MODIFIES: this
    // EFFECTS: add the given album to album list
    public void addAlbum(Album album) {
        albums.add(album);
    }

    // MODIFIES: this
    // EFFECTS: remove the given album from album list
    public void removeAlbum(Album album) {
        albums.remove(album);
    }
    
    // EFFECTS: getter
    public List<Album> getAlbums() {
        return albums;
    }
    
}
