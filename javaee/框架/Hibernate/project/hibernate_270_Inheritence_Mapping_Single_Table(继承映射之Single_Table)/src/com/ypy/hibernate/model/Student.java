package com.ypy.hibernate.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="t_student")
@DiscriminatorValue("student")   //��ʾ����һ��Student��ʱ�����ڱ�����ֵ��ֶ��в���һ��student
public class Student extends Person{
	private int score;   //ֻд�������е����Ծ���

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
}
