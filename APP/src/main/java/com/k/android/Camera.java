package com.k.android;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by RAHUL CHAUHAN on 08-06-2015.
 */
public class Camera extends Activity implements View.OnClickListener {

    ImageButton ib;
    Button bu;
    ImageView iv;
    Intent cameraIntent;
    final static int cameradata = 0;
    private static final int CAMERA_REQUEST = 1888;
    Bitmap bmp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photo);
        intialize();
        InputStream ss = getResources().openRawResource(R.raw.rkclogo);
        bmp = BitmapFactory.decodeStream(ss);
    }

    private void intialize() {
        ib = (ImageButton) findViewById(R.id.imageButton);
        bu = (Button) findViewById(R.id.button);
        iv = (ImageView) findViewById(R.id.imageView44);
        bu.setOnClickListener(this);
        ib.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                try {
                    getApplicationContext().setWallpaper(bmp);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.imageButton :
                cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
                break;

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            iv.setImageBitmap(photo);
        }
    }
}

