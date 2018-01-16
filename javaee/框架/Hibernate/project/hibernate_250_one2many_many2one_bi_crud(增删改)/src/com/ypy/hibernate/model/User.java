package com.ypy.hibernate.model;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * �û���,���һ����
 */
@Entity
@Table(name="t_user")
public class User {
	private int id;
	private String name;
	
	@ManyToOne(cascade={CascadeType.ALL})//.ALL��ʾ��ɾ�Ĳ鶼����йصı���м���
	public Group getGroup() {
		return group;
	}
	public void setGroup(Group group) {
		this.group = group;
	}
	private Group group;
	
	@Id
	@GeneratedValue
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
	
}
