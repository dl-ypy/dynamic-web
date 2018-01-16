package com.ypy.shopping.action;

import com.ypy.shopping.service.impl.CategoryServiceImpl;

public class TestAction {
	private CategoryServiceImpl categoryServiceImpl=null;
	
	public void setCategoryServiceImpl(CategoryServiceImpl categoryServiceImpl) {
		this.categoryServiceImpl = categoryServiceImpl;
	} 
	public String test() {
		System.out.println(categoryServiceImpl);
		return "success";
	}
}
