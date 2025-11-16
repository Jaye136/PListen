package persistence;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;
import model.handlers.Library;

@ExcludeFromJacocoGeneratedReport
public class LibraryWriterTest { // referenced from JsonSerialisationDemo from CPSC210

    @Test
    void testWriteInvalid() {
        try {
            Library saveThis = new Library();
            LibraryWriter write = new LibraryWriter("./data/\0illegal:filenameCant.json");
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
            LibraryWriter write = new LibraryWriter("./data/emptyWrite.json");
            write.writeJson(saveThis);

            LibraryLoader load = new LibraryLoader("./data/emptyWrite.json");
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
            saveThis.loadDefault();
            saveThis.addSongToLibrary("bland performance", "https://awardWinnerOfMostDefault.boo");
            LibraryWriter write = new LibraryWriter("./data/noneExceptDefaultWrite.json");
            write.writeJson(saveThis);

            LibraryLoader load = new LibraryLoader("./data/noneExceptDefaultWrite.json");
            saveThis = load.readJson();
            assertEquals(saveThis.getSongLibrary().size(), 6);
        } catch (IOException e) {
            fail();
        }
    }
}
