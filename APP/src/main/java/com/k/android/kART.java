package com.k.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class kART extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent i = new Intent(getApplicationContext(),CartActivity.class);
        startActivity(i);
    }
}