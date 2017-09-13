package com.k.android;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by RAHUL CHAUHAN on 15-06-2015.
 */
public class SimpleBrowser extends Activity implements View.OnClickListener {
    EditText url;
    WebView mybrows;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simplebrowser);

        mybrows = (WebView)findViewById(R.id.webview);
        mybrows.getSettings().setJavaScriptEnabled(true);
        mybrows.getSettings().setLoadWithOverviewMode(true);
        mybrows.getSettings().setUseWideViewPort(true);
        mybrows.setWebViewClient(new myviewclient());
        try {
            mybrows.loadUrl("https://www.facebook.com/");
        }catch (Exception e){
            e.printStackTrace();
        }

        Button go = (Button) findViewById(R.id.go);
        Button back = (Button) findViewById(R.id.bback);
        Button forward = (Button) findViewById(R.id.bforward);
        Button refresh = (Button) findViewById(R.id.brefresh);
        Button clrhistory = (Button) findViewById(R.id.bclearhistory);
        url = (EditText) findViewById(R.id.eturl);
        go.setOnClickListener(this);
        back.setOnClickListener(this);
        forward.setOnClickListener(this);
        clrhistory.setOnClickListener(this);
        refresh.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.go:
                String thewebsite = url.getText().toString();
                mybrows.loadUrl(thewebsite);
                //hiding keyboard
                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(url.getWindowToken(),0);
                break;
            case R.id.bback:
                if (mybrows.canGoBack())
                    mybrows.goBack();

                break;
            case R.id.bforward:
                if (mybrows.canGoForward())
                    mybrows.goForward();

                break;
            case R.id.brefresh:
                mybrows.reload();

                break;

            case R.id.bclearhistory:
                mybrows.clearHistory();
                break;
        }
    }
}
