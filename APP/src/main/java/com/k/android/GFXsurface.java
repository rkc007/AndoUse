package com.k.android;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

/**
 * Created by RAHUL CHAUHAN on 14-06-2015.
 */
public class GFXsurface extends Activity implements View.OnTouchListener{

    @Override
    protected void onResume() {
        super.onResume();
        mysurface.resume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mysurface.pause();
    }

    Rahulviewsurface mysurface;
    float x,y,sx,sy,fx,fy,dx,dy,anix,aniy,scaledx,scaledy;
    Bitmap test,plus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mysurface = new Rahulviewsurface(this);
        mysurface.setOnTouchListener(this);
        x=0;
        y=0;
        sx=0;
        sy=0;
        fx=0;
        fy=0;
        dx=dy=anix=aniy=scaledx=scaledy=0;
         test = BitmapFactory.decodeResource(getResources(),R.drawable.greenball);
        plus = BitmapFactory.decodeResource(getResources(),R.drawable.plus1);
        setContentView(mysurface);

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        x=event.getX();
        y=event.getY();

        switch (event.getAction()){

            case MotionEvent.ACTION_DOWN :
                sx=event.getX();
                sy = event.getY();
                dx=dy=anix=aniy=scaledx=scaledy=fx=fy=0;
                break;
            case MotionEvent.ACTION_UP:
                fx=event.getX();
                fy=event.getY();
                dx=fx-sx;
                dy=fy-sy;
                scaledx = dx/30;
                scaledy = dy/30;
                x=y=0;
                break;

        }
        return true;
    }
    public class Rahulviewsurface extends SurfaceView implements Runnable {
        SurfaceHolder myholder;
        Thread mythread;
        Boolean isrunning = false;
        public Rahulviewsurface(Context context) {
            super(context);
            myholder = getHolder();

        }

        public void pause(){
            isrunning = false;
            while (true){
                try {
                    mythread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;

            }
            mythread = null;
        }

        public  void resume(){
            isrunning =true;
            mythread = new Thread(this);
            mythread.start();
        }

        @Override
        public void run() {
            while (isrunning){
                if (!myholder.getSurface().isValid())
                    continue;

                Canvas canvas= myholder.lockCanvas();
                canvas.drawRGB(02, 02, 150);
                if (x!=0 && y!=0){
                    canvas.drawBitmap(test,(x-test.getWidth()/2),(y-test.getHeight()/2),null);
                }
                if (sx!=0 && sy!=0){
                    canvas.drawBitmap(plus,(sx-plus.getWidth()/2),(sy-plus.getHeight()/2),null);
                } if (fx!=0 && fy!=0){
                    canvas.drawBitmap(test,(fx-test.getWidth()/2)-anix,(fy-test.getHeight()/2)-aniy,null);
                    canvas.drawBitmap(plus,(fx-plus.getWidth()/2),(fy-plus.getHeight()/2),null);
                }
                anix = anix+scaledx;
                aniy = aniy+scaledy;

                myholder.unlockCanvasAndPost(canvas);

            }

        }
    }

}
