package com.k.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by RAHUL CHAUHAN on 09-06-2015.
 */
public class Data extends Activity implements View.OnClickListener {
    Button start,startfor;
    EditText txxt;
    TextView txvw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.get);
        initialize();
    }

    private void initialize() {
        start=(Button) findViewById(R.id.bsa);
        startfor=(Button) findViewById(R.id.bsaf);
        txxt = (EditText) findViewById(R.id.edsend);
        txvw = (TextView) findViewById(R.id.tvgot);
        start.setOnClickListener(this);
        startfor.setOnClickListener(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode==RESULT_OK){
            Bundle basket = data.getExtras();
            String s = basket.getString("answer");
            txvw.setText(s);
    }}

    @Override
    public void onClick(View k) {

        switch (k.getId()){
            case R.id.bsa:
                String bread = txxt.getText().toString();
                Bundle basket = new Bundle();
                basket.putString("key1",bread);
                Intent z =new Intent(Data.this,OpenedClass.class);
                z.putExtras(basket);
                startActivity(z);
                break;
            case R.id.bsaf:
                Intent y = new Intent(Data.this,OpenedClass.class);
                startActivityForResult(y,0);
                break;
        }
    }
}
