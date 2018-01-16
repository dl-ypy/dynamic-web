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
//��ע��ʵ��
@Entity
@Table(name="_Teacher")   //ָ���������
public class Teacher {
	private int id;
	private String name;
	private String title;
	private Date birthDay;
	private Zhicheng zhicheng;
	
	@Enumerated(EnumType.STRING)     //�洢���ַ������ͣ���һ��ORDINAL�Ǵ洢Ϊint���ͣ��洢������±�
	public Zhicheng getZhicheng() {
		return zhicheng;
	}
	public void setZhicheng(Zhicheng zhicheng) {
		this.zhicheng = zhicheng;
	}
	@Temporal(TemporalType.DATE)   //����ʱ���ʽ��������Ϊֻ��ʾ������
	public Date getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}
	private String mimi;
	
	@Transient    //��ʾ��д�����ݿ���  
	public String getMimi() {
		return mimi;
	}
	public void setMimi(String mimi) {
		this.mimi = mimi;
	}
	@Id      //ע��д��get������
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
