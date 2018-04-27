package com.example.jordijaspers.musicgraph;

import android.os.Bundle;
import android.preference.Preference;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class SettingsActivity extends AppCompatActivity implements Preference.OnPreferenceClickListener {

    Preference general;
    Preference sharing;
    Preference notification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_settings);
        ActionBar actionBar = this.getSupportActionBar();

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.home);{
            NavUtils.navigateUpFromSameTask(this);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onPreferenceClick(Preference preference) {
        String key = preference.getKey();

        switch (key){
            case "General":
                return true;

            case "Sharing":
                setContentView(R.layout.activity_settings);
                return true;

            case "Notifications":
                setContentView(R.layout.activity_settings);
                return true;

            default:
                return false;
        }
    }
}
