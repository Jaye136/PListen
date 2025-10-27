package model.data.collections;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;
import model.data.exceptions.SongNotFoundException;
import model.data.plain.Song;

@ExcludeFromJacocoGeneratedReport
public abstract class CollectionTest {

    protected Collection testCollection;
    protected Song testSong;
    protected Song testSecondSong;

    protected Set<Collection> colHash;
    protected String colName;
    protected Album equalsAlbum;
    protected Artist equalsArtist;
    protected Playlist equalsPlaylist;

    @Test
    public void nameChange() {
        testCollection.setName("testCollection");
        assertEquals("testCollection", testCollection.getName());
    }

    @Test
    public void addOneSong() {
        testCollection.addSong(testSong);
        List<Song> whatSongs = testCollection.getSongs();
        assertEquals(1, whatSongs.size());
        assertEquals(testSong, whatSongs.get(0));
    }

    @Test
    public void addTwoSongs() {
        testCollection.addSong(testSong);
        testCollection.addSong(testSecondSong);
        List<Song> whatSongs = testCollection.getSongs();
        assertEquals(2, whatSongs.size());
        assertEquals(testSong, whatSongs.get(0));
        assertEquals(testSecondSong, whatSongs.get(1));
    }

    @Test
    public void removeOneSong() {
        testCollection.addSong(testSong);
        List<Song> whatSongs = testCollection.getSongs();
        assertEquals(1, whatSongs.size());
        testCollection.removeSong(testSong);
        whatSongs = testCollection.getSongs();
        assertEquals(0, whatSongs.size());
    }

    @Test
    public void removeTwoSongs() {
        testCollection.addSong(testSong);
        testCollection.addSong(testSecondSong);
        List<Song> whatSongs = testCollection.getSongs();
        assertEquals(2, whatSongs.size());
        testCollection.removeSong(testSong);
        whatSongs = testCollection.getSongs();
        assertEquals(1, whatSongs.size());
        assertEquals(testSecondSong, whatSongs.get(0));
        testCollection.removeSong(testSecondSong);
        whatSongs = testCollection.getSongs();
        assertTrue(whatSongs.isEmpty());
    }

    @Test
    public void checkGetSongExist() {
        testCollection.addSong(testSecondSong);
        try {
            testCollection.searchSong("mysterious tunes");
        } catch (SongNotFoundException e) {
            fail("Song exists");
        }
    }

    @Test
    public void checkGetSongNull() {
        testCollection.addSong(testSecondSong);
        try {
            testCollection.searchSong("fresh beats");
            fail("how did we get here?");
        } catch (SongNotFoundException e) {
            System.out.println("task successfully failed");
        }
    }

    @Test
    public void hashTest() {
        hashSetUp();
        colHash.add(testCollection);
        if (testCollection.getClass() == Album.class) {
            assertTrue(colHash.contains(equalsAlbum));
        } else if (testCollection.getClass() == Artist.class) {
            assertTrue(colHash.contains(equalsArtist));
        } else if (testCollection.getClass() == Playlist.class) {
            assertTrue(colHash.contains(equalsPlaylist));
        } else {
            fail("given object is not a collection type");
        }
    }

    @Test
    public void hashDiffName() {
        hashSetUp();
        colHash.add(testCollection);
        if (testCollection.getClass() == Album.class) {
            equalsAlbum.setName("diffName");
            assertFalse(colHash.contains(equalsAlbum));
            assertNotEquals(testCollection, equalsAlbum);
        } else if (testCollection.getClass() == Artist.class) {
            equalsArtist.setName("diffName");
            assertFalse(colHash.contains(equalsArtist));
            assertNotEquals(testCollection, equalsArtist);
        } else if (testCollection.getClass() == Playlist.class) {
            equalsPlaylist.setName("diffName");
            assertFalse(colHash.contains(equalsPlaylist));
            assertNotEquals(testCollection, equalsPlaylist);
        } else {
            fail("given object is not a collection type");
        }
    }

    @Test
    public void hashNoName() {
        hashSetUp();
        testCollection.setName(null);
        colHash.add(testCollection);

        assertFalse(colHash.contains(equalsAlbum));
        assertFalse(colHash.contains(equalsArtist));
        assertFalse(colHash.contains(equalsPlaylist));

        assertNotEquals(testCollection, equalsAlbum);
        assertNotEquals(testCollection, equalsArtist);
        assertNotEquals(testCollection, equalsPlaylist);
        hashEquals();
    }

    private void hashEquals() {
        if (testCollection.getClass() == Album.class) {
            equalsAlbum.setName(null);
            assertTrue(colHash.contains(equalsAlbum));
            assertEquals(equalsAlbum, testCollection);
        } else if (testCollection.getClass() == Artist.class) {
            equalsArtist.setName(null);
            assertTrue(colHash.contains(equalsArtist));
            assertEquals(testCollection, equalsArtist);
        } else if (testCollection.getClass() == Playlist.class) {
            equalsPlaylist.setName(null);
            assertTrue(colHash.contains(equalsPlaylist));
            assertEquals(testCollection, equalsPlaylist);
        } else {
            fail("given object is not a collection type");
        }
    }

    @Test
    public void hashNull() {
        hashSetUp();
        colHash.add(testCollection);
        assertFalse(colHash.contains(null));
        assertNotEquals(testCollection, null);
    }

    private void hashSetUp() {
        colHash = new HashSet<>();
        colName = testCollection.getName();
        equalsAlbum = new Album(colName);
        equalsArtist = new Artist(colName);
        equalsPlaylist = new Playlist();
    }

}
