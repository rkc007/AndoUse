package com.k.android;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * Created by DINANATH CHAUHAN on 27-06-2015.
 */
public class SQLiteExample extends Activity implements View.OnClickListener{
    Button sqlupdate , sqlview;
    EditText sqlname,sqlhot;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sqliteexample);
        sqlupdate = (Button) findViewById(R.id.btsql);
        sqlhot = (EditText) findViewById(R.id.hotness);
        sqlview = (Button) findViewById(R.id.btview);
        sqlname = (EditText) findViewById(R.id.hotname);
        sqlupdate.setOnClickListener(this);
        sqlview.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btsql:
                boolean worked = true;
                try {
                    String name = sqlname.getText().toString();
                    String hotness = sqlhot.getText().toString();

                    HotOrNot entry = new HotOrNot(SQLiteExample.this);
                    entry.open();
                    entry.CreateEntry(name, hotness);
                    entry.close();

                }catch (Exception e){
                    worked = false;
                    String error = e.toString();
                    Dialog d = new Dialog(this);
                    d.setTitle("bang it !");
                    TextView tv = new TextView(this);
                    tv.setText(error);
                    d.setContentView(tv);
                    d.show();
                } finally {
                     if(worked){

                         Dialog d = new Dialog(this);
                         d.setTitle("ohhh Yea !");
                         TextView tv = new TextView(this);
                         tv.setText("Success");
                         d.setContentView(tv);
                         d.show();

                     }
                }

                break;
            case R.id.btview:
                Intent i = new Intent("com.k.android.SQLVIEW");
                startActivity(i);
                break;

        }

    }
}
