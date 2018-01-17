springboot+mybatis+thymeleaf+mysql实现简单增删改查

配置：
	1.https://start.spring.io/构建springboot项目
	2.将构建好的项目以maven工程导入
	3.配置pom文件
	4.配置mybatis的配置文件
	5.配置application.properties文件
	
注意：
	1.controller跳转到前台页面：
	方法一：需要引入thymeleaf引擎，导入相关jar包，配置application.properties文件，将前台页面放入templates文件夹下。
	方法二：
	在properties文件中配置：
	# 配置jsp文件的位置，默认位置为：src/main/webapp
	spring.mvc.view.prefix=/page/
	# 配置jsp文件的后缀
	spring.mvc.view.suffix=.jsp
	新建webapp文件夹。
        pom文件中引入依赖：
	<!-- 添加 tomcat 的支持 -->  
		<dependency>  
		    <groupId>org.springframework.boot</groupId>  
		    <artifactId>spring-boot-starter-tomcat</artifactId>  
		    <scope>provided</scope>  
		</dependency>  
		  
		<dependency>  
		    <groupId>org.apache.tomcat.embed</groupId>  
		    <artifactId>tomcat-embed-jasper</artifactId>  
		    <scope>provided</scope>  
		</dependency>  
		  
		<!-- servlet 依赖 -->  
		<dependency>  
		    <groupId>javax.servlet</groupId>  
		    <artifactId>javax.servlet-api</artifactId>  
		    <scope>provided</scope>  
		</dependency>  
		  
		<!-- 添加 JSTL 支持 -->  
		<dependency>  
		    <groupId>javax.servlet</groupId>  
		    <artifactId>jstl</artifactId>  
		</dependency>  
	2.加入thymeleaf引擎后，controller要想返回字符串，需要加注解@ResponseBoday
	3.controller将信息传入前台，用.addAttribute
	4.controller跳转到controller，使用重定向
	
测试：
	1.运行启动类
	2.输入http://localhost:8088/query