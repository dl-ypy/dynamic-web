package com.Struts2_0130_DomainModel.model;

public class User {
	//只要这些属性和传过来的参数名字相同，就会自动匹配
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
