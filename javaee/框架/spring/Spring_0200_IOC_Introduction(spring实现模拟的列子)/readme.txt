spring实现上个模拟spring项目的功能

1.配置：
	导入包：右击项目->Build Path->Add Library->User Library新建一个库，添加外部jar：
		spring-framework中的一些包
		还有Struts2中的commons-logging包
	编写java,beans.xml（要建在src目录下，参考api文档）等文件：
		<?xml version="1.0" encoding="UTF-8"?>
		<beans xmlns="http://www.springframework.org/schema/beans"
		    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
		    xsi:schemaLocation="http://www.springframework.org/schema/beans
		        http://www.springframework.org/schema/beans/spring-beans.xsd">
		    <bean id="u" class="com.ypy.dao.impl.UserDaoImpl"></bean>
		    <bean id="userService" class="com.ypy.service.UserService">
				<property name="userdao" ref="u"/>
		    </bean>
		</beans>
	新建测试：项目新建 Source Folder，新建包，包下新建JUnit。
	
2.测试：执行JUnit  UserServiceTest.java

3.意外收获：将导入的jar包与API文档关联起来：
		   右击jar包->Properties->javadoc Location  导入api文档，按f1就能查看文档。