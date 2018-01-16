package com.ypy.servlet3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class UpLoad
 */
@MultipartConfig  //�ļ��ϴ���Ҫ��ע��
@WebServlet("/UpLoad")
public class UpLoad extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpLoad() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Part part = request.getPart("files");
		System.out.println("size=" + part.getSize());  //�õ��ļ��Ĵ�С
		
		//��ȡ�ļ�����
		String fileDisposit = part.getHeader("content-disposition");
		String filename = fileDisposit.substring(fileDisposit.lastIndexOf("=")+2, fileDisposit.length()-1);
		System.out.println("filename=" + filename);
		
		//��ȡҪ���·��
		String path = this.getServletContext().getRealPath("images");
		System.out.println("path=" + path);
		
		//���ļ����浽ָ��·����
		part.write(path + "\\" + filename);
		
		//��ҳ������ʾ��ͼƬ
		PrintWriter out = response.getWriter();
		out.println("<img src='images\\"+filename+"'>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}








