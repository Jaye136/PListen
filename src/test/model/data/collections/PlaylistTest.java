package model.data.collections;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;

import org.junit.jupiter.api.BeforeEach;

import model.data.plain.Song;
import model.handlers.Library;

@ExcludeFromJacocoGeneratedReport
public class PlaylistTest extends CollectionTest {

    protected Playlist forPlaylistMethods;

    @BeforeEach
    void runBefore() {
        Library.defaultValues();
        testCollection = new Playlist();
        forPlaylistMethods = new Playlist();
        forPlaylistMethods.setName("playlist test");
        testSong = new Song("fresh beats", "linkpath");
        testSecondSong = new Song("mysterious tunes", "linkpath");
    }

    @Test
    void massOpinionBoostOne() {
        forPlaylistMethods.addSong(testSong);
        forPlaylistMethods.addSong(testSecondSong);
        testSong.switchLikedStatus(true);
        forPlaylistMethods.massOpinion(true);
        List<Song> allLiked = forPlaylistMethods.getSongs();
        for (Song song:allLiked) {
            assertTrue(song.getLikedStatus());
        }
    }

    @Test
    void massOpinionBoostAll() {
        forPlaylistMethods.addSong(testSong);
        forPlaylistMethods.addSong(testSecondSong);
        forPlaylistMethods.massOpinion(true);
        List<Song> allLiked = forPlaylistMethods.getSongs();
        for (Song song:allLiked) {
            assertTrue(song.getLikedStatus());
        }
    }

    @Test
    void massOpinionDropOne() {
        forPlaylistMethods.addSong(testSong);
        forPlaylistMethods.addSong(testSecondSong);
        testSecondSong.switchLikedStatus(true);
        forPlaylistMethods.massOpinion(false);
        List<Song> allNotLiked = forPlaylistMethods.getSongs();
        for (Song song:allNotLiked) {
            assertFalse(song.getLikedStatus());
        }
    }

    @Test
    void massOpinionDropAll() {
        forPlaylistMethods.addSong(testSong);
        forPlaylistMethods.addSong(testSecondSong);
        testSong.switchLikedStatus(true);
        testSecondSong.switchLikedStatus(true);
        forPlaylistMethods.massOpinion(false);
        List<Song> allNotLiked = forPlaylistMethods.getSongs();
        for (Song song:allNotLiked) {
            assertFalse(song.getLikedStatus());
        }
    }

    @Test
    void playTimeNone() {
        forPlaylistMethods.addSong(testSong);
        forPlaylistMethods.addSong(testSecondSong);
        int duration = forPlaylistMethods.playlistDuration();
        assertEquals(0, duration);
    }

    @Test
    void playTimeMore() {
        testSong.setDuration(15);
        testSecondSong.setDuration(30);
        forPlaylistMethods.addSong(testSong);
        forPlaylistMethods.addSong(testSecondSong);
        int duration = forPlaylistMethods.playlistDuration();
        assertEquals(45, duration);
    }

}