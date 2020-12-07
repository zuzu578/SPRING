package com.javalec.ex;

import java.util.ArrayList;

public class Student {
	//필드//
	private String name;
	private int age;
	private ArrayList<String> hobbys;
	private double height;
	private double weight;
	//생성자로 ApplicationConfig.java에서 넘어온 Bean(객체)들이 전달이 된다.//
	public Student(String name, int age, ArrayList<String> hobbys) {
		this.name = name;
		this.age = age;
		this.hobbys = hobbys;
	}
	//전달된Bean(객체)값들을 설정해준다.setter();
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}

	public void setHobbys(ArrayList<String> hobbys) {
		this.hobbys = hobbys;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}
	
	public void setWeight(double weight) {
		this.weight = weight;
	}
	//getter();==> 메인에서 호출을 할때 사용하는 메서드//
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public ArrayList<String> getHobbys() {
		return hobbys;
	}
	
	public double getHeight() {
		return height;
	}
	
	public double getWeight() {
		return weight;
	}
	
}
