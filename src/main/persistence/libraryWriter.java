package persistence;

import org.json.JSONObject;

import java.io.*;

import model.handlers.Library;

public class LibraryWriter { // referenced from JsonSerialisationDemo from CPSC210
    private static final int TAB = 4;
    private PrintWriter writer;
    private String saveTo;

    // EFFECTS: construct a process to write save data
    // into given JSON file
    public LibraryWriter(String filepath) {
        this.saveTo = filepath;
    }

    // EFFECTS: open and write save data into the given JSON file.
    // Closes writer after successful save. Throws IOException
    // if the given file cannot be written in.
    public void writeJson(Library libraryToSave) throws FileNotFoundException {
        writer = new PrintWriter(new File(saveTo));
        JSONObject json = libraryToSave.toJson();
        writer.print(json.toString(TAB));
        writer.close();
    }
}