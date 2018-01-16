spring整合hibernate   hibernate模板


1.beans.xml新增：
	<!-- 配置hibernate模板 -->
	<bean id="hibernateTemplate" class="org.springframework.orm.hibernate5.HibernateTemplate">
	    <property name="sessionFactory" ref="sessionFactory"/>
	</bean>	



2.修改UserDaoImpl.java（本实验中只对user实体使用了hibernate模板）。

    
测试：执行JUnit  UserServiceTest.java
	功能：建数据库并添加信息。