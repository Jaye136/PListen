package model.data.collections;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;
import model.data.plain.Song;
import model.handlers.Library;

@ExcludeFromJacocoGeneratedReport
public class ArtistTest extends CollectionTest {

    private Artist forArtistMethods;
    private Album testAlbum;
    private Album testSecondAlbum;

    @BeforeEach
    void runBefore() {
        Library.defaultValues();
        testCollection = new Artist("abstract tester artist");
        forArtistMethods = new Artist("john artist");
        testAlbum = new Album("test album");
        testSecondAlbum = new Album("album test");
        testSong = new Song("fresh beats", "linkpath");
        testSecondSong = new Song("mysterious tunes", "linkpath");
    }

    @Test
    void testConstructor() {
        assertEquals("john artist", forArtistMethods.getName());
        assertTrue(forArtistMethods.getSongs().isEmpty());
        assertTrue(forArtistMethods.getAlbums().isEmpty());
    }

    @Test
    void addOneAlbum() {
        forArtistMethods.addAlbum(testAlbum);
        List<Album> whatAlbums = forArtistMethods.getAlbums();
        assertEquals(1, whatAlbums.size());
        assertEquals(testAlbum, whatAlbums.get(0));
    }

    @Test
    void addTwoAlbums() {
        forArtistMethods.addAlbum(testAlbum);
        forArtistMethods.addAlbum(testSecondAlbum);
        List<Album> whatAlbums = forArtistMethods.getAlbums();
        assertEquals(2, whatAlbums.size());
        assertEquals(testAlbum, whatAlbums.get(0));
        assertEquals(testSecondAlbum, whatAlbums.get(1));
    }

    @Test
    void removeOneAlbum() {
        forArtistMethods.addAlbum(testAlbum);
        List<Album> whatAlbums = forArtistMethods.getAlbums();
        assertEquals(1, whatAlbums.size());
        forArtistMethods.removeAlbum(testAlbum);
        whatAlbums = forArtistMethods.getAlbums();
        assertEquals(0, whatAlbums.size());
    }

    @Test
    void removeTwoAlbums() {
        forArtistMethods.addAlbum(testAlbum);
        forArtistMethods.addAlbum(testSecondAlbum);
        List<Album> whatAlbums = forArtistMethods.getAlbums();
        assertEquals(2, whatAlbums.size());
        forArtistMethods.removeAlbum(testAlbum);
        whatAlbums = forArtistMethods.getAlbums();
        assertEquals(1, whatAlbums.size());
        assertEquals(testSecondAlbum, whatAlbums.get(0));
        forArtistMethods.removeAlbum(testSecondAlbum);
        whatAlbums = forArtistMethods.getAlbums();
        assertTrue(whatAlbums.isEmpty());
    }

}