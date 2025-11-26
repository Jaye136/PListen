package model.data.collections;

import java.util.ArrayList;

import model.data.plain.Song;
import model.handlers.Library;
import model.logging.*;

// CLASS DOCUMENT: a subtype of Playlist, which is a subtype of Collection.
// This object can do Playlist mass-actions such as liking/unliking all songs
// inside of it, or displaying additional information such as total runtime.
// It has a field that shows its creator (Artist).

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
        if (!this.contributor.equals(Library.getUnknownArtist())) {
            this.contributor.removeAlbum(this);
        }
        this.contributor = contributor;
        this.contributor.addAlbum(this);
        EventLog.getInstance().logEvent(new Event("Set contributor of " + name + " to " + contributor.getName()));
    }

    // EFFECTS: getter
    public Artist getContributor() {
        return contributor;
    }

}
