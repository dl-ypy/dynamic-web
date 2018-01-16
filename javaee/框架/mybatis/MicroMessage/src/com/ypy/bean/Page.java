package com.ypy.bean;
/**
 * 分页的实体类
 */
public class Page {
	//分页时要从第几条记录开始
	private int dbIndex;
	//每页放几条记录
	private int dbNumber;
	//总条数
	private int totalNumber;
	//当前第几页
	private int currentPage;
	//总页数
	private int totalPage;
	//每页显示条数
	private int pageNumber = 3;
	
	//计算总页数等
	public void count() {
		//计算总页数
		int totalPageTemp = this.totalNumber / this.pageNumber;
		int plus = (this.totalNumber % this.pageNumber) == 0?0:1;
		totalPageTemp = totalPageTemp + plus;
		if (totalPageTemp <= 0) {
			totalPageTemp = 1;//如果为0，设置总页数为1
		}
		this.totalPage = totalPageTemp;
		
		//设置当前页数
		if (this.totalPage < this.currentPage) {
			this.currentPage = this.totalPage;
		}
		if (this.currentPage < 1) {
			this.currentPage = 1;
		}
		
		//设置limit的参数
		this.dbIndex = (this.currentPage - 1) * this.pageNumber;
		this.dbNumber = this.pageNumber;
	}
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public int getTotalNumber() {
		return totalNumber;
	}
	public void setTotalNumber(int totalNumber) {
		this.totalNumber = totalNumber;
	}
	public int getDbIndex() {
		return dbIndex;
	}
	public void setDbIndex(int dbIndex) {
		this.dbIndex = dbIndex;
	}
	public int getDbNumber() {
		return dbNumber;
	}
	public void setDbNumber(int dbNumber) {
		this.dbNumber = dbNumber;
	}
	
	
}
