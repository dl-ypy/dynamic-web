package com.ypy.service;

import com.ypy.model.User;

/**
 * 分页时的一些业务
 * @author ypy
 */
public class PagingService {
	/**
	 * 计算总页数
	 * @param allrecords 总记录数
	 * @return 总页数
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
	 * 分页时判断用户身份，得到要跳转的页面名字
	 * @param status 用户身份
	 * @return 页面名字
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
