配置：
首先创建项目时要勾选上web.xml
新建class时，要添加HttpSessionListener接口
在web.xml中加入：
<listener>
      <listener-class>com.ypy.listener.Listener</listener-class>
</listener>