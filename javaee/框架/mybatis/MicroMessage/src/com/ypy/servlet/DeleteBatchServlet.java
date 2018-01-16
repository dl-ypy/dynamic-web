package com.ypy.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ypy.dao.Dao;

/**
 * Servlet implementation class DeleteBatchServlet
 */
@WebServlet("/DeleteBatchServlet")
public class DeleteBatchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteBatchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ids[] = request.getParameterValues("id");
		if (ids == null) {
			System.out.println("---------ids are null!----------");
			return;
		}
		//��Щ��Ӧ��д��ҵ������棬servlet�Ĺ���ֻ�ǽ������ݣ�����ҵ����еķ�����ҳ����ת
		//��ҵ��㸺�����dao��ķ������Լ�����һЩ����
		List<Integer> list = new ArrayList<Integer>();
		for (String id : ids) {
			list.add(Integer.parseInt(id));
		}
		new Dao().deleteBatch(list);
		request.getRequestDispatcher("ListServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
