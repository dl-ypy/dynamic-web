SSH框架历史六：加入spring



描述：1.spring结合hibernate。
	2.注入userDao。
	3.spring结合Struts2。
	4.注入Struts的action（spring帮助Struts产生action）。



配置：
	1.导入spring包。
	
	2.创建beans.xml、jdbc.properties文件，删除hibernate.cfg.xml文件。
	
	3.更改UserManagerImpl.java，对userDao进行依赖注入。（注：用HibernateTmplate的save、find等一些方法时，要对其进行事物处理，否则会出错）
		
		此时可以先写一个Junit对userDao的注入进行测试。
	
	4.配置web.xml。
		<!-- 配置spring結合Struts2 -->
		<listener>
			<listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
		</listener>
		<context-param>
			<param-name>contextConfigLocation</param-name>
			<!-- 默认为WEB-INF/applicationContext*.xml -->
			<!-- <param-value>/WEB-INF/applicationContext*.xml</param-value> -->
			<param-value>classpath:beans.xml</param-value>
		</context-param>
		
	5.更改UserAction.java，对Struts2的action进行依赖注入。
	
	6.导入struts2-spring-plugin-2.3.4.1.jar包（注：有的版本的会出错）。



功能：用户注册。



测试：通过jsp页面测试。