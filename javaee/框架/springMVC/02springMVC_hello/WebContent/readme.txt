注解方式写SpringMVC（参考spring-framework-4.3.3.RELEASE\docs\spring-framework-reference\html下的index.html）

1.新建项目的时候要勾选web.xml

2.导入jar包：commons-logging-1.1.3.jar（struts2中的包）
		   jstl-1.2.jar（jstl中的包）
		   spring-beans-4.3.3.RELEASE.jar
		   spring-context-4.3.3.RELEASE.jar
		   spring-context-support-4.3.3.RELEASE.jar
		   spring-core-4.3.3.RELEASE.jar
		   spring-expression-4.3.3.RELEASE.jar
		   spring-web-4.3.3.RELEASE.jar
		   spring-webmvc-4.3.3.RELEASE.jar
		   standard-1.1.2.jar（jstl中的包）
		   spring-aop-4.3.3.RELEASE.jar（新加的）
		   
3.配置web.xml:
	<display-name>02springMVC_hello</display-name>
  <servlet>
    <servlet-name>springmvc</servlet-name>
    <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
    <init-param>
      <param-name>contextConfigLocation</param-name>
      <param-value>classpath:mvc.xml</param-value>
    </init-param>
    <load-on-startup>1</load-on-startup>
  </servlet>
  <servlet-mapping>
    <servlet-name>springmvc</servlet-name>
    <url-pattern>*.do</url-pattern>
  </servlet-mapping>
  
4.创建java文件（要写注解）

5.在src文件下新建xxx.xml文件(要与web.xml中配置的名称相同)(注：不要建到包下)

6.配置xxx.xml:
	<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:p="http://www.springframework.org/schema/p"
    xmlns:context="http://www.springframework.org/schema/context"
    xsi:schemaLocation="
        http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd">
    <bean id="jspViewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver">
	    <property name="viewClass" value="org.springframework.web.servlet.view.JstlView"/>
	    <!-- 结果视图的前缀 -->
	    <property name="prefix" value="/WEB-INF/jsp/"/>
	    <!-- 结果视图的后缀 -->
	    <property name="suffix" value=".jsp"/>
	</bean>
	<!-- 扫描该包下的注解 -->
	<context:component-scan base-package="com.ypy.controller"/>
</beans>
	
7.在WEB-INF目录下新建jsp目录，下面新建jsp文件

8.测试:http://localhost:8080/02springMVC_hello/hello.do