package com.k.android;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;

/**
 * Created by RAHUL CHAUHAN on 25-05-2015.
 */
public class Splash extends Activity{

    MediaPlayer song;

    @Override
    protected void onPause() {
        super.onPause();
        song.release();
        finish();
    }

    @Override
    protected void onCreate(Bundle boy) {
        super.onCreate(boy);

        setContentView(R.layout.spalsh);
        song = MediaPlayer.create(Splash.this,R.raw.spls);
        SharedPreferences getprefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
       Boolean music = getprefs.getBoolean("checkbox", true);

        if(music == true){
        song.start();}

        Thread timer = new Thread(){
            public void run(){
                try{
                    sleep(3000);

                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    Intent openit = new Intent("com.k.android.INTERMEDIATE");
                    startActivity(openit);
                }
            }

        }; timer.start();
    }
}
