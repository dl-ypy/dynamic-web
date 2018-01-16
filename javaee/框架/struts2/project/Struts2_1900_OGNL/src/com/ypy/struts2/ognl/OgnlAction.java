package com.ypy.struts2.ognl;

import java.util.*;

import com.opensymphony.xwork2.ActionSupport;

public class OgnlAction extends ActionSupport{
	private String password;
	private String username;
	private User user;
	private Cat cat;
	
	private List<User> users = new ArrayList<User>();
	private Set<Dog> dogs = new HashSet<Dog>();
	private Map<String, Dog> dogMap = new HashMap<String, Dog>();
	
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public Set<Dog> getDogs() {
		return dogs;
	}

	public void setDogs(Set<Dog> dogs) {
		this.dogs = dogs;
	}

	public Map<String, Dog> getDogMap() {
		return dogMap;
	}

	public void setDogMap(Map<String, Dog> dogMap) {
		this.dogMap = dogMap;
	}

	public Cat getCat() {
		return cat;
	}

	public void setCat(Cat cat) {
		this.cat = cat;
	}

	public OgnlAction(){
		users.add(new User(1));
		users.add(new User(2));
		users.add(new User(3));
		
		dogs.add(new Dog("dog1"));
		dogs.add(new Dog("dog2"));
		dogs.add(new Dog("dog3"));
		
		dogMap.put("dog100", new Dog("dog100"));
		dogMap.put("dog101", new Dog("dog101"));
		dogMap.put("dog102", new Dog("dog102"));
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public String m(){
		return "访问的是OgnlAction.java中的m方法。";
	}
	
	@Override
	public String execute(){
		return SUCCESS;
	}
}
