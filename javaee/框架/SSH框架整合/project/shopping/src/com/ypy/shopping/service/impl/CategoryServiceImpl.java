package com.ypy.shopping.service.impl;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.ypy.shopping.model.Category;


public class CategoryServiceImpl {
	private HibernateTemplate hibernateTemplate = null;
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	public void save(Category category) {
		hibernateTemplate.save(category);
	}
}
