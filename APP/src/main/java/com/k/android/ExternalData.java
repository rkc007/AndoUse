package com.k.android;

import android.app.Activity;
import android.content.DialogInterface;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by DINANATH CHAUHAN on 26-06-2015.
 */
public class ExternalData extends Activity implements View.OnClickListener, AdapterView.OnItemSelectedListener{
    private TextView canwrite,canread;
    private String state;
    Boolean canr,canw;
    Spinner spinner;
    String paths[]={"Photos" , "Music" , "Downloads"};
    File path = null;
    EditText savefile;
    Button confirm,save;
    File file=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.externaldata);
        canwrite = (TextView) findViewById(R.id.tvcanwrite);
        canread = (TextView) findViewById(R.id.tvcanread);
        save = (Button) findViewById(R.id.btsave);
        confirm = (Button) findViewById(R.id.btconfirm);
        savefile = (EditText) findViewById(R.id.saveas);
        save.setOnClickListener(this);
        confirm.setOnClickListener(this);
        checkstate();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(ExternalData.this,android.R.layout.simple_spinner_item,paths);

        spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    private void checkstate() {
        state = Environment.getExternalStorageState();
        if(state.equals(Environment.MEDIA_MOUNTED)){
            //read and writeT
            canread.setText("True");
            canwrite.setText("True");
            canw=canr=true;
        }
        else if (state.equals(Environment.MEDIA_MOUNTED_READ_ONLY)){
            //read but cant write
            canread.setText("True");
            canwrite.setText("False");
            canr=true;
            canw=false;
        }
        else{
            canread.setText("False");
            canwrite.setText("False");
            canw=canr=false;
        }

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        int pos =  spinner.getSelectedItemPosition();
        switch(pos){
            case 0 :
                path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC);
                break;
            case 1 :
                path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
                break;
            case 2 :
                path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
                break;

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btsave:
                String f = savefile.getText().toString();
                file = new File(path,f+".png");

                checkstate();
                if (canw==canr==true){
                    path.mkdirs();
                    try {
                    InputStream is = getResources().openRawResource(R.raw.greenball1);
                        OutputStream os = new FileOutputStream(file);
                        byte data[] = new byte[is.available()];
                        is.read(data);
                        os.write(data);
                        is.close();
                        os.close();

                        Toast t = Toast.makeText(ExternalData.this,"Path Has Been Saved",Toast.LENGTH_LONG);
                        t.show();
                        MediaScannerConnection.scanFile(ExternalData.this,new  String[] {file.toString()},null,
                                new MediaScannerConnection.OnScanCompletedListener() {
                                    @Override
                                    public void onScanCompleted(String path, Uri uri) {
                                      Toast t =   Toast.makeText(ExternalData.this, "Scan Complete . . .", Toast.LENGTH_SHORT);
                                        t.show();
                                    }
                                });
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case R.id.btconfirm:
                save.setVisibility(v.VISIBLE);
                break;


        }
    }
}
