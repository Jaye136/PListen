package model;

public class Song { // could also make podcast subclass
    private String title;
    private String link;
    private Artist creator;
    private Album songAlbum;
    private Genre songGenre;
    private int durationInSeconds;
    private int covColour;
    private Boolean likedSong;

    // REQUIRES: title is not an empty string, link is not an empty string
    // EFFECTS: construct an album with given name and link, everything else is unknown
    public Song() {
    }

    // REQUIRES: title is not an empty string
    // MODIFIES: this
    // EFFECTS: set a new name for the song
    public void setTitle() {
    }

    // REQUIRES: link is not an empty string
    // MODIFIES: this
    // EFFECTS: change the link or filepath for the song
    public void setLink() {
    }

    // MODIFIES: this, artist
    // EFFECTS: set the artist for this song, and add this song to the artist's created songs
    public void setArtist() {
    }

    // MODIFIES: this
    // EFFECTS: set the album for this song, and add this song to the album's songs
    public void setAlbum() {
    }

    // MODIFIES: this
    // EFFECTS: set the duration for this song
    public void setDuration() {
    }

    // MODIFIES: this
    // EFFECTS: set the display colour for this song
    public void setColour() {
    }

    // MODIFIES: this
    // EFFECTS: switch the liked status of the song
    public void switchLikedStatus() {
    }

    public String getTitle() {
        return "";
    }

    public String getLink() {
        return "";
    }
    
    public Artist getCreator() {
        return null;
    }
    
    public Album getSongAlbum() {
        return null;
    }

    public Genre getSongGenre() {
        return Genre.UNKNOWN;
    }

    public int getDuration() {
        return 0;
    }

    public int getCoverColour() {
        return 0;
    }

    public Boolean getLikedStatus() {
        return false;
    }

}
