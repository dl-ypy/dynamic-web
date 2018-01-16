package com.shixun.servlet;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shixun.student.Daos;
import com.shixun.student.Yhs;

/**
 * Servlet implementation class Servletst
 */
public class Servletst extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servletst() {
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
			Yhs yhs = new Yhs();
			Daos daos = new Daos();
			yhs.setSt_id(request.getParameter("st_id"));
			yhs.setSt_password(request.getParameter("st_password"));
			ResultSet rs = daos.Panduan(yhs);      //���÷���
			if (rs.next())
			{		
				session.setAttribute("name", rs.getString("st_name"));//��߰�ȫ��
				session.setAttribute("userid", rs.getString("st_id"));//�õ����ݿ��ж�Ӧ��¼��idֵ
				response.sendRedirect("houtais.jsp");
				
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
