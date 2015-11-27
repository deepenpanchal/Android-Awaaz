package com.example.awaaz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.example.aawaaz.R;
import com.example.aawaaz.R.id;
import com.example.aawaaz.R.layout;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
TextView text;
	protected static final int REQUEST_OK = 1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		findViewById(R.id.button1).setOnClickListener(this);
		text= (TextView)findViewById(R.id.text1);
	}


@Override
public void onClick(View v) {
Intent i = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        i.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, "en-US");
       	 try {
             startActivityForResult(i, REQUEST_OK);
         } catch (Exception e) {
       	 	Toast.makeText(this, "Error initializing speech to text engine.", Toast.LENGTH_LONG).show();
         }
        	
}


@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==REQUEST_OK  && resultCode==RESULT_OK) {
        		ArrayList<String> thingsYouSaid = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
        		((TextView)findViewById(R.id.text1)).setText(thingsYouSaid.get(0));
        		String bstring=text.getText().toString();
        		if(bstring.equals("Call"))
        		{
        			 Intent j = new Intent(MainActivity.this, call.class);
     				startActivity(j);
        		}
        		if(bstring.equals("message"))
        		{
        			 Intent j = new Intent(MainActivity.this, message.class);
     				startActivity(j);
        		}
        		if(bstring.equals("calculator"))
        				{
        		 ArrayList<HashMap<String,Object>> items =new ArrayList<HashMap<String,Object>>();
        	        
        	      final PackageManager pm1 = getPackageManager();
        	        List<PackageInfo> packs = pm1.getInstalledPackages(0);  
        	        for (PackageInfo pi : packs) {
        	        if( pi.packageName.toString().toLowerCase().contains("calcul")){
        	            HashMap<String, Object> map = new HashMap<String, Object>();
        	            map.put("appName", pi.applicationInfo.loadLabel(pm1));
        	            map.put("packageName", pi.packageName);
        	            items.add(map);
        	            if(items.size()>=1){
        	            	String packageName = (String) items.get(0).get("packageName");
        	            	Intent i = pm1.getLaunchIntentForPackage(packageName);
        	            	if (i != null)
        	            	  startActivity(i);
        	            	} 
        	            	else{
        	            		Toast.makeText(this, "Application Not Found", Toast.LENGTH_LONG).show();
        	            	   }
        	         }
        	        }
        }
       
    }
}
}