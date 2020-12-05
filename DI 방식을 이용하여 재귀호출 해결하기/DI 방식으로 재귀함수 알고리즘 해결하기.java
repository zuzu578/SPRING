package com.board.controller;

public class MyCalculator {
	private Calculator calculator;
	private int firstNum;
	private int secondNum;
	private int thirdNum;
	private int fourthNum;
	private int factorialNumber;
	
	public int getFactorialNumber() {
		return factorialNumber;
	}
	public void setFactorialNumber(int factorialNumber) {
		this.factorialNumber = factorialNumber;
	}
	public int getThirdNum() {
		return thirdNum;
	}
	public void setThirdNum(int thirdNum) {
		this.thirdNum = thirdNum;
	}
	public int getFourthNum() {
		return fourthNum;
	}
	public void setFourthNum(int fourthNum) {
		this.fourthNum = fourthNum;
	}
	public Calculator getCalculator() {
		return calculator;
	}
	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
	}
	public int getFirstNum() {
		return firstNum;
	}
	public void setFirstNum(int firstNum) {
		this.firstNum = firstNum;
	}
	public int getSecondNum() {
		return secondNum;
	}
	public void setSecondNum(int secondNum) {
		this.secondNum = secondNum;
	}
	
	public void add() {
		calculator.additon(firstNum,secondNum);
	}
	public void sub() {
		calculator.subtraction(firstNum,secondNum);
	}
	public void multi() {
		calculator.multiplication(firstNum,secondNum);
	}
	public void div() {
		calculator.division(firstNum,secondNum);
	}
	public void factorial() {
		calculator.factorial(thirdNum);
	}
	public int recursive() {
		return calculator.recursive(fourthNum);
	}
	public int recursiveFactorial() {
		return calculator.recursiveFactorial(factorialNumber);
	}

}
