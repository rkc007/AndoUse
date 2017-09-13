package com.k.android;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

/**
 * Created by RAHUL CHAUHAN on 09-06-2015.
 */
public class OpenedClass extends Activity implements View.OnClickListener,RadioGroup.OnCheckedChangeListener {
    Button enter;
    TextView ques,tst;
    RadioGroup selectlist;
    String gotbread,senddata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.send);
        initialize();

        SharedPreferences getData = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        String et = getData.getString("name", "Rahul is ...");
        String values = getData.getString("list", "4");
        if (values.contentEquals("1")){
            ques.setText(et);
        }
      //  Bundle gotbasket= getIntent().getExtras();
       // gotbread = gotbasket.getString("key1");
       // ques.setText(gotbread);
    }

    private void initialize() {
        ques = (TextView) findViewById(R.id.quen);
        tst = (TextView) findViewById(R.id.testne);
        selectlist = (RadioGroup) findViewById(R.id.rgp);
        enter=(Button) findViewById(R.id.btnnnn);
        enter.setOnClickListener(this);
        selectlist.setOnCheckedChangeListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent person = new Intent();
        Bundle bckpck = new Bundle();
        bckpck.putString("answer",senddata);
        person.putExtras(bckpck);
        setResult(RESULT_OK,person);
        finish();
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.rbcool:
                senddata = "Probably right !";
                break;
            case R.id.rbnaughty:
                senddata = "Oh yea!! here u r  !";
                break;
            case R.id.rbboth:
                senddata = "spot On !";
                break;
        }
        tst.setText(senddata);
    }
}
