package com.ypy.shopping.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ypy.shopping.model.Mc;
import com.ypy.shopping.model.Page;
import com.ypy.shopping.service.impl.IMcServiceImpl;
import com.ypy.shopping.util.Util;

/**
 * Servlet implementation class McServlet
 */
@WebServlet("/McServlet")
public class McServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public McServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IMcServiceImpl impl = new IMcServiceImpl();
		query(request, response, impl);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	/**
	 * 分页查询
	 * @param request
	 * @param response
	 * @param impl
	 * @throws ServletException
	 * @throws IOException
	 */
	private void query(HttpServletRequest request, HttpServletResponse response, IMcServiceImpl impl)
			throws ServletException, IOException {
		int pageSize = Util.getPageSize(request);//动态设置每页记录数
		int currentPage = Util.getCurrentPage(request);//动态获取当前页数
		String mcname = request.getParameter("mcname");
		String flag = request.getParameter("flag");
		String price = request.getParameter("price");
		Mc mc = new Mc();
		mc.setMcname(mcname);
		mc.setFlag(flag);
		mc.setPrice(Util.strToInt(price, -1));
		Page<?> p = impl.queryPage(mc, currentPage, pageSize);
		request.setAttribute("p", p);
		request.getRequestDispatcher("/back/mc/mclist.jsp").forward(request, response);
	}

}
