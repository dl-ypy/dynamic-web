springMVC中json的处理

1.导入jar包：（jackson中的包，jackson2.7与spring-framework3.0兼容，换其他版本可能出现错误）
	jackson-annotations-2.7.0.jar
	jackson-core-2.7.0.jar
	jackson-databind-2.7.0.jar
	
2.配置mvc.xml:
	<bean id="stringConverter" class="org.springframework.http.converter.StringHttpMessageConverter">
        <property name="supportedMediaTypes">
            <list>
                <value>text/plain;charset=UTF-8</value>
            </list>
        </property>
    </bean>
    <bean id="jsonConverter" class="org.springframework.http.converter.json.MappingJackson2HttpMessageConverter"></bean>
    <bean class="org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter">
        <property name="messageConverters">
            <list>
                <ref bean="stringConverter"/>
                <ref bean="jsonConverter"/>
            </list>
        </property>
    </bean>
    
3.写java,jsp代码（java代码中要加@ResponseBody）

4.测试：http://localhost:8080/08springMVC_json/index.jsp