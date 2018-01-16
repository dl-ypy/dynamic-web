package com.ypy.hibernate.model;

import java.io.Serializable;

//联合主键的类
//@Embeddable   //可以被嵌入     实现联合主键方式一
public class TeacherPK implements Serializable{
	private int id;
	private String name;
	
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
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof StudentPK) {   //Java 中的instanceof 运算符是用来在运行时指出对象是否是特定类的一个实例
			StudentPK pk = (StudentPK)o;
			if (this.id == pk.getId() && this.name == pk.getName()) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return this.name.hashCode();
	}
}
