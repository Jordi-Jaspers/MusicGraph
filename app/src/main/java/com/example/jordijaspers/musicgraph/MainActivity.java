package com.example.jordijaspers.musicgraph;


import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
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
 * TODO:
 * Lifecycle hooks (onPause, onResume, …)
 * Preferences (zie ook config Activity)
 * Menu (settings, …)
 * ContentProvider
 *
 * Questions:
 * Multiple adapter for every search engine?
 * How to download pictures on an asynctask?
 * Use of Bitmap of images? errors?
 *
 */

/**
 * The MainActivity of the app musicBrains.
 */
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    //Declare all Objects for later use
    private Button bArtist;
    private Button bAlbum;
    private Button bSong;
    private EditText searchInput;
    private TextView errorMessage;
    private ProgressBar loadingIndicator;

    private String buttonClicked;

    /**
     * Creates all the object and reference them to their according ID.
     *
     * @param savedInstanceState savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(TAG, "onCreate: Creating Objects And Finding ID.");

        buttonClicked = null;

        bArtist = (Button) findViewById(R.id.button_artist);
        bArtist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClicked = "Artist";
                createSearchQuery(buttonClicked);
            }
        });

        bAlbum =(Button) findViewById(R.id.button_album);
        bAlbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClicked = "Album";
                createSearchQuery(buttonClicked);
            }
        });

        bSong = (Button) findViewById(R.id.button_song);
        bSong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClicked = "Song";
                createSearchQuery(buttonClicked);
            }
        });

        searchInput = (EditText) findViewById(R.id.tv_search_input);
        errorMessage = (TextView) findViewById(R.id.tv_error_message);
        loadingIndicator = (ProgressBar) findViewById(R.id.pb_loading_indicator);

    }

    /**
     * Creates option menu by adding buttons in the list_items.xml
     *
     * @param menu menu of the application
     * @return true: inflate the menu
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_items, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    /**
     * Queries the BuildURl to get the specific API-URL for the JSON Data.
     */
    public void createSearchQuery(String subjectSearch) {
        Log.i(TAG, "createSearchQuery: Searching...");

        Context context = getApplicationContext();
        String message = "Searching...";
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();

        String input = searchInput.getText().toString();
        URL SearchURL = NetworkUtils.buildUrl(input, subjectSearch);
        String SearchResults = null;
        new QueryTasks().execute(SearchURL);
    }

    //------------------------------------------
    //SubClass starting.

    public class QueryTasks extends AsyncTask<URL, Void, String> {

        @Override
        protected void onPreExecute(){
            super.onPreExecute();
            loadingIndicator.setVisibility(View.VISIBLE);
        }

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
                Intent intent = new Intent(MainActivity.this, ResultsActivity.class);
                intent.putExtra("JSONresults", searchResults);
                intent.putExtra("SearchMethod", buttonClicked);
                Log.d(TAG, "onPostExecute() returned: " + searchResults);
                startActivity(intent);
            }
        }
    }
}
