package com.ypy.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AJAX
 */
@WebServlet("/AJAX")
public class AJAX extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AJAX() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.setContentType("text/html:charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		//request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String old = request.getParameter("name");
		if (old==null || "".equals(old)) {
			out.println("�û�������Ϊ��!");
		} else {
			//System.out.println(old);
			String name = URLDecoder.decode(old,"utf-8");//�����������
			if ("ypy".equals(name)) {
				out.print("�û���[" + name + "]�Ѿ����ڣ���ʹ�������û�����");
			} else {
				out.println("�û���[" + name + "]��δ���ڣ�����ע�ᣡ");
			}
		}
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
