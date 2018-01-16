package com.ypy.struts2.ognl;

public class Cat {
	private Dog dog;

	public Dog getDog() {
		return dog;
	}

	public void setDog(Dog dog) {
		this.dog = dog;
	}
	
	public String jiao(){
		return "miao";
	}
}
