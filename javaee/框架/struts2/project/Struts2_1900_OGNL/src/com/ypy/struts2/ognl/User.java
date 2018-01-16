package com.ypy.struts2.ognl;

import java.io.Serializable;

public class User{
	private int age = 8;
	
	public User(){
		System.out.println("user constructor!");
	}
	
	public User(int age){
		super();
		this.age = age;
	}
	
	@Override
	public String toString(){
		return "user" + age;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
