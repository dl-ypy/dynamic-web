springMVC + spring + mybatis



配置：1.导入包。

	2.配置web.xml:
		<!-- spring 配置 -->
	  	<listener>
			<listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
		</listener>
		<context-param>
			<param-name>contextConfigLocation</param-name>
			<param-value>/WEB-INF/applicationContext*.xml</param-value>
		</context-param>
		  <!-- springMVC 配置 -->
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
		  
	3.配置applicationContext.xml、jdbc.properties
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
		    <!-- 配置数据库 -->
			<bean id="dataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource" destroy-method="close">
			    <property name="driverClass" value="${jdbc.driverClassName}"/>
			    <property name="jdbcUrl" value="${jdbc.url}"/>
			    <property name="user" value="${jdbc.username}"/>
			    <property name="password" value="${jdbc.password}"/>
			</bean>
			<!-- 引入数据库的具体配置 -->
			<context:property-placeholder location="classpath:jdbc.properties"/>
			<!-- <bean class="org.springframework.beans.factory.config.PropertyPlaceholderConfigurer">
			    <property name="location" value="classpath:jdbc.properties"></property>
			</bean> -->
			<!-- 配置工厂 -->
			<bean id="sqlsessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
		        <property name="dataSource" ref="dataSource"/>
		        <property name="configLocation" value="classpath:mybatis.cfg.xml"></property>
		    </bean>
			<!-- 配置事务-->
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
		
	4.配置mvc.xml:
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
		    <!-- 配置截器 -->
		    <!-- <mvc:interceptors>
		        <mvc:interceptor>
		            /**包括路径及其子路径
		            <mvc:mapping path="/**"/>
		            <bean class="com.ypy.interceptor.MyInterceptor">
		                <property name="allowedPass">
		                    <list>
		                        <value>login.do</value>
		                    </list>   表示login.do不被拦截
		                </property>
		            </bean>
		        </mvc:interceptor>
		    </mvc:interceptors> -->
			<!-- 扫描该包下的注解 -->
			<context:component-scan base-package="com.ypy.controller"/>
		</beans>
		
	5.配置mybatis.cfg.xml、User.xml：
		mybatis.cfg.xml:
			<?xml version="1.0" encoding="UTF-8" ?>
			<!DOCTYPE configuration
			    PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
			    "http://mybatis.org/dtd/mybatis-3-config.dtd">
			<configuration>
			  <typeAliases>
			      <package name="com.ypy.model"/>
			  </typeAliases> 
			  <!-- 配置对应的User.xml -->
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
			
	6.编写代码
			



测试：http://localhost:8080/11springMVC_LoginInterceptor/list.do



功能：查询spring数据库下的user表。