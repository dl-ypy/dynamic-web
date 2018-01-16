package xiangmu3servlet;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xiangmu2.dao.UserDao;
import com.xiangmu2.yh.Yhgl;

/**
 * Servlet implementation class ServletUser
 */
public class ServletUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//get方式提交
		this.doPost(request, response);//也执行doPost方法
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try
		{
			HttpSession session = request.getSession();//能够用session
			request.setCharacterEncoding("utf-8");
			Yhgl yh = new Yhgl();
			UserDao user = new UserDao();
			yh.setUsername(request.getParameter("username"));
			yh.setPassword(request.getParameter("password"));
			yh.setType(request.getParameter("type"));
			ResultSet rs = user.Panduan(yh);      //调用方法
			//System.out.println(request.getParameter("username"));
			if (rs.next())
			{
				if (rs.getString("type").equals("管理员"))
				{
					session.setAttribute("userid", rs.getString("id"));//得到数据库中对应记录的id值
					session.setAttribute("username", rs.getString("username"));//提高安全性
					response.sendRedirect("houtai.jsp");
				}
				else
				{
					session.setAttribute("userid", rs.getString("id"));
					session.setAttribute("username", rs.getString("username"));
					response.sendRedirect("houtai1.jsp");
				}
			}
			else
			{
				response.sendRedirect("Shuaxin.jsp");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
