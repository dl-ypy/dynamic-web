集合的注入

1.更改beans.xml：
	<!-- id即name -->
    <bean id="userDao" class="com.ypy.dao.impl.UserDaoImpl">
        <property name="sets">   <!-- sets为属性名 -->
            <set>
                <value>1</value>   <!-- 通过set方法设值 -->
                <value>2</value>
            </set>
        </property>
        <property name="lists">
            <list>
                <value>1</value>
                <value>2</value>
                <value>3</value>
            </list>
        </property>
        <property name="maps">
            <map>
                <entry key="1" value="1"></entry>
                <entry key="2" value="2"></entry>
                <entry key="3" value="3"></entry>
            </map>
        </property>
    </bean>
    
    <bean id="userService" class="com.ypy.service.UserService">
		<property name="userdao" ref="userDao"/>
    </bean>
	
2.往UserDaoImpl.java中添加集合属性以及对应的set，get方法和toString方法。


测试：执行JUnit  UserServiceTest.java