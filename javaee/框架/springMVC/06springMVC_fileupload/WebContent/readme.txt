ʵ���ļ��ϴ�

1.���⵼�����������struts2�еİ���
	commons-fileupload-1.3.2.jar
	commons-io-2.2.jar
	
2.����mvc.xml:
	<bean id="multipartResolver"
        class="org.springframework.web.multipart.commons.CommonsMultipartResolver">

    <!-- one of the properties available; the maximum file size in bytes -->
    <property name="maxUploadSize" value="100000"/>
	</bean>
	
3.�½�һ���ϴ����ļ���fileupload

4.дjava,jsp�ļ�

5.ע�⣺�ϴ����ļ�Ҫ��д����ʱ�涨�Ĵ�С��������Χ�ͻ����
	     �ϴ�ʱ�ϴ����������ˣ�����ֻ����apache-tomcat-7.0.57\wtpwebapps\06springMVC_fileupload\fileupload�ļ��²��ܿ����ϴ����ļ���
	     Ҫ�����ϴ�ʱ��ֻ��Ҫ��Ϊ���鼴�ɡ� 