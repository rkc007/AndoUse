package com.k.android;


import android.app.ActionBar;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.actionbarsherlock.app.SherlockListActivity;

/**
 * Created by RAHUL CHAUHAN on 25-05-2015.
 */
public class Menu extends SherlockListActivity {

    String classes[] ={"CartActivity", "Payment"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      // requestWindowFeature(Window.FEATURE_NO_TITLE);
       // getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //setListAdapter(new ArrayAdapter<String>(Menu.this, android.R.layout.simple_list_item_1, classes));

       // ActionBar br = getActionBar();
       // br.show();
       MenuAdapter adapter = new MenuAdapter(this, classes);
        setListAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu){
        super.onCreateOptionsMenu(menu);
        MenuInflater blowup = getMenuInflater();
        blowup.inflate(R.menu.cool_menu,menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.abme:
                Intent i = new Intent("com.k.android.STATUS");
                startActivity(i);
                break;
            case R.id.pref:
                Intent s = new Intent("com.k.android.PREFS");
                startActivity(s);
                break;
            case R.id.exit:
                finish();
                break;

        }
        return  false;
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        String ch = classes[position];
        try {
            Class ourc = Class.forName("com.k.android."+ch);
            Intent ourin = new Intent(Menu.this, ourc);
            startActivity(ourin);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        }
}
