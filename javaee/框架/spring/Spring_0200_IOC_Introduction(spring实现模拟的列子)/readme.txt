springʵ���ϸ�ģ��spring��Ŀ�Ĺ���

1.���ã�
	��������һ���Ŀ->Build Path->Add Library->User Library�½�һ���⣬����ⲿjar��
		spring-framework�е�һЩ��
		����Struts2�е�commons-logging��
	��дjava,beans.xml��Ҫ����srcĿ¼�£��ο�api�ĵ������ļ���
		<?xml version="1.0" encoding="UTF-8"?>
		<beans xmlns="http://www.springframework.org/schema/beans"
		    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
		    xsi:schemaLocation="http://www.springframework.org/schema/beans
		        http://www.springframework.org/schema/beans/spring-beans.xsd">
		    <bean id="u" class="com.ypy.dao.impl.UserDaoImpl"></bean>
		    <bean id="userService" class="com.ypy.service.UserService">
				<property name="userdao" ref="u"/>
		    </bean>
		</beans>
	�½����ԣ���Ŀ�½� Source Folder���½����������½�JUnit��
	
2.���ԣ�ִ��JUnit  UserServiceTest.java

3.�����ջ񣺽������jar����API�ĵ�����������
		   �һ�jar��->Properties->javadoc Location  ����api�ĵ�����f1���ܲ鿴�ĵ���