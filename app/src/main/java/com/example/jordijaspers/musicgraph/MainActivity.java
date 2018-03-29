package com.example.jordijaspers.musicgraph;

import android.content.Context;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jordijaspers.musicgraph.Utilities.JSONInputTest;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.net.URL;

/**
 * The MainActivity of the app musicBrains.
 */
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static final int AMOUNT = 100;
    private String searchResults;

    //Declare all Objects for later use
    private Button bArtist;
    private Button bAlbum;
    private Button bSong;
    private EditText searchInput;
    private TextView errorMessage;
    private ProgressBar loadingIndicator;

    private Adapter mAdapter;
    private RecyclerView mResults;
    private Cursor mCursor;

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

        bArtist = (Button) findViewById(R.id.button_artist);
        bArtist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createSearchQuery("Artist");
            }
        });
        bAlbum =(Button) findViewById(R.id.button_album);
        bAlbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createSearchQuery("Album");
            }
        });
        bSong = (Button) findViewById(R.id.button_song);
        bSong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createSearchQuery("Song");
            }
        });

        searchInput = (EditText) findViewById(R.id.tv_search_input);
        errorMessage = (TextView) findViewById(R.id.tv_error_message);
        loadingIndicator = (ProgressBar) findViewById(R.id.pb_loading_indicator);

        mCursor = getJSONCursor(searchResults);
        mAdapter = new Adapter(AMOUNT, this, mCursor);

        Log.i(TAG, "onCreate: Setting the Layout & linking the Adapter for the recycleView.");
        mResults = (RecyclerView) findViewById(R.id.rv_artist_results);
        mResults.setLayoutManager(new LinearLayoutManager(this));
        mResults.setAdapter(mAdapter);
    }

    /**
     * Parse the input of JSONobject to a readable string.
     *
     * @param JSONString JSONString
     * @throws JSONException Throws exception when null.
     */
    public void JSONParse(String JSONString) throws JSONException {


    }

    private Cursor getJSONCursor(String response){
        try{
            JSONArray array = new JSONArray(response);
            return new com.s16.data.JSONArrayCursor(array);
        } catch(JSONException exception)
        {
            String ex = exception.getMessage();
        }
        return null;
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
     * Shows the all the JSON data when prompted.
     */
    public void showJSONDataView(){
        errorMessage.setVisibility(View.INVISIBLE);
        mResults.setVisibility(View.VISIBLE);
    }

    /**
     * Shows the error message when prompted.
     */
    public void showErrorMessage(){
        errorMessage.setVisibility(View.VISIBLE);
        mResults.setVisibility(View.INVISIBLE);
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
        URL SearchURL = com.example.jordijaspers.musicgraph.NetworkUtils.buildUrl(input, subjectSearch);
        searchResults = null;
        new QueryTasks().execute(SearchURL);
    }

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
                searchResults = com.example.jordijaspers.musicgraph.NetworkUtils.getResponseFromHttpUrl(createdURL);
            } catch (IOException e){
                e.printStackTrace();
            }
            return searchResults;
        }

        @Override
        protected void onPostExecute(String searchResults) {
            Log.i(TAG, "onPostExecute: Checking Search information");
            loadingIndicator.setVisibility(View.INVISIBLE);
            if (searchResults == null && !searchResults.equals("")){
                showJSONDataView();
            }else {
                Log.i(TAG, "onPostExecute: Not Found");
                showErrorMessage();
            }
        }
    }
}
