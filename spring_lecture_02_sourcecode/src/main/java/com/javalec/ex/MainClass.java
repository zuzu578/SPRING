package com.javalec.ex;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		//생성자주입(constructor DI)
		String configLocatioin = "classpath:applicationCTX.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocatioin);
		Calculation c = ctx.getBean("calculation",Calculation.class);//xml에서의 왼쪽은 id 오른쪽은 class//
		c.addition();
		c.subtraction();
		c.multiplication();
		c.division();
		ctx.close();
		
	}
	
}
