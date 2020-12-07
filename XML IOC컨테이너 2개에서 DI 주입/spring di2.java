package com.javalec.ex;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		//==> xml1번째를 configLocation1 에 저장//
		//==> xml2 번째를 configLocation2 에 저장//
		String configLocation1 = "classpath:applicationCTX.xml";
		String configLocation2 = "classpath:applicationCTX1.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation1, configLocation2);
		//ctx.getBean ==> IOC 컨테이너에서 student클래스의 student1 Bean(객체)를 가져오도록함//
		//==> student1,student2 ==> applicationCTX.xml 소속이다//
		Student student1 = ctx.getBean("student1", Student.class);
		System.out.println(student1.getName());	//홍길동
		System.out.println(student1.getHobbys());	// 수영, 요리
		
		StudentInfo studentInfo = ctx.getBean("sutudentInfo1", StudentInfo.class);
		Student student2 = studentInfo.getStudent();	//student1  == student2
		System.out.println(student2.getName());	//홍길동
		System.out.println(student2.getHobbys());	// 수영, 요리
			
		if(student1.equals(student2)) {
			//같음 ==> xml 에서 students2 는 student1의 레퍼런스 값을 참조했기 때문//
			//<ref bean="student1"/> ==>이것의 의미는 student1의 레퍼런스 값을 참조하겠다 라는뜻//
			//그렇기 때문에 같다//
			
			System.out.println("student1 == student2");
		}
		//==> student3 ==> applicationCTX1.xml 소속이다//
		Student student3 = ctx.getBean("student3", Student.class);
		System.out.println(student3.getName());//홍길자
		//때문에 student1 과 student3은 같지 않다//
		//결론적으로 student2 도 student3 와 같지 않다.//
		if(student2.equals(student3)) {
			System.out.println("같다");
		}else {
			System.out.println("같지않다.");
		}
		if(student1.equals(student3)) {
			System.out.println("student1 == student3");
		} else {
			System.out.println("student1 != student3");
		}
		
		Family family = ctx.getBean("family", Family.class);
		System.out.println(family.getPapaName());
		System.out.println(family.getMamiName());
		System.out.println(family.getSisterName());
		System.out.println(family.getBrotherName());
		
		//ctx.close();
		
	}
	
}
