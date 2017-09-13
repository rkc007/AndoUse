package com.k.android;

import android.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;


/**
 * Created by dell on 2/19/2016.
 */
public abstract class SingleFragmentActivity extends FragmentActivity {
    protected abstract Fragment createFragment();
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        FragmentManager fragmentManager=getSupportFragmentManager();
        Fragment fragment= fragmentManager.findFragmentById(R.id.fragmentHost);
        android.support.v4.app.FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        if(fragment==null){
            fragment=createFragment();

            fragmentTransaction.add(R.id.fragmentHost,fragment).commit();
        }
    }
}