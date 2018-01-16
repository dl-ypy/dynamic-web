package com.ypy.login.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

//����cookie
public class CookieUtil {
	public static String getCookie(HttpServletRequest request, String name) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(name)) {
					String username = cookie.getValue();
					try {
						//�����Ľ���ת��
						return URLDecoder.decode(username,"utf-8");
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return "";
	}
}

