package com.example.jordijaspers.musicgraph.Database;

public class SongInfo {

    private String songName;
    private String artistName;
    private String website;

    public SongInfo(String songName, String artistName, String website) {
        this.songName = songName;
        this.artistName = artistName;
        this.website = website;
    }

    public String getSongName() {
        return songName;
    }

    public String getArtistName() {
        return artistName;
    }

    public String getWebsite() {
        return website;
    }
}
