package com.mycompany.myapp;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

	@Bean
	public Student student1() {
		ArrayList<String>hobbys = new ArrayList<String>();
		hobbys.add("요리");
		hobbys.add("수영");
		Student student = new Student("hong");
		student.setAge(10);
		student.setHobbys(hobbys);
		
		return student;
	}
	@Bean 
	public Student student2() {
		ArrayList<String>hobbys = new ArrayList<String>();
		hobbys.add("독서");
		hobbys.add("음악감상");
		Student student = new Student("kim");
		student.setAge(5);
		student.setHobbys(hobbys);
		
		return student;
	}
}
