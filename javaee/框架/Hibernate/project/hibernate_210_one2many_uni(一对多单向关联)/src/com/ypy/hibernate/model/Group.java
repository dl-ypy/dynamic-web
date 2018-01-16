package com.ypy.hibernate.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 小组类，单的一方。
 */
@Entity
@Table(name="t_group")   //表的名字
public class Group {
	private int id;
	private String name;
	private Set<User> user = new HashSet<User>();   //用set的原因是set中元素不会有重复
	
	@OneToMany
	@JoinColumn(name="groupId")  //如果没有这一句，就会当成多对多关系，生成中间表
	public Set<User> getUser() {
		return user;
	}
	public void setUser(Set<User> user) {
		this.user = user;
	}
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
