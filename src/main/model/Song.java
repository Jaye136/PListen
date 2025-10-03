package model;

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
    }

    // MODIFIES: this
    // EFFECTS: set a new name for the song
    public void setTitle(String title) {
    }

    // MODIFIES: this
    // EFFECTS: change the link or filepath for the song
    public void setLink(String link) {
    }

    // MODIFIES: this, artist
    // EFFECTS: set the artist for this song, remove this song from the old artist,
    // and add this song to the artist's created songs
    public void setCreator(Artist creator) {
    }

    // MODIFIES: this
    // EFFECTS: set the album for this song, remove this song from the old album,
    // and add this song to the album's songs
    public void setAlbum(Album album) {
    }

    // MODIFIES: this
    // EFFECTS: set the genre for this song
    public void setGenre(Genre genre) {
    }

    // MODIFIES: this
    // EFFECTS: set the duration for this song
    public void setDuration(int durationInSeconds) {
    }

    // MODIFIES: this
    // EFFECTS: set the display colour for this song
    public void setColour(int colour) {
    }

    // MODIFIES: this
    // EFFECTS: switch the liked status of the song
    public void switchLikedStatus(Boolean likedStatus) {
    }

    // EFFECTS: getter
    public String getTitle() {
        return "";
    }
    
    // EFFECTS: getter
    public String getLink() {
        return "";
    }
    
    // EFFECTS: getter
    public Artist getCreator() {
        return null;
    }
    
    // EFFECTS: getter
    public Album getAlbum() {
        return null;
    }

    // EFFECTS: getter
    public Genre getSongGenre() {
        return Genre.UNKNOWN;
    }

    // EFFECTS: getter
    public int getDuration() {
        return 0;
    }

    // EFFECTS: getter
    public int getCoverColour() {
        return 0;
    }

    // EFFECTS: getter
    public Boolean getLikedStatus() {
        return false;
    }

}
