package persistence;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import model.handlers.Library;

public class LibraryWriterTest { // referenced from JsonSerialisationDemo from CPSC210

    @Test
    void testWriteInvalid() {
        try {
            Library saveThis = new Library();
            LibraryWriter write = new LibraryWriter("./data/null.json");
            write.writeJson(saveThis);
            fail();
        } catch (IOException e) {
            // success
        }
    }

    @Test
    void testWriteEmpty() {
        try {
            Library saveThis = new Library();
            LibraryWriter write = new LibraryWriter("./data/emptyWrite");
            write.writeJson(saveThis);

            LibraryLoader load = new LibraryLoader("./data/emptyWrite");
            saveThis = load.readJson();
            assertEquals(saveThis.getSongLibrary().size(), 0);
        } catch (IOException e) {
            fail();
        }
    }

    @Test
    void testWriteNoneExceptDefault() {
        try {
            Library saveThis = new Library();
            Library.defaultValues();
            LibraryWriter write = new LibraryWriter("./data/noneExceptDefaultWrite");
            write.writeJson(saveThis);

            LibraryLoader load = new LibraryLoader("./data/noneExceptDefaultWrite");
            saveThis = load.readJson();
            assertEquals(saveThis.getSongLibrary().size(), 5);
        } catch (IOException e) {
            fail();
        }
    }
}
