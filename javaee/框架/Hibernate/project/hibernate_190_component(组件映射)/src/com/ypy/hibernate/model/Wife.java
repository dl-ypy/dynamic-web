package com.ypy.hibernate.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;

public class Wife {
	private String wifeName;
	
	public String getWifeName() {
		return wifeName;
	}
	public void setWifeName(String WifeName) {
		this.wifeName = WifeName;
	}
	
	
}
