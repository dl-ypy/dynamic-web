spring整合hibernate


1.更改beans.xml：
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
		
	    <!-- 配置数据库 -->
		<bean id="dataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource" destroy-method="close">
		    <property name="driverClass" value="${jdbc.driverClassName}"/>
		    <property name="jdbcUrl" value="${jdbc.url}"/>
		    <property name="user" value="${jdbc.username}"/>
		    <property name="password" value="${jdbc.password}"/>
		</bean>
		<!-- 引入数据库的具体配置 -->
		<context:property-placeholder location="jdbc.properties"/>
		
		<bean id="sessionFactory" class="org.springframework.orm.hibernate5.LocalSessionFactoryBean">
	        <property name="dataSource" ref="dataSource"/>
	        
	        <!-- 扫描实体类 -->
	        <property name="packagesToScan">
	            <list>
	                <value>com.ypy.model</value> <!-- 注意：这里是包名，不是类名！！！！！！！！ -->
	            </list>
	        </property>
	        
	        <!-- 配置hibernate -->
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



2.调整导入的类库，只导入spring_hibernate、JUnit4、MySQL_jdbc  （注：spring_hibernate中导入的hibernate-core.Final.jar是5.0.12的，如果是5.2.4的，就会出错）



3.更改UserDaoImpl.java， User.java。

    
测试：执行JUnit  UserServiceTest.java
	功能：建数据库并添加信息。