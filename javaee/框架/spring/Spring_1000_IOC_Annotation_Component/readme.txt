ע��֮@Resource (����)  ע�����û��Դ�룬��ֻ��ʹ��xml��

1.����beans.xml��
	<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:context="http://www.springframework.org/schema/context"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
         http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd">
        
    <context:annotation-config/>      ���������Ҳ���ԣ���������������������������������������
	<!-- ��ʾ��ָ���İ�����ɨ�裬�ð�������@Component����Դ�ͻᱻɨ�赽 -->
    <context:component-scan base-package="com.ypy"/> 
	</beans>
    
2.��UserService.java��UserDaoImpl.java�����ע�⡣


���ԣ�ִ��JUnit  UserServiceTest.java