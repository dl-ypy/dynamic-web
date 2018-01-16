提交数据的处理

1.提交普通数据
	测试：http://localhost:8080/04springMVC_data/hello.do?uname=ypy

2.提交一个对象
	测试：http://localhost:8080/04springMVC_data/user.do?id=222&name=ypy
	
将数据显示到UI层

1.通过ModelAndView(需要配置视图解析器)
	测试：http://localhost:8080/04springMVC_data/modavie.do
	
2.通过ModelMap(不需要配置视图解析器)
	测试：http://localhost:8080/04springMVC_data/modelmap.do?uname=ypy