package persistence;

import model.handlers.Library;
import persistence.exceptions.InvalidFileException;

public class LibraryWriter { // referenced from JsonSerialisationDemo from CPSC210
    private String saveTo;

    // EFFECTS: construct a process to write save data
    // into given JSON file
    public LibraryWriter(String filepath) {}

    // EFFECTS: open and write save data into the given JSON file.
    // Closes writer after successful save. Throws InvalidFileException
    // if the given file cannot be written in.
    public void writeJson(Library libraryToSave) throws InvalidFileException {}
}