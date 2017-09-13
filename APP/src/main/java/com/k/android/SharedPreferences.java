package com.k.android;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

/**
 * Created by RAHUL CHAUHAN on 15-06-2015.
 */
public class SharedPreferences extends Activity implements View.OnClickListener {
    EditText shareddata;
    TextView dataresults;
    android.content.SharedPreferences somedata;
    public static String filename = "MyImpData";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sharedpreferences);
        setupVariables();
       somedata = getSharedPreferences(filename,0);

    }

    private void setupVariables() {
        Button save = (Button) findViewById(R.id.save);
        Button load = (Button) findViewById(R.id.load);
        shareddata = (EditText) findViewById(R.id.edtest);
        dataresults=(TextView) findViewById(R.id.txtview);
        save.setOnClickListener(this);
        load.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){

            case R.id.save:
                String stringdata = shareddata.getText().toString();
                android.content.SharedPreferences.Editor edditor = somedata.edit();
                edditor.putString("mystring",stringdata);
                edditor.commit();
                break;
            case R.id.load:
                somedata=getSharedPreferences(filename,0);
                String datareturned = somedata.getString("mystring","Couldn't Load Data");
                dataresults.setText(datareturned);

                break;
        }

    }
}
