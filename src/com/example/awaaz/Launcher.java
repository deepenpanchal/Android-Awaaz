package com.example.awaaz;






import com.example.aawaaz.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
 
public class Launcher extends Activity implements OnClickListener{
     Button App;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.launcher);
    
        App=(Button)findViewById(R.id.button1);
		App.setOnClickListener(this);
    }
   

       
	@Override
	public void onClick(View v) {
	
		int iidd=v.getId();
		Button gghh=(Button)findViewById(iidd);
		String bstring=gghh.getText().toString();
		if(bstring.equals("To use this app, touch the phone with your finger to know what the button is. To select a particular button, Double click on it. To scroll lists in contacts, use two finger and scroll. Enjoy the experience of using Awaaz! To continue to the home page, double click on this"))
		{
		Intent LevelSelec = new Intent(this,main.class);
    		
    		startActivity(LevelSelec);
		}
	}
     
   
}