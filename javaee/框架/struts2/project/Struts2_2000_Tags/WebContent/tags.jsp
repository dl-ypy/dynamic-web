<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<ol>
		<li>property:<s:property value="username"/></li><!-- 因为value的类型为Object，所以Struts2会将username当ognl表达式，然后从值栈中取出username的值 -->
		<li>property 取值为字符串：<s:property value="'username'"/></li><!-- 这种形式可以直接显示出username字符串 -->
		<li>property 设定默认值：<s:property value="admin" default="管理员"/></li><!-- 为取不到的值设置默认值 -->
		<li>property 设定HTML：<s:property value="'<hr/>'" escape="false"/></li><!-- escape的默认值是true，如果默认，就会将<hr/>当普通字符串输出，设置为false就会当一个HTML标签 -->
		<hr/>
		<li>set 设定adminName值（默认为request和ActionContext，scope=action）<s:set var="adminName" value="username"/></li><!-- 默认的范围 scope="action" -->
		<li>set 从request取值：<s:property value="#request.adminName"/></li><!-- 在debug中的request中并不显示adminName，因为在存放到request之前，debug已经形成 -->
		<li>set 从ActionContext取值：<s:property value="#adminName"/></li>
		<li>set 设定范围，范围为page<s:set var="adminPassword" value="password" scope="page"/></li><!-- 范围为当前页面 -->
		<li>set 从相应范围取值：<%=pageContext.getAttribute("adminPassword") %></li>
		<li>set 设定var，范围为：session<s:set var="adminPassword" value="password" scope="session"/></li>
		<li>set 从相应范围取值：<s:property value="#session.adminPassword"/></li>
		<hr/>
		<li>bean 定义bean,并使用param来设定新的属性值：
			<s:bean name="com.ypy.struts2.tags.Dog">
				<s:debug></s:debug><!--必须在此bean中 查看值栈时会发现将com.ypy.struts2.tags.Dog压入栈顶，因此能通过s:property value="name"调用里面的name属性 -->
			</s:bean>
		</li>
		<li>bean 查看debug情况：
			<s:bean name="com.ypy.struts2.tags.Dog" var="myDog">
				<s:param name="name" value="'八公'"></s:param><!-- value中是字符串  值栈中的显示为 myDog   dog:八公 -->
			</s:bean>
			<s:debug></s:debug>
		</li>
		<hr/>
		<li>include:(不建议使用,不过此版本可以访问中文页面)</li>
		<li>include _include1.jsp 包含静态英文文件
			<s:include value="/_include1.jsp"/>
		</li>
		<li>include _include2.jsp 包含静态中文文件
			<s:include value="/_include2.jsp"/>
		</li>
		<li>include _include1.jsp 包含静态英文文件，说明%用法
			<s:set var="incPage" value="'/_include1.jsp'"/>
			<s:include value="%{#incPage}"/><!-- 通过变量访问，加%{}的意思就是将{}中的字符串当ognl表达式 -->
		</li>
		<hr/>
		<li>if elseif else:
			age = <s:property value="#parameters.age[0]"/><br/><!-- 在链接中传入age的值，因为age可以传多个,所以是集合 -->
			<s:set var="age" value="#parameters.age[0]"/><!-- 此处体现了set的好处 -->
			<s:if test="#age < 0">wrong age!</s:if>
			<s:elseif test="#age < 20">too yong!</s:elseif>
			<s:else>yeah!</s:else><br/>
			<s:if test="#parameters.aaa == null">null</s:if><!-- 判断一个属性是否为空，此处没有aaa属性，所以为空 -->
		</li>
		<hr/>
		<li>遍历集合：<br/>
			<s:iterator value="{1, 2, 3}">
				<s:property/> |<!-- 得到值 -->
			</s:iterator>
		</li>
		<li>自定义变量：<br/>
			<s:iterator value="{'aa','bb','cc'}" var="x">
				<s:property value="#x.toUpperCase()"/>
			</s:iterator>
		</li>
		<li>使用status:<br/>
			<s:iterator value="{'aaa','bbb','ccc'}" status="status"><!-- 状态 -->
				<s:property/> |
				遍历过的元素总数：<s:property value="#status.count"/> |
				遍历过的元素索引：<s:property value="#status.index"/> |
				当前是第偶数个？<s:property value="#status.even"/> |
				当前是第奇数个？<s:property value="#status.odd"/> |
				是第一个元素？<s:property value="#status.first"/> |
				是最后一个元素？<s:property value="#status.last"/><br/>
			</s:iterator>
		</li>
		<li>
			<s:iterator value="#{1:'a', 2:'b', 3:'c'}"><!-- 遍历Map,必须加#-->
				<s:property value="key"/> | <s:property value="value"/><br/>
			</s:iterator>
		</li>
		<li>
			<s:iterator value="#{1:'a', 2:'b', 3:'c'}" var="x"><!-- 用变量遍历-->
				<s:property value="#x.key"/> | <s:property value="#x.value"/><br/>
			</s:iterator>
		</li>
		<hr/>
		<li>ui标签（基本不用）</li>
	</ol>
	<s:debug></s:debug>
</body>
</html>















