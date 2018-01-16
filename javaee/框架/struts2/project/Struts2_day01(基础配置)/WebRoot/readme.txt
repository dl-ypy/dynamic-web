配置struts2

1.导入jar包。

2.创建struts.xml文件。
  （1）. Web App Libraries->struts2-core中的struts-default中找到配置dtd文件的语句：
	  <!DOCTYPE struts PUBLIC
	    "-//Apache Software Foundation//DTD Struts Configuration 2.5//EN"
	    "http://struts.apache.org/dtds/struts-2.5.dtd">
	    复制到struts.xml中，此语句是配置文件中能用的标签。
  （2）. 通过查找Web App Libraries->struts2-core->org.apache.struts2->default.properties
              文件，在struts.xml中通过<constant name="" value="true"></constant>属性可配置其他属性，如修改xml文件后自动重启。
  （3）. 编写action文件
  （4）. 配置web.xml:
       <filter>
	  	 <filter-name>struts2</filter-name>
	  	 <filter-class>org.apache.struts2.dispatcher.filter.StrutsPrepareAndExecuteFilter</filter-class>
	   </filter>
	   <filter-mapping>
	  	 <filter-name>struts2</filter-name>
	  	 <url-pattern>/*</url-pattern>
	   </filter-mapping>  
	   其中<filter-class>的路径是：Web App Libraries->struts2-core->org.apache.struts2.dispatcher.filter->StrutsPrepareAndExecuteFilter的路径。
  
3.测试：http://localhost:8686/Struts2_day01/mc/mc_save