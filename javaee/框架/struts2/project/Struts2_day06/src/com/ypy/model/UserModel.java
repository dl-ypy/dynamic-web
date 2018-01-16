package com.ypy.model;

public class UserModel {
	private int userid;
	private String username;
	private String password;
	private String truename;
	@Override
	public String toString() {
		return "UserModel [userid=" + userid + ", username=" + username + ", password=" + password + ", truename="
				+ truename + "]";
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
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
	public String getTruename() {
		return truename;
	}
	public void setTruename(String truename) {
		this.truename = truename;
	}
	public UserModel() {
		super();
	}
	public UserModel(int userid, String username, String password, String truename) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.truename = truename;
	}
}
