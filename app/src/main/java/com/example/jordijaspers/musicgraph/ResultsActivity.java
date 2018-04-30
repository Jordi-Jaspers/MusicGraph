package com.example.jordijaspers.musicgraph;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.jordijaspers.musicgraph.Adapters.AlbumAdapter;
import com.example.jordijaspers.musicgraph.Adapters.ArtistAdapter;
import com.example.jordijaspers.musicgraph.Adapters.SimilarArtistAdapter;
import com.example.jordijaspers.musicgraph.Adapters.SongAdapter;
import com.example.jordijaspers.musicgraph.Adapters.TopArtistsAdapter;
import com.example.jordijaspers.musicgraph.Adapters.TopSongsAdapter;
import com.example.jordijaspers.musicgraph.Database.AlbumInfo;
import com.example.jordijaspers.musicgraph.Database.ArtistInfo;
import com.example.jordijaspers.musicgraph.Database.SimilarArtistInfo;
import com.example.jordijaspers.musicgraph.Database.SongInfo;
import com.example.jordijaspers.musicgraph.Database.TopArtistsInfo;
import com.example.jordijaspers.musicgraph.Database.TopSongsInfo;
import com.example.jordijaspers.musicgraph.Utilities.DataDbHelper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ResultsActivity extends AppCompatActivity {

    private static final int AMOUNT = 30;
    private static final String TAG = "ResultsActivity";
    private String buttonClicked;
    private Boolean CONNECTED;

    private Intent mIntent;

    private RecyclerView recyclerView;
    public static SQLiteDatabase mDb;
    private DataDbHelper dbHelper;

    private List<ArtistInfo> artistInfoList;
    private List<AlbumInfo> albumInfoList;
    private List<SongInfo> songInfoList;
    private List<TopArtistsInfo> topArtistsInfoList;
    private List<TopSongsInfo> topSongsInfoList;
    private List<SimilarArtistInfo> similarArtistInfoList;

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
        topArtistsInfoList = new ArrayList<>();
        topSongsInfoList = new ArrayList<>();
        similarArtistInfoList = new ArrayList<>();

        dbHelper = new DataDbHelper(this);

        mIntent = getIntent();
        buttonClicked = mIntent.getStringExtra("SearchMethod");
        CONNECTED = mIntent.getBooleanExtra("Connected", true);

        Log.i(TAG, "OnCreate: Setting the Layout & linking the Adapter for the recycleView.");
        recyclerView = (RecyclerView) findViewById(R.id.rv_results);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        String JSONString = null;
        if (mIntent.getStringExtra("JSONresults") != null){
            JSONString = mIntent.getStringExtra("JSONresults");
        }

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

            case "TopArtists":

                if (!CONNECTED){
                    mDb = dbHelper.getReadableDatabase();
                    dbHelper.getTop50ArtistsFromDb(mDb, topArtistsInfoList);
                    TopArtistsAdapter mTopArtistsAdapter = new TopArtistsAdapter(this, topArtistsInfoList);
                    recyclerView.setAdapter(mTopArtistsAdapter);

                    if(topSongsInfoList.isEmpty())
                        Toast.makeText(this, "No Internet Connection, please try again.", Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(this, "Not Live Data: Internet Connection Error.", Toast.LENGTH_LONG).show();

                    mDb.close();
                    break;
                }else {
                    try {
                        JSONParseTopArtists(JSONString);
                    } catch (JSONException exception) {
                        Log.e(TAG, "JSONParse: Exception Error: ", exception);
                    }
                    TopArtistsAdapter mTopArtistsAdapter = new TopArtistsAdapter(this, topArtistsInfoList);
                    recyclerView.setAdapter(mTopArtistsAdapter);
                    break;
                }

            case "TopSongs":

                if(!CONNECTED){
                    mDb = dbHelper.getReadableDatabase();
                    dbHelper.getTop50SongsFromDb(mDb, topSongsInfoList);
                    TopSongsAdapter mTopSongsAdapter = new TopSongsAdapter(this, topSongsInfoList);
                    recyclerView.setAdapter(mTopSongsAdapter);

                    if(topSongsInfoList.isEmpty())
                        Toast.makeText(this, "No Internet Connection, please try again.", Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(this, "Not Live Data: Internet Connection Error.", Toast.LENGTH_LONG).show();

                    mDb.close();
                    break;
                }else {
                    try {
                        JSONParseTopSongs(JSONString);
                    } catch (JSONException exception) {
                        Log.e(TAG, "JSONParse: JSONException Error: ", exception);
                    } catch (IOException exception) {
                        Log.e(TAG, "JSONParse: IOException Error: ", exception);
                    }
                    TopSongsAdapter mTopSongsAdapter = new TopSongsAdapter(this, topSongsInfoList);
                    recyclerView.setAdapter(mTopSongsAdapter);
                    break;
                }

            case "SimilarArtist":
                try {
                    JSONParseSimilarArtist(JSONString);
                } catch (JSONException exception) {
                    Log.e(TAG, "JSONParse: JSONException Error: ", exception);
                } catch (IOException exception) {
                    Log.e(TAG, "JSONParse: IOException Error: ", exception);
                }
                SimilarArtistAdapter mSimilarArtistAdapter = new SimilarArtistAdapter(this, similarArtistInfoList);
                recyclerView.setAdapter(mSimilarArtistAdapter);
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

    /**
     * Parse the input of JSONobject to a readable string.
     *
     * @param JSONString JSONString
     * @throws JSONException Throws exception when null.
     */
    public void JSONParseTopArtists(String JSONString) throws JSONException {
        Log.i(TAG, "JSONParse: Parsing JSON data to object.");
        try{
            JSONObject tempObject = new JSONObject(JSONString).getJSONObject("artists");
            JSONArray array = tempObject.getJSONArray("artist");

            for (int i = 0 ;i < 50; i++){
                JSONObject JSONTopArtists = array.getJSONObject(i);
                JSONArray imageArray = JSONTopArtists.getJSONArray("image");
                topArtistsInfoList.add(new TopArtistsInfo(JSONTopArtists.getString("name"),
                        JSONTopArtists.getString("listeners"),
                        JSONTopArtists.getString("playcount"),
                        (i+1),
                        JSONTopArtists.getString("url"),
                        imageArray.getJSONObject(3).getString("#text")));
            }
        } catch(JSONException exception) {
            Log.e(TAG, "JSONParse: JSONException Error: ", exception);
        }
        mDb = dbHelper.getWritableDatabase();
        dbHelper.readTop50ArtistsToDb(mDb, topArtistsInfoList);
        mDb.close();
    }

    /**
     * Parse the input of JSONobject to a readable string.
     *
     * @param JSONString JSONString
     * @throws JSONException Throws exception when null.
     */
    public void JSONParseTopSongs(String JSONString) throws JSONException, IOException {
        Log.i(TAG, "JSONParse: Parsing JSON data to object.");
        try{
            JSONObject tempObject = new JSONObject(JSONString).getJSONObject("tracks");
            JSONArray array = tempObject.getJSONArray("track");

            for (int i = 0 ;i < 50; i++){
                JSONObject JSONTopSongs = array.getJSONObject(i);
                JSONArray imageArray = JSONTopSongs.getJSONArray("image");
                topSongsInfoList.add(new TopSongsInfo(
                        JSONTopSongs.getString("name"),
                        JSONTopSongs.getJSONObject("artist").getString("name"),
                        JSONTopSongs.getString("listeners"), JSONTopSongs.getString("playcount"),
                        (i+1),
                        JSONTopSongs.getString("url"),
                        imageArray.getJSONObject(3).getString("#text")));
            }

            mDb = dbHelper.getWritableDatabase();
            dbHelper.readTop50SongsToDb(mDb, topSongsInfoList);
            mDb.close();

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
    public void JSONParseSimilarArtist(String JSONString) throws JSONException, IOException {
        Log.i(TAG, "JSONParse: Parsing JSON data to object.");
        try{
            JSONArray artistArray = new JSONObject(JSONString).getJSONArray("artist");

            for (int i = 0 ;i < artistArray.length(); i++) {
                similarArtistInfoList.add(new SimilarArtistInfo(
                        artistArray.getJSONObject(i).getString("name"),
                        String.valueOf(i + 1),
                        artistArray.getJSONObject(i).getJSONArray("image").getJSONObject(3).getString("#text")));
            }
        } catch(JSONException exception) {
            Log.e(TAG, "JSONParse: JSONException Error: ", exception);
        }
    }

}
