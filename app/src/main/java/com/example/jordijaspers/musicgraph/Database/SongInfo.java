package com.example.jordijaspers.musicgraph.Database;

public class SongInfo {

    private String songName;
    private String artistName;
    private String website;
    private String listeners;
    private String imageURL;

    public SongInfo(String songName, String artistName, String website, String listeners, String imageURL) {
        this.songName = songName;
        this.artistName = artistName;
        this.website = website;
        this.listeners = listeners;
        this.imageURL = imageURL;
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

    public String getListeners() {
        return listeners;
    }

    public String getImageURL() {
        return imageURL;
    }
}
