package com.mycompany.myapp;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Mainclas {

	public static void main(String[] args) {
	AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
	Student student1 = 	ctx.getBean("student1",Student.class);
	Student student2 = 	ctx.getBean("student1",Student.class);
    System.out.println(student1.getAge());
    System.out.println(student1.getHobbys());
    System.out.println(student1.getName());
    System.out.println(student2.getAge());
    System.out.println(student2.getHobbys());
    System.out.println(student2.getName());
    ctx.close();

	}

}
