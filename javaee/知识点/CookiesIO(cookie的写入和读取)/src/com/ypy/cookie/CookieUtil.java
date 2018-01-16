package com.ypy.cookie;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

//����cookie�е��û���
public class CookieUtil {
	public static String getCookie(HttpServletRequest request, String name) {
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals(name)) {
				return cookie.getValue();
			}
		}
		return "";
	}
}
