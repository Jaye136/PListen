package model.data.collections;

import java.util.ArrayList;

import model.data.plain.Song;
import model.handlers.Library;

public class Album extends Playlist {

    private Artist contributor;

    // EFFECTS: construct a new album with the given title, with no songs in it
    public Album(String title) {
        this.name = title;
        this.contributor = Library.getUnknownArtist();
        this.songs = new ArrayList<Song>();
    }

    // MODIFIES: this
    // EFFECTS: set the given artist as the contributor, remove this from
    // the old artist, and add this to artist's albums
    public void setContributor(Artist contributor) {
        if (this.contributor != Library.getUnknownArtist()) {
            this.contributor.removeAlbum(this);
        }
        this.contributor = contributor;
        this.contributor.addAlbum(this);
    }

    // EFFECTS: getter
    public Artist getContributor() {
        return contributor;
    }

}
