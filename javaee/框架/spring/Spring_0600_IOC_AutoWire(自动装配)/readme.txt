�Զ�װ��

1.����beans.xml��
	<bean id="userDao" class="com.ypy.dao.impl.UserDaoImpl">
        <property name="daoId" value="1"></property>
    </bean>
    
    <bean id="userDao1" class="com.ypy.dao.impl.UserDaoImpl">
        <property name="daoId" value="2"></property>
    </bean>
    													<!-- ͨ�����ֲ��ң���ʵ����ͨ�����ֲ��ҵ���Ӧ������userDao�����������valueΪ1
    													����ͨ�����Ͳ��ҵ�byType��ƥ�������ֻ����һ����������������ͬ�����ͣ�����ᱨ�� -->
    <bean id="userService" class="com.ypy.service.UserService" autowire="byName">
    </bean>
    
	
2.��UserDaoImpl.java����������Լ���Ӧ��set��get������toString������


���ԣ�ִ��JUnit  UserServiceTest.java