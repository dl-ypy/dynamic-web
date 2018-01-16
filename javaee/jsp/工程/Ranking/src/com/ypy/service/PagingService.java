package com.ypy.service;

import com.ypy.model.User;

/**
 * ��ҳʱ��һЩҵ��
 * @author ypy
 */
public class PagingService {
	/**
	 * ������ҳ��
	 * @param allrecords �ܼ�¼��
	 * @return ��ҳ��
	 */
	public int getAllPages(int allrecords) {
		int allPages = 0;
		if (allrecords%User.PAGE_SIZE == 0) {
			allPages = allrecords/User.PAGE_SIZE;
		} else {
			allPages = allrecords/User.PAGE_SIZE + 1;
		}
		return allPages;
	}
	
	/**
	 * ��ҳʱ�ж��û���ݣ��õ�Ҫ��ת��ҳ������
	 * @param status �û����
	 * @return ҳ������
	 */
	public String getFileName(String status) {
		String filename = null;
		if ("user".equals(status)) {
			filename = "User";
		} else if ("admin".equals(status)) {
			filename = "Admin";
		} else {
			filename = "";
		}
		return filename;
	}
}
