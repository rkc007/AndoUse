package com.k.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
/**
 * Created by dell on 2/20/2016.
 */
public class BarCodeReader extends FragmentActivity implements View.OnClickListener{
    private Button scanBtn;
    private TextView formatTxt,contentTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scanner_layout);
        scanBtn=(Button)findViewById(R.id.scan_button);
        formatTxt=(TextView)findViewById(R.id.scan_format);
        contentTxt=(TextView)findViewById(R.id.scan_content);
        scanBtn.setOnClickListener(this);
    }
    public void onActivityResult(int requestCode,int resultCode,Intent intent){
        IntentResult result=IntentIntegrator.parseActivityResult(requestCode, resultCode, intent) ;
        String scanContent=result.getContents();
        formatTxt.setText(scanContent);




    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.scan_button:{
                    IntentIntegrator integrator = new IntentIntegrator(this);
                integrator.initiateScan();}
        }

    }

}
