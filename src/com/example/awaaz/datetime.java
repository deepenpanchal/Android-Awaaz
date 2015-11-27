package com.example.awaaz;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.example.aawaaz.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class datetime extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.datetime);
		
		// 1
		Calendar c1 = Calendar.getInstance();
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MMM \n h:m:s a");
		String strdate1 = sdf1.format(c1.getTime());
		
		TextView txtdate1 = (TextView) findViewById(R.id.textView1);
		txtdate1.setText(strdate1);
		
		
						
	}

}
