package com.example.awaaz;

public class CalculatorController {

	public double addition(CalculatorModel cmodel){
		return cmodel.m_num1 + cmodel.m_num2;
	}
	
	public double subtraction(CalculatorModel cmodel){
		return cmodel.m_num1 - cmodel.m_num2;
	}
	
	public double multiplication(CalculatorModel cmodel){
		return cmodel.m_num1 * cmodel.m_num2;
	}
	
	public double divistion(CalculatorModel cmodel){
		return cmodel.m_num1 / cmodel.m_num2;
	}
}

