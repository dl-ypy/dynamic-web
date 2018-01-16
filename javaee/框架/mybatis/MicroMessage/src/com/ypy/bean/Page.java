package com.ypy.bean;
/**
 * ��ҳ��ʵ����
 */
public class Page {
	//��ҳʱҪ�ӵڼ�����¼��ʼ
	private int dbIndex;
	//ÿҳ�ż�����¼
	private int dbNumber;
	//������
	private int totalNumber;
	//��ǰ�ڼ�ҳ
	private int currentPage;
	//��ҳ��
	private int totalPage;
	//ÿҳ��ʾ����
	private int pageNumber = 3;
	
	//������ҳ����
	public void count() {
		//������ҳ��
		int totalPageTemp = this.totalNumber / this.pageNumber;
		int plus = (this.totalNumber % this.pageNumber) == 0?0:1;
		totalPageTemp = totalPageTemp + plus;
		if (totalPageTemp <= 0) {
			totalPageTemp = 1;//���Ϊ0��������ҳ��Ϊ1
		}
		this.totalPage = totalPageTemp;
		
		//���õ�ǰҳ��
		if (this.totalPage < this.currentPage) {
			this.currentPage = this.totalPage;
		}
		if (this.currentPage < 1) {
			this.currentPage = 1;
		}
		
		//����limit�Ĳ���
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
