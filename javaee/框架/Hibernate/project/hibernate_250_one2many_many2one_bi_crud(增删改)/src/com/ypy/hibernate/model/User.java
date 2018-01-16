package com.ypy.hibernate.model;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * 用户类,多的一方。
 */
@Entity
@Table(name="t_user")
public class User {
	private int id;
	private String name;
	
	@ManyToOne(cascade={CascadeType.ALL})//.ALL表示增删改查都会对有关的表进行级联
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
