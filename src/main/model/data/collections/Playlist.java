package model.data.collections;

import java.util.ArrayList;

import model.data.plain.Song;
import model.logging.*;

// CLASS DOCUMENT: A special type of Collection that is intended
// to be user-managed. It can do mass-actions such as liking/unliking
// all Songs inside of it, and can display additional information such
// as total runtime. Any Playlist object that is not a PlayHandler (queue)
// should set a name.

// - Album is a subtype of Playlist that is auto-managed, and has a
//   creator (Artist) field
// - PlayHandler is a subtype of Playlist that has no intended referencable
//   name. It is temporary, and not saved as a part of user data

public class Playlist extends Collection {

    // EFFECTS: construct a playlist with with no songs yet. If it is a
    // playlist, assumes that playlist.setName() is the next line called
    public Playlist() {
        this.name = "error (you should not be seeing this message)";
        this.songs = new ArrayList<Song>();
    }

    // MODIFIES: this
    // EFFECTS: add the given song to song list, allowing duplicates
    @Override
    public void addSong(Song song) {
        songs.add(song);
    }

    // MODIFIES: song in this.songs
    // EFFECTS: mass like or unlike all songs in the playlist
    // t: mass like, f: mass unlike
    public void massOpinion(Boolean liked) {
        for (Song songOpinion : songs) {
            songOpinion.switchLikedStatus(liked);
            EventLog.getInstance().logEvent(new Event(songs.size() + " / " + songs.size() + " songs in " + name
                    + " have had their like status changed to: " + Boolean.toString(liked)));
        }
    }

    // EFFECTS: return the duration of the whole playlist (or just the songs that
    // have a set duration)
    public int playlistDuration() {
        int durationSoFar = 0;
        for (Song forSongTime : songs) {
            durationSoFar = durationSoFar + forSongTime.getDuration();
        }
        return durationSoFar;
    }

}
