模拟简单struts框架

思路：
根据配置文件struts.xml创建对应的节点类型ActionModel、ResultModel。
访问请求->Servlet，
在Servlet中截取所需信息，
通过调用ActionMappingManager中的方法解析配置文件struts.xml中的信息，
获得一个ActionModel对象，通过反射执行对应的action中的对应方法，得到要跳转的路径，
进行页面跳转。

打包：
file->emport->java->Runnable jar file。

使用：
将此jar包导入，编写struts.xml、对应action、jsp文件。
配置web.xml文件:
	  <servlet>
	  	<servlet-name>mystruts</servlet-name>
	  	<servlet-class>com.ypy.mystruts.servlet.ControllerServlet</servlet-class>
	  </servlet>
	  <servlet-mapping>
	  	<servlet-name>mystruts</servlet-name>
	  	<url-pattern>/mvc/*</url-pattern>
	  </servlet-mapping>

执行：
http://localhost:端口号/项目名/mvc/action的name名。