package com.board.controller;

public class Calculator {

	public void addition(int f, int s) {
		System.out.println("addition()");
		int result = f+s;
		System.out.println(result);
		
	}

	public void subtraction(int f, int s) {
		System.out.println("subtraction()");
		int result = f-s;
		System.out.println(result);

	}

	public void multiplication(int f, int s) {
		System.out.println("multiplication()");
		int result = f*s;
		System.out.println(result);
		
	}

	public void division(int f, int s) {
		System.out.println("division()");
		int result = f/s;
		System.out.println(result);
		
	}
	public void nSum(int t) {
		int sum = 0;
		
		System.out.println("nSum()");
		for(int i= t ; i <= 100 ; i++) {
			sum = sum+i;		
		}
		
		System.out.println(sum);
		
	}
	
}
