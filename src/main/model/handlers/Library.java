package model.handlers;

import java.util.ArrayList;
import java.util.List;

import model.data.collections.*;
import model.data.exceptions.SongNotFoundException;
import model.data.plain.*;

public class Library {
    private List<Song> songLibrary;
    public static Artist unknownArtist;
    public static Album unknownAlbum;
    private Song lastSearchedSong;

    // EFFECTS: initialise the default library
    public Library() {
        songLibrary = new ArrayList<Song>();
        defaultValues();
        startLibrary();
    }

    // EFFECTS: allows for default values of songs. Only callable for
    // test purposes
    public static void defaultValues() {
        unknownArtist = new Artist("unknown");
        unknownAlbum = new Album("unknown");
    }

    // MODIFIES: this
    // EFFECTS: temporary function to add default songs into library
    // (in phase 2, will read from user file, and not self-instantiate)
    private void startLibrary() {
        Artist chachaBoomer = new Artist("chachaBoomer");
        Artist istArt = new Artist("istArt the trAtsi");

        Album songsOfMovement = new Album("wanting to MOVE!");
        songsOfMovement.setContributor(chachaBoomer);

        Album songsOfSlow = new Album("feeling sleepy...");
        songsOfSlow.setContributor(istArt);

        Song song1 = new Song("boomChaCha", "https/didItrickyou/question/BCHCH.M4A");
        song1.setCreator(chachaBoomer);
        song1.setAlbum(songsOfMovement);
        addToLibrary(song1);

        Song song2 = new Song("fresh beats", "file/morefile/songfiles/FrshBts.WAV");
        song2.setCreator(chachaBoomer);
        song2.setGenre(Genre.HIPRAP);
        song2.setColour(0x000000);
        addToLibrary(song2);

        Song song3 = new Song("mysterious tunes", "file/hidefile/songfiles/MysTune.mp3");
        song3.setCreator(istArt);
        song3.setDuration(75);
        song3.switchLikedStatus(true);
        addToLibrary(song3);

        Song song4 = new Song("nice bars", "https://spotthefy.moc");
        song4.setAlbum(songsOfMovement);
        song4.setGenre(Genre.HIPRAP);
        song4.setColour(0xFFFFFF);
        addToLibrary(song4);

        Song song5 = new Song("jazzy jams", "https://tubeyou.moc");
        song5.setAlbum(songsOfSlow);
        song5.setGenre(Genre.JAZZ);
        song5.setDuration(80);
        addToLibrary(song5);
    }

    // MODIFIES: this
    // EFFECTS: add song data to library. For stored songs only. For other uses,
    // please use the addToLibrary(String title, String link) method.
    // (temporary, not saved as user data yet)
    private void addToLibrary(Song song) {
        songLibrary.add(song);
    }

    // MODIFIES: this
    // EFFECTS: create and add new song to list of available songs in program
    // (temporary, not saved as user data yet)
    public void addToLibrary(String title, String link) {
        Song song = new Song(title, link);
        songLibrary.add(song);
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
