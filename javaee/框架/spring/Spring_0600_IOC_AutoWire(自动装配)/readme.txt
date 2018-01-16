自动装配

1.更改beans.xml：
	<bean id="userDao" class="com.ypy.dao.impl.UserDaoImpl">
        <property name="daoId" value="1"></property>
    </bean>
    
    <bean id="userDao1" class="com.ypy.dao.impl.UserDaoImpl">
        <property name="daoId" value="2"></property>
    </bean>
    													<!-- 通过名字查找，本实验中通过名字查找到对应的属性userDao，所以输出的value为1
    													还有通过类型查找的byType，匹配的类型只能有一个，不能有两种相同的类型，否则会报错 -->
    <bean id="userService" class="com.ypy.service.UserService" autowire="byName">
    </bean>
    
	
2.往UserDaoImpl.java中添加属性以及对应的set，get方法和toString方法。


测试：执行JUnit  UserServiceTest.java