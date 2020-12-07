package com.javalec.ex;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

	@Bean
	public Student student1(){
		
		ArrayList<String> hobbys = new ArrayList<String>();
		hobbys.add("수영");
		hobbys.add("요리");
		
		Student student = new Student("홍길동", 20, hobbys);
		student.setHeight(180);
		student.setWeight(80);
		
		return student;
	}
	@Bean
	public Student student3() {
		ArrayList<String>hobbys = new ArrayList<String>();
		hobbys.add("잠자기");
		hobbys.add("멍때리기");
		Student student = new Student("이주환",22,hobbys);
		student.setHeight(168);
		student.setWeight(64);
		return student;
	}
	
}
