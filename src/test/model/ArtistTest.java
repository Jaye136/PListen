package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ArtistTest {
    private Artist testArtist;
    private Album testAlbum;
    private Album testSecondAlbum;
    private Song testSong;
    private Song testSecondSong;

    @BeforeEach
    void runBefore() {
        testArtist = new Artist("john artist");
        testAlbum = new Album("test album");
        testSecondAlbum = new Album("album test");
        testSong = new Song("fresh beats", "linkpath");
        testSecondSong = new Song("mysterious tunes", "linkpath");
        testSong.setCreator(testArtist);
        testSecondSong.setCreator(testArtist);
    }

    @Test
    void testConstructor() {
        assertEquals("john artist", testArtist.getName());
        assertTrue(testArtist.getAlbums().isEmpty());
        assertTrue(testArtist.getSongs().isEmpty());
    }

    @Test
    void nameChange() {
        testArtist.setName("john test");
        assertEquals("john test", testArtist.getName());
    }

    @Test
    void addOneSong() {
        testArtist.addSong(testSong);
        List<Song> whatSongs = testArtist.getSongs();
        assertEquals(1, whatSongs.size());
        assertEquals(testSong, whatSongs.get(0));
    }

    @Test
    void addTwoSongs() {
        testArtist.addSong(testSong);
        testArtist.addSong(testSecondSong);
        List<Song> whatSongs = testArtist.getSongs();
        assertEquals(2, whatSongs.size());
        assertEquals(testSong, whatSongs.get(0));
        assertEquals(testSecondSong, whatSongs.get(1));
    }

    @Test
    void removeOneSong() {
        testArtist.addSong(testSong);
        List<Song> whatSongs = testArtist.getSongs();
        assertEquals(1, whatSongs.size());
        testArtist.removeSong(testSecondSong);
        whatSongs = testArtist.getSongs();
        assertEquals(0, whatSongs.size());
    }

    @Test
    void removeTwoSongs() {
        testArtist.addSong(testSong);
        testArtist.addSong(testSecondSong);
        List<Song> whatSongs = testArtist.getSongs();
        assertEquals(2, whatSongs.size());
        testArtist.removeSong(testSong);
        whatSongs = testArtist.getSongs();
        assertEquals(1, whatSongs.size());
        assertEquals(testSecondSong, whatSongs.get(0));
        testArtist.removeSong(testSecondSong);
        whatSongs = testArtist.getSongs();
        assertTrue(whatSongs.isEmpty());
    }

    @Test
    void addOneAlbum() {
        testArtist.addAlbum(testAlbum);
        List<Album> whatAlbums = testArtist.getAlbums();
        assertEquals(1, whatAlbums.size());
        assertEquals(testAlbum, whatAlbums.get(0));
    }

    @Test
    void addTwoAlbums() {
        testArtist.addAlbum(testAlbum);
        testArtist.addAlbum(testSecondAlbum);
        List<Album> whatAlbums = testArtist.getAlbums();
        assertEquals(2, whatAlbums.size());
        assertEquals(testAlbum, whatAlbums.get(0));
        assertEquals(testSecondAlbum, whatAlbums.get(1));
    }

    @Test
    void removeOneAlbum() {
        testArtist.addAlbum(testAlbum);
        List<Album> whatAlbums = testArtist.getAlbums();
        assertEquals(1, whatAlbums.size());
        testArtist.removeAlbum(testSecondAlbum);
        whatAlbums = testArtist.getAlbums();
        assertEquals(0, whatAlbums.size());
    }

    @Test
    void removeTwoAlbums() {
        testArtist.addAlbum(testAlbum);
        testArtist.addAlbum(testSecondAlbum);
        List<Album> whatAlbums = testArtist.getAlbums();
        assertEquals(2, whatAlbums.size());
        testArtist.removeAlbum(testAlbum);
        whatAlbums = testArtist.getAlbums();
        assertEquals(1, whatAlbums.size());
        assertEquals(testSecondAlbum, whatAlbums.get(0));
        testArtist.removeAlbum(testSecondAlbum);
        whatAlbums = testArtist.getAlbums();
        assertTrue(whatAlbums.isEmpty());
    }

    @Test
    void checkGetSong() {
        testArtist.addSong(testSong);
        Artist artistTest = new Artist("john test");
        artistTest.addSong(testSong);
        assertEquals(testArtist.searchSong("fresh beats"), artistTest.searchSong("fresh beats"));
        assertEquals(testArtist.searchSong("mysterious tunes"), artistTest.searchSong("mysterious tunes"));
    }

}