package model.handlers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;
import model.data.exceptions.SongNotFoundException;

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
    public void checkGetSongExist() {
        try {
            library.searchSong("mysterious tunes");
        } catch (SongNotFoundException e) {
            fail("Song does not exist");
        }
    }

    @Test
    public void checkGetSongNull() {
        try {
            library.searchSong("tunes mysterious");
            fail("how did we get here?");
        } catch (SongNotFoundException e) {
            System.out.println("task successfully failed");
        }
    }


}
