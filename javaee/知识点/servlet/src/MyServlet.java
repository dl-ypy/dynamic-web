import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//通过此程序发现servlet的生命周期
public class MyServlet extends HttpServlet {
    @Override
    //消除对象时调用
	public void destroy() {
    	System.out.println("destroy");
	}

	//构造方法 
	public MyServlet() {
		System.out.println("构造函数！");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet!");
	}

	@Override
	//init方法只在初始化的时候执行一次
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init");
	}

}
