spring����hibernate   hibernateģ��


1.beans.xml������
	<!-- ����hibernateģ�� -->
	<bean id="hibernateTemplate" class="org.springframework.orm.hibernate5.HibernateTemplate">
	    <property name="sessionFactory" ref="sessionFactory"/>
	</bean>	



2.�޸�UserDaoImpl.java����ʵ����ֻ��userʵ��ʹ����hibernateģ�壩��

    
���ԣ�ִ��JUnit  UserServiceTest.java
	���ܣ������ݿⲢ�����Ϣ��