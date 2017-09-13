package com.k.android;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TextView;

/**
 * Created by RAHUL CHAUHAN on 15-06-2015.
 */
public class Tabs extends Activity implements View.OnClickListener {

    TabHost th;
    TextView showresults;
    long start,stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tabs);
         th= (TabHost) findViewById(R.id.tabHost);
        Button startwatch = (Button) findViewById(R.id.startwatch);
        Button stopwatch = (Button) findViewById(R.id.stopwatch);
        Button newtab= (Button) findViewById(R.id.addtab);
        showresults = (TextView) findViewById(R.id.tvshowresults);
        newtab.setOnClickListener(this);
        startwatch.setOnClickListener(this);
        stopwatch.setOnClickListener(this);
        th.setup();

        TabHost.TabSpec ts = th.newTabSpec("tag1");
        ts.setContent(R.id.tab1);
        ts.setIndicator("StopWatch");
        th.addTab(ts);

        ts = th.newTabSpec("tag2");
        ts.setContent(R.id.tab2);
        ts.setIndicator("Tab 2");
        th.addTab(ts);

        ts = th.newTabSpec("tag3");
        ts.setContent(R.id.tab3);
        ts.setIndicator("Add a Tab");
        th.addTab(ts);
        start=0;

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.addtab:
                TabHost.TabSpec myspec = th.newTabSpec("tag1");
                myspec.setContent(new TabHost.TabContentFactory() {
                    @Override
                    public View createTabContent(String tag) {
                        TextView txt = new TextView(Tabs.this);
                       txt.setText("you have created a new tab");
                        return (txt);
                    }
                });
                myspec.setIndicator("New");
                th.addTab(myspec);
                break;
            case R.id.stopwatch:
                stop = System.currentTimeMillis();
                if (start!=0){
                    long result = stop-start;
                    int mills = (int)result;
                    int second = (int) result/1000;
                    int minute =  second/60;
                    mills = mills%100;
                    second = second%60;

                showresults.setText(String.format("%d:%02d:%02d",minute,second,mills));}
                break;
            case R.id.startwatch:
                start = System.currentTimeMillis();
                break;


        }
    }
}
