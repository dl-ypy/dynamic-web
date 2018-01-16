注解之@Resource (常用)  注：如果没有源码，就只能使用xml。

1.更改beans.xml：
	<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:context="http://www.springframework.org/schema/context"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
         http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd">
        
    <context:annotation-config/>      （这个不加也可以？？？？？？？？？？？？？？？？？？？）
	    <bean id="userDao" class="com.ypy.dao.impl.UserDaoImpl">
	    </bean>
	    <bean id="u" class="com.ypy.dao.impl.UserDaoImpl">
	    </bean>
	    <bean id="userService" class="com.ypy.service.UserService">
	        <!-- 这里并没有注入，而是通过注解注入 -->
	    </bean>
	</beans>
    
2.在UserService.java中的setUserDao方法上添加注解。


测试：执行JUnit  UserServiceTest.java