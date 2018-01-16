package com.ypy.shopping.util;

import javax.servlet.http.HttpServletRequest;

public class Util {
	/**
	 * 防止String转int出错
	 * @param str 要转的值
	 * @param defval 出错时返回的默认值
	 * @return
	 */
	public static int strToInt(String str, int defval) {
		int result = 0;
		try {
			result = Integer.parseInt(str);
		} catch (Exception e) {
			return defval;
		}
		return result;
	}
	
	/**
	 * 判断字符串是否为空
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		if (str!=null && !"".equals(str)) {
			return false;
		}
		return true;
	}
	
	/**
	 * 得到当前页数
	 * @param request
	 * @return
	 */
	public static int getCurrentPage(HttpServletRequest request) {
		String currentPage = request.getParameter("currentPage");
		if (!isEmpty(currentPage)) {
			return strToInt(currentPage, 1);
		}
		return 1;
	}
	
	/**
	 * 得到每页显示的记录数
	 * @param request
	 * @return
	 */
	public static int getPageSize(HttpServletRequest request) {
		String pageSize = request.getParameter("pageSize");
		if (!isEmpty(pageSize)) {
			return strToInt(pageSize, 5);
		}
		return 5;
	}
}
