package com.ypy.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ypy.bean.Message;
import com.ypy.dao.Dao;

/**
 * Servlet implementation class InsertBatchServlet
 */
@WebServlet("/InsertBatchServlet")
public class InsertBatchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertBatchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Message message = new Message();
		message.setCommand(request.getParameter("command1"));//ע������Ҫ��Ҳ����Ϊcommand,����ListServletByPage��command��ͬ��
															 //��Ϊ���ҳ�����ListServletByPage����ȥcommand��ֵ�����ListServletByPageҳ��ͻ�������ѯ��ֻ�鵽һ��
		message.setDescription(request.getParameter("description"));
		message.setContent(request.getParameter("content"));
		List<Message> list = new ArrayList<Message>();
		list.add(message);
		new Dao().insertBatch(list);
		request.getRequestDispatcher("ListByPageServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
