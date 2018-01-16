package com.ypy.bean;

import java.util.List;

public class Command {
	private int id;
	private String name;
	private List<Command_Content> list;
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
	public List<Command_Content> getList() {
		return list;
	}
	public void setList(List<Command_Content> list) {
		this.list = list;
	}
	
}
