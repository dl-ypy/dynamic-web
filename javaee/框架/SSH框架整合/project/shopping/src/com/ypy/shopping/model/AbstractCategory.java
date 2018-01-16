package com.ypy.shopping.model;

/**
 * AbstractCategory entity provides the base persistence definition of the
 * Category entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractCategory implements java.io.Serializable {

	// Fields

	private Integer cid;
	private String ctype;
	private Boolean chot;
	private Integer aid;

	// Constructors

	/** default constructor */
	public AbstractCategory() {
	}

	/** full constructor */
	public AbstractCategory(String ctype, Boolean chot, Integer aid) {
		this.ctype = ctype;
		this.chot = chot;
		this.aid = aid;
	}

	// Property accessors

	public Integer getCid() {
		return this.cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getCtype() {
		return this.ctype;
	}

	public void setCtype(String ctype) {
		this.ctype = ctype;
	}

	public Boolean getChot() {
		return this.chot;
	}

	public void setChot(Boolean chot) {
		this.chot = chot;
	}

	public Integer getAid() {
		return this.aid;
	}

	public void setAid(Integer aid) {
		this.aid = aid;
	}

}