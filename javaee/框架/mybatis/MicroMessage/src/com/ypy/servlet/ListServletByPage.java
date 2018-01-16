package com.ypy.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ypy.bean.Message;
import com.ypy.bean.Page;
import com.ypy.dao.Dao;



/**
 * 分页查询
 */
@WebServlet("/ListByPageServlet")
public class ListServletByPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListServletByPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Message message = new Message();
		message.setCommand(request.getParameter("command"));
		Page page = new Page();
		String currentPage = request.getParameter("currentPage");
		Pattern pattern = Pattern.compile("[0-9]{1,9}");
		if (currentPage==null || !pattern.matcher(currentPage).matches()) {
			page.setCurrentPage(1);
		} else {
			page.setCurrentPage(Integer.parseInt(currentPage));
		}
		//page.count();
		
		Map<String,Object> parameter = new HashMap<>();
		parameter.put("message", message);
		parameter.put("page", page);
		//这里应该写一个业务层，来调用dao中的方法，这里就不再写了
		Dao dao = new Dao();
		List<Message> messagelistByPage = dao.selectMessageByPage(parameter);
		request.setAttribute("messagelistByPage", messagelistByPage);
		request.setAttribute("page", page);
		request.getRequestDispatcher("WEB-INF/jsp/back/listByPage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
