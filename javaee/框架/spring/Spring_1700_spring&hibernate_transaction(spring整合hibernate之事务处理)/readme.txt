spring����hibernate������


����������һ����־�࣬���û������־���������д���


1.beans.xml������
	<!-- �������� ��sessionFactoryע��transactionManager-->
	<bean id="transactionManager" class="org.springframework.orm.hibernate5.HibernateTransactionManager">
        <property name="sessionFactory" ref="sessionFactory"/>
    </bean>
    <!-- ��������Ĺ����� -->
	<tx:annotation-driven transaction-manager="transactionManager"/>



2.�½�Log.java, LogDao.java, LogDaoImpl.java,  ����UserDaoImpl.java, UserService.java��

    
���ԣ�ִ��JUnit  UserServiceTest.java
	���ܣ������ݿⲢ�����Ϣ��