import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//ͨ���˳�����servlet����������
public class MyServlet extends HttpServlet {
    @Override
    //��������ʱ����
	public void destroy() {
    	System.out.println("destroy");
	}

	//���췽�� 
	public MyServlet() {
		System.out.println("���캯����");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet!");
	}

	@Override
	//init����ֻ�ڳ�ʼ����ʱ��ִ��һ��
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init");
	}

}
