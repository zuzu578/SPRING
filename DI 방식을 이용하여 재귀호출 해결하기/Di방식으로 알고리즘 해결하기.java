package com.board.controller;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		//객체 주입==> xml, 객체 조립 ==>java//
		String configLoc = "classpath:applicationCTX.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLoc);
		MyCalculator myCalculator = ctx.getBean("myCalculator",MyCalculator.class);
		myCalculator.add();
		myCalculator.sub();
		myCalculator.multi();
		myCalculator.div();
		myCalculator.factorial();
		int r1 = myCalculator.recursive();
		int r2 = myCalculator.recursiveFactorial();
		System.out.println(r1);
		System.out.println(r2);

	}

}
