package com.javalec.ex;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//==>Configuration ==> 역할:IOC컨테이너로써 객체들(Bean)을 관리하는 역할을한다.(객체를 생성)//
@Configuration//==>@Configuration ==> IOC컨테이너 역할//
public class ApplicationConfig {
//==>객체들을 관리(생성) ==> @Bean//
	@Bean
	public Student student1(){
		
		ArrayList<String> hobbys = new ArrayList<String>();
		hobbys.add("수영");
		hobbys.add("요리");
		
		Student student = new Student("홍길동", 20, hobbys);
		student.setHeight(180);
		student.setWeight(80);
		//==>return ==>Student 클래스에 Bean(객체)들을 생성하고 반환해주는 역할을 한다.//
		//==>Java파일(ApplicationConfig.java)가 Student.java에게 DI(Dependency Injection)을 해주고있다.//
		return student;
	}
	
	@Bean
	public Student student2(){
		
		ArrayList<String> hobbys = new ArrayList<String>();
		hobbys.add("독서");
		hobbys.add("음악감상");
		
		Student student = new Student("홍길순", 18, hobbys);
		student.setHeight(170);
		student.setWeight(55);
		//==>Java파일(ApplicationConfig.java)가 Student.java에게 DI(Dependency Injection)을 해주고있다.//
		//==>return ==>Student 클래스에 Bean(객체)들을 생성하고 반환해주는 역할을 한다.//
		return student;
	}
	
}
