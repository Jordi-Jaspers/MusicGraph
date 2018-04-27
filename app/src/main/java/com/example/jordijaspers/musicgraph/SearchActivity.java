package com.example.jordijaspers.musicgraph;


import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jordijaspers.musicgraph.Utilities.NetworkUtils;

import java.io.IOException;
import java.net.URL;

/**
 * The SearchActivity of the app musicBrains.
 */
public class SearchActivity extends AppCompatActivity {

    private static final String TAG = "SearchActivity";

    //Declare all Objects for later use
    private Button bArtist;
    private Button bAlbum;
    private Button bSong;

    private EditText searchInput;
    private TextView errorMessage;
    private ProgressBar loadingIndicator;
    private Context mContext;

    private String buttonClicked;

    /**
     * Creates all the object and reference them to their according ID.
     *
     * @param savedInstanceState savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        Log.i(TAG, "onCreate: Creating Objects And Finding ID.");
        mContext = getApplicationContext();

        buttonClicked = null;

        bArtist = (Button) findViewById(R.id.button_artist);
        bArtist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClicked = "Artist";
                if (MainisNetworkAvailable()){
                    createSearchQuery(buttonClicked);
                }
                else{
                    Toast.makeText(mContext, "No Internet Connection: Search function Not Available", Toast.LENGTH_SHORT).show();
                }
            }
        });

        bAlbum =(Button) findViewById(R.id.button_album);
        bAlbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClicked = "Album";
                if (MainisNetworkAvailable()){
                    createSearchQuery(buttonClicked);
                }
                else{
                    Toast.makeText(mContext, "No Internet Connection: Search function Not Available", Toast.LENGTH_SHORT).show();
                }
            }
        });

        bSong = (Button) findViewById(R.id.button_song);
        bSong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClicked = "Song";
                if (MainisNetworkAvailable()){
                    createSearchQuery(buttonClicked);
                }
                else{
                    Toast.makeText(mContext, "No Internet Connection: Search function Not Available", Toast.LENGTH_SHORT).show();
                }
            }
        });

        searchInput = (EditText) findViewById(R.id.tv_search_input);
        errorMessage = (TextView) findViewById(R.id.tv_error_message);
        loadingIndicator = (ProgressBar) findViewById(R.id.pb_loading_indicator);

    }

    /**
     *
     * @return
     */
    private boolean MainisNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        assert connectivityManager != null;
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    /**
     *
     */
    @Override
    protected void onPause() {
        super.onPause();
    }

    /**
     *
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }

    /**
     * Queries the BuildURl to get the specific API-URL for the JSON Data.
     */
    public void createSearchQuery(String subjectSearch) {
        Log.i(TAG, "createSearchQuery: Searching...");

        Toast.makeText(mContext, "Searching...", Toast.LENGTH_SHORT).show();

        String input = searchInput.getText().toString();
        URL searchURL = NetworkUtils.buildUrl(input, subjectSearch);
        new QueryTasks().execute(searchURL);
    }

    //------------------------------------------
    //SubClass starting.

    public class QueryTasks extends AsyncTask<URL, Void, String> {

        /**
         *
         */
        @Override
        protected void onPreExecute(){
            super.onPreExecute();
            loadingIndicator.setVisibility(View.VISIBLE);
        }

        /**
         *
         * @param urls
         * @return
         */
        @Override
        protected String doInBackground(URL[] urls) {
            URL createdURL = urls[0];
            String searchResults = null;
            try{
                searchResults = NetworkUtils.getResponseFromHttpUrl(createdURL);
            } catch (IOException e){
                e.printStackTrace();
            }
            return searchResults;
        }

        /**
         *
         * @param searchResults
         */
        @Override
        protected void onPostExecute(String searchResults) {
            Log.i(TAG, "onPostExecute: Checking Search information");
            loadingIndicator.setVisibility(View.INVISIBLE);
            if (searchResults == null || searchResults.equals("")) {
                Log.i(TAG, "onPostExecute: Not Found");
                errorMessage.setVisibility(View.VISIBLE);
            }
            else if(searchInput.equals("") || searchInput == null || searchInput.equals("What are you searching?")){
                Log.i(TAG, "onPostExecute: blank search engine");
                errorMessage.setVisibility(View.VISIBLE);
            }else {
                errorMessage.setVisibility(View.INVISIBLE);
                Intent intent = new Intent(SearchActivity.this, ResultsActivity.class);
                intent.putExtra("JSONresults", searchResults);
                intent.putExtra("SearchMethod", buttonClicked);
                Log.d(TAG, "onPostExecute() returned: " + searchResults);
                startActivity(intent);
            }
        }
    }
}
