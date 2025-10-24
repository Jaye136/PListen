package persistence;

import org.json.JSONObject;

import model.handlers.Library;
import persistence.exceptions.InvalidFileException;
import persistence.exceptions.InvalidFilepathException;

public class LibraryLoader { // referenced from JsonSerialisationDemo from CPSC210
    private String saveSource;

    // EFFECTS: construct a process to load save data from given
    // JSON file
    public LibraryLoader(String filepath) {
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
    // throw InvalidFileException. Otherwise, return the parsed
    // saved state of the Library
    public Library parseJson(JSONObject jsonObject) throws InvalidFileException {
        return null;
    }

    // DEPENDANCY PRIORITY OF LOADING:
    // 1. Artist, 2. Album, 3. Song, 4. Playlists
    // 1. Song, 2. Playlists, 3. Artist/Album
    // - Most likely would use modified .equals() to make sure
    //   correct song is being added into correct Collection, etc.

    // MODIFIES: libraryToLoadInto
    // EFFECTS: load parsed objects into the Library
    public void startLibrary(Library libraryToLoadInto) {}

}
