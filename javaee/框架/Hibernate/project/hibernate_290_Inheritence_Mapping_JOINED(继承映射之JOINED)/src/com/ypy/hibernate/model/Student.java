package com.ypy.hibernate.model;

import javax.persistence.Entity;


@Entity
public class Student extends Person{
	private int score;   //只写子类特有的属性就行

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
}
