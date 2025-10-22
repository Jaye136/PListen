package persistence;

import model.handlers.Library;
import persistence.exceptions.InvalidFileException;
import persistence.exceptions.InvalidFilepathException;

public class libraryLoader {
    private String saveSource;

    // EFFECTS: construct a process to load save data from JSON
    // in filepath !!setSelf library method(?)
    public libraryLoader(String filepath) {
    }

    // EFFECTS: attempt to read the JSON, and save it to a JSON
    // object for reference.
    // If the JSON does not exist in the given filepath, throw
    // InvalidFilepathException. If a JSON does exist, but fails
    // to be readable during parsing, pass InvalidFileException
    public Library readJson() throws InvalidFilepathException, InvalidFileException {
        return null;
    }

    // EFFECTS: attempt to parse the JSON. If it fails to be readable,
    // throw InvalidFileException
    public Library parseJson() throws InvalidFileException {
        return null;
    }


}
