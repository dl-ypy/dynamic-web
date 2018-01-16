package com.ypy.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class Action {
	
	@RequestMapping("/ajax.do")
	public void ajax(String msg, HttpServletResponse response) {
		PrintWriter out= null;
		try {
			System.out.println("------"+msg);
			out = response.getWriter();
			out.write(msg);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			out.flush();
			out.close();
		}
	}
}
