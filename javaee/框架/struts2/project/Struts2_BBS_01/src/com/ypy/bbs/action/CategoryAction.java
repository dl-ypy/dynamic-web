package com.ypy.bbs.action;

import java.util.*;
import com.opensymphony.xwork2.ActionSupport;
import com.ypy.bbs.model.Category;
import com.ypy.bbs.service.CategoryService;

public class CategoryAction extends ActionSupport{
	private List<Category> categories;
	private CategoryService categoryservice = new CategoryService();
	private Category category;
	private int id;
	
	public List<Category> getCategories() {
		return categories;
	}
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	public CategoryService getCategoryservice() {
		return categoryservice;
	}
	public void setCategoryservice(CategoryService categoryservice) {
		this.categoryservice = categoryservice;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String list() throws Exception{
		categories = categoryservice.select();
		return SUCCESS;
	}
	public String update(){
		categoryservice.update(category);
		return SUCCESS;
	}
	public String add(){
		categoryservice.add(category);
		return SUCCESS;
	}
	public String delete(){
		categoryservice.deleteById(id);
		return SUCCESS;
	}
	public String updateInput(){
		this.category = this.categoryservice.loadById(id);
		return INPUT;
	}
	public String addInput(){
		return INPUT;
	}
}
