ע�ⷽʽдSpringMVC���ο�spring-framework-4.3.3.RELEASE\docs\spring-framework-reference\html�µ�index.html��

1.�½���Ŀ��ʱ��Ҫ��ѡweb.xml

2.����jar����commons-logging-1.1.3.jar��struts2�еİ���
		   jstl-1.2.jar��jstl�еİ���
		   spring-beans-4.3.3.RELEASE.jar
		   spring-context-4.3.3.RELEASE.jar
		   spring-context-support-4.3.3.RELEASE.jar
		   spring-core-4.3.3.RELEASE.jar
		   spring-expression-4.3.3.RELEASE.jar
		   spring-web-4.3.3.RELEASE.jar
		   spring-webmvc-4.3.3.RELEASE.jar
		   standard-1.1.2.jar��jstl�еİ���
		   spring-aop-4.3.3.RELEASE.jar���¼ӵģ�
		   
3.����web.xml:
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
  
4.����java�ļ���Ҫдע�⣩

5.��src�ļ����½�xxx.xml�ļ�(Ҫ��web.xml�����õ�������ͬ)(ע����Ҫ��������)

6.����xxx.xml:
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
	    <!-- �����ͼ��ǰ׺ -->
	    <property name="prefix" value="/WEB-INF/jsp/"/>
	    <!-- �����ͼ�ĺ�׺ -->
	    <property name="suffix" value=".jsp"/>
	</bean>
	<!-- ɨ��ð��µ�ע�� -->
	<context:component-scan base-package="com.ypy.controller"/>
</beans>
	
7.��WEB-INFĿ¼���½�jspĿ¼�������½�jsp�ļ�

8.����:http://localhost:8080/02springMVC_hello/hello.do