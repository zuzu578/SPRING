package com.board.controller;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass01 {

	public static void main(String[] args) {
		String configLocation = "classpath:applicationCTX2.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation);
		Myinfo myinfo = ctx.getBean("myinfo",Myinfo.class);
		myinfo.getinfo();	
		ctx.close();

	}

}
