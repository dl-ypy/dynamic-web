拦截器

配置：
1.配置mvc.xml:（注意：新加了一些配置，所以要全部复制）
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
	    <!-- 配置截器 -->
	    <mvc:interceptors>
	        <mvc:interceptor>
	            <!-- /**包括路径及其子路径 -->
	            <mvc:mapping path="/**"/>
	            <bean class="com.ypy.interceptor.MyInterceptor">
	                
	            </bean>
	        </mvc:interceptor>
	    </mvc:interceptors>
		<!-- 扫描该包下的注解 -->
		<context:component-scan base-package="com.ypy.controller"/>
	</beans>
2.编写拦截器代码：MyInterceptor.java
3.编写java,jsp代码。

测试：http://localhost:8080/09springMVC_intercepter/hello.do
结果：在控制台中显示