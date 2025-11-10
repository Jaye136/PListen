package model.handlers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;
import model.data.exceptions.*;
import model.data.plain.Song;

@ExcludeFromJacocoGeneratedReport
public class LibraryTest {

    private Library library;

    @BeforeEach
    void runBefore() {
        library = new Library();
        library.loadDefault();
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
    void setSongAlbumForLibrary() {
        library.addSongToLibrary("a", "b");
        try {
            Song thisSong = library.searchSong("a");
            library.songAlbum("yoy", "woy", thisSong);
            assertEquals(thisSong.getAlbum().getName(), "yoy");
            assertEquals(thisSong.getCreator().getName(), "woy");
        } catch (SongNotFoundException e) {
            fail();
        }
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
}
