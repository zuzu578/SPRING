package com.javalec.ex;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
public class MainClass {

	public static void main(String[] args) {
		//IOC container란?
		
		//객체(class)의 생성 , 라이프사이클(생명주기)를 관리하는 모듈이다..//
		//DI를 java 에서 구현할때 사용//
		//쉽게말해서 IOC컨테이너는 객체(Bean)을 생성해주는 모듈이다 .//
		//즉, DI를 Java에서 주입해줄때 Annotation을 이용하여 Configuration을 설정하고 주입해준다(DI)//
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		//*StudentClass ==> ApplicationConfig에게 DI를 당함(주입 받음)//
		//IOC 컨테이너에서 Student에 주입된 객체를 가져와야함//
		Student student1 = ctx.getBean("student1", Student.class);
		System.out.println("이름 : " + student1.getName());
		System.out.println("나이 : " + student1.getAge());
		System.out.println("취미 : " + student1.getHobbys());
		System.out.println("신장 : " + student1.getHeight());
		System.out.println("몸무게 : " + student1.getWeight());
		
		Student student2 = ctx.getBean("student2", Student.class);
		System.out.println("이름 : " + student2.getName());
		System.out.println("나이 : " + student2.getAge());
		System.out.println("취미 : " + student2.getHobbys());
		System.out.println("신장 : " + student2.getHeight());
		System.out.println("몸무게 : " + student2.getWeight());
		
		
	}
	
}
