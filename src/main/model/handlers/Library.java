package model.handlers;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import model.data.collections.*;
import model.data.exceptions.*;
import model.data.plain.*;

// CLASS DOCUMENT: a handler to read and initialise user data.

public class Library {
    private List<Song> songLibrary;
    private List<Playlist> playLibrary;
    private List<Artist> artistLibrary;
    private List<Album> albumLibrary;
    private static Artist unknownArtist;
    private static Album unknownAlbum;
    private Song lastSearchedSong;
    private Artist lastSearchedArtist;
    private Album lastSearchedAlbum;

    // EFFECTS: initialise the default library
    public Library() {
        songLibrary = new ArrayList<Song>();
        playLibrary = new ArrayList<Playlist>();
        artistLibrary = new ArrayList<Artist>();
        albumLibrary = new ArrayList<Album>();
        defaultValues();
    }

    // EFFECTS: allows for default values of songs. Only callable for
    // test purposes. Not added/recognised as a part of artist/albumLibrary
    public static void defaultValues() {
        unknownArtist = new Artist("unknown");
        unknownAlbum = new Album("unknown");
    }

    // EFFECTS: getter for default/unknown artist
    public static Artist getUnknownArtist() {
        return unknownArtist;
    }

    // EFFECTS: getter for default/unknown album
    public static Album getUnknownAlbum() {
        return unknownAlbum;
    }

    // EFFECTS: start up default library
    public void loadDefault() {
        addSongToLibrary("boomChaCha", "https/didItrickyou/question/BCHCH.M4A");
        addSongToLibrary("fresh beats", "file/morefile/songfiles/FrshBts.WAV");
        addSongToLibrary("mysterious tunes", "file/hidefile/songfiles/MysTune.mp3");
        addSongToLibrary("nice bars", "https://spotthefy.moc");
        addSongToLibrary("jazzy jams", "https://tubeyou.moc");

        defaultSongDetails();
    }

    // EFFECTS: add details for default value songs
    private void defaultSongDetails() {
        Artist chachaBoomer = new Artist("chachaBoomer");
        Artist istArt = new Artist("istArt the trAtsi");

        Album songsOfMovement = new Album("wanting to MOVE!");
        songsOfMovement.setContributor(chachaBoomer);

        Album songsOfSlow = new Album("feeling sleepy...");
        songsOfSlow.setContributor(istArt);

        songArtist("chachaBoomer", songLibrary.get(0));
        songAlbum("wanting to MOVE!", "chachaBoomer", songLibrary.get(0));

        songArtist("chachaBoomer", songLibrary.get(1));
        songLibrary.get(1).setGenre(Genre.HIPRAP);
        songLibrary.get(1).setColour(0x000000);

        songArtist("istArtist the trAtsi", songLibrary.get(2));
        songLibrary.get(2).setDuration(75);
        songLibrary.get(2).switchLikedStatus(true);

        songAlbum("wanting to MOVE!", "chachaBoomer", songLibrary.get(3));
        songLibrary.get(3).setGenre(Genre.HIPRAP);
        songLibrary.get(3).setColour(0xFFFFFF);

        songAlbum("feeling sleepy...", "istArtist the trAtsi", songLibrary.get(4));
        songLibrary.get(4).setGenre(Genre.JAZZ);
        songLibrary.get(4).setDuration(80);
    }

    // MODIFIES: this
    // EFFECTS: create and add new song to list of available songs in program.
    // Temporary, needs to be manually saved afterwards
    public void addSongToLibrary(String title, String link) {
        Song song = new Song(title, link);
        songLibrary.add(song);
    }

    // MODIFIES: this
    // EFFECTS: add artist to list of available artists in program, if there
    // are no other artists by the same name, then set song's artist
    public void songArtist(String name, Song song) {
        try {
            Artist artistFind = searchArtist(name);
            song.setCreator(artistFind);
        } catch (ArtistNotFoundException e) {
            Artist artistExist = new Artist(name);
            if (!artistExist.equals(unknownArtist)) {
                artistLibrary.add(artistExist);
                song.setCreator(artistExist);
            }
        }
    }

    // MODIFIES: this
    // EFFECTS: add album to list of available albums in program, if there
    // are no other albums by the same name, then accurately sets song's album
    public void songAlbum(String albumTitle, String albumArtist, Song song) {
        try {
            Album albumFind = searchAlbum(albumTitle);
            song.setAlbum(albumFind);
            song.setCreator(albumFind.getContributor());
        } catch (AlbumNotFoundException e) {
            songAlbumAdd(albumTitle, albumArtist, song);
        }
    }

    // EFFECTS: helper for songAlbum(), in the case that the given album is not
    // found, or is unknown
    private void songAlbumAdd(String albumTitle, String albumArtist, Song song) {
        try {
            Artist artistFind = searchArtist(albumArtist);
            Album albumArtistExist = new Album(albumTitle);
            if (!albumArtistExist.equals(unknownAlbum)) {
                albumArtistExist.setContributor(artistFind);
                albumLibrary.add(albumArtistExist);
                song.setAlbum(albumArtistExist);
            }
        } catch (ArtistNotFoundException ex) {
            Artist artistExist = new Artist(albumArtist);
            Album albumArtistExist = new Album(albumTitle);
            if (!albumArtistExist.equals(unknownAlbum)) {
                albumLibrary.add(albumArtistExist);
                song.setAlbum(albumArtistExist);
                if (!artistExist.equals(unknownArtist)) {
                    albumArtistExist.setContributor(artistExist);
                    artistLibrary.add(artistExist);
                    song.setCreator(artistExist);
                }
            }
        }
    }

    // MODIFIES: this
    // EFFECTS: add saved song data to library. For stored songs only. For other
    // uses, please use the addToLibrary(String title, String link) method.
    public void loadSongToLibrary(JSONObject jsonSong) {
        String title = jsonSong.getString("title");
        String link = jsonSong.getString("link");
        addSongToLibrary(title, link);
        String creator = jsonSong.getString("creator");
        String album = jsonSong.getString("album");
        String songGenre = jsonSong.getString("songGenre");
        int durationInSeconds = jsonSong.getInt("durationInSeconds");
        int colour = Integer.valueOf(jsonSong.getString("colour"));
        Boolean likedStatus = Boolean.valueOf(jsonSong.getString("likedStatus"));
        try {
            Song loadedSong = searchSong(title);
            songArtist(creator, loadedSong);
            songAlbum(album, creator, loadedSong);
            loadedSong.setGenre(Genre.valueOf(songGenre));
            loadedSong.setDuration(durationInSeconds);
            loadedSong.setColour(colour);
            loadedSong.switchLikedStatus(likedStatus);
        } catch (SongNotFoundException e) {
            e.printStackTrace();
        }
    }

    // EFFECTS: write save data to JSON
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("songLibrary", songsToJson());
        return json;
    }

    // EFFECTS: turn song object to JSON
    public JSONArray songsToJson() {
        JSONArray jsonArray = new JSONArray();
        for (Song song : songLibrary) {
            jsonArray.put(song.toJson());
        }
        return jsonArray;
    }

    // EFFECTS: getter (only for testing)
    public List<Song> getSongLibrary() {
        return songLibrary;
    }

    // EFFECTS: getter (only for testing)
    public List<Playlist> getPlayLibrary() {
        return playLibrary;
    }

    // EFFECTS: getter (only for testing)
    public List<Artist> getArtistLibrary() {
        return artistLibrary;
    }

    // EFFECTS: getter (only for testing)
    public List<Album> getAlbumLibrary() {
        return albumLibrary;
    }

    // EFFECTS: return the song found using canGetSongFromCollection
    // otherwise, if cannot find song, throw SongNotFoundException
    public Song searchSong(String title) throws SongNotFoundException {
        if (canGetSongFromLibrary(title)) {
            return lastSearchedSong;
        } else {
            throw new SongNotFoundException();
        }
    }

    // REQUIRES: library has no other songs with the same title
    // EFFECTS: search library for the first song with the given title. If
    // true, song exists, otherwise fail
    private Boolean canGetSongFromLibrary(String title) {
        for (Song inLibrary : songLibrary) {
            if (inLibrary.getTitle().equals(title)) {
                lastSearchedSong = inLibrary;
                return true;
            }
        }
        return false;
    }

    // EFFECTS: return the artist found using canGetArtistFromCollection
    // otherwise, if cannot find artist, throw ArtistNotFoundException
    public Artist searchArtist(String name) throws ArtistNotFoundException {
        if (canGetArtistFromLibrary(name)) {
            return lastSearchedArtist;
        } else {
            throw new ArtistNotFoundException();
        }
    }

    // REQUIRES: library has no other artists with the same name
    // EFFECTS: search library for the first artist with the given name. If
    // true, artist exists, otherwise fail
    private Boolean canGetArtistFromLibrary(String name) {
        for (Artist inLibrary : artistLibrary) {
            if (inLibrary.getName().equals(name)) {
                lastSearchedArtist = inLibrary;
                return true;
            }
        }
        return false;
    }

    // EFFECTS: return the album found using canGetAlbumFromCollection
    // otherwise, if cannot find album, throw AlbumgNotFoundException
    public Album searchAlbum(String name) throws AlbumNotFoundException {
        if (canGetAlbumFromLibrary(name)) {
            return lastSearchedAlbum;
        } else {
            throw new AlbumNotFoundException();
        }
    }

    // REQUIRES: library has no other albums with the same title
    // EFFECTS: search library for the first albums with the given title. If
    // true, album exists, otherwise fail
    private Boolean canGetAlbumFromLibrary(String name) {
        for (Album inLibrary : albumLibrary) {
            if (inLibrary.getName().equals(name)) {
                lastSearchedAlbum = inLibrary;
                return true;
            }
        }
        return false;
    }
}
