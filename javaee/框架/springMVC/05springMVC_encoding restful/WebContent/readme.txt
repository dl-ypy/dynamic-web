һ.�����������
	���Post�ύ��
		����web.xml:
		<filter>  
        <filter-name>characterEncodingFilter</filter-name>  
        <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>  
        <init-param>  
            <param-name>encoding</param-name>  
            <param-value>UTF-8</param-value>  
        </init-param>  
	    </filter>  
	    <filter-mapping>  
	        <filter-name>characterEncodingFilter</filter-name>  
	        <url-pattern>/*</url-pattern>  
	    </filter-mapping>
	����:http://localhost:8080/05springMVC_encoding_restful/a.jsp
	
	���get�ύ��
		��Ҫ����elicpse��tomcat�������е�server.xml������ߵ�Servers�ļ���Ѱ�ң�
		<Connector connectionTimeout="20000" port="8080" protocol="HTTP/1.1" redirectPort="8443"/>
		��Ϊ��
		<Connector connectionTimeout="20000" port="8080" protocol="HTTP/1.1" redirectPort="8443" useBodyEncodingForURI="true"/>
		ע������useBodyEncodingForURI="true"�󣬿��Խ����ͨget����������������⣬���Ƕ���ͨ��ajax�����get����������Ȼ�����룬���useBodyEncodingForURI="true"��ΪURIEncoding="UTF-8"���ɡ�
		���ĺ�eclipse�Դ���������������롣
	���ԣ�http://localhost:8080/05springMVC_encoding_restful/hello.do?uname=������
	    
��.restful�����루����ɾ����¼�ȣ�
	���ԣ�http://localhost:8080/05springMVC_encoding_restful/delete/22/8888.do