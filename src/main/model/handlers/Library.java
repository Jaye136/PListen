package model.handlers;

import java.util.ArrayList;
import java.util.List;

import model.data.collections.*;
import model.data.plain.*;;

public class Library {
    private List<Song> songLibrary;

    // EFFECTS: initialise the default library
    public Library() {
        songLibrary = new ArrayList<Song>();
        startLibrary();
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
    // EFFECTS: add a song to list of available songs in program
    // (temporary, not saved as user data yet)
    public void addToLibrary(Song song) {
        songLibrary.add(song);
    }

    // EFFECTS: getter (only for testing)
    public List<Song> getSongLibrary() {
        return songLibrary;
    }

}
