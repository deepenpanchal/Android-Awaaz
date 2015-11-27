package com.example.awaaz;


import com.example.aawaaz.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;


public class main extends Activity implements OnClickListener {
TextView text;
Intent LevelSelec;	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		findViewById(R.id.button1).setOnClickListener(this);
		findViewById(R.id.button2).setOnClickListener(this);
		findViewById(R.id.button3).setOnClickListener(this);	
		findViewById(R.id.button4).setOnClickListener(this);
		findViewById(R.id.button5).setOnClickListener(this);
		findViewById(R.id.button6).setOnClickListener(this);
		findViewById(R.id.button7).setOnClickListener(this);
		findViewById(R.id.button8).setOnClickListener(this);
		findViewById(R.id.button9).setOnClickListener(this);
		findViewById(R.id.button10).setOnClickListener(this);
		findViewById(R.id.button11).setOnClickListener(this);
	}


@Override
public void onClick(View v) {
	int iidd=v.getId();
	Button gghh=(Button)findViewById(iidd);
	String bstring=gghh.getText().toString();
	if(bstring.equals("Call"))
	{
	LevelSelec=new Intent(this,call.class);
		
		startActivity(LevelSelec);
	}
	if(bstring.equals("Message"))
	{
	LevelSelec=new Intent(this,message.class);
		
		startActivity(LevelSelec);
	}
	if(bstring.equals("What is the time?"))
	{
	LevelSelec=new Intent(this,datetime.class);
		
		startActivity(LevelSelec);
	}
	if(bstring.equals("Calculator"))
	{
	LevelSelec=new Intent(this,calci.class);
		
		startActivity(LevelSelec);
	}
	if(bstring.equals("Battery Status"))
	{
		LevelSelec=new Intent(this,battery.class);
			
			startActivity(LevelSelec);
		}
	if(bstring.equals("Contacts"))
	{
		LevelSelec=new Intent(this,contacts.class);
			
			startActivity(LevelSelec);
		}
	if(bstring.equals("Music Player"))
	{
		LevelSelec=new Intent(this,music.class);
			
			startActivity(LevelSelec);
		}
	if(bstring.equals("Email"))
	{
		LevelSelec=new Intent(this,email.class);
			
			startActivity(LevelSelec);
		}
	if(bstring.equals("Voice Recorder"))
	{
		LevelSelec=new Intent(this,record.class);
			
			startActivity(LevelSelec);
		}
	if(bstring.equals("Ringing Profiles"))
	{
		LevelSelec=new Intent(this,profile.class);
			
			startActivity(LevelSelec);
		}
	if(bstring.equals("Translate"))
	{
	//	LevelSelec=new Intent(this,translate.class);
			
			startActivity(LevelSelec);
		}
}
}