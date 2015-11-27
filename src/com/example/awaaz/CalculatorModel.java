package com.example.awaaz;

public class CalculatorModel {

 	double m_num1, m_num2;
	
	//constructor
	
	//setters
	
	public CalculatorModel(double num1, double num2) {
		// TODO Auto-generated constructor stub
		this.m_num1 = num1;
		this.m_num2 = num2;
	}

	public void setNum1(double num1){
		this.m_num1 = num1;
	}
	
	public void setNum2(double num2){
		this.m_num2 = num2;
	}
	
	//getters
	
	public double getNum1(){
		return this.m_num1;
	}
	
	public double getNum2(){
		return this.m_num2;
	}

}