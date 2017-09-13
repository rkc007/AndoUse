package com.k.android;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.Random;

/**
 * Created by RAHUL CHAUHAN on 25-05-2015.
 */
public class Textplay extends Activity implements View.OnClickListener  {
    Button b;
    ToggleButton t;
    EditText  ett;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.texts);
        
        createmethod();
        t.setOnClickListener(this);
        b.setOnClickListener(this);}


    private void createmethod() {
        b = (Button) findViewById(R.id.res);
        t = (ToggleButton) findViewById(R.id.tb);
         ett = (EditText) findViewById(R.id.et);
         tv = (TextView) findViewById(R.id.disp);
    }


    public void onClick(View view) {
        switch (view.getId()) {


                case R.id.res:
                {
                    String check = ett.getText().toString();
                    tv.setText(check);
                    if (check.contentEquals("left")) {
                        tv.setGravity(Gravity.LEFT);
                    } else if (check.contentEquals("right")) {
                        tv.setGravity(Gravity.RIGHT);
                    } else if (check.contentEquals("center")) {
                        tv.setGravity(Gravity.CENTER);
                    } else if (check.contentEquals("blue")) {
                        tv.setTextColor(Color.BLUE);
                    } else if (check.contentEquals("rkc")) {
                        Random crazy = new Random();
                        tv.setText("it,S Me");
                        tv.setTextSize(crazy.nextInt(75));
                        tv.setTextColor(Color.rgb(crazy.nextInt(265), crazy.nextInt(265), crazy.nextInt(265)));
                        switch (crazy.nextInt(3)) {
                            case 0:
                                tv.setGravity(Gravity.CENTER);
                                break;

                            case 1:
                                tv.setGravity(Gravity.RIGHT);
                                break;
                            case 2:
                                tv.setGravity(Gravity.LEFT);
                                break;
                        }
                    } else {

                        tv.setText("invalid");
                        tv.setGravity(Gravity.CENTER);
                        tv.setTextColor(Color.RED);
                    }}

            break;
            case R.id.tb: {

                if (t.isChecked()) {
                    ett.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);


                } else {
                    ett.setInputType(InputType.TYPE_CLASS_TEXT);


                }
            }
            break;



        }
    }
}
