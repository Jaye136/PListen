package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

public abstract class CollectionTest {
    protected Collection testCollection;
    protected Song testSong;
    protected Song testSecondSong;

    @Test
    void nameChange() {
        testCollection.setName("testCollection");
        assertEquals("testCollection", testCollection.getName());
    }

    @Test
    void addOneSong() {
        testCollection.addSong(testSong);
        List<Song> whatSongs = testCollection.getSongs();
        assertEquals(1, whatSongs.size());
        assertEquals(testSong, whatSongs.get(0));
    }

    @Test
    void addTwoSongs() {
        testCollection.addSong(testSong);
        testCollection.addSong(testSecondSong);
        List<Song> whatSongs = testCollection.getSongs();
        assertEquals(2, whatSongs.size());
        assertEquals(testSong, whatSongs.get(0));
        assertEquals(testSecondSong, whatSongs.get(1));
    }

    @Test
    void removeOneSong() {
        testCollection.addSong(testSong);
        List<Song> whatSongs = testCollection.getSongs();
        assertEquals(1, whatSongs.size());
        testCollection.removeSong(testSecondSong);
        whatSongs = testCollection.getSongs();
        assertEquals(0, whatSongs.size());
    }

    @Test
    void removeTwoSongs() {
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
    void checkGetSong() {
        testCollection.addSong(testSong);
        Album albumTest = new Album("album test");
        albumTest.addSong(testSong);
        assertEquals(testCollection.searchSong("fresh beats"), albumTest.searchSong("fresh beats"));
        assertEquals(testCollection.searchSong("mysterious tunes"), albumTest.searchSong("mysterious tunes"));
    }

    @Test
    void checkGetSongOnlyOne() {
        testCollection.addSong(testSecondSong);
        Album albumTest = new Album("album test");
        albumTest.addSong(testSong);
        assertNotEquals(testCollection.searchSong("fresh beats"), albumTest.searchSong("fresh beats"));
        assertNotEquals(testCollection.searchSong("mysterious tunes"), albumTest.searchSong("mysterious tunes"));
    }

}
