springMVC + spring + mybatis



���ã�1.�������

	2.����web.xml:
		<!-- spring ���� -->
	  	<listener>
			<listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
		</listener>
		<context-param>
			<param-name>contextConfigLocation</param-name>
			<param-value>/WEB-INF/applicationContext*.xml</param-value>
		</context-param>
		  <!-- springMVC ���� -->
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
		  
	3.����applicationContext.xml��jdbc.properties
		<?xml version="1.0" encoding="UTF-8"?>
		<beans xmlns="http://www.springframework.org/schema/beans"
		    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
		    xmlns:context="http://www.springframework.org/schema/context"
		    xmlns:aop="http://www.springframework.org/schema/aop"
		    xmlns:tx="http://www.springframework.org/schema/tx"
		    xsi:schemaLocation="http://www.springframework.org/schema/beans
		        http://www.springframework.org/schema/beans/spring-beans.xsd
		         http://www.springframework.org/schema/context
		        http://www.springframework.org/schema/context/spring-context.xsd
		        http://www.springframework.org/schema/aop
		        http://www.springframework.org/schema/aop/spring-aop-4.3.xsd
		        http://www.springframework.org/schema/tx
		        http://www.springframework.org/schema/tx/spring-tx.xsd">
		    <context:annotation-config/>
		    <context:component-scan base-package="com.ypy"/>  
		    <!-- �������ݿ� -->
			<bean id="dataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource" destroy-method="close">
			    <property name="driverClass" value="${jdbc.driverClassName}"/>
			    <property name="jdbcUrl" value="${jdbc.url}"/>
			    <property name="user" value="${jdbc.username}"/>
			    <property name="password" value="${jdbc.password}"/>
			</bean>
			<!-- �������ݿ�ľ������� -->
			<context:property-placeholder location="classpath:jdbc.properties"/>
			<!-- <bean class="org.springframework.beans.factory.config.PropertyPlaceholderConfigurer">
			    <property name="location" value="classpath:jdbc.properties"></property>
			</bean> -->
			<!-- ���ù��� -->
			<bean id="sqlsessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
		        <property name="dataSource" ref="dataSource"/>
		        <property name="configLocation" value="classpath:mybatis.cfg.xml"></property>
		    </bean>
			<!-- ��������-->
			<bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
		        <property name="dataSource" ref="dataSource"/>
		    </bean>
			<tx:advice id="txActive" transaction-manager="transactionManager">
			    <tx:attributes>
			        <tx:method name="save" propagation="REQUIRED"/>
			        <tx:method name="get" read-only="true"/>
			        <tx:method name="*" propagation="REQUIRED"/>
			    </tx:attributes>
			</tx:advice>
			<aop:config>
			    <aop:pointcut expression="execution(* com.ypy.service.impl.*.*(..))" id="pointcut"/>
			    <aop:advisor advice-ref="txActive" pointcut-ref="pointcut"/>
			</aop:config>
		</beans>
		
	4.����mvc.xml:
		<?xml version="1.0" encoding="UTF-8"?>
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
		    <!-- <mvc:interceptors>
		        <mvc:interceptor>
		            /**����·��������·��
		            <mvc:mapping path="/**"/>
		            <bean class="com.ypy.interceptor.MyInterceptor">
		                <property name="allowedPass">
		                    <list>
		                        <value>login.do</value>
		                    </list>   ��ʾlogin.do��������
		                </property>
		            </bean>
		        </mvc:interceptor>
		    </mvc:interceptors> -->
			<!-- ɨ��ð��µ�ע�� -->
			<context:component-scan base-package="com.ypy.controller"/>
		</beans>
		
	5.����mybatis.cfg.xml��User.xml��
		mybatis.cfg.xml:
			<?xml version="1.0" encoding="UTF-8" ?>
			<!DOCTYPE configuration
			    PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
			    "http://mybatis.org/dtd/mybatis-3-config.dtd">
			<configuration>
			  <typeAliases>
			      <package name="com.ypy.model"/>
			  </typeAliases> 
			  <!-- ���ö�Ӧ��User.xml -->
			  <mappers>
			      <mapper resource="com/ypy/model/User.xml"/>
			  </mappers>
			</configuration>
		User.xml:
			<?xml version="1.0" encoding="UTF-8"?>
			<!DOCTYPE mapper
			    PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
			    "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
			<mapper namespace="com.ypy.model.User">
				<select id="list" resultType="User">
				    select * from user
				</select>
			</mapper>
			
	6.��д����
			



���ԣ�http://localhost:8080/11springMVC_LoginInterceptor/list.do



���ܣ���ѯspring���ݿ��µ�user��