package com.k.android;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by RAHUL CHAUHAN on 19-07-2015.
 */
public class MenuAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final String[] values;

    public MenuAdapter(Context context, String[] values) {
        super(context, R.layout.list_back, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_back, parent, false);
        TextView textView = (TextView) rowView.findViewById(R.id.label);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        textView.setText(values[position]);

        String s = values[position];
         if (s.startsWith("Payment")) {
            imageView.setImageResource(R.drawable.calculator);
        } else if (s.startsWith("BarCode")) {
            imageView.setImageResource(R.drawable.email);
        } else if (s.startsWith("kART")) {
            imageView.setImageResource(R.drawable.text);
        } else {
            imageView.setImageResource(R.drawable.home);
        }

        return rowView;
    }
}

