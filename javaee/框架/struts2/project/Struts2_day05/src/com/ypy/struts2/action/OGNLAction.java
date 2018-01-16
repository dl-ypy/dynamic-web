package com.ypy.struts2.action;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ModelDriven;
import com.ypy.struts2.model.UserModel;
/**
 * 只要是action中的属性都会被放到值栈
 * @author ypy
 */
public class OGNLAction implements ServletRequestAware,ModelDriven<UserModel>{
	private HttpServletRequest request;
	private UserModel model = new UserModel();
//	private String username;
	private String password;
	private List<UserModel> list;
	public void setModel(UserModel model) {
		this.model = model;
	}
	/*public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}*/
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request=request;
		
	}
	public String save(){
		model.setUsername("bbb");
//		this.username="aaa";
		HttpSession session=request.getSession();
		ServletContext appplcation=request.getServletContext();
		request.setAttribute("msg","request");
		session.setAttribute("msg", "sesstion");
		appplcation.setAttribute("msg", "application");
		list=new ArrayList<UserModel>();
		list.add(new UserModel("张三"));
		list.add(new UserModel("张三"));
		list.add(new UserModel("张三3"));
		return "success";
	}
	public String query(){
		
		return "success";
	}
	public String say(){
		return "say---------------";
	}
	public static String hello(){
		return "hello---------";
	}
	public List<UserModel> getList() {
		return list;
	}
	public void setList(List<UserModel> list) {
		this.list = list;
	}
	@Override
	public UserModel getModel() {
		return model;
	}
	
}

