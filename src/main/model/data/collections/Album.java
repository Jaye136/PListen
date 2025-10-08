package model.data.collections;

public class Album extends Playlist {

    private Artist contributor;

    // EFFECTS: construct a new album with the given title, with no songs in it
    public Album(String title) {
    }

    // REQUIRES: one of artist.getAlbums() == this
    // MODIFIES: this
    // EFFECTS: set the given artist as the contributor
    public void setContributor(Artist contributor) {
    }

    // EFFECTS: getter
    public Artist getContributor() {
        return null;
    }

}
