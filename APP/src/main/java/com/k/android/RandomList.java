package com.k.android;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.actionbarsherlock.app.SherlockListFragment;

/**
 * Created by RAHUL CHAUHAN on 25-07-2015.
 */
public class RandomList extends SherlockListFragment {
    String classes[] ={"Menu","RateUs"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.list, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, classes));
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        String ch = classes[position];
        try {
            Class ourc = Class.forName("com.k.android."+ch);
            Intent ourin = new Intent(RandomList.this.getSherlockActivity(), ourc);
            startActivity(ourin);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
