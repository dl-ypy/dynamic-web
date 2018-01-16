实现文件上传

1.另外导入包：（都是struts2中的包）
	commons-fileupload-1.3.2.jar
	commons-io-2.2.jar
	
2.配置mvc.xml:
	<bean id="multipartResolver"
        class="org.springframework.web.multipart.commons.CommonsMultipartResolver">

    <!-- one of the properties available; the maximum file size in bytes -->
    <property name="maxUploadSize" value="100000"/>
	</bean>
	
3.新建一个上传的文件夹fileupload

4.写java,jsp文件

5.注意：上传的文件要看写代码时规定的大小，超过范围就会出错。
	     上传时上传到服务器端，所以只有在apache-tomcat-7.0.57\wtpwebapps\06springMVC_fileupload\fileupload文件下才能看到上传的文件。
	     要批量上传时，只需要改为数组即可。 