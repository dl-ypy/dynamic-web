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
@MultipartConfig  //文件上传需要的注解
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
		System.out.println("size=" + part.getSize());  //得到文件的大小
		
		//获取文件名称
		String fileDisposit = part.getHeader("content-disposition");
		String filename = fileDisposit.substring(fileDisposit.lastIndexOf("=")+2, fileDisposit.length()-1);
		System.out.println("filename=" + filename);
		
		//获取要存的路径
		String path = this.getServletContext().getRealPath("images");
		System.out.println("path=" + path);
		
		//将文件保存到指定路径中
		part.write(path + "\\" + filename);
		
		//在页面上显示该图片
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








