package com.ypy.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

@org.springframework.stereotype.Controller
public class HelloController {

	@RequestMapping("/ajax")
	public void ajax(HttpServletResponse resp, String name) throws IOException {
		if ("ypy".equals(name)) {
			resp.getWriter().println("true");
		} else {
			resp.getWriter().println("false");
		}
	}

}
