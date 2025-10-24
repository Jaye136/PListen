package persistence;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.json.JSONArray;
import org.json.JSONObject;

import model.handlers.Library;

public class LibraryLoader { // referenced from JsonSerialisationDemo from CPSC210
    private String saveSource;

    // EFFECTS: construct a process to load save data from given
    // JSON file
    public LibraryLoader(String filepath) {
        this.saveSource = filepath;
    }

    // EFFECTS: attempt to read the JSON, and save it to a JSON
    // object for reference.
    // If the JSON fails to be readable during parsing, due to
    // not existing, or other reasons, pass IOException
    public Library readJson() throws IOException {
        StringBuilder strBuild = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(saveSource), StandardCharsets.UTF_8)) {
            stream.forEach(s -> strBuild.append(s));
        }

        String strData = strBuild.toString();
        JSONObject jsonData = new JSONObject(strData);
        return parseJson(jsonData);
    }

    // EFFECTS: attempt to parse the JSON. If it fails to be readable,
    // throw IOException. Otherwise, return the parsed
    // saved state of the Library
    private Library parseJson(JSONObject jsonObject) throws IOException {
        Library loadLib = new Library();
        startLibrary(loadLib, jsonObject);
        return loadLib;
    }

    // DEPENDANCY PRIORITY OF LOADING:
    // 1. Artist, 2. Album, 3. Song, 4. Playlists
    // 1. Song, 2. Playlists, 3. Artist/Album
    // - Most likely would use modified .equals() to make sure
    //   correct song is being added into correct Collection, etc.

    // MODIFIES: libraryToLoadInto
    // EFFECTS: load parsed objects into the Library
    private void startLibrary(Library libraryToLoadInto, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("songLibrary");
        for (Object json : jsonArray) {
            JSONObject nextSong = (JSONObject) json;
            libraryToLoadInto.loadSongToLibrary(nextSong);
        }
    }

}
