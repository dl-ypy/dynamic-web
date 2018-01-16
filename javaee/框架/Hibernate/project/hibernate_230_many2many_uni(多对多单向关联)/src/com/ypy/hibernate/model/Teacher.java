package com.ypy.hibernate.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 小组类，单的一方。
 */
@Entity
public class Teacher {
	private int id;
	private String name;
	private Set<Student> students = new HashSet<Student>();   //用set的原因是set中元素不会有重复
	
	@ManyToMany
	@JoinTable(name="t_s",   //第三个表的表名
		joinColumns={@JoinColumn(name="teacher_id")},   //本表对应的字段名
		inverseJoinColumns={@JoinColumn(name="student_id")}   //对方表对应的字段名
	)
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
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
