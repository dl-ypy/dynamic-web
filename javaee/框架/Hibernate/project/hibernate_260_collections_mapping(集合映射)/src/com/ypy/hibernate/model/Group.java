package com.ypy.hibernate.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MapKey;
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
	//private Set<User> user = new HashSet<User>();   //用set的原因是set中元素不会有重复
	//private List<User> user = new ArrayList<User>();
	private Map<Integer, User> user = new HashMap<Integer, User>();//<>中的Integer表示主键的类型，key可以是任何字段，但建议用主键，因为主键不会重复。
	
	@OneToMany(mappedBy="group",
			cascade={CascadeType.ALL}/*,
			fetch=FetchType.EAGER*/
	) 
	@MapKey(name="id")//用map时必须指定MapKey,也就是map中用哪个字段作为key。
	public Map<Integer, User> getUser() {
		return user;
	}
	public void setUser(Map<Integer, User> user) {
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
