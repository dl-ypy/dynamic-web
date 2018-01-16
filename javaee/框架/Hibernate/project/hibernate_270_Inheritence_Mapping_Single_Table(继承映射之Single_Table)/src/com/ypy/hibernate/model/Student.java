package com.ypy.hibernate.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="t_student")
@DiscriminatorValue("student")   //表示插入一个Student类时，就在标记区分的字段中插入一个student
public class Student extends Person{
	private int score;   //只写子类特有的属性就行

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
}
