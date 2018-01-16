package com.ypy.hibernate.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
//用注解实现
@Entity
@Table(name="_Teacher")   //指定表的名字
public class Teacher {
	private int id;
	private String name;
	private String title;
	private Date birthDay;
	private Zhicheng zhicheng;
	
	@Enumerated(EnumType.STRING)     //存储成字符串类型，另一种ORDINAL是存储为int类型，存储数组的下标
	public Zhicheng getZhicheng() {
		return zhicheng;
	}
	public void setZhicheng(Zhicheng zhicheng) {
		this.zhicheng = zhicheng;
	}
	@Temporal(TemporalType.DATE)   //设置时间格式，此列子为只显示年月日
	public Date getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}
	private String mimi;
	
	@Transient    //表示不写到数据库中  
	public String getMimi() {
		return mimi;
	}
	public void setMimi(String mimi) {
		this.mimi = mimi;
	}
	@Id      //注解写在get方法上
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
}
