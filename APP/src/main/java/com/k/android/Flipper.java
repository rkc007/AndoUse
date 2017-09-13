package com.k.android;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;

public class Flipper extends Activity {

    ViewFlipper viewFlipper;
    Button Next, Previous;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flipper);

        viewFlipper = (ViewFlipper) findViewById(R.id.ViewFlipper01);

        Next = (Button) findViewById(R.id.Next);
        Previous = (Button) findViewById(R.id.Previous);

        Next.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                viewFlipper.showNext();
            }
        });

        Previous.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                viewFlipper.showPrevious();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}