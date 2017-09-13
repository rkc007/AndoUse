package com.k.android;



        import android.app.Activity;
        import android.app.AlertDialog;
        import android.content.DialogInterface;
        import android.content.Intent;
        import android.os.Bundle;
        import android.provider.Telephony.Mms.Rate;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.view.View;
        import android.view.View.OnClickListener;
        import android.widget.Button;
        import android.widget.RatingBar;
        import android.widget.Toast;

public class RateUs extends Activity  {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rateus);
        AlertDialog.Builder buld= new AlertDialog.Builder(this);
        buld.setMessage("Is This App Helpful and does it meet your requirements,lets know by your rating");
        buld.setCancelable(false);
        buld.setPositiveButton("Rate Us", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                Intent ab = new Intent(getApplicationContext(),RateUs1.class);
                startActivity(ab);
            }
        });
        buld.setNegativeButton("Remind Me Later", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                finish();

            }
        });
        AlertDialog bh =buld.create();
        bh.setTitle("regsiter");
        bh.show();

    }




	/*public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.first, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	*/
}
