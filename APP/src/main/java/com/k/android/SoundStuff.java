package com.k.android;

import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;

/**
 * Created by RAHUL CHAUHAN on 14-06-2015.
 */
public class SoundStuff extends Activity implements View.OnClickListener, View.OnLongClickListener {
    SoundPool sp;
    int explosion=0;
    MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View vi = new View(this);
        vi.setOnClickListener(this);
        vi.setOnLongClickListener(this);
        setContentView(vi);
        sp = new SoundPool(5, AudioManager.STREAM_MUSIC,0);
        explosion = sp.load(this,R.raw.explo,1);
       mp = MediaPlayer.create(this,R.raw.background);

    }

    @Override
    public void onClick(View v) {
        if (explosion!=0){
        sp.play(explosion,1,1,0,0,1);
    }}

    @Override
    public boolean onLongClick(View v) {
        mp.start();
        return false;
    }
}
