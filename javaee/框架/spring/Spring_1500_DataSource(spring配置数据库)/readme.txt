spring配置数据库

1.更改beans.xml：
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
		
		<bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
		    <property name="driverClassName" value="com.mysql.jdbc.Driver"/>
		    <property name="url" value="jdbc:mysql://localhost:3306/spring"/>
		    <property name="username" value="root"/>
		    <property name="password" value="12345678900"/>
		</bean>
	</beans>


2.导入连接数据库的包。


3.创建数据库。


4.更改UserDaoImpl.java。

    
测试：执行JUnit  UserServiceTest.java
	功能：往数据库中添加一条信息。