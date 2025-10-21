package model.data.collections;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;
import model.data.plain.Song;
import model.handlers.Library;

@ExcludeFromJacocoGeneratedReport
public class AlbumTest extends PlaylistTest {

    private Album forAlbumMethods;
    private Artist testArtist;

    @BeforeEach
    void runBefore() {
        Library.defaultValues();
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
        assertEquals("unknown", forAlbumMethods.getContributor().getName());
    }

    @Test
    void testSetAlbumContributor() {
        forAlbumMethods.setContributor(testArtist);
        assertEquals(testArtist, forAlbumMethods.getContributor());
        Artist differentArtist = new Artist("change artist");
        forAlbumMethods.setContributor(differentArtist);
        for (Album album : testArtist.getAlbums()) {
            if (album == forAlbumMethods) {
                fail("album should be removed from old artist");
            }
        }
    }

}