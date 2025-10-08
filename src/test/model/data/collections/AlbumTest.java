package model.data.collections;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.data.plain.Song;

public class AlbumTest extends PlaylistTest {

    private Album forAlbumMethods;
    private Artist testArtist;

    @BeforeEach
    void runBefore() {
        testCollection = new Album("abstract tester album");
        forPlaylistMethods = new Album("abstract tester album");
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
        assertEquals("unknown", forAlbumMethods.getContributor());
        forAlbumMethods.setContributor(testArtist);
        assertEquals("john artist", forAlbumMethods.getContributor());
    }

}