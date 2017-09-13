package com.k.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.actionbarsherlock.app.SherlockActivity;

/**
 * Created by RAHUL CHAUHAN on 22-07-2015.
 */
public class Intermediate extends SherlockActivity implements View.OnClickListener {
    Button bt,bt1,bt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intermediate);
        bt = (Button) findViewById(R.id.benter);
        bt1 = (Button) findViewById(R.id.babout);
        bt2 = (Button) findViewById(R.id.abtus);
        bt.setOnClickListener(this);
        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.benter:
                Intent n = new Intent("com.k.android.MENU");
                startActivity(n);
                break;
            case R.id.babout:
                Intent p = new Intent("com.k.android.MAINACTIVITY");
                startActivity(p);
                break;
            case R.id.abtus:
                Intent m = new Intent("com.k.android.ABOUTUS");
                startActivity(m);
                break;


        }
    }
}
