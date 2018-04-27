package com.example.jordijaspers.musicgraph;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jordijaspers.musicgraph.Utilities.NetworkUtils;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;

import de.hdodenhof.circleimageview.CircleImageView;

public class DetailActivity extends AppCompatActivity {

    private static final String TAG = "DetailActivity";

    //Declare all Objects for later use
    private Button bSimilar;
    private Button bWebsite;
    private CircleImageView artistPicture;
    private TextView tv_Title;
    private TextView tv_Bio;

    private ImageView imageAlbum1;
    private TextView tvAlbumname1;
    private TextView tvAlbumPlaycount1;

    private ImageView imageAlbum2;
    private TextView tvAlbumname2;
    private TextView tvAlbumPlaycount2;

    private ImageView imageAlbum3;
    private TextView tvAlbumname3;
    private TextView tvAlbumPlaycount3;


    private String artistName;
    private Boolean CONNECTED;
    private Context mContext;
    private Intent mIntent;

    private JSONObject similarArtists;
    private String websiteURL;

    /**
     * Creates all the object and reference them to their according ID.
     *
     * @param savedInstanceState savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Log.i(TAG, "onCreate: Creating Objects And Finding ID.");
        mContext = getApplicationContext();
        mIntent = getIntent();
        artistName = mIntent.getStringExtra("ArtistName");

        bWebsite = (Button) findViewById(R.id.button_website);
        bSimilar = (Button) findViewById(R.id.button_similar);
        artistPicture = (CircleImageView) findViewById(R.id.image_artist);
        tv_Bio = (TextView) findViewById(R.id.tv_biography);
        tv_Title = (TextView) findViewById(R.id.tv_artistname);

        imageAlbum1 = (ImageView) findViewById(R.id.imageView_album1);
        imageAlbum2 = (ImageView) findViewById(R.id.imageView_album2);
        imageAlbum3 = (ImageView) findViewById(R.id.imageView_album3);

        tvAlbumname1 = (TextView) findViewById(R.id.tv_albumname1);
        tvAlbumname2 = (TextView) findViewById(R.id.tv_albumname2);
        tvAlbumname3 = (TextView) findViewById(R.id.tv_albumname3);

        tvAlbumPlaycount1 = (TextView) findViewById(R.id.tv_playcount1);
        tvAlbumPlaycount2 = (TextView) findViewById(R.id.tv_playcount2);
        tvAlbumPlaycount3 = (TextView) findViewById(R.id.tv_playcount3);

        createSearchQuery();

        bSimilar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (isNetworkAvailable()){
                    CONNECTED = true;

                }
                else{
                    CONNECTED = false;
                    Toast.makeText(mContext, "No Internet Connection: Search function Not Available", Toast.LENGTH_SHORT).show();
                }
            }
        });

        bWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isNetworkAvailable()){
                    CONNECTED = true;
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(websiteURL));
                    startActivity(browserIntent);
                }
                else{
                    CONNECTED = false;
                    Toast.makeText(mContext, "No Internet Connection: Search function Not Available", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        assert connectivityManager != null;
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    /**
     * Queries the BuildURl to get the specific API-URL for the JSON Data.
     */
    public void createSearchQuery() {
        Log.i(TAG, "createSearchQuery: Getting Info");

        Toast.makeText(mContext, "Getting Info", Toast.LENGTH_SHORT).show();

        URL[] searchURLs = new URL[2];
        searchURLs[0] = NetworkUtils.getArtistInfoURL(artistName);
        searchURLs[1] = NetworkUtils.getAlbumInfoURL(artistName);
        new QueryTasks().execute(searchURLs);
    }

    //------------------------------------------
    //SubClass starting.

    public class QueryTasks extends AsyncTask<URL, Void, String[]> {

        @Override
        protected void onPreExecute(){
            super.onPreExecute();
        }

        /**
         *
         * @param urls
         * @return
         */
        @Override
        protected String[] doInBackground(URL[] urls) {
            URL createdURLInfo = urls[0];
            URL createdURLAlbum = urls[1];

            String[] searchResults = new String[2];
            try{
                searchResults[0] = NetworkUtils.getResponseFromHttpUrl(createdURLInfo);
                searchResults[1] = NetworkUtils.getResponseFromHttpUrl(createdURLAlbum);
            } catch (IOException e){
                Log.e(TAG, "IOException error: Getting Info");
            }
            return searchResults;
        }

        /**
         *
         * @param searchResults
         */
        @Override
        protected void onPostExecute(String[] searchResults) {
            parseInfo(searchResults[0]);
            parseAlbum(searchResults[1]);
        }

        private void parseInfo(String searchresult){
            Log.i(TAG, "onPostExecute: Parsing JSON data to object.");
            try{
                JSONObject tempObject = new JSONObject(searchresult).getJSONObject("artist");
                JSONArray array = tempObject.getJSONArray("image");

                tv_Title.setText(tempObject.getString("name"));
                tv_Bio.setText("published on: " + tempObject.getJSONObject("bio").getString("published" )+ "\n" + "\n" +
                        tempObject.getJSONObject("bio").getString("summary"));

                websiteURL = tempObject.getString("url");
                similarArtists = tempObject.getJSONObject("similar");

                String picURL = null;
                picURL = array.getJSONObject(3).getString("#text");
                if(picURL != null || picURL != "")
                    Picasso.with(mContext).load(picURL).into(artistPicture);

            } catch(JSONException exception) {
                Log.e(TAG, "JSONParse: JSONException Error: ", exception);
            }
        }

        private void parseAlbum(String searchresult) {
            Log.i(TAG, "onPostExecute: Parsing JSON data to object.");
            try{
                JSONObject tempObject = new JSONObject(searchresult).getJSONObject("topalbums");
                JSONArray array = tempObject.getJSONArray("album");

                tvAlbumname1.setText(array.getJSONObject(1).getString("name"));
                tvAlbumname2.setText(array.getJSONObject(2).getString("name"));
                tvAlbumname3.setText(array.getJSONObject(3).getString("name"));

                tvAlbumPlaycount1.setText("Playcount: " + array.getJSONObject(1).getString("playcount"));
                tvAlbumPlaycount2.setText("Playcount: " + array.getJSONObject(2).getString("playcount"));
                tvAlbumPlaycount3.setText("Playcount: " + array.getJSONObject(3).getString("playcount"));

                String imageAlbumURL1 = array.getJSONObject(1).getJSONArray("image").getJSONObject(2).getString("#text");
                String imageAlbumURL2 = array.getJSONObject(2).getJSONArray("image").getJSONObject(2).getString("#text");
                String imageAlbumURL3 = array.getJSONObject(3).getJSONArray("image").getJSONObject(2).getString("#text");

                if (imageAlbumURL1 != null || imageAlbumURL1 != ""){
                        Picasso.with(mContext).load(imageAlbumURL1).into(imageAlbum1);
                }
                if (imageAlbumURL2 != null || imageAlbumURL2 != ""){
                    Picasso.with(mContext).load(imageAlbumURL2).into(imageAlbum2);
                }
                if (imageAlbumURL3 != null || imageAlbumURL3 != ""){
                    Picasso.with(mContext).load(imageAlbumURL3).into(imageAlbum3);
                }

            } catch(JSONException exception) {
                    Log.e(TAG, "JSONParse: JSONException Error: ", exception);
                }
        }
    }
}
