������

���ã�
1.����mvc.xml:��ע�⣺�¼���һЩ���ã�����Ҫȫ�����ƣ�
	<beans xmlns="http://www.springframework.org/schema/beans"
	    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	    xmlns:p="http://www.springframework.org/schema/p"
	    xmlns:context="http://www.springframework.org/schema/context"
	    xmlns:mvc="http://www.springframework.org/schema/mvc"
	    xsi:schemaLocation="
	        http://www.springframework.org/schema/beans
	        http://www.springframework.org/schema/beans/spring-beans.xsd
	        http://www.springframework.org/schema/context
	        http://www.springframework.org/schema/context/spring-context.xsd
	        http://www.springframework.org/schema/mvc
	        http://www.springframework.org/schema/mvc/spring-mvc.xsd">
	    <!-- ���ý��� -->
	    <mvc:interceptors>
	        <mvc:interceptor>
	            <!-- /**����·��������·�� -->
	            <mvc:mapping path="/**"/>
	            <bean class="com.ypy.interceptor.MyInterceptor">
	                
	            </bean>
	        </mvc:interceptor>
	    </mvc:interceptors>
		<!-- ɨ��ð��µ�ע�� -->
		<context:component-scan base-package="com.ypy.controller"/>
	</beans>
2.��д���������룺MyInterceptor.java
3.��дjava,jsp���롣

���ԣ�http://localhost:8080/09springMVC_intercepter/hello.do
������ڿ���̨����ʾ