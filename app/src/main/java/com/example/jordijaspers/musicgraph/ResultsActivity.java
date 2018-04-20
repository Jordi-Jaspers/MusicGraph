package com.example.jordijaspers.musicgraph;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.jordijaspers.musicgraph.Database.ArtistInfo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ResultsActivity extends AppCompatActivity {

    private static final String TAG = "ResultsActivity";
    private static final int AMOUNT = 30;

    private RecyclerView recyclerView;
    private List<ArtistInfo> artistInfoList;

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

        Log.i(TAG, "OnCreate: Setting the Layout & linking the Adapter for the recycleView.");
        recyclerView = (RecyclerView) findViewById(R.id.rv_results);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Intent intent = getIntent();
        String JSONString = intent.getStringExtra("JSONresults");
        try {
            JSONParse(JSONString);
        } catch (JSONException exception) {
            Log.e(TAG, "JSONParse: Exception Error: ", exception);
        }
        ArtistAdapter mAdapter = new ArtistAdapter(this, artistInfoList);
        recyclerView.setAdapter(mAdapter);
    }

    /**
     * Parse the input of JSONobject to a readable string.
     *
     * @param JSONString JSONString
     * @throws JSONException Throws exception when null.
     */
    public void JSONParse(String JSONString) throws JSONException {
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
}
