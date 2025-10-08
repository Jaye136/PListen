package model.data.collections;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import model.data.plain.Song;

public class PlaylistTest extends CollectionTest {

    protected Playlist forPlaylistMethods;

    @BeforeEach
    void runBefore() {
        testCollection = new Playlist();
        forPlaylistMethods = new Playlist();
        testSong = new Song("fresh beats", "linkpath");
        testSecondSong = new Song("mysterious tunes", "linkpath");
        forPlaylistMethods.addSong(testSong);
        forPlaylistMethods.addSong(testSecondSong);
    }

    @Test
    public void massOpinionBoostOne() {
        testSong.switchLikedStatus(true);
        forPlaylistMethods.massOpinion(true);
        List<Song> allLiked = forPlaylistMethods.getSongs();
        for (Song song:allLiked) {
            assertTrue(song.getLikedStatus());
        }
    }

    @Test
    public void massOpinionBoostAll() {
        forPlaylistMethods.massOpinion(true);
        List<Song> allLiked = forPlaylistMethods.getSongs();
        for (Song song:allLiked) {
            assertTrue(song.getLikedStatus());
        }
    }

    @Test
    public void massOpinionDropOne() {
        testSecondSong.switchLikedStatus(true);
        forPlaylistMethods.massOpinion(false);
        List<Song> allNotLiked = forPlaylistMethods.getSongs();
        for (Song song:allNotLiked) {
            assertFalse(song.getLikedStatus());
        }
    }

    @Test
    public void massOpinionDropAll() {
        testSong.switchLikedStatus(true);
        testSecondSong.switchLikedStatus(true);
        forPlaylistMethods.massOpinion(false);
        List<Song> allNotLiked = forPlaylistMethods.getSongs();
        for (Song song:allNotLiked) {
            assertTrue(song.getLikedStatus());
        }
    }

    @Test
    public void playTimeNone() {
        int duration = forPlaylistMethods.playlistDuration();
        assertEquals(0, duration);
    }

    @Test
    public void playTimeMore() {
        testSong.setDuration(15);
        testSecondSong.setDuration(30);
        int duration = forPlaylistMethods.playlistDuration();
        assertEquals(45, duration);
    }

}
