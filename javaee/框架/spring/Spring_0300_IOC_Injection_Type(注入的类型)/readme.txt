springע�������

1.ͨ��set����ע�룺��Ҫ��set�����������й��췽��������Ҫ��
	<bean id="userService" class="com.ypy.service.UserService">
		<property name="userdao" ref="u"/>
    </bean>
	
2.ͨ�����췽��ע�룺��Ҫ�й��췽����
	<bean id="userService" class="com.ypy.service.UserService">
		<constructor-arg>
		    <ref bean="u"/>
		</constructor-arg>
    </bean>
    
3.�ӿ�ע��... ������Ҫ��

4.���ԣ�ִ��JUnit  UserServiceTest.java