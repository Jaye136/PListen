package model.data.collections;

import java.util.ArrayList;

import model.data.plain.Song;

public class Playlist extends Collection {

    // EFFECTS: construct a playlist with with no songs yet. If it is a
    // playlist, assumes that playlist.setName() is the next line called

    public Playlist() {
        this.name = "error (you should not be seeing this message)";
        this.songs = new ArrayList<Song>();
    }

    // MODIFIES: song in this
    // EFFECTS: mass like or unlike all songs in the playlist
    // t: mass like, f: mass unlike
    public void massOpinion(Boolean liked) {
        for (Song songOpinion : songs) {
            songOpinion.switchLikedStatus(liked);
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
