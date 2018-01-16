package com.ypy.ajax;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Proxy
 */
@WebServlet("/Proxy")
public class Proxy extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Proxy() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*//post方法
		String url = request.getParameter("url");
		StringBuffer paramBuffer = new StringBuffer();*/
		
		//get方法
		StringBuilder url = new StringBuilder();
		url.append(request.getParameter("url"));
		
		Enumeration enu = request.getParameterNames();
		boolean flag = false;
		while (enu.hasMoreElements()) {
			String paramName = (String)enu.nextElement();
			if (!paramName.equals("url")) {
				String paramValue = request.getParameter(paramName);
				paramValue = URLEncoder.encode(paramValue, "utf-8");
				if (!flag) {
					/*//post方法
					paramBuffer.append(paramName).append("=").append(paramValue);*/
					
					//get方法
					url.append("?").append(paramName).append("=").append(paramValue);
				} else {
					/*//post方法
					paramBuffer.append("&").append(paramName).append("=").append(paramValue);*/
					
					//get方法
					url.append("&").append(paramName).append("=").append(paramValue);
				}
			}
		}
		//post方法
		/*response.setContentType("text/html:charset=UTF-8");
		PrintWriter out = response.getWriter();
		if (url != null && url.trim().length() > 0) {
			URL connectUrl = new URL(url);
			URLConnection connection = connectUrl.openConnection();
			connection.setDoOutput(true);
			OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
			writer.write(paramBuffer.toString());
			writer.flush();
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
			String line;
			while ((line=reader.readLine()) != null) {
				out.println(line);
			}
			writer.close();
			reader.close();
		}*/
		
		//get方法
		response.setContentType("text/html:charset=UTF-8");
		PrintWriter out = response.getWriter();
		if (url != null && url.length() > 0) {
			URL connectionUrl = new URL(url.toString());
			BufferedReader reader = new BufferedReader(new InputStreamReader(connectionUrl.openStream(), "utf-8"));
			String line;
			while ((line=reader.readLine()) != null) {
				out.println(line);
			}
			reader.close();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}






















