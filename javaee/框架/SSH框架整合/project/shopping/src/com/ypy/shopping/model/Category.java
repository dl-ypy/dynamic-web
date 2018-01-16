package com.ypy.shopping.model;

/**
 * Category entity. @author MyEclipse Persistence Tools
 */
public class Category extends AbstractCategory implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Category() {
	}

	/** full constructor */
	public Category(String ctype, Boolean chot, Integer aid) {
		super(ctype, chot, aid);
	}

}
