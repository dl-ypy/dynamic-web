package com.shixun.servlet;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shixun.teacher.Dao;
import com.shixun.teacher.Yh;

/**
 * Servlet implementation class Servletjs
 */
public class Servletjs extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servletjs() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try
		{
			HttpSession session = request.getSession();//�ܹ���session
			request.setCharacterEncoding("utf-8");
			Yh yht = new Yh();
			Dao dao = new Dao();
			yht.setTh_id(request.getParameter("th_id"));
			yht.setTh_password(request.getParameter("th_password"));
			yht.setTh_type(request.getParameter("th_type"));
			ResultSet rs = dao.Panduan(yht);      //���÷���
			if (rs.next())
			{
				if (rs.getString("th_type").equals("����Ա"))
				{
					
					session.setAttribute("name", rs.getString("th_name"));//��߰�ȫ��
					response.sendRedirect("houtaig.jsp");
				}
				else
				{
					session.setAttribute("userid", rs.getString("th_id"));//�õ����ݿ��ж�Ӧ��¼��idֵ
					session.setAttribute("name", rs.getString("th_name"));
					response.sendRedirect("houtaip.jsp");
				}
			}
			else
			{
				response.sendRedirect("Shouye.jsp");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
