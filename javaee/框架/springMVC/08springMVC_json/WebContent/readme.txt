springMVC��json�Ĵ���

1.����jar������jackson�еİ���jackson2.7��spring-framework3.0���ݣ��������汾���ܳ��ִ���
	jackson-annotations-2.7.0.jar
	jackson-core-2.7.0.jar
	jackson-databind-2.7.0.jar
	
2.����mvc.xml:
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
    
3.дjava,jsp���루java������Ҫ��@ResponseBody��

4.���ԣ�http://localhost:8080/08springMVC_json/index.jsp