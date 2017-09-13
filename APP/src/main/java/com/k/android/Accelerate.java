package com.k.android;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by DINANATH CHAUHAN on 02-07-2015.
 */
public class Accelerate extends Activity implements SensorEventListener {

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


                myholder.unlockCanvasAndPost(canvas);

            }

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new Rahulviewsurface(this));
        SensorManager sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        if (sm.getSensorList(Sensor.TYPE_ACCELEROMETER).size()!=0){

            Sensor s = sm.getSensorList(Sensor.TYPE_ACCELEROMETER).get(0);
           // sm.registerListener(this,s,SensorManager,SensorManager.SENSOR_DELAY_NORMAL);
        }

    }

    @Override
    public void onSensorChanged(SensorEvent event) {

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
