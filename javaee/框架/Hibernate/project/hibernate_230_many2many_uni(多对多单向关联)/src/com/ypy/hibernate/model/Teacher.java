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
 * С���࣬����һ����
 */
@Entity
public class Teacher {
	private int id;
	private String name;
	private Set<Student> students = new HashSet<Student>();   //��set��ԭ����set��Ԫ�ز������ظ�
	
	@ManyToMany
	@JoinTable(name="t_s",   //��������ı���
		joinColumns={@JoinColumn(name="teacher_id")},   //�����Ӧ���ֶ���
		inverseJoinColumns={@JoinColumn(name="student_id")}   //�Է����Ӧ���ֶ���
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
