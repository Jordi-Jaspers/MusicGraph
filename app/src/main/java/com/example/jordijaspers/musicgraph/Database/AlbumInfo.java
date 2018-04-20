package com.example.jordijaspers.musicgraph.Database;

public class AlbumInfo {

    private String albumName;
    private String artistName;
    private String website;
    private String imageURL;
    private String streamable;

    public AlbumInfo(String albumName, String artistName, String website, String streamable, String imageURL) {
        this.albumName = albumName;
        this.artistName = artistName;
        this.website = website;
        this.imageURL = imageURL;
        this.streamable = streamable;
    }

    public String getAlbumName() {
        return albumName;
    }

    public String getArtistName() {
        return artistName;
    }

    public String getWebsite() {
        return website;
    }

    public String getImageURL() {
        return imageURL;
    }

    public String getStreamable() {
        return streamable;
    }
}
