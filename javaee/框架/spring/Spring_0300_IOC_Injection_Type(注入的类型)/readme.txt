spring注入的类型

1.通过set方法注入：（要有set方法，不能有构造方法）（重要）
	<bean id="userService" class="com.ypy.service.UserService">
		<property name="userdao" ref="u"/>
    </bean>
	
2.通过构造方法注入：（要有构造方法）
	<bean id="userService" class="com.ypy.service.UserService">
		<constructor-arg>
		    <ref bean="u"/>
		</constructor-arg>
    </bean>
    
3.接口注入... （不重要）

4.测试：执行JUnit  UserServiceTest.java