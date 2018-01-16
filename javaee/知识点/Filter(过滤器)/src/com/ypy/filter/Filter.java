package com.ypy.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class Filter
 */
@WebFilter("/*")//这里的/*表示过滤所有内容   若想只过滤jsp文件，就写为@WebFilter("*.jsp")
public class Filter implements javax.servlet.Filter {

    /**
     * Default constructor. 
     */
    public Filter() {

    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;//这里需要进行强制类型转换
		HttpServletResponse response = (HttpServletResponse)res;
		
		String uri = request.getRequestURI();//得到本页面的uri地址
		if (!uri.equals("/Filter/login.jsp") && !uri.equals("/Filter/loginServlet")){//判断此页面的地址是否是登录页面或者判断登录的Servlet
																					 //防止过滤器将登录页面和判断页面也过滤掉
																					 //uri地址是从项目名称开始的
			String username = (String)request.getSession().getAttribute("username");
			if (username == null){
				response.sendRedirect("登录页面");
				return;   //防止重定向完继续执行以下代码，使得响应了两次
			}
		}
		chain.doFilter(req, res);//过滤完要放行    上面的代码就是过滤的条件
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
