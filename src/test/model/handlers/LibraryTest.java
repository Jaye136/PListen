package model.handlers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;
import model.data.collections.*;
import model.data.exceptions.*;
import model.data.plain.Song;

@ExcludeFromJacocoGeneratedReport
public class LibraryTest {

    private Library library;

    @BeforeEach
    void runBefore() {
        library = new Library();
    }
    
    @Test
    void libraryInitialise() {
        assertEquals("boomChaCha", library.getSongLibrary().get(0).getTitle());
        assertEquals("mysterious tunes", library.getSongLibrary().get(2).getTitle());
    }

    @Test
    void libraryNoneToOne() {
        assertEquals(5, library.getSongLibrary().size());
        library.addSongToLibrary("fresh beats", "linkpath");
        assertEquals(6, library.getSongLibrary().size());
        assertEquals("fresh beats", library.getSongLibrary().get(5).getTitle());
    }

    @Test
    void checkGetSongExist() {
        try {
            library.searchSong("mysterious tunes");
        } catch (SongNotFoundException e) {
            fail("Song exists");
        }

        try {
            library.searchAlbum("feeling sleepy...");
        } catch (AlbumNotFoundException e) {
            fail("Album exists");
        }

        try {
            library.searchArtist("chachaBoomer");
        } catch (ArtistNotFoundException e) {
            fail("Artist exists");
        }
    }

    @Test
    void checkGetSongNull() {
        try {
            library.searchSong("tunes mysterious");
            fail("how did we get here?");
        } catch (SongNotFoundException e) {
            System.out.println("task successfully failed");
        }

        try {
            library.searchAlbum("feeling awake!!");
            fail("how did we get here?");
        } catch (AlbumNotFoundException e) {
            System.out.println("task successfully failed");
        }

        try {
            library.searchArtist("boomerChaCha");
            fail("how did we get here?");
        } catch (ArtistNotFoundException e) {
            System.out.println("task successfully failed");
        }
    }

    @Test
    void loadSongToLibraryTest() {
        Song testSong = new Song("a", "b");
        library.loadSongToLibrary(testSong);
        try {
            assertEquals(testSong, library.searchSong("a"));
        } catch (SongNotFoundException e) {
            fail();
        }
    }

    @Test
    void loadPlayToLibraryTest() {
        Playlist testPlay = new Playlist();
        library.loadPlayToLibrary(testPlay);
        assertEquals(testPlay, library.getPlayLibrary().size());
    }

    @Test
    void loadArtistToLibraryTest() {
        Artist testArtist = new Artist("a");
        library.loadArtistToLibrary(testArtist);
        try {
            assertEquals(testArtist, library.searchArtist("a"));
        } catch (ArtistNotFoundException e) {
            fail();
        }
    }

    @Test
    void loadAlbumToLibraryTest() {
        Album testAlbum = new Album("a");
        library.loadAlbumToLibrary(testAlbum);
        try {
            assertEquals(testAlbum, library.searchAlbum("a"));
        } catch (AlbumNotFoundException e) {
            fail();
        }
    }

}
