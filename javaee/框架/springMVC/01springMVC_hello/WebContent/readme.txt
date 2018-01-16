配置方式写SpringMVC（参考spring-framework-4.0.0.RELEASE\docs\spring-framework-reference\html下的index.html）

1.新建项目的时候要勾选web.xml

2.导入jar包：commons-logging-1.1.3.jar（struts2中的包）
		   jstl-1.2.jar（jstl中的包）
		   spring-beans-4.0.0.RELEASE.jar
		   spring-context-4.0.0.RELEASE.jar
		   spring-context-support-4.0.0.RELEASE.jar
		   spring-core-4.0.0.RELEASE.jar
		   spring-expression-4.0.0.RELEASE.jar
		   spring-web-4.0.0.RELEASE.jar
		   spring-webmvc-4.0.0.RELEASE.jar
		   standard-1.1.2.jar（jstl中的包）
		   
3.配置web.xml:
	<servlet>
      <servlet-name>springmvc</servlet-name>
      <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
      <load-on-startup>1</load-on-startup>
   </servlet>
   <servlet-mapping>
      <servlet-name>springmvc</servlet-name>
      <url-pattern>*.do</url-pattern>
   </servlet-mapping>
4.创建java文件

5.在WEB-INF文件下新建springmvc（与web.xml中的servlet-name相同）-servlet.xml文件

6.配置springmvc-servlet.xml:
	<beans xmlns="http://www.springframework.org/schema/beans"
	    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	    xmlns:p="http://www.springframework.org/schema/p"
	    xmlns:context="http://www.springframework.org/schema/context"
	    xsi:schemaLocation="
	        http://www.springframework.org/schema/beans
	        http://www.springframework.org/schema/beans/spring-beans.xsd
	        http://www.springframework.org/schema/context
	        http://www.springframework.org/schema/context/spring-context.xsd">
	    <!-- 配置handlerMapping -->
	    <bean class="org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping"/>
	    <!-- 配置handlerAdapter -->
	    <bean class="org.springframework.web.servlet.mvc.SimpleControllerHandlerAdapter"/>
	    <!-- 配置渲染器 -->
	    <bean id="jspViewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver">
		    <property name="viewClass" value="org.springframework.web.servlet.view.JstlView"/>
		    <!-- 结果视图的前缀 -->
		    <property name="prefix" value="/WEB-INF/jsp/"/>
		    <!-- 结果视图的后缀 -->
		    <property name="suffix" value=".jsp"/>
		</bean>
		<!-- 配置请求和处理器 -->
		<bean name="/hello.do" class="com.ypy.controller.HelloController"/>
	</beans>
	
7.在WEB-INF目录下新建jsp目录，下面新建jsp文件

8.测试:http://localhost:8080/01springMVC_hello/hello.do