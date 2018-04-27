package com.example.jordijaspers.musicgraph.Database;

public class TopArtistsInfo {

    private String website;
    private String artistName;
    private String listeners;
    private String imageURL;
    private String playCount;
    private int rank;


    public TopArtistsInfo(String artistName, String listeners, String playCount, int rank, String website, String imageURL) {
        this.listeners = listeners;
        this.artistName = artistName;
        this.website = website;
        this.imageURL = imageURL;
        this.playCount = playCount;
        this.rank = rank;
    }

    public String getArtistName() {
        return artistName;
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
