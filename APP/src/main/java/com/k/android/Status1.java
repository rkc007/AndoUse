package com.k.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by RAHUL CHAUHAN on 22-07-2015.
 */
public class Status1 extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent i = new Intent("com.k.android.MENU");
        startActivity(i);
        Toast.makeText(getApplicationContext(),"DIRECTED TO APP",Toast.LENGTH_LONG).show();

    }
}
