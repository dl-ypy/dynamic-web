���÷�ʽдSpringMVC���ο�spring-framework-4.0.0.RELEASE\docs\spring-framework-reference\html�µ�index.html��

1.�½���Ŀ��ʱ��Ҫ��ѡweb.xml

2.����jar����commons-logging-1.1.3.jar��struts2�еİ���
		   jstl-1.2.jar��jstl�еİ���
		   spring-beans-4.0.0.RELEASE.jar
		   spring-context-4.0.0.RELEASE.jar
		   spring-context-support-4.0.0.RELEASE.jar
		   spring-core-4.0.0.RELEASE.jar
		   spring-expression-4.0.0.RELEASE.jar
		   spring-web-4.0.0.RELEASE.jar
		   spring-webmvc-4.0.0.RELEASE.jar
		   standard-1.1.2.jar��jstl�еİ���
		   
3.����web.xml:
	<servlet>
      <servlet-name>springmvc</servlet-name>
      <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
      <load-on-startup>1</load-on-startup>
   </servlet>
   <servlet-mapping>
      <servlet-name>springmvc</servlet-name>
      <url-pattern>*.do</url-pattern>
   </servlet-mapping>
4.����java�ļ�

5.��WEB-INF�ļ����½�springmvc����web.xml�е�servlet-name��ͬ��-servlet.xml�ļ�

6.����springmvc-servlet.xml:
	<beans xmlns="http://www.springframework.org/schema/beans"
	    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	    xmlns:p="http://www.springframework.org/schema/p"
	    xmlns:context="http://www.springframework.org/schema/context"
	    xsi:schemaLocation="
	        http://www.springframework.org/schema/beans
	        http://www.springframework.org/schema/beans/spring-beans.xsd
	        http://www.springframework.org/schema/context
	        http://www.springframework.org/schema/context/spring-context.xsd">
	    <!-- ����handlerMapping -->
	    <bean class="org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping"/>
	    <!-- ����handlerAdapter -->
	    <bean class="org.springframework.web.servlet.mvc.SimpleControllerHandlerAdapter"/>
	    <!-- ������Ⱦ�� -->
	    <bean id="jspViewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver">
		    <property name="viewClass" value="org.springframework.web.servlet.view.JstlView"/>
		    <!-- �����ͼ��ǰ׺ -->
		    <property name="prefix" value="/WEB-INF/jsp/"/>
		    <!-- �����ͼ�ĺ�׺ -->
		    <property name="suffix" value=".jsp"/>
		</bean>
		<!-- ��������ʹ����� -->
		<bean name="/hello.do" class="com.ypy.controller.HelloController"/>
	</beans>
	
7.��WEB-INFĿ¼���½�jspĿ¼�������½�jsp�ļ�

8.����:http://localhost:8080/01springMVC_hello/hello.do