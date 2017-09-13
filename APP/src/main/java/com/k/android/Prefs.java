package com.k.android;

import android.os.Bundle;
import android.preference.PreferenceActivity;

/**
 * Created by RAHUL CHAUHAN on 12-06-2015.
 */
public class Prefs extends PreferenceActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.prefs);
    }
}
