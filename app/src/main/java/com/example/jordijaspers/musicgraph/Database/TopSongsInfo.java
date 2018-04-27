package com.example.jordijaspers.musicgraph.Database;

public class TopSongsInfo {

    private String artistName;
    private String website;
    private String songName;
    private String listeners;
    private String imageURL;
    private String playCount;
    private int rank;


    public TopSongsInfo(String songName, String artistName, String listeners, String playCount, int rank, String website, String imageURL) {
        this.artistName = artistName;
        this.listeners = listeners;
        this.songName = songName;
        this.website = website;
        this.imageURL = imageURL;
        this.playCount = playCount;
        this.rank = rank;
    }

    public String getArtistName() {
        return artistName;
    }

    public String getSongName() {
        return songName;
    }

    public String getListeners() {
        return listeners;
    }

    public String getWebsite() {
        return website;
    }

    public String getImageURL() {
        return imageURL;
    }

    public String getPlayCount() {
        return playCount;
    }

    public int getRank() {
        return rank;
    }
}
