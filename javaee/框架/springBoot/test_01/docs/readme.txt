springboot+mybatis+thymeleaf+mysql实现简单增删改查

配置：
	1.https://start.spring.io/构建springboot项目
	2.将构建好的项目以maven工程导入
	3.配置pom文件
	4.配置mybatis的配置文件
	5.配置application.properties文件
	
注意：
	1.controller跳转到前台页面：需要引入thymeleaf引擎，导入相关jar包，配置application.properties文件，将前台页面放入templates文件夹下。
	2.加入thymeleaf引擎后，controller要想返回字符串，需要加注解@ResponseBoday
	3.controller将信息传入前台，用.addAttribute
	4.controller跳转到controller，使用重定向
	
测试：
	1.运行启动类
	2.输入http://localhost:8088/query