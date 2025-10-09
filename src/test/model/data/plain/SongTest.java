package model.data.plain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import model.data.collections.Album;
import model.data.collections.Artist;
import model.data.exceptions.SongNotFoundException;
import model.handlers.Library;

public class SongTest {

    private Song testSong;
    private Album testAlbum;
    private Artist testArtist;

    @BeforeEach
    void runBefore() {
        Library.defaultValues();
        testSong = new Song("fresh beats", "linkpath");
        testAlbum = new Album("test album");
        testArtist = new Artist("john artist");
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

}
