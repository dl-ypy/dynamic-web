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
	<!-- 表示从指定的包下面扫描，该包下配有@Component的资源就会被扫描到 -->
    <context:component-scan base-package="com.ypy"/> 
	</beans>
    
2.在UserService.java和UserDaoImpl.java中添加注解。


测试：执行JUnit  UserServiceTest.java