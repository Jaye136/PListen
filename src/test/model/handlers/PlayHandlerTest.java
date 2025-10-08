package model.handlers;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.data.collections.Playlist;
import model.data.plain.Song;

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
    void testConstructor() {
        Playlist queue = playHandler.getQueue();
        List<Song> emptyQueue = queue.getSongs();
        assertTrue(emptyQueue.isEmpty());
    }

    @Test
    void testPlaySongNow() {
        playHandler.playSongNow(testSong);
        int queueSize = playHandler.getQueue().getSongs().size();
        assertEquals(1, queueSize);
        playHandler.playSongNow(testSecondSong);
        queueSize = playHandler.getQueue().getSongs().size();
        assertEquals(1, queueSize);
    }

    @Test
    void testPlayPlaylistNow() {
        Playlist songs = new Playlist();
        songs.addSong(testSong);
        songs.addSong(testSecondSong);
        playHandler.playPlaylistNow(songs);
        int queueSize = playHandler.getQueue().getSongs().size();
        assertEquals(2, queueSize);
        songs.addSong(testSong);
        songs.addSong(testSecondSong);
        playHandler.playPlaylistNow(songs);
        queueSize = playHandler.getQueue().getSongs().size();
        assertEquals(4, queueSize);
    }

    @Test
    void queueSongAtFront() {
        playHandler.nextAddSong(testSong);
        playHandler.nextAddSong(testSecondSong);
        assertEquals(testSecondSong, playHandler.getQueue().getSongs().get(0));
        assertEquals(testSong, playHandler.getQueue().getSongs().get(1));
    }

    @Test
    void queueSongAtBack() {
        playHandler.queueAddSong(testSong);
        playHandler.queueAddSong(testSecondSong);
        assertEquals(testSong, playHandler.getQueue().getSongs().get(0));
        assertEquals(testSecondSong, playHandler.getQueue().getSongs().get(1));
    }

    @Test
    void queuePlaylistAtFront() {
        Song songShouldBeLast = new Song("shldblst", "link lonk");
        playHandler.nextAddSong(songShouldBeLast);
        Playlist songs = new Playlist();
        songs.addSong(testSong);
        songs.addSong(testSecondSong);
        playHandler.nextAddSongs(songs);
        assertEquals(testSecondSong, playHandler.getQueue().getSongs().get(1));
        assertEquals(songShouldBeLast, playHandler.getQueue().getSongs().get(2));
    }

    @Test
    void queuePlaylistAtBack() {
        Song songShouldBeFirst = new Song("shldblst", "link lonk");
        playHandler.nextAddSong(songShouldBeFirst);
        Playlist songs = new Playlist();
        songs.addSong(testSong);
        songs.addSong(testSecondSong);
        playHandler.nextAddSongs(songs);
        assertEquals(songShouldBeFirst, playHandler.getQueue().getSongs().get(0));
        assertEquals(testSecondSong, playHandler.getQueue().getSongs().get(2));
    }
    
}
