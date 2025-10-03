package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AlbumTest extends CollectionTest {

    private Album forAlbumMethods;
    private Artist testArtist;

    @BeforeEach
    void runBefore() {
        testCollection = new Album("abstract tester album");
        forAlbumMethods = new Album("test album");
        testArtist = new Artist("john artist");
        testSong = new Song("fresh beats", "linkpath");
        testSecondSong = new Song("mysterious tunes", "linkpath");
    }

    @Test
    void testConstructor() {
        assertEquals("test album", forAlbumMethods.getName());
        assertTrue(forAlbumMethods.getSongs().isEmpty());
        assertEquals("unknown", forAlbumMethods.getContributor());
    }

    @Test
    void testSetAlbumContributor() {
        forAlbumMethods.setContributor(testArtist);;
    }

}