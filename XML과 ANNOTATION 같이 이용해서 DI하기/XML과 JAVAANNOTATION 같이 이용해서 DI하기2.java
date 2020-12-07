package com.javalec.ex;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

		public static void main(String[] args) {
			
			AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
			Student student1 = ctx.getBean("student1", Student.class);
			System.out.println("이름 : " + student1.getName());
			System.out.println("나이 : " + student1.getAge());
			System.out.println("취미 : " + student1.getHobbys());
			System.out.println("키 : " + student1.getHeight());
			System.out.println("몸무게 : " + student1.getWeight());
			
			Student student2 = ctx.getBean("student2", Student.class);
			System.out.println("이름 : " + student2.getName());
			System.out.println("나이 : " + student2.getAge());
			System.out.println("취미 : " + student2.getHobbys());
			System.out.println("키 : " + student2.getHeight());
			System.out.println("몸무게 : " + student2.getWeight());
			
			Student student3 = ctx.getBean("student3",Student.class);
			System.out.println("이름 : " + student3.getName());
			System.out.println("나이 : " + student3.getAge());
			System.out.println("취미 : " + student3.getHobbys());
			System.out.println("키 : " + student3.getHeight());
			System.out.println("몸무게 : " + student3.getWeight());
			
			Student student4 = ctx.getBean("student4", Student.class);
			System.out.println("이름 : " + student4.getName());
			System.out.println("나이 : " + student4.getAge());
			System.out.println("취미 : " + student4.getHobbys());
			System.out.println("키 : " + student4.getHeight());
			System.out.println("몸무게 : " + student4.getWeight());
		}
	
}
