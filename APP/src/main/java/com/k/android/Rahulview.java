package com.k.android;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.View;

/**
 * Created by RAHUL CHAUHAN on 14-06-2015.
 */
public class Rahulview extends View {
    Bitmap gball;
    float changingy;
    Typeface font;


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.YELLOW);
        Paint txtpaint = new Paint();
        txtpaint.setARGB(50,254,10,50);
        txtpaint.setTextAlign(Paint.Align.CENTER);
        txtpaint.setTextSize(100);
        txtpaint.setTypeface(font);
        canvas.drawBitmap(gball, (canvas.getWidth() / 2), changingy, null);
        if (changingy < canvas.getHeight()){

            changingy +=10;

        }
        else {

            changingy =0;
        }

        invalidate();
    }

    public Rahulview(Context context) {
        super(context);
        gball = BitmapFactory.decodeResource(getResources(),R.drawable.images);
        changingy = 0;
        font = Typeface.createFromAsset(context.getAssets(),"dragon.otf");
    }
}
