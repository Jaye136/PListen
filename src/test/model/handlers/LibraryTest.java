package model.handlers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

import model.data.plain.Song;

public class LibraryTest {

    private Library library;
    
    @Test
    void libraryNoneToOne() {
        assertEquals(0, library.getSongLibrary().size());
        Song testSong = new Song("fresh beats", "linkpath");
        library.addToLibrary(testSong);
        assertEquals(1, library.getSongLibrary().size());
    }


}
