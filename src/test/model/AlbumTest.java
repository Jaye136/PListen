package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AlbumTest {
    private Album testAlbum;
    private Song testSong;
    private Song testSecondSong;

    @BeforeEach
    void runBefore() {
        testAlbum = new Album("test album");
        testSong = new Song("fresh beats", "linkpath");
        testSecondSong = new Song("mysterious tunes", "linkpath");
    }

    @Test
    void testConstructor() {
        assertEquals("test album", testAlbum.getName());
        assertTrue(testAlbum.getSongs().isEmpty());
    }

    @Test
    void nameChange() {
        testAlbum.setName("album test");
        assertEquals("album test", testAlbum.getName());
    }

    @Test
    void addOneSong() {
        testAlbum.addSong(testSong);
        List<Song> whatSongs = testAlbum.getSongs();
        assertEquals(1, whatSongs.size());
        assertEquals(testSong, whatSongs.get(0));
    }

    @Test
    void addTwoSongs() {
        testAlbum.addSong(testSong);
        testAlbum.addSong(testSecondSong);
        List<Song> whatSongs = testAlbum.getSongs();
        assertEquals(2, whatSongs.size());
        assertEquals(testSong, whatSongs.get(0));
        assertEquals(testSecondSong, whatSongs.get(1));
    }

    @Test
    void removeOneSong() {
        testAlbum.addSong(testSong);
        List<Song> whatSongs = testAlbum.getSongs();
        assertEquals(1, whatSongs.size());
        testAlbum.removeSong(testSecondSong);
        whatSongs = testAlbum.getSongs();
        assertEquals(0, whatSongs.size());
    }

    @Test
    void removeTwoSongs() {
        testAlbum.addSong(testSong);
        testAlbum.addSong(testSecondSong);
        List<Song> whatSongs = testAlbum.getSongs();
        assertEquals(2, whatSongs.size());
        testAlbum.removeSong(testSong);
        whatSongs = testAlbum.getSongs();
        assertEquals(1, whatSongs.size());
        assertEquals(testSecondSong, whatSongs.get(0));
        testAlbum.removeSong(testSecondSong);
        whatSongs = testAlbum.getSongs();
        assertTrue(whatSongs.isEmpty());
    }

    @Test
    void checkGetSong() {
        testAlbum.addSong(testSong);
        Album albumTest = new Album("album test");
        albumTest.addSong(testSong);
        assertEquals(testAlbum.searchSong("fresh beats"), albumTest.searchSong("fresh beats"));
        assertEquals(testAlbum.searchSong("mysterious tunes"), albumTest.searchSong("mysterious tunes"));
    }

    @Test
    void checkGetSongOnlyOne() {
        testAlbum.addSong(testSecondSong);
        Album albumTest = new Album("album test");
        albumTest.addSong(testSong);
        assertNotEquals(testAlbum.searchSong("fresh beats"), albumTest.searchSong("fresh beats"));
        assertNotEquals(testAlbum.searchSong("mysterious tunes"), albumTest.searchSong("mysterious tunes"));
    }
}