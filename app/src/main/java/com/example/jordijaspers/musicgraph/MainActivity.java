package com.example.jordijaspers.musicgraph;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.jordijaspers.musicgraph.Utilities.NetworkUtils;

import java.io.IOException;
import java.net.URL;

public class MainActivity extends AppCompatActivity  {

    private static final String TAG = "MainActivity";

    //Declare all Objects for later use
    private Button bTopArtist;
    private Button bSearch;
    private Button bTopSong;

    private String buttonClicked;
    private Boolean CONNECTED;
    private Context mContext;

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
        mContext = getApplicationContext();

        bSearch = (Button) findViewById(R.id.button_search);
        bSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isNetworkAvailable()){
                    Intent intentArtist = new Intent(MainActivity.this, SearchActivity.class);
                    startActivity(intentArtist);
                }
                else{
                    Toast.makeText(mContext, "No Internet Connection: Search function Not Available", Toast.LENGTH_SHORT).show();
                }
            }
        });

        bTopArtist = (Button) findViewById(R.id.button_top_artist);
        bTopArtist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClicked = "TopArtists";
                if (!isNetworkAvailable()){
                    CONNECTED = false;
                    Intent intent = new Intent(MainActivity.this, ResultsActivity.class);
                    intent.putExtra("Connected", CONNECTED);
                    intent.putExtra("SearchMethod", buttonClicked);
                    startActivity(intent);
                }else {
                    CONNECTED = true;
                    Toast.makeText(mContext, "Getting Top Artists...", Toast.LENGTH_SHORT).show();
                    URL SearchURL = NetworkUtils.getTop(buttonClicked);
                    new QueryTasks().execute(SearchURL);
                }
            }
        });

        bTopSong = (Button) findViewById(R.id.button_top_song);
        bTopSong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClicked = "TopSongs";
                if (!isNetworkAvailable()){
                    CONNECTED = false;
                    Intent intent = new Intent(MainActivity.this, ResultsActivity.class);
                    intent.putExtra("Connected", CONNECTED);
                    intent.putExtra("SearchMethod", buttonClicked);
                    startActivity(intent);
                }
                else {
                    CONNECTED = true;
                    Toast.makeText(mContext, "Getting Top Songs...", Toast.LENGTH_SHORT).show();
                    URL SearchURL = NetworkUtils.getTop(buttonClicked);
                    new QueryTasks().execute(SearchURL);
                }
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }

    public boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        assert connectivityManager != null;
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    /**
     * Creates option menu by adding buttons in the list_items.xml
     *
     * @param menu menu of the application
     * @return true: inflate the menu
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_items, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.action_settings){
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //------------------------------------------
    //SubClass starting.

    public class QueryTasks extends AsyncTask<URL, Void, String> {

        @Override
        protected void onPreExecute(){
            super.onPreExecute();
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
            Intent intent = new Intent(MainActivity.this, ResultsActivity.class);
            intent.putExtra("JSONresults", searchResults);
            intent.putExtra("SearchMethod", buttonClicked);
            intent.putExtra("Connected", CONNECTED);
            Log.d(TAG, "onPostExecute() returned: " + searchResults);
            startActivity(intent);
        }
    }
}
