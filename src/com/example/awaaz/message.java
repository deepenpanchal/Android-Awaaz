package com.example.awaaz;



import java.util.ArrayList;

import com.example.aawaaz.R;

import android.os.Bundle;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.speech.RecognizerIntent;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class  message extends Activity implements OnClickListener{
	protected static final int REQUEST_OK = 1;
	EditText mobileno,message;
	Button sendsms;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message);
        
        mobileno=(EditText)findViewById(R.id.editText1);
        message=(EditText)findViewById(R.id.editText2);
        findViewById(R.id.editText2).setOnClickListener(this);
        findViewById(R.id.editText1).setOnClickListener(this);
        sendsms=(Button)findViewById(R.id.button1);
        
        sendsms.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				String no=mobileno.getText().toString();
				String msg=message.getText().toString();
				
				Intent intent=new Intent(getApplicationContext(),MainActivity.class);
				PendingIntent pi=PendingIntent.getActivity(getApplicationContext(), 0, intent,0);
				
				SmsManager sms=SmsManager.getDefault();
				sms.sendTextMessage(no, null, msg, pi,null);
				
				Toast.makeText(getApplicationContext(), "Message Sent successfully!",Toast.LENGTH_LONG).show();
			}
		});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
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
            		((EditText)findViewById(R.id.editText2)).setText(thingsYouSaid.get(0));
            }
    }
}

