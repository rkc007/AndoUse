package com.k.android;

import android.app.Activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Mainpoint extends Activity implements View.OnClickListener {


    Button a, b;
    TextView txt;
    EditText e1,e2;
    String s1,s2;
    int i1,i2,sum,sub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainpoint);
        a = (Button) findViewById(R.id.btadd1);
        b = (Button) findViewById(R.id.btsub);
        txt = (TextView) findViewById(R.id.txt19);
        e1 = (EditText) findViewById(R.id.edt11);
        e2 = (EditText) findViewById(R.id.edt22);
        a.setOnClickListener(this);
        b.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btadd1:
                s1 = e1.getText().toString();
                s2=e2.getText().toString();
                i1= Integer.parseInt(s1);
                i2= Integer.parseInt(s2);
                sum = i1 + i2;
                sub = i1 - i2;
               Toast.makeText(getApplicationContext(),"ADDED",Toast.LENGTH_SHORT).show();
                txt.setText(String.valueOf(sum));
                break;
            case R.id.btsub :
                s1 = e1.getText().toString();
                s2=e2.getText().toString();
                i1= Integer.parseInt(s1);
                i2= Integer.parseInt(s2);
                sum = i1 + i2;
                sub = i1 - i2;
                Toast.makeText(getApplicationContext(),"SUBTRACTED",Toast.LENGTH_SHORT).show();
                txt.setText(String.valueOf(sub));
                break;

        }

    }
}