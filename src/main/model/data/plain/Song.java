package model.data.plain;

import model.data.collections.Album;
import model.data.collections.Artist;
import model.handlers.Library;

// CLASS DOCUMENTATION: a data type detailing information about a Song.
// The song has a variety of information, but only the title and link
// are necessary to instantiate it (as that would be the minimum needed
// in a functioning version of this program. A link/filepath to access
// the song, and a name to search for the song in a Collection/in the
// Library). Any other values are default.

// DEFAULT VALUES:
// The Song's default Album and Artist are the objects instantiated
// in the Library class (otherwise every time a song was made, it would
// create a new Artist and Album with the names 'unknown'). This is a
// special state of the Song, as while it has the values of unknownArtist
// and unknownAlbum, unknownArtist and unknownAlbum do not have this object
// as part of their song lists. (Songs cannot be searched for using unknown
// information).

// DEFAULT -> NON-DEFAULT SETTING:
// When the Song is given an actual Artis/Album to set, it adds itself
// to the Artist/Album Collections' song list (this is why these
// Collection classes were referred to as auto-managed).

// NON-DEFAULT -> NON-DEFAULT SETTING:
// When the Song is given an actual Artist/Album while it already is owned
// by a different actual Artist/Album, it removes itself from its old
// Artist/Album (auto-managed) and adds itself to the new Collection's
// song list.

public class Song { // could also make podcast subclass
    private String title;
    private String link;
    private Artist creator;
    private Album album;
    private Genre songGenre;
    private int durationInSeconds;
    private int colour;
    private Boolean likedStatus;

    // EFFECTS: construct an song with given name and link, everything else is
    // unknown. Callable for testing purposes only. For other uses, please use
    // Library.addSong(String title, String link) method.
    public Song(String title, String link) {
        this.title = title;
        this.link = link;
        this.creator = Library.getUnknownArtist();
        this.album = Library.getUnknownAlbum();
        this.songGenre = Genre.UNKNOWN;
        this.durationInSeconds = 0;
        this.colour = 0xc3cdde;
        this.likedStatus = false;
    }

    // MODIFIES: this
    // EFFECTS: set a new name for the song
    public void setTitle(String title) {
        this.title = title;
    }

    // MODIFIES: this
    // EFFECTS: change the link or filepath for the song
    public void setLink(String link) {
        this.link = link;
    }

    // MODIFIES: this, artist
    // EFFECTS: set the artist for this song, remove this song from the old artist,
    // and add this song to the artist's created songs
    public void setCreator(Artist creator) {
        if (this.creator != Library.getUnknownArtist()) {
            this.creator.removeSong(this);
        }
        this.creator = creator;
        this.creator.addSong(this);
    }

    // MODIFIES: this
    // EFFECTS: set the album for this song, remove this song from the old album,
    // and add this song to the album's songs
    public void setAlbum(Album album) {
        if (this.album != Library.getUnknownAlbum()) {
            this.album.removeSong(this);
        }
        this.album = album;
        this.creator.addSong(this);
    }

    // MODIFIES: this
    // EFFECTS: set the genre for this song
    public void setGenre(Genre genre) {
        this.songGenre = genre;
    }

    // MODIFIES: this
    // EFFECTS: set the duration for this song
    public void setDuration(int durationInSeconds) {
        this.durationInSeconds = durationInSeconds;
    }

    // MODIFIES: this
    // EFFECTS: set the display colour for this song in HEX
    public void setColour(int colour) {
        this.colour = colour;
    }

    // MODIFIES: this
    // EFFECTS: switch the liked status of the song to given boolean
    public void switchLikedStatus(Boolean likedStatus) {
        this.likedStatus = likedStatus;
    }

    // EFFECTS: getter
    public String getTitle() {
        return title;
    }

    // EFFECTS: getter
    public String getLink() {
        return link;
    }

    // EFFECTS: getter
    public Artist getCreator() {
        return creator;
    }

    // EFFECTS: getter
    public Album getAlbum() {
        return album;
    }

    // EFFECTS: getter
    public Genre getSongGenre() {
        return songGenre;
    }

    // EFFECTS: getter
    public int getDuration() {
        return durationInSeconds;
    }

    // EFFECTS: getter
    public int getCoverColour() {
        return colour;
    }

    // EFFECTS: getter
    public Boolean getLikedStatus() {
        return likedStatus;
    }

}
