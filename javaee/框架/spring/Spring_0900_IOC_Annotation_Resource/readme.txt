ע��֮@Resource (����)  ע�����û��Դ�룬��ֻ��ʹ��xml��

1.����beans.xml��
	<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:context="http://www.springframework.org/schema/context"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
         http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd">
        
    <context:annotation-config/>      ���������Ҳ���ԣ���������������������������������������
	    <bean id="userDao" class="com.ypy.dao.impl.UserDaoImpl">
	    </bean>
	    <bean id="u" class="com.ypy.dao.impl.UserDaoImpl">
	    </bean>
	    <bean id="userService" class="com.ypy.service.UserService">
	        <!-- ���ﲢû��ע�룬����ͨ��ע��ע�� -->
	    </bean>
	</beans>
    
2.��UserService.java�е�setUserDao���������ע�⡣


���ԣ�ִ��JUnit  UserServiceTest.java