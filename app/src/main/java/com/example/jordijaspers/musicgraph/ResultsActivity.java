package com.example.jordijaspers.musicgraph;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.jordijaspers.musicgraph.Adapters.AlbumAdapter;
import com.example.jordijaspers.musicgraph.Adapters.ArtistAdapter;
import com.example.jordijaspers.musicgraph.Adapters.SongAdapter;
import com.example.jordijaspers.musicgraph.Database.AlbumInfo;
import com.example.jordijaspers.musicgraph.Database.ArtistInfo;
import com.example.jordijaspers.musicgraph.Database.SongInfo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ResultsActivity extends AppCompatActivity {

    private static final int AMOUNT = 30;
    private static final String TAG = "ResultsActivity";
    private String buttonClicked;

    private RecyclerView recyclerView;

    private List<ArtistInfo> artistInfoList;
    private List<AlbumInfo> albumInfoList;
    private List<SongInfo> songInfoList;

    /**
     * Creates all the object and reference them to their according ID.
     *
     * @param savedInstanceState savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        Log.i(TAG, "onCreate: Creating Objects And Finding ID.");
        artistInfoList = new ArrayList<>();
        albumInfoList = new ArrayList<>();
        songInfoList = new ArrayList<>();

        Intent intentButton = getIntent();
        buttonClicked = intentButton.getStringExtra("SearchMethod");

        Log.i(TAG, "OnCreate: Setting the Layout & linking the Adapter for the recycleView.");
        recyclerView = (RecyclerView) findViewById(R.id.rv_results);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Intent intentResults = getIntent();
        String JSONString = intentResults.getStringExtra("JSONresults");

        switch(buttonClicked){
            case "Artist":

                try {
                    JSONParseArtist(JSONString);
                } catch (JSONException exception) {
                    Log.e(TAG, "JSONParse: Exception Error: ", exception);
                }
                ArtistAdapter mArtistAdapter = new ArtistAdapter(this, artistInfoList);
                recyclerView.setAdapter(mArtistAdapter);
                break;

            case "Album":

                try {
                    JSONParseAlbum (JSONString);
                } catch (JSONException exception) {
                    Log.e(TAG, "JSONParse: Exception Error: ", exception);
                }
                AlbumAdapter mAlbumAdapter = new AlbumAdapter(this, albumInfoList);
                recyclerView.setAdapter(mAlbumAdapter);
                break;

            case "Song":

                try {
                    JSONParseSong (JSONString);
                } catch (JSONException exception) {
                    Log.e(TAG, "JSONParse: Exception Error: ", exception);
                }
                SongAdapter mSongAdapter = new SongAdapter(this, songInfoList);
                recyclerView.setAdapter(mSongAdapter);
                break;

            default:
                Log.i(TAG, "onCreate: No possible button! Try again!");
                break;
        }
    }

    /**
     * Parse the input of JSONobject to a readable string.
     *
     * @param JSONString JSONString
     * @throws JSONException Throws exception when null.
     */
    public void JSONParseArtist(String JSONString) throws JSONException {
        Log.i(TAG, "JSONParse: Parsing JSON data to object.");
        try{
            JSONObject tempObject = new JSONObject(JSONString).getJSONObject("results").getJSONObject("artistmatches");
            JSONArray array = tempObject.getJSONArray("artist");

            for (int i = 0 ;i < array.length(); i++){
                JSONObject JSONArtist = array.getJSONObject(i);
                JSONArray imageArray = JSONArtist.getJSONArray("image");
                artistInfoList.add(new ArtistInfo(JSONArtist.getString("name"), JSONArtist.getString("url"), JSONArtist.getString("listeners"), imageArray.getJSONObject(3).getString("#text")));
            }
        } catch(JSONException exception) {
            Log.e(TAG, "JSONParse: JSONException Error: ", exception);
        }
    }

    /**
     * Parse the input of JSONobject to a readable string.
     *
     * @param JSONString JSONString
     * @throws JSONException Throws exception when null.
     */
    public void JSONParseAlbum(String JSONString) throws JSONException {
        Log.i(TAG, "JSONParse: Parsing JSON data to object.");
        try{
            JSONObject tempObject = new JSONObject(JSONString).getJSONObject("results").getJSONObject("albummatches");
            JSONArray array = tempObject.getJSONArray("album");

            for (int i = 0 ;i < array.length(); i++){
                JSONObject JSONAlbum = array.getJSONObject(i);
                JSONArray imageArray = JSONAlbum.getJSONArray("image");
                albumInfoList.add(new AlbumInfo(JSONAlbum.getString("name"), JSONAlbum.getString("artist"), JSONAlbum.getString("url"), JSONAlbum.getString("streamable"), imageArray.getJSONObject(3).getString("#text")));
            }
        } catch(JSONException exception) {
            Log.e(TAG, "JSONParse: JSONException Error: ", exception);
        }
    }

    /**
     * Parse the input of JSONobject to a readable string.
     *
     * @param JSONString JSONString
     * @throws JSONException Throws exception when null.
     */
    public void JSONParseSong(String JSONString) throws JSONException {
        Log.i(TAG, "JSONParse: Parsing JSON data to object.");
        try{
            JSONObject tempObject = new JSONObject(JSONString).getJSONObject("results").getJSONObject("trackmatches");
            JSONArray array = tempObject.getJSONArray("track");

            for (int i = 0 ;i < array.length(); i++){
                JSONObject JSONSong = array.getJSONObject(i);
                JSONArray imageArray = JSONSong.getJSONArray("image");
                songInfoList.add(new SongInfo(JSONSong.getString("name"), JSONSong.getString("artist"), JSONSong.getString("url"), JSONSong.getString("listeners"), imageArray.getJSONObject(3).getString("#text")));
            }
        } catch(JSONException exception) {
            Log.e(TAG, "JSONParse: JSONException Error: ", exception);
        }
    }
}
