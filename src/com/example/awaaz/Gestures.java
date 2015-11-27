package com.example.awaaz;


	import java.util.ArrayList;

import com.example.aawaaz.R;
import com.example.aawaaz.R.id;
import com.example.aawaaz.R.layout;
import com.example.aawaaz.R.raw;



	import android.app.Activity;
import android.content.Intent;
import android.gesture.Gesture;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.gesture.GestureOverlayView.OnGesturePerformedListener;
import android.gesture.Prediction;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

	public class Gestures extends Activity implements OnGesturePerformedListener {
	  private GestureLibrary gestureLib;
	  EditText edittext1;
		Button button1;
	  
	/** Called when the activity is first created. */

	  @Override
	  public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    GestureOverlayView gestureOverlayView = new GestureOverlayView(this);
	    
	    View inflate = getLayoutInflater().inflate(R.layout.gestures, null);
	    
	    gestureOverlayView.addView(inflate);
	    gestureOverlayView.addOnGesturePerformedListener(this);
	    gestureLib = GestureLibraries.fromRawResource(this, R.raw.gestures);
	    if (!gestureLib.load()) {
	      finish();
	    }
	    setContentView(gestureOverlayView);
	    edittext1=(EditText)findViewById(R.id.editText1);
        button1=(Button)findViewById(R.id.button1);
        
        button1.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				String number=edittext1.getText().toString();
				Intent callIntent = new Intent(Intent.ACTION_CALL);
				callIntent.setData(Uri.parse("tel:"+number));
				startActivity(callIntent);
			}
        	
        });
	  }

	  @Override
	  public void onGesturePerformed(GestureOverlayView overlay, Gesture gesture) {
	    ArrayList<Prediction> predictions = gestureLib.recognize(gesture);
	    for (Prediction prediction : predictions) {
	      if (prediction.score > 3.0) {
	        Toast.makeText(this, prediction.name, Toast.LENGTH_SHORT)
	            .show();
	        edittext1.setText(prediction.name);
	      }
	    }
	  }
	} 
