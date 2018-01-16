spring����hibernate


1.����beans.xml��
	<?xml version="1.0" encoding="UTF-8"?>
	<beans xmlns="http://www.springframework.org/schema/beans"
	    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	    xmlns:context="http://www.springframework.org/schema/context"
	    xmlns:aop="http://www.springframework.org/schema/aop"
	    xsi:schemaLocation="http://www.springframework.org/schema/beans
	        http://www.springframework.org/schema/beans/spring-beans.xsd
	         http://www.springframework.org/schema/context
	        http://www.springframework.org/schema/context/spring-context.xsd
	        http://www.springframework.org/schema/aop
	        http://www.springframework.org/schema/aop/spring-aop-4.3.xsd">
	        
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
		<context:property-placeholder location="jdbc.properties"/>
		
		<bean id="sessionFactory" class="org.springframework.orm.hibernate5.LocalSessionFactoryBean">
	        <property name="dataSource" ref="dataSource"/>
	        
	        <!-- ɨ��ʵ���� -->
	        <property name="packagesToScan">
	            <list>
	                <value>com.ypy.model</value> <!-- ע�⣺�����ǰ����������������������������� -->
	            </list>
	        </property>
	        
	        <!-- ����hibernate -->
	        <property name="hibernateProperties">
	            <props>  
	                <prop key="hibernate.dialect">org.hibernate.dialect.MySQLDialect</prop>  
	                <prop key='hibernate.hbm2ddl.auto'>update</prop>
	                <prop key="hibernate.show_sql">true</prop>  
	                <prop key="hibernate.format_sql">true</prop>  
	            </props>  
	        </property>
	    </bean>
	    
	</beans>



2.�����������⣬ֻ����spring_hibernate��JUnit4��MySQL_jdbc  ��ע��spring_hibernate�е����hibernate-core.Final.jar��5.0.12�ģ������5.2.4�ģ��ͻ����



3.����UserDaoImpl.java�� User.java��

    
���ԣ�ִ��JUnit  UserServiceTest.java
	���ܣ������ݿⲢ�����Ϣ��