AOP  xml��ʽ���ã���Ҫ��    ��ע������õ�ԭ�򣺿����о���ʹ�ñ��˵Ŀ�ܣ�û��Դ�룬���Բ�����Դ����дע�⡣

1.����beans.xml��
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


2.�������
	aspectjrt.jar
	aspectjweaver.jar

    
���ԣ�ִ��JUnit  UserServiceTest.java
	���ܣ���ָ���ķ���֯��ָ���ĵط���