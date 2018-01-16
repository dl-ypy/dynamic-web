一.解决乱码问题
	解决Post提交：
		配置web.xml:
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
	测试:http://localhost:8080/05springMVC_encoding_restful/a.jsp
	
	解决get提交：
		需要更改elicpse中tomcat服务器中的server.xml（从左边的Servers文件下寻找）
		<Connector connectionTimeout="20000" port="8080" protocol="HTTP/1.1" redirectPort="8443"/>
		改为：
		<Connector connectionTimeout="20000" port="8080" protocol="HTTP/1.1" redirectPort="8443" useBodyEncodingForURI="true"/>
		注：配置useBodyEncodingForURI="true"后，可以解决普通get请求的中文乱码问题，但是对于通过ajax发起的get请求中文依然会乱码，请把useBodyEncodingForURI="true"改为URIEncoding="UTF-8"即可。
		更改后eclipse自带的浏览器还是乱码。
	测试：http://localhost:8080/05springMVC_encoding_restful/hello.do?uname=杨佩钰
	    
二.restful风格编码（例如删除记录等）
	测试：http://localhost:8080/05springMVC_encoding_restful/delete/22/8888.do