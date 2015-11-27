package com.example.awaaz;

import com.example.aawaaz.R;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


	public class call extends Activity implements OnClickListener {
	  EditText edittext1;
		Button buttoncall,butclear,buttonc,button1,button2,button3,button4,button5,button6,button7,button8,button9,buttonst,button0,buttonha;
	  
	

	  @Override
	  public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.gestures);
	    buttoncall=(Button)findViewById(R.id.button1);
	    button1=(Button)findViewById(R.id.button2);
        button2=(Button)findViewById(R.id.button3);
        button3=(Button)findViewById(R.id.button6);
        button4=(Button)findViewById(R.id.button8);
        button5=(Button)findViewById(R.id.button9);
        button6=(Button)findViewById(R.id.button10);
        button7=(Button)findViewById(R.id.button11);
        button8=(Button)findViewById(R.id.button12);
        button9=(Button)findViewById(R.id.button13);
        buttonst=(Button)findViewById(R.id.button14);
        button0=(Button)findViewById(R.id.button15);
        buttonha=(Button)findViewById(R.id.button16);
        butclear=(Button)findViewById(R.id.button17);
        buttonc=(Button)findViewById(R.id.button1);
        buttonc.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        buttonst.setOnClickListener(this);
        button0.setOnClickListener(this);
        buttonha.setOnClickListener(this);
        butclear.setOnClickListener(this);
 edittext1= (EditText) findViewById(R.id.editText1);
	
        	
	  
	  }



	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		if(edittext1.length()<=10)
		{
		switch(v.getId()){

        
			
			case R.id.button2: { 
			edittext1.setText(edittext1.getText().toString() + "1");
			break;
			
			}
			
			case R.id.button3:{  
			edittext1.setText(edittext1.getText().toString() + "2");
			break;}
			case R.id.button6:{ 
			edittext1.setText(edittext1.getText().toString() + "3");
			break;
			}
			case R.id.button8: {  
			edittext1.setText(edittext1.getText().toString() + "4");
				break;
			}
			case R.id.button9: { 
			edittext1.setText(edittext1.getText().toString() + "5");
				break;
				
			}
			case R.id.button10: {
			edittext1.setText(edittext1.getText().toString() + "6");
			break;
			
			}
			case R.id.button11:  {
			edittext1.setText(edittext1.getText().toString() + "7");
			break;}
			case R.id.button12: { 
			edittext1.setText(edittext1.getText().toString() + "8");
				break;
			}
			case R.id.button13: { 
			edittext1.setText(edittext1.getText().toString() + "9");
				break;
			}
			case R.id.button14: { 
			edittext1.setText(edittext1.getText().toString() + "*");
				break;
			}
			case R.id.button15:{  
			edittext1.setText(edittext1.getText().toString() + "0");
				break;
			}
			case R.id.button16: {  
			edittext1.setText(edittext1.getText().toString() + "#");
				break;
			}
			case R.id.button17: {  
				edittext1.setText(" ");
					break;
				}
			
			case R.id.button1: {  
				String number=edittext1.getText().toString();
				Intent callIntent = new Intent(Intent.ACTION_CALL);
				callIntent.setData(Uri.parse("tel:"+number));
				startActivity(callIntent);
				break;
				}
			
			}
			
/*
			String number=edittext1.getText().toString();
			Intent callIntent = new Intent(Intent.ACTION_CALL);
			callIntent.setData(Uri.parse("tel:"+number));
			startActivity(callIntent);
			*/
			}
	}
			
		}

		
	