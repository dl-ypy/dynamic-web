SSH�����ʷ��������spring



������1.spring���hibernate��
	2.ע��userDao��
	3.spring���Struts2��
	4.ע��Struts��action��spring����Struts����action����



���ã�
	1.����spring����
	
	2.����beans.xml��jdbc.properties�ļ���ɾ��hibernate.cfg.xml�ļ���
	
	3.����UserManagerImpl.java����userDao��������ע�롣��ע����HibernateTmplate��save��find��һЩ����ʱ��Ҫ����������ﴦ����������
		
		��ʱ������дһ��Junit��userDao��ע����в��ԡ�
	
	4.����web.xml��
		<!-- ����spring�Y��Struts2 -->
		<listener>
			<listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
		</listener>
		<context-param>
			<param-name>contextConfigLocation</param-name>
			<!-- Ĭ��ΪWEB-INF/applicationContext*.xml -->
			<!-- <param-value>/WEB-INF/applicationContext*.xml</param-value> -->
			<param-value>classpath:beans.xml</param-value>
		</context-param>
		
	5.����UserAction.java����Struts2��action��������ע�롣
	
	6.����struts2-spring-plugin-2.3.4.1.jar����ע���еİ汾�Ļ������



���ܣ��û�ע�ᡣ



���ԣ�ͨ��jspҳ����ԡ�