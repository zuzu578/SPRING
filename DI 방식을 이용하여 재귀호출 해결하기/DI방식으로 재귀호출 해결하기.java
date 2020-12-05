package com.board.controller;

public class Calculator {
	public void additon(int f, int s) {
		System.out.println("additon()");
		int result = f + s;
		System.out.println(result);
	}
	public void subtraction(int f, int s) {
		System.out.println("subtraction()");
		int result = f - s;
		System.out.println(result);
	}
	public void multiplication(int f, int s) {
		System.out.println("multiplication");
		int result = f * s;
		System.out.println(result);
	}
	public void division(int f, int s) {
		System.out.println("division()");
		int result = f / s;
		System.out.println(result);
	}
	public void factorial(int thirdNum) {
		System.out.println("factorial()");
		int number1=1;
		for(int i = thirdNum ; i>0; i=i-1) {
			number1 = number1*i;
		}
		System.out.println(number1);
	}
	public int recursive(int fourthNum) {
	
		if(fourthNum==0) {
			return 0;
		}else if(fourthNum==1) {
			return 1;
		}else {
			
			return recursive(fourthNum-1)+recursive(fourthNum-2);
		}
		
	}
	public int recursiveFactorial(int factorialNumber) {
		if(factorialNumber==1) {
			return factorialNumber;
		}else {
			return factorialNumber* recursiveFactorial(factorialNumber-1);
		}
	}

}
