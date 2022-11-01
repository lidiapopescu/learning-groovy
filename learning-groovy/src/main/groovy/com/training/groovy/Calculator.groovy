package com.training.groovy

class Calculator {
	
	int add(int a, int b) {
		a + b
	}
	
	int substract(int a , int b) {
		a - b
	}
	
	int multiply(int a, int b) {
		a * b
	}
	
	float divide(int a, int b) {
//		if ( b == 0)
//			throw new RuntimeException("Cannot divide by zero")
		try {
			a / b
		} catch (ArithmeticException e) {
			assert e instanceof ArithmeticException
			assert e.getMessage() == "Division by zero"
			println "Cannot devide by zero"
			0
		}
	}
}
