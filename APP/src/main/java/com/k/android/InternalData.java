package com.k.android;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by RAHUL CHAUHAN on 15-06-2015.
 */
public class InternalData extends Activity implements View.OnClickListener {
    EditText shareddata;
    TextView dataresults;
    FileOutputStream fos;
    String FILENAME = "internalstring";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sharedpreferences);
        setupVariables();
    }

    private void setupVariables() {
        Button save = (Button) findViewById(R.id.save);
        Button load = (Button) findViewById(R.id.load);
        shareddata = (EditText) findViewById(R.id.edtest);
        dataresults=(TextView) findViewById(R.id.txtview);
        save.setOnClickListener(this);
        load.setOnClickListener(this);
        try {
            fos =openFileOutput(FILENAME, Context.MODE_PRIVATE);
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){

            case R.id.save:
                String data = shareddata.getText().toString();
                //saving data via file
                /*
                File f = new File(FILENAME);
                try {
                    fos = new FileOutputStream(f);
                    //write some data
                    fos.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                */
                try {
                    fos = openFileOutput(FILENAME,Context.MODE_PRIVATE);
                    fos.write(data.getBytes());
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }


                break;
            case R.id.load:
               new loadsome().execute(FILENAME);
                break;
        }

    }

    public class loadsome extends AsyncTask<String,Integer,String> {
        ProgressDialog dialouge;
        protected void onPreExecute(){
            //setting something
            dialouge = new ProgressDialog(InternalData.this);
            dialouge.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            dialouge.setMax(100);
            dialouge.show();

        }

        @Override
        protected String doInBackground(String... params) {
            String collected = null;
            FileInputStream fis=null;

            for(int i = 0;i<20;i++){
                publishProgress(5);
                try {
                    Thread.sleep(88);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            dialouge.dismiss();
            try {
                fis  = openFileInput(FILENAME);
                byte[] dataarray = new byte[fis.available()];
                while (fis.read(dataarray) != -1){
                    collected = new String(dataarray);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            finally {
                try {
                    fis.close();
                    return collected;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        protected void onProgressUpdate(Integer...progress){
            dialouge.incrementProgressBy(progress[0]);

        }

        protected void onPostExecute(String result){
            dataresults.setText(result);

        }
    }
}