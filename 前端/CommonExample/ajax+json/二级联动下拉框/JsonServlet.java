package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;



/**
 * Servlet implementation class JsonServlet
 */
@WebServlet("/JsonServlet")
public class JsonServlet extends HttpServlet {
	private int j;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JsonServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*List<User> list = new ArrayList<User>();
		for (int i=0; i<10; i++) {
			list.add(new User(i, "lzsx"+i, 10+i));
		}
		JSONArray js = new JSONArray(list);
		PrintWriter out = response.getWriter();
		out.print(js.toString());
		out.flush();
		out.close();*/
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
		if ("0".equals(id)) {
			request.getRequestDispatcher("/ajax.jsp").forward(request, response);
		} else if ("1".equals(id)) {
			out.write("[{\"name\":\"太原\"},{\"name\":\"大同\"},{\"name\":\"吕梁\"},]");
		} else if ("2".equals(id)) {
			out.write("[{\"name\":\"青岛\"},{\"name\":\"烟台\"},{\"name\":\"临沂\"},]");
		} else if ("3".equals(id)) {
			out.write("[{\"name\":\"西安\"},{\"name\":\"咸阳\"},{\"name\":\"延安\"},]");
		}
		out.flush();
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
