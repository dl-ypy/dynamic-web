拦截器应用--登录

测试：http://localhost:8080/10springMVC_LoginInterceptor/login.jsp
	访问该网页时，后台会访问login.do，因为在mvc.xml中配置的login.do是不被拦截的，所以通过。
	如果name=ypy&&password=1234，登录到index页面，否则重定向到login.jsp。
	没有成功登录的时候，访问add.do，就会被拦截，重定向到login.jsp页面，
	如果成功登录了，访问add.do，就能成功访问。