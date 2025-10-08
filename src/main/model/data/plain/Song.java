package model.data.plain;

import model.data.collections.Album;
import model.data.collections.Artist;

public class Song { // could also make podcast subclass
    private String title;
    private String link;
    private Artist creator;
    private Album album;
    private Genre songGenre;
    private int durationInSeconds;
    private int colour;
    private Boolean likedStatus;

    // EFFECTS: construct an song with given name and link, everything else is unknown
    public Song(String title, String link) {
        this.title = title;
        this.link = link;
        this.creator = new Artist("unknown");
        this.album = new Album("unknown");
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
        this.creator.removeSong(this);
        this.creator = creator;
        this.creator.addSong(this);
    }

    // MODIFIES: this
    // EFFECTS: set the album for this song, remove this song from the old album,
    // and add this song to the album's songs
    public void setAlbum(Album album) {
        this.album.removeSong(this);
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
