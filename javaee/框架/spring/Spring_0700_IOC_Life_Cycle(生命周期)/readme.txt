生命周期

1.更改beans.xml：
	<bean id="userDao" class="com.ypy.dao.impl.UserDaoImpl">
    </bean>
    															<!-- 将init和destroy方法配置到xml中 -->
    <bean id="userService" class="com.ypy.service.UserService" init-method="init" destroy-method="destroy">
        <property name="userdao" ref="userDao"/>
    </bean>
    
	
2.往UserService.java中添加init,destroy方法。


测试：执行JUnit  UserServiceTest.java