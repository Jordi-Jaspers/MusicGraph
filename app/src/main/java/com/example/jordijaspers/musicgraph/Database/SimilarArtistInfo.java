package com.example.jordijaspers.musicgraph.Database;

public class SimilarArtistInfo {

    private String artistName;
    private String rank;
    private String imageURL;

    public SimilarArtistInfo(String artistName, String rank, String imageURL) {
        this.artistName = artistName;
        this.rank = rank;
        this.imageURL = imageURL;
    }

    public String getArtistName() {
        return artistName;
    }

    public String getRank(){ return rank; }

    public String getImageURL() {
        return imageURL;
    }
}
