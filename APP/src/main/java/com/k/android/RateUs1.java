package com.k.android;


        import android.app.Activity;
        import android.os.Bundle;
        import android.view.View;
        import android.view.View.OnClickListener;
        import android.widget.Button;
        import android.widget.RatingBar;
        import android.widget.Toast;

public class RateUs1 extends Activity implements OnClickListener{
    RatingBar rbt;
    Button bjk;

    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rateus1);
        rbt=(RatingBar) findViewById(R.id.ratingBar1);
        bjk=(Button) findViewById(R.id.button1);
        bjk.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        String rate = String.valueOf(rbt.getRating());
        Toast.makeText(getApplicationContext(), " you rated us =>"+rate+" and Thank You For your Rating", Toast.LENGTH_SHORT).show();
        finish();

    }
}
