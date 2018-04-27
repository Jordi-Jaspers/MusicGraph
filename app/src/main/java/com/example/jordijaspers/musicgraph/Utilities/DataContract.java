package com.example.jordijaspers.musicgraph.Utilities;

import android.provider.BaseColumns;

public class DataContract {

    public static final class DataEntryTopSongs implements BaseColumns{
        public static final String TABLE_TOP50SONGS = "TopSongs";
        public static final String COLUMN_SONG_NAME = "SongName";
        public static final String COLUMN_ARTIST_NAME = "ArtistName";
        public static final String COLUMN_PLAYCOUNT = "PlayCount";
        public static final String COLUMN_LISTENERS = "Listeners";
        public static final String COLUMN_RANKING = "Ranking";
        public static final String COLUMN_IMAGE_URL = "ImageURL";
        public static final String COLUMN_WEBSITE = "Website";


        public static final String[] COLUMN_NAMES = new String[]{
                DataEntryTopSongs.COLUMN_SONG_NAME,
                DataEntryTopSongs.COLUMN_ARTIST_NAME,
                DataEntryTopSongs.COLUMN_PLAYCOUNT,
                DataEntryTopSongs.COLUMN_LISTENERS,
                DataEntryTopSongs.COLUMN_RANKING,
                DataEntryTopSongs.COLUMN_IMAGE_URL,
                DataEntryTopSongs.COLUMN_WEBSITE
        };
    }

    public static final class DataEntryTopArtist implements BaseColumns{
        public static final String TABLE_TOP50ARTISTS = "TopArtists";
        public static final String COLUMN_ARTIST_NAME = "ArtistName";
        public static final String COLUMN_PLAYCOUNT = "PlayCount";
        public static final String COLUMN_LISTENERS = "Listeners";
        public static final String COLUMN_RANKING = "Ranking";
        public static final String COLUMN_IMAGE_URL = "ImageURL";
        public static final String COLUMN_WEBSITE = "Website";


        public static final String[] COLUMN_NAMES = new String[]{
                DataEntryTopArtist.COLUMN_ARTIST_NAME,
                DataEntryTopArtist.COLUMN_PLAYCOUNT,
                DataEntryTopArtist.COLUMN_LISTENERS,
                DataEntryTopArtist.COLUMN_RANKING,
                DataEntryTopArtist.COLUMN_IMAGE_URL,
                DataEntryTopArtist.COLUMN_WEBSITE
        };
    }
}
