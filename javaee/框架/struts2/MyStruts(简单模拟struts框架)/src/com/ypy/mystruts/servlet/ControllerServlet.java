package com.ypy.mystruts.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ypy.mystruts.model.ActionModel;
import com.ypy.mystruts.utils.ActionMappingManager;

/**
 * Servlet implementation class ControllerServlet
 */
@WebServlet("/mvc/*")    //拦截所有带有mvc/的访问地址
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ActionMappingManager manager;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * 初始化方法，解析配置文件
	 */
	public void init(ServletConfig config) throws ServletException {
		manager = new ActionMappingManager();
		manager.init();
	}

	/**
	 * 获取请求，截取请求中的字符串，得到action和method名，处理业务
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getRequestURI();
		String actionName = path.substring(path.lastIndexOf("/")+1);   //从最后一个/开始截取
		//获取方法名
		String[] array = actionName.split("_");
		String methodName = array[1];
		ActionModel action = manager.getActionModel(actionName);
		//获取处理业务对象的类路径
		String actionClass = action.getClasses();
		try {
			//加载类并实例化对象
			Object obj = Class.forName(actionClass).newInstance();
			//获取具体处理请求的方法
			Method mothod = obj.getClass().getMethod(methodName);
			//执行方法，得到返回的result的name
			String res = (String) mothod.invoke(obj);
			//根据返回的result的name得到result的返回路径
			String resPath = action.getResultMap().get(res).getPath();
			//跳转界面
			request.getRequestDispatcher(resPath).forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
