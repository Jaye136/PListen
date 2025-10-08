package model.handlers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.data.plain.Song;

public class LibraryTest {

    private Library library;

    @BeforeEach
    void constructLibrary() {
        library = new Library();
    }
    
    @Test
    void libraryInitialise() {
        assertEquals("boomChaCha", library.getSongLibrary().get(0).getTitle());
        assertEquals("nice bars", library.getSongLibrary().get(3).getTitle());
    }

    @Test
    void libraryNoneToOne() {
        assertEquals(5, library.getSongLibrary().size());
        Song testSong = new Song("fresh beats", "linkpath");
        library.addToLibrary(testSong);
        assertEquals(6, library.getSongLibrary().size());
        assertEquals(testSong, library.getSongLibrary().get(5));
    }


}
