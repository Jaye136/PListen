package model.handlers;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;
import model.data.collections.Playlist;
import model.data.plain.Song;

@ExcludeFromJacocoGeneratedReport
public class PlayHandlerTest {

    private PlayHandler playHandler;
    private Song testSong;
    private Song testSecondSong;

    @BeforeEach
    void runBefore() {
        playHandler = new PlayHandler();
        playHandler.start();
        testSong = new Song("fresh beats", "linkpath");
        testSecondSong = new Song("mysterious tunes", "linkpath");
    }

    @Test
    void playQueueTester() {
        playHandler.playSongNow(testSong);
        playHandler.queueAddSong(testSecondSong);
        testSecondSong.setLink("https://");
        assertEquals(2, playHandler.getQueue().size());
        assertEquals("BingBong!!", playHandler.playSongQueue());
        assertEquals("BingBing!!", playHandler.playSongQueue());
    }

    @Test
    void testConstructor() {
        List<Song> queue = playHandler.getQueue();
        List<Song> emptyQueue = queue;
        assertTrue(emptyQueue.isEmpty());
    }

    @Test
    void testPlaySongNow() {
        playHandler.playSongNow(testSong);
        int queueSize = playHandler.getQueue().size();
        assertEquals(1, queueSize);
        playHandler.playSongNow(testSecondSong);
        queueSize = playHandler.getQueue().size();
        assertEquals(1, queueSize);
    }

    @Test
    void testPlayPlaylistNow() {
        Playlist songs = new Playlist();
        songs.addSong(testSong);
        songs.addSong(testSecondSong);
        playHandler.playPlaylistNow(songs);
        int queueSize = playHandler.getQueue().size();
        assertEquals(2, queueSize);
        songs.addSong(testSong);
        songs.addSong(testSecondSong);
        playHandler.playPlaylistNow(songs);
        queueSize = playHandler.getQueue().size();
        assertEquals(4, queueSize);
    }

    @Test
    void queueSongAtFront() {
        playHandler.nextAddSong(testSong);
        playHandler.nextAddSong(testSecondSong);
        assertEquals(testSecondSong, playHandler.getQueue().get(0));
        assertEquals(testSong, playHandler.getQueue().get(1));
    }

    @Test
    void queueSongAtBack() {
        playHandler.queueAddSong(testSong);
        playHandler.queueAddSong(testSecondSong);
        assertEquals(testSong, playHandler.getQueue().get(0));
        assertEquals(testSecondSong, playHandler.getQueue().get(1));
    }

    @Test
    void queuePlaylistAtFront() {
        Song songShouldBeLast = new Song("shldblst", "link lonk");
        playHandler.nextAddSong(songShouldBeLast);
        Playlist songs = new Playlist();
        songs.addSong(testSong);
        songs.addSong(testSecondSong);
        playHandler.nextAddSongs(songs);
        assertEquals(testSecondSong, playHandler.getQueue().get(1));
        assertEquals(songShouldBeLast, playHandler.getQueue().get(2));
    }

    @Test
    void queuePlaylistAtBack() {
        Song songShouldBeFirst = new Song("shldbfst", "link lonk");
        playHandler.nextAddSong(songShouldBeFirst);
        Playlist songs = new Playlist();
        songs.addSong(testSong);
        songs.addSong(testSecondSong);
        playHandler.queueAddSongs(songs);
        assertEquals(songShouldBeFirst, playHandler.getQueue().get(0));
        assertEquals(testSecondSong, playHandler.getQueue().get(2));
    }
    
}
