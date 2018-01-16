拦截器用户登陆案例
使用拦截器对未登陆的用户进行拦截（即未登陆不能访问UserAction的方法）
测试：在未登陆前访问：http://localhost:8686/Struts2_day07_2/login/user_save，会提示登陆
	 注：此处指定了拦截的方法，所以访问query方法是可以通过的。
	 进行登陆：http://localhost:8686/Struts2_day07_2/login.jsp    用户名和密码：111  222
          此时再访问http://localhost:8686/Struts2_day07_2/login/user_save即可访问成功。