package com.ypy.hibernate.model;

import javax.persistence.Entity;


@Entity
public class Student extends Person{
	private int score;   //ֻд�������е����Ծ���

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
}
