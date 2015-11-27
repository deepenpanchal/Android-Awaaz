package com.example.awaaz;



import com.example.aawaaz.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class calci extends Activity implements OnClickListener{

	EditText et_result;
	Button btn_one, btn_two, btn_three, btn_four, btn_five, btn_six, btn_seven, 
	btn_eight, btn_nine, btn_zero, btn_point, btn_add, btn_minus, btn_times, 
	btn_divide, btn_equal, btn_clear;
	
	double num1 = 0;
	int indicator = 0;
	
	CalculatorModel c_model;
	CalculatorController c_controller;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.calci);
		
		initializeVars();
	}

	
	
	public void initializeVars(){
		
		et_result = (EditText)findViewById(R.id.et_result);
		btn_one = (Button)findViewById(R.id.btn_one);
		btn_two = (Button)findViewById(R.id.btn_two);
		btn_three = (Button)findViewById(R.id.btn_three);
		btn_four = (Button)findViewById(R.id.btn_four);
		btn_five = (Button)findViewById(R.id.btn_five);
		btn_six = (Button)findViewById(R.id.btn_six);
		btn_seven = (Button)findViewById(R.id.btn_seven);
		btn_eight = (Button)findViewById(R.id.btn_eight);
		btn_nine = (Button)findViewById(R.id.btn_nine);
		btn_zero = (Button)findViewById(R.id.btn_zero);
		btn_point = (Button)findViewById(R.id.btn_point);
		btn_add = (Button)findViewById(R.id.btn_add);
		btn_minus = (Button)findViewById(R.id.btn_minus);
		btn_times = (Button)findViewById(R.id.btn_times);
		btn_divide = (Button)findViewById(R.id.btn_divide);
		btn_equal = (Button)findViewById(R.id.btn_equal);
		btn_clear = (Button)findViewById(R.id.btn_clear);
		
		btn_one.setOnClickListener(this);
		btn_two.setOnClickListener(this);
		btn_three.setOnClickListener(this);
		btn_four.setOnClickListener(this);
		btn_five.setOnClickListener(this);
		btn_six.setOnClickListener(this);
		btn_seven.setOnClickListener(this);
		btn_eight.setOnClickListener(this);
		btn_nine.setOnClickListener(this);
		btn_zero.setOnClickListener(this);
		btn_point.setOnClickListener(this);
		btn_add.setOnClickListener(this);
		btn_minus.setOnClickListener(this);
		btn_times.setOnClickListener(this);
		btn_divide.setOnClickListener(this);
		btn_equal.setOnClickListener(this);
		btn_clear.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		
		// TODO Auto-generated method stub
		
	try{
		
	
			switch(v.getId()){
			case R.id.btn_one:
					et_result.setText(et_result.getText().toString()+btn_one.getText().toString());
				break;
				
			case R.id.btn_two:
					et_result.setText(et_result.getText().toString()+btn_two.getText().toString());
				break;
				
			case R.id.btn_three:
					et_result.setText(et_result.getText().toString()+btn_three.getText().toString());
				break;
			
			case R.id.btn_four:
					et_result.setText(et_result.getText().toString()+btn_four.getText().toString());
				break;
			
			case R.id.btn_five:
					et_result.setText(et_result.getText().toString()+btn_five.getText().toString());
				break;
			
			case R.id.btn_six:
					et_result.setText(et_result.getText().toString()+btn_six.getText().toString());
				break;
			
			case R.id.btn_seven:
					et_result.setText(et_result.getText().toString()+btn_seven.getText().toString());
				break;
			
			case R.id.btn_eight:
					et_result.setText(et_result.getText().toString()+btn_eight.getText().toString());
				break;
			
			case R.id.btn_nine:
					et_result.setText(et_result.getText().toString()+btn_nine.getText().toString());
				break;
			
			case R.id.btn_zero:
					et_result.setText(et_result.getText().toString()+btn_zero.getText().toString());
				break;
			
			case R.id.btn_point:
					et_result.setText(et_result.getText().toString()+btn_point.getText().toString());
				break;
				
			case R.id.btn_add:
					num1 = Double.parseDouble(et_result.getText().toString());
					et_result.setText("");
					indicator = 1;
				break;
				
			case R.id.btn_minus:
					num1 = Double.parseDouble(et_result.getText().toString());
					et_result.setText("");
					indicator = 2;
				break;
			
			case R.id.btn_times:
					num1 = Double.parseDouble(et_result.getText().toString());
					et_result.setText("");
					indicator = 3;
				break;
			
			case R.id.btn_divide:
					num1 = Double.parseDouble(et_result.getText().toString());
					et_result.setText("");
					indicator = 4;
				break;
			
			case R.id.btn_clear:
					et_result.setText("");
				break;
				
			case R.id.btn_equal:
				
					c_model = new CalculatorModel(num1, Double.parseDouble(et_result.getText().toString()));
					c_controller = new CalculatorController();
					
					switch(indicator){
						case 1:
								et_result.setText(Double.toString(c_controller.addition(c_model)));
							break;
						case 2:
								et_result.setText(Double.toString(c_controller.subtraction(c_model)));
							break;
						case 3:
								et_result.setText(Double.toString(c_controller.multiplication(c_model)));
							break;
						case 4:
								et_result.setText(Double.toString(c_controller.divistion(c_model)));
							break;
					}
					
				break;
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}