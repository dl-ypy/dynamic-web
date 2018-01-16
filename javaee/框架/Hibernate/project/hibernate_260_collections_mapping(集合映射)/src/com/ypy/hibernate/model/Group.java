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
 * С���࣬����һ����
 */
@Entity
@Table(name="t_group")   //�������
public class Group {
	private int id;
	private String name;
	//private Set<User> user = new HashSet<User>();   //��set��ԭ����set��Ԫ�ز������ظ�
	//private List<User> user = new ArrayList<User>();
	private Map<Integer, User> user = new HashMap<Integer, User>();//<>�е�Integer��ʾ���������ͣ�key�������κ��ֶΣ�����������������Ϊ���������ظ���
	
	@OneToMany(mappedBy="group",
			cascade={CascadeType.ALL}/*,
			fetch=FetchType.EAGER*/
	) 
	@MapKey(name="id")//��mapʱ����ָ��MapKey,Ҳ����map�����ĸ��ֶ���Ϊkey��
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
