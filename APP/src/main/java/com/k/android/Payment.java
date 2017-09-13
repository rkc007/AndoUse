package com.k.android;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Payment  extends Activity implements OnClickListener{

    Button bh,bg,bk,bl;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment);

        bh=(Button) findViewById(R.id.button1);
        bg=(Button) findViewById(R.id.button2);
        bk=(Button) findViewById(R.id.button3);
        bl=(Button) findViewById(R.id.button4);
        bh.setOnClickListener(this);
        bg.setOnClickListener(this);
        bk.setOnClickListener(this);
        bl.setOnClickListener(this);
    }


    @Override
    public void onClick(View arg) {
        // TODO Auto-generated method stub
        switch(arg.getId())
        {
            case R.id.button1:
                Intent hi = new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.onlinesbi.com/"));
                startActivity(hi);
                break;
            case R.id.button2:
                Intent hu = new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.hdfcbank.com/personal/ways-to-bank/bank-online/netbanking"));
                startActivity(hu);
                break;
            case R.id.button3:
                Intent hw = new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.netpnb.com/"));
                startActivity(hw);
                break;
            case R.id.button4:
                Intent ht = new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.axisbank.com/personal/speed-banking/axis-bank-internet-banking/features.aspx"));
                startActivity(ht);
                break;

        }

    }




}

