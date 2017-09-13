package com.k.android;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.PowerManager;

/**
 * Created by RAHUL CHAUHAN on 14-06-2015.
 */
public class GFX extends Activity {
    Rahulview myview;
    PowerManager.WakeLock wl;

    @Override
    protected void onPause() {
        super.onPause();
        wl.release();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //wake-lock

        PowerManager pm = (PowerManager)getSystemService(Context.POWER_SERVICE);
        wl = pm.newWakeLock(PowerManager.FULL_WAKE_LOCK, "whatever");
        super.onCreate(savedInstanceState);
        wl.acquire();
        myview = new Rahulview(this);
        setContentView(myview);

    }
}
