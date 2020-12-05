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

}
