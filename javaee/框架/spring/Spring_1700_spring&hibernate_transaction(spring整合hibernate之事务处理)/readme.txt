spring整合hibernate事务处理


描述：新增一个日志类，对用户类和日志类的事务进行处理。


1.beans.xml新增：
	<!-- 配置事务 将sessionFactory注给transactionManager-->
	<bean id="transactionManager" class="org.springframework.orm.hibernate5.HibernateTransactionManager">
        <property name="sessionFactory" ref="sessionFactory"/>
    </bean>
    <!-- 配置事务的管理者 -->
	<tx:annotation-driven transaction-manager="transactionManager"/>



2.新建Log.java, LogDao.java, LogDaoImpl.java,  更改UserDaoImpl.java, UserService.java。

    
测试：执行JUnit  UserServiceTest.java
	功能：建数据库并添加信息。