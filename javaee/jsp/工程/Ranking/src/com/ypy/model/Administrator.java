package com.ypy.model;
/**
 * 管理员类
 * @author ypy
 */
public class Administrator {
	private int id;
	private String username;
	private String password;
	public static int PAGE_SIZE = 5;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
