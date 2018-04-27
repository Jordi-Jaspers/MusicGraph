package com.example.jordijaspers.musicgraph.Utilities;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.jordijaspers.musicgraph.Database.TopArtistsInfo;
import com.example.jordijaspers.musicgraph.Database.TopSongsInfo;

import java.util.List;

public class DataDbHelper extends SQLiteOpenHelper {

    public static final String TAG = "DataDbHelper";
    public static final String DATABASE_NAME = "top50.db";
    public static final int DATABASE_VERSION = 1;

    final String SQL_CREATE_SONG_LIST = "CREATE TABLE " +
            DataContract.DataEntryTopSongs.TABLE_TOP50SONGS + "(" +
            DataContract.DataEntryTopSongs._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            DataContract.DataEntryTopSongs.COLUMN_SONG_NAME + " TEXT NOT NULL, " +
            DataContract.DataEntryTopSongs.COLUMN_ARTIST_NAME + " TEXT NOT NULL, " +
            DataContract.DataEntryTopSongs.COLUMN_PLAYCOUNT + " TEXT NOT NULL, " +
            DataContract.DataEntryTopSongs.COLUMN_LISTENERS + " TEXT NOT NULL, " +
            DataContract.DataEntryTopSongs.COLUMN_RANKING + " INTEGER NOT NULL, " +
            DataContract.DataEntryTopSongs.COLUMN_IMAGE_URL + " TEXT NOT NULL, " +
            DataContract.DataEntryTopSongs.COLUMN_WEBSITE + " TEXT NOT NULL); ";

    private static final String SQL_DELETE_SONG_LIST =
            "DROP TABLE IF EXISTS " + DataContract.DataEntryTopSongs.TABLE_TOP50SONGS;

    final String SQL_CREATE_ARTIST_LIST = "CREATE TABLE " +
            DataContract.DataEntryTopArtist.TABLE_TOP50ARTISTS + "(" +
            DataContract.DataEntryTopArtist._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            DataContract.DataEntryTopArtist.COLUMN_ARTIST_NAME + " TEXT NOT NULL, " +
            DataContract.DataEntryTopArtist.COLUMN_PLAYCOUNT + " TEXT NOT NULL, " +
            DataContract.DataEntryTopArtist.COLUMN_LISTENERS + " TEXT NOT NULL, " +
            DataContract.DataEntryTopArtist.COLUMN_RANKING + " INTEGER NOT NULL, " +
            DataContract.DataEntryTopArtist.COLUMN_IMAGE_URL + " TEXT NOT NULL, " +
            DataContract.DataEntryTopArtist.COLUMN_WEBSITE + " TEXT NOT NULL); ";

    private static final String SQL_DELETE_ARTIST_LIST =
            "DROP TABLE IF EXISTS " + DataContract.DataEntryTopArtist.TABLE_TOP50ARTISTS;

    public DataDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_SONG_LIST);
        db.execSQL(SQL_CREATE_ARTIST_LIST);
    }

    @Override
    public SQLiteDatabase getWritableDatabase() {
        return super.getWritableDatabase();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_SONG_LIST);
        db.execSQL(SQL_DELETE_ARTIST_LIST);
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    public void readTop50SongsToDb(SQLiteDatabase db, List<TopSongsInfo> topSongsInfoList) {
        for (int i = 0; i < topSongsInfoList.size(); ++i) {
            TopSongsInfo topSongsInfo = topSongsInfoList.get(i);
            ContentValues contentValues = new ContentValues();

            contentValues.put(DataContract.DataEntryTopSongs.COLUMN_SONG_NAME, topSongsInfo.getSongName());
            contentValues.put(DataContract.DataEntryTopSongs.COLUMN_ARTIST_NAME, topSongsInfo.getArtistName());
            contentValues.put(DataContract.DataEntryTopSongs.COLUMN_PLAYCOUNT, topSongsInfo.getPlayCount());
            contentValues.put(DataContract.DataEntryTopSongs.COLUMN_LISTENERS, topSongsInfo.getListeners());
            contentValues.put(DataContract.DataEntryTopSongs.COLUMN_RANKING, topSongsInfo.getRank());
            contentValues.put(DataContract.DataEntryTopSongs.COLUMN_IMAGE_URL, topSongsInfo.getImageURL());
            contentValues.put(DataContract.DataEntryTopSongs.COLUMN_WEBSITE, topSongsInfo.getWebsite());

            db.insert(DataContract.DataEntryTopSongs.TABLE_TOP50SONGS, null, contentValues);

            Log.d(TAG, "Inserted Successfully " + contentValues );
        }
    }

    public List<TopSongsInfo> getTop50SongsFromDb(SQLiteDatabase db, List<TopSongsInfo> topSongsInfoList){

        Cursor cursor = db.query(
                        DataContract.DataEntryTopSongs.TABLE_TOP50SONGS,
                        DataContract.DataEntryTopSongs.COLUMN_NAMES,
                        null,
                        null,
                        null,
                        null,
                        DataContract.DataEntryTopSongs.COLUMN_RANKING,
                        null);

        if(cursor.getCount() > 0) {
            if (cursor != null) {
                cursor.moveToFirst();

                do {
                    topSongsInfoList.add(new TopSongsInfo(
                            cursor.getString(cursor.getColumnIndex(DataContract.DataEntryTopSongs.COLUMN_SONG_NAME)),
                            cursor.getString(cursor.getColumnIndex(DataContract.DataEntryTopSongs.COLUMN_ARTIST_NAME)),
                            cursor.getString(cursor.getColumnIndex(DataContract.DataEntryTopSongs.COLUMN_LISTENERS)),
                            cursor.getString(cursor.getColumnIndex(DataContract.DataEntryTopSongs.COLUMN_PLAYCOUNT)),
                            cursor.getInt(cursor.getColumnIndex(DataContract.DataEntryTopSongs.COLUMN_RANKING)),
                            cursor.getString(cursor.getColumnIndex(DataContract.DataEntryTopSongs.COLUMN_WEBSITE)),
                            cursor.getString(cursor.getColumnIndex(DataContract.DataEntryTopSongs.COLUMN_IMAGE_URL))));
                } while (cursor.moveToNext());
            }
        }
        return topSongsInfoList;
    }

    public void readTop50ArtistsToDb(SQLiteDatabase db, List<TopArtistsInfo> topArtistInfoList) {
        for (int i = 0; i < topArtistInfoList.size(); ++i) {
            TopArtistsInfo topArtistsInfo = topArtistInfoList.get(i);
            ContentValues contentValues = new ContentValues();

            contentValues.put(DataContract.DataEntryTopArtist.COLUMN_ARTIST_NAME, topArtistsInfo.getArtistName());
            contentValues.put(DataContract.DataEntryTopArtist.COLUMN_PLAYCOUNT, topArtistsInfo.getPlayCount());
            contentValues.put(DataContract.DataEntryTopArtist.COLUMN_LISTENERS, topArtistsInfo.getListeners());
            contentValues.put(DataContract.DataEntryTopArtist.COLUMN_RANKING, topArtistsInfo.getRank());
            contentValues.put(DataContract.DataEntryTopArtist.COLUMN_IMAGE_URL, topArtistsInfo.getImageURL());
            contentValues.put(DataContract.DataEntryTopArtist.COLUMN_WEBSITE, topArtistsInfo.getWebsite());

            db.insert(DataContract.DataEntryTopArtist.TABLE_TOP50ARTISTS, null, contentValues);

            Log.d(TAG, "Inserted Successfully " + contentValues );
        }
    }

    public List<TopArtistsInfo> getTop50ArtistsFromDb(SQLiteDatabase db, List<TopArtistsInfo> topArtistsInfoList){

        Cursor cursor = db.query(
                DataContract.DataEntryTopArtist.TABLE_TOP50ARTISTS,
                DataContract.DataEntryTopArtist.COLUMN_NAMES,
                null,
                null,
                null,
                null,
                DataContract.DataEntryTopArtist.COLUMN_RANKING,
                null);

        if(cursor.getCount() > 0) {
            if (cursor != null) {
                cursor.moveToFirst();

                do {
                    topArtistsInfoList.add(new TopArtistsInfo(
                            cursor.getString(cursor.getColumnIndex(DataContract.DataEntryTopArtist.COLUMN_ARTIST_NAME)),
                            cursor.getString(cursor.getColumnIndex(DataContract.DataEntryTopArtist.COLUMN_LISTENERS)),
                            cursor.getString(cursor.getColumnIndex(DataContract.DataEntryTopArtist.COLUMN_PLAYCOUNT)),
                            cursor.getInt(cursor.getColumnIndex(DataContract.DataEntryTopArtist.COLUMN_RANKING)),
                            cursor.getString(cursor.getColumnIndex(DataContract.DataEntryTopArtist.COLUMN_WEBSITE)),
                            cursor.getString(cursor.getColumnIndex(DataContract.DataEntryTopArtist.COLUMN_IMAGE_URL))));
                } while (cursor.moveToNext());
            }
        }
        return topArtistsInfoList;
    }
}
