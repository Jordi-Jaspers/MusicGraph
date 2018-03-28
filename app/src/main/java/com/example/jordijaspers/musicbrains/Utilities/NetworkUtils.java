package com.example.jordijaspers.musicbrains;

import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * These utilities will be used to communicate with the network.
 */
public class NetworkUtils {

    private static final String TAG = "NetworkUtils";

    public final static String MUSICBRAINS_BASE_URL = "http://ws.audioscrobbler.com/2.0/";
    public final static String MUSICBRAINS_API_KEY = "&api_key=20bbf5972ac5cdaba44806b4ef8207aa";
    public final static String FORMAT_JSON = "&format=json";
    public final static String PREFIX = "?";

    public final static String METHOD_SEARCH = ".search";
    public final static String METHOD_GETINFO = ".getInfo";
    public final static String METHOD_TOPALBUMS = ".getTopAlbums";
    public final static String METHOD_TOPTRACKS = ".getTopTracks";
    public final static String METHOD_SIMILAR = ".getSimilar";

    public final static String ARTIST = "method=artist";
    public final static String ALBUM = "method=album";
    public final static String TRACK = "method=track";


    /**
     * Builds the URL used to query musicGraph.
     *
     * @param SearchQuery The keyword that will be queried for.
     * @return The URL to use to query the weather server.
     */
    public static URL buildUrl(String SearchQuery, String subjectSearch) {
        Log.i(TAG, "buildUrl: Building URL...");
        String stringURL = null;

        switch(subjectSearch) {
            case "Album":
                Log.i(TAG, "buildUrl: Creating Album URL");
                stringURL = MUSICBRAINS_BASE_URL + PREFIX + ALBUM + METHOD_SEARCH + "&album=" + SearchQuery + MUSICBRAINS_API_KEY + FORMAT_JSON;
                break;
            case "Artist":
                Log.i(TAG, "buildUrl: Creating Artist URL");
                stringURL = MUSICBRAINS_BASE_URL + PREFIX + ARTIST + METHOD_SEARCH + "&artist=" + SearchQuery + MUSICBRAINS_API_KEY + FORMAT_JSON;
                break;
            case "Song":
                Log.i(TAG, "buildUrl: Creating Song URL");
                stringURL = MUSICBRAINS_BASE_URL + PREFIX + TRACK + METHOD_SEARCH + "&track=" + SearchQuery + MUSICBRAINS_API_KEY + FORMAT_JSON;
                break;
            default:
                break;
        }

        Log.i(TAG, "buildUrl: Created URL: " + stringURL);
        URL url = null;

        try {
            url = new URL(stringURL);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            Log.e(TAG, "buildUrl: Couldn't create URL");
        }

        Log.i(TAG, "buildUrl: Returning URL");
        return url;
    }

    /**
     * This method returns the entire result from the HTTP response.
     * More in UDACITY 2.9
     * @param url The URL to fetch the HTTP response from.
     * @return The contents of the HTTP response.
     * @throws IOException Related to network and stream reading
     */
    public static String getResponseFromHttpUrl(URL url) throws IOException {
        Log.i(TAG, "Opening Internet Connection");
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            InputStream in = urlConnection.getInputStream();
            Log.i(TAG, "Buffering URL-Data");
            Scanner scanner = new Scanner(in);
            Log.i(TAG, "Encoding Data from UTF-16 To UTF-8");
            scanner.useDelimiter("\\A");
            Log.i(TAG, "Checking Data...");
            boolean hasInput = scanner.hasNext();
            if (hasInput) {
                return scanner.next();
            } else {
                return null;
            }
        } finally {
            Log.i(TAG, "Disconnecting Internet Connection");
            urlConnection.disconnect();
        }
    }
}
