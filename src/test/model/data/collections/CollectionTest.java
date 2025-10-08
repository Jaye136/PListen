package model.data.collections;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import model.data.exceptions.SongNotFoundException;
import model.data.plain.Song;

public abstract class CollectionTest {

    protected Collection testCollection;
    protected Song testSong;
    protected Song testSecondSong;

    @Test
    public void nameChange() {
        testCollection.setName("testCollection");
        assertEquals("testCollection", testCollection.getName());
    }

    @Test
    public void addOneSong() {
        testCollection.addSong(testSong);
        List<Song> whatSongs = testCollection.getSongs();
        assertEquals(1, whatSongs.size());
        assertEquals(testSong, whatSongs.get(0));
    }

    @Test
    public void addTwoSongs() {
        testCollection.addSong(testSong);
        testCollection.addSong(testSecondSong);
        List<Song> whatSongs = testCollection.getSongs();
        assertEquals(2, whatSongs.size());
        assertEquals(testSong, whatSongs.get(0));
        assertEquals(testSecondSong, whatSongs.get(1));
    }

    @Test
    public void removeOneSong() {
        testCollection.addSong(testSong);
        List<Song> whatSongs = testCollection.getSongs();
        assertEquals(1, whatSongs.size());
        testCollection.removeSong(testSong);
        whatSongs = testCollection.getSongs();
        assertEquals(0, whatSongs.size());
    }

    @Test
    public void removeTwoSongs() {
        testCollection.addSong(testSong);
        testCollection.addSong(testSecondSong);
        List<Song> whatSongs = testCollection.getSongs();
        assertEquals(2, whatSongs.size());
        testCollection.removeSong(testSong);
        whatSongs = testCollection.getSongs();
        assertEquals(1, whatSongs.size());
        assertEquals(testSecondSong, whatSongs.get(0));
        testCollection.removeSong(testSecondSong);
        whatSongs = testCollection.getSongs();
        assertTrue(whatSongs.isEmpty());
    }

    @Test
    public void checkGetSongExist() {
        testCollection.addSong(testSecondSong);
        try {
            testCollection.searchSong("mysterious tunes");
        } catch (SongNotFoundException e) {
            fail("Song does not exist");
        }
    }

    @Test
    public void checkGetSongNull() {
        testCollection.addSong(testSecondSong);
        try {
            testCollection.searchSong("fresh beats");
            fail("how did we get here?");
        } catch (SongNotFoundException e) {
            System.out.println("task successfully failed");
        }
    }

}
