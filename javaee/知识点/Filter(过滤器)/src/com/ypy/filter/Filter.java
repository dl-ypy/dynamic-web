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
@WebFilter("/*")//�����/*��ʾ������������   ����ֻ����jsp�ļ�����дΪ@WebFilter("*.jsp")
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
		HttpServletRequest request = (HttpServletRequest)req;//������Ҫ����ǿ������ת��
		HttpServletResponse response = (HttpServletResponse)res;
		
		String uri = request.getRequestURI();//�õ���ҳ���uri��ַ
		if (!uri.equals("/Filter/login.jsp") && !uri.equals("/Filter/loginServlet")){//�жϴ�ҳ��ĵ�ַ�Ƿ��ǵ�¼ҳ������жϵ�¼��Servlet
																					 //��ֹ����������¼ҳ����ж�ҳ��Ҳ���˵�
																					 //uri��ַ�Ǵ���Ŀ���ƿ�ʼ��
			String username = (String)request.getSession().getAttribute("username");
			if (username == null){
				response.sendRedirect("��¼ҳ��");
				return;   //��ֹ�ض��������ִ�����´��룬ʹ����Ӧ������
			}
		}
		chain.doFilter(req, res);//������Ҫ����    ����Ĵ�����ǹ��˵�����
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
