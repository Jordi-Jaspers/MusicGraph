package com.example.jordijaspers.musicgraph.Database;

public class AlbumInfo {

    private String albumName;
    private String artistName;
    private String website;

    public AlbumInfo(String albumName, String artistName, String website) {
        this.albumName = albumName;
        this.artistName = artistName;
        this.website = website;
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
}
