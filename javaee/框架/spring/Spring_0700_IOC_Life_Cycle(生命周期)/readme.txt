��������

1.����beans.xml��
	<bean id="userDao" class="com.ypy.dao.impl.UserDaoImpl">
    </bean>
    															<!-- ��init��destroy�������õ�xml�� -->
    <bean id="userService" class="com.ypy.service.UserService" init-method="init" destroy-method="destroy">
        <property name="userdao" ref="userDao"/>
    </bean>
    
	
2.��UserService.java�����init,destroy������


���ԣ�ִ��JUnit  UserServiceTest.java