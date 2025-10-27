package persistence;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import model.handlers.Library;

public class LibraryLoaderTest { // referenced from JsonSerialisationDemo from CPSC210

    @Test
    void testFileDoesntExistIssue() {
        LibraryLoader load = new LibraryLoader("./data/nullRead.json");
        try {
            load.readJson();
            fail("no such file");
        } catch (IOException e) {
            System.out.println("expected");
        }
    }

    @Test
    void libraryLoadEmpty() {
        LibraryLoader load = new LibraryLoader("./data/emptyLoad.json");
        try {
            Library loadLib = load.readJson();
            assertEquals(loadLib.getSongLibrary().size(), 0);
            assertEquals(loadLib.getAlbumLibrary().size(), 0);
            assertEquals(loadLib.getArtistLibrary().size(), 0);
        } catch (IOException e) {
            fail("file exists");
        }
    }

    @Test
    void libraryNoneExceptDefault() {
        LibraryLoader load = new LibraryLoader("./data/noneExceptDefaultLoad.json");
        try {
            Library loadLib = load.readJson();
            assertEquals(loadLib.getSongLibrary().size(), 5);
            assertEquals(loadLib.getAlbumLibrary().size(), 2);
            assertEquals(loadLib.getArtistLibrary().size(), 2);
        } catch (IOException e) {
            fail("file exists");
        }
    }
}
