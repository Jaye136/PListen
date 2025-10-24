package model.handlers;

import java.util.ArrayList;
import java.util.List;

import model.data.collections.*;
import model.data.exceptions.SongNotFoundException;
import model.data.plain.*;

// CLASS DOCUMENT: a handler to read and initialise user data.

public class Library {
    private List<Song> songLibrary;
    private List<Playlist> playLibrary;
    private List<Artist> artistLibrary;
    private List<Album> albumLibrary;
    private static Artist unknownArtist;
    private static Album unknownAlbum;
    private Song lastSearchedSong;

    // EFFECTS: initialise the default library
    public Library() {
        songLibrary = new ArrayList<Song>();
        playLibrary = new ArrayList<Playlist>();
        artistLibrary = new ArrayList<Artist>();
        albumLibrary = new ArrayList<Album>();
        defaultValues();
        loadDefault();
    }

    // EFFECTS: allows for default values of songs. Only callable for
    // test purposes. Not added/recognised as a part of artist/albumLibrary
    public static void defaultValues() {
        unknownArtist = new Artist("unknown");
        unknownAlbum = new Album("unknown");
    }

    // EFFECTS: getter for default/unknown artist
    public static Artist getUnknownArtist() {
        return unknownArtist;
    }

    // EFFECTS: getter for default/unknown album
    public static Album getUnknownAlbum() {
        return unknownAlbum;
    }

    // EFFECTS: start up default library
    public void loadDefault() {
        addSongToLibrary("boomChaCha", "https/didItrickyou/question/BCHCH.M4A");
        addSongToLibrary("fresh beats", "file/morefile/songfiles/FrshBts.WAV");
        addSongToLibrary("mysterious tunes", "file/hidefile/songfiles/MysTune.mp3");
        addSongToLibrary("nice bars", "https://spotthefy.moc");
        addSongToLibrary("jazzy jams", "https://tubeyou.moc");

        defaultSongDetails();
    }

    // EFFECTS: add details for default value songs
    private void defaultSongDetails() {
        Artist chachaBoomer = new Artist("chachaBoomer");
        Artist istArt = new Artist("istArt the trAtsi");

        Album songsOfMovement = new Album("wanting to MOVE!");
        songsOfMovement.setContributor(chachaBoomer);

        Album songsOfSlow = new Album("feeling sleepy...");
        songsOfSlow.setContributor(istArt);
        
        songLibrary.get(0).setCreator(chachaBoomer);
        songLibrary.get(0).setAlbum(songsOfMovement);

        songLibrary.get(1).setCreator(chachaBoomer);
        songLibrary.get(1).setGenre(Genre.HIPRAP);
        songLibrary.get(1).setColour(0x000000);

        songLibrary.get(2).setCreator(istArt);
        songLibrary.get(2).setDuration(75);
        songLibrary.get(2).switchLikedStatus(true);

        songLibrary.get(3).setAlbum(songsOfMovement);
        songLibrary.get(3).setGenre(Genre.HIPRAP);
        songLibrary.get(3).setColour(0xFFFFFF);

        songLibrary.get(4).setAlbum(songsOfSlow);
        songLibrary.get(4).setGenre(Genre.JAZZ);
        songLibrary.get(4).setDuration(80);
    }

    // MODIFIES: this
    // EFFECTS: create and add new song to list of available songs in program.
    // Temporary, needs to be manually saved afterwards
    public void addSongToLibrary(String title, String link) {
        Song song = new Song(title, link);
        songLibrary.add(song);
    }

    // MODIFIES: this
    // EFFECTS: add saved song data to library. For stored songs only. For other
    // uses, please use the addToLibrary(String title, String link) method.
    private void loadSongToLibrary(Song song) {
    }

    // MODIFIES: this
    // EFFECTS: add saved playlist data to library
    private void loadPlayToLibrary(Playlist playlist) {
    }

    // MODIFIES: this
    // EFFECTS: add saved artist data to library
    private void loadArtistToLibrary(Artist artist) {
    }

    // MODIFIES: this
    // EFFECTS: add saved album data to library
    private void loadAlbumToLibrary(Album album) {
    }

    // EFFECTS: getter (only for testing)
    public List<Song> getSongLibrary() {
        return songLibrary;
    }

    // EFFECTS: return the song found using canGetSongFromCollection
    // otherwise, if cannot find song, throw SongNotFoundException
    public Song searchSong(String title) throws SongNotFoundException {
        if (canGetSongFromLibrary(title)) {
            return lastSearchedSong;
        } else {
            throw new SongNotFoundException();
        }
    }

    // REQUIRES: library has no other songs with the same title
    // EFFECTS: search library for the first song with the given title. If
    // true, song exists, otherwise fail
    private Boolean canGetSongFromLibrary(String title) {
        for (Song inLibrary : songLibrary) {
            if (inLibrary.getTitle().equals(title)) {
                lastSearchedSong = inLibrary;
                return true;
            }
        }
        return false;
    }
}
