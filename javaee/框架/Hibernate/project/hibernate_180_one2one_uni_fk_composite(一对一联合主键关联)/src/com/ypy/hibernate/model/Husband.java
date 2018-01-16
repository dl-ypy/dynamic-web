package com.ypy.hibernate.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToOne;

@Entity
public class Husband {
	private int id;
	private String name;
	private Wife wife;
	
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
	
	@OneToOne
	@JoinColumns(     //设置外键，外键为一个数组，有两个元素，name表示为外键起的名字，referencedColumnName表示参考外键表中对应的字段。
		{
			@JoinColumn(name="wifeId", referencedColumnName="id"),
			@JoinColumn(name="wifeName", referencedColumnName="name")
		}
	)
	public Wife getWife() {
		return wife;
	}
	public void setWife(Wife wife) {
		this.wife = wife;
	}
	
}
