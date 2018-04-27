package com.example.jordijaspers.musicgraph.Utilities;

import android.os.Bundle;
import android.support.v7.preference.PreferenceFragmentCompat;

import com.example.jordijaspers.musicgraph.R;

public class SettingsFragment extends PreferenceFragmentCompat {

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.pref_headers);
    }
}
