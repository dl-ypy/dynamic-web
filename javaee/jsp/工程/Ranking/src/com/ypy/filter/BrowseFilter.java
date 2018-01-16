package com.ypy.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * �������������֤��¼��߲��������
 */
@WebFilter("*.jsp")  //ֻ����jsp�ļ�
public class BrowseFilter implements Filter {

    /**
     * Default constructor. 
     */
    public BrowseFilter() {
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		String uri = req.getRequestURI();
		if (!"/Ranking/login.jsp".equals(uri) && !"/Ranking/register.jsp".equals(uri)) {   //�Է�ע���û����й���   ���û�������û���¼���û�ע��ҳ��
			String username = (String) req.getSession().getAttribute("username");
			if (username == null) {
				resp.sendRedirect("login.jsp");
				return;
				
				//�Էǹ���Ա�û����й���
			} else if("/Ranking/adminAdd.jsp".equals(uri) || "/Ranking/adminList.jsp".equals(uri) || "/Ranking/list.jsp".equals(uri)) {
				String adminname = (String) req.getSession().getAttribute("adminname");
				if (adminname == null) {
					resp.sendRedirect("adminLogin.jsp");
					return;
				}
			}
		}
		chain.doFilter(req, resp);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
