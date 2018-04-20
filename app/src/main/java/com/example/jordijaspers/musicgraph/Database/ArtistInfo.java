package com.example.jordijaspers.musicgraph.Database;

public class ArtistInfo {

    private String website;
    private String artistName;
    private String listeners;
    private String imageURL;


    public ArtistInfo(String artistName, String website, String listeners, String imageURL) {
        this.listeners = listeners;
        this.artistName = artistName;
        this.website = website;
        this.imageURL = imageURL;
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
}
