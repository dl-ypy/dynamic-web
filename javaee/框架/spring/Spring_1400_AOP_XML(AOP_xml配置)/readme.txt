AOP  xml方式配置（主要）    比注解更常用的原因：开发中经常使用别人的框架，没有源码，所以不能在源码内写注解。

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
		
		<bean id="logInterceptor" class="com.ypy.aop.LogInterceptor"></bean>
		<aop:config>
		    <aop:aspect id="logAspect" ref="logInterceptor">
		        <aop:before method="before" pointcut="execution(public * com.ypy.dao.impl..*.*(..))"/>
		        <aop:after method="after" pointcut="execution(public * com.ypy.dao.impl..*.*(..))"/>
		    </aop:aspect>
		</aop:config>
	</beans>


2.导入包：
	aspectjrt.jar
	aspectjweaver.jar

    
测试：执行JUnit  UserServiceTest.java
	功能：将指定的方法织入指定的地方。