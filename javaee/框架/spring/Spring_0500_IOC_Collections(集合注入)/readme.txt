���ϵ�ע��

1.����beans.xml��
	<!-- id��name -->
    <bean id="userDao" class="com.ypy.dao.impl.UserDaoImpl">
        <property name="sets">   <!-- setsΪ������ -->
            <set>
                <value>1</value>   <!-- ͨ��set������ֵ -->
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
	
2.��UserDaoImpl.java����Ӽ��������Լ���Ӧ��set��get������toString������


���ԣ�ִ��JUnit  UserServiceTest.java