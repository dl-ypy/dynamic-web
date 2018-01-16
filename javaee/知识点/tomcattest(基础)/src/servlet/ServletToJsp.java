package servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletToJsp extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp){
		try
		{
			resp.setContentType("text/html;charset=utf-8");
			req.setAttribute("name", "ServletToJsp");
			getServletConfig().getServletContext().getRequestDispatcher("/jsp base/ServletToJSP/Show.jsp").forward(req, resp);
			//servlet×ªµ½jsp
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
}
