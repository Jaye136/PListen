package model.data.plain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;

import org.junit.jupiter.api.BeforeEach;

import model.data.collections.Album;
import model.data.collections.Artist;
import model.data.exceptions.SongNotFoundException;
import model.handlers.Library;

@ExcludeFromJacocoGeneratedReport
public class SongTest {

    private Song testSong;
    private Album testAlbum;
    private Artist testArtist;

    private Set<Song> testHash;
    private Song equalsSong;

    @BeforeEach
    void runBefore() {
        Library.defaultValues();
        testSong = new Song("fresh beats", "linkpath");
        testAlbum = new Album("test album");
        testArtist = new Artist("john artist");

        testHash = new HashSet<>();
        equalsSong = new Song("fresh beats", "linkpath");
        testHash.add(testSong);
    }

    @Test
    void constructCorrect() {
        assertEquals("fresh beats", testSong.getTitle());
        assertEquals("linkpath", testSong.getLink());
        assertEquals(Genre.UNKNOWN, testSong.getSongGenre());
        assertEquals(0, testSong.getDuration());
        assertEquals(0xc3cdde, testSong.getCoverColour());
        assertFalse(testSong.getLikedStatus());
    }

    @Test
    void changeTitle() {
        testSong.setTitle("mysterious tunes");
        assertEquals("mysterious tunes", testSong.getTitle());
    }

    @Test
    void changeLink() {
        testSong.setLink("unknown");
        assertEquals("unknown", testSong.getLink());
    }

    @Test
    void changeCreator() {
        testSong.setCreator(testArtist);
        assertEquals(testArtist, testSong.getCreator());
        Artist differentArtist = new Artist("change artist");
        testSong.setCreator(differentArtist);
        try {
            testArtist.searchSong("fresh beats");
        } catch (SongNotFoundException e) {
            System.out.println("song should be removed from old artist");
        }
    }

    @Test
    void changeAlbum() {
        testSong.setAlbum(testAlbum);
        assertEquals(testAlbum, testSong.getAlbum());
        Album differentAlbum = new Album("change album");
        testSong.setAlbum(differentAlbum);
        try {
            testAlbum.searchSong("fresh beats");
        } catch (SongNotFoundException e) {
            System.out.println("song should be removed from old album");
        }
    }

    @Test
    void changeGenre() {
        testSong.setGenre(Genre.RNBSOUL);
        assertEquals(Genre.RNBSOUL, testSong.getSongGenre());
    }

    @Test
    void changeDuration() {
        testSong.setDuration(15);
        assertEquals(15, testSong.getDuration());
    }

    @Test
    void changeCoverColour() {
        testSong.setColour(0x000000);
        assertEquals(0x000000, testSong.getCoverColour());
    }

    @Test
    void changeLikedStatus() {
        testSong.switchLikedStatus(false);
        assertFalse(testSong.getLikedStatus());
        testSong.switchLikedStatus(true);
        assertTrue(testSong.getLikedStatus());
        testSong.switchLikedStatus(true);
        assertTrue(testSong.getLikedStatus());
    }

    @Test
    void checkModdedHash() {
        Song equalsSong = new Song("fresh beats", "linkpath");
        testHash.add(testSong);
        assertTrue(testHash.contains(equalsSong));
        assertEquals(equalsSong, testSong);
        assertFalse(testHash.contains(null));
        assertNotEquals(testSong, null);
        assertNotEquals(testSong, testAlbum);
    }

    @Test
    void checkModdedEqualsTitle() {
        equalsSong.setTitle(null);
        assertNotEquals(equalsSong, testSong);
        equalsSong.setTitle("fresh?");
        assertNotEquals(equalsSong, testSong);
        equalsSong.setTitle(null);
        testSong.setTitle(null);
        assertEquals(equalsSong, testSong);
        equalsSong.setTitle("fresh beats");
        testSong.setTitle("fresh beats");
        assertEquals(equalsSong, testSong);
    }

    @Test
    void checkModdedEqualsLink() {
        equalsSong.setLink(null);
        assertNotEquals(equalsSong, testSong);
        equalsSong.setLink("link?");
        assertNotEquals(equalsSong, testSong);
        equalsSong.setLink(null);
        testSong.setLink(null);
        assertEquals(equalsSong, testSong);
        equalsSong.setLink("linkpath");
        testSong.setLink("linkpath");
        assertEquals(equalsSong, testSong);
    }

    @Test
    void checkModdedEqualsCreator() {
        equalsSong.setCreator(testArtist);
        assertNotEquals(equalsSong, testSong);
        testSong.setCreator(testArtist);
        assertEquals(equalsSong, testSong);
    }

    @Test
    void checkModdedEqualsAlbum() {
        equalsSong.setAlbum(testAlbum);
        assertNotEquals(equalsSong, testSong);
        testSong.setAlbum(testAlbum);
        assertEquals(equalsSong, testSong);
    }

    @Test
    void checkModdedEqualsGenre() {
        testSong.setGenre(Genre.BLUES);
        assertNotEquals(equalsSong, testSong);
        equalsSong.setGenre(Genre.BLUES);
        assertEquals(equalsSong, testSong);
    }

    @Test
    void checkModdedEqualsDuration() {
        equalsSong.setDuration(1);
        assertNotEquals(equalsSong, testSong);
        equalsSong.setDuration(0);
        assertEquals(equalsSong, testSong);
    }

    @Test
    void checkModdedEqualsColour() {
        equalsSong.setColour(0x000000);
        assertNotEquals(equalsSong, testSong);
        equalsSong.setColour(0xc3cdde);
        assertEquals(equalsSong, testSong);
    }

    @Test
    void checkModdedEqualsLike() {
        equalsSong.switchLikedStatus(true);
        assertNotEquals(equalsSong, testSong);
        testSong.switchLikedStatus(true);
        assertEquals(equalsSong, testSong);
    }
}
