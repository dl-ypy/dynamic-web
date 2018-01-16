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
		//get��ʽ�ύ
		this.doPost(request, response);//Ҳִ��doPost����
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
			Yhgl yh = new Yhgl();
			UserDao user = new UserDao();
			yh.setUsername(request.getParameter("username"));
			yh.setPassword(request.getParameter("password"));
			yh.setType(request.getParameter("type"));
			ResultSet rs = user.Panduan(yh);      //���÷���
			//System.out.println(request.getParameter("username"));
			if (rs.next())
			{
				if (rs.getString("type").equals("����Ա"))
				{
					session.setAttribute("userid", rs.getString("id"));//�õ����ݿ��ж�Ӧ��¼��idֵ
					session.setAttribute("username", rs.getString("username"));//��߰�ȫ��
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
