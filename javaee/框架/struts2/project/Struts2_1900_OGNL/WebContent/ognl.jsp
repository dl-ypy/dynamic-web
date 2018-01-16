<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib uri="/struts-tags" prefix="s"%><!-- !!!!!!!!!!!!!!!!!!!!!!!!! -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<ol>
		<li>访问值栈中的action的普通属性：username = <s:property value="username"/></li>
		<li>访问值栈中对象的普通属性（get set方法）：<s:property value="user.age"/></li><!-- 在OgnlAction中没有new User对象，所以必须在链接中传user.xxx=xxx,才会构造，当然也可以在OgnlAction中手动new出来 -->
																			  <!-- 在User类中必须有参数为空的构造方法，因为如果没有此构造方法，在自动new的时候不能确定要调用哪个构造方法,但手动new的可以不写此构造函数 -->
		<li>访问值栈中对象的普通属性（get set方法）：<s:property value="cat.dog.name"/></li><!-- 要在链接里传值cat.dog.name=bagong -->
		<li>访问值栈中对象的普通方法：<s:property value="password.length()"/></li><!-- 密码的长度 -->
		<li>访问值栈中对象的普通方法：<s:property value="cat.jiao()"/></li><!-- 调用cat类中的jiao方法 ，必须将值传过去才能调用方法-->
		<li>访问值栈中action的普通方法：<s:property value="m()"/></li>	
		<hr/>
		<li>访问静态方法：<s:property value="@com.ypy.struts2.ognl.S@s()"/></li>	<!-- 格式为@包名.类名@方法 -->
		<li>访问静态属性：<s:property value="@com.ypy.struts2.ognl.S@STR"/></li>
		<li>访问Math类的静态方法：<s:property value="@@max(2, 5)"/></li>		<!-- 用两个@只能访问某个指定类的方法 -->
		<hr/>
		<li>访问普通类的构造方法：<s:property value="new com.ypy.struts2.User(1)"/></li><hr/>	<!-- 能够直接通过构造方法new (访问不了？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？)-->
		<li>访问集合List:<s:property value="users"/></li><!-- 访问List集合 -->
		<li>访问List中的某个元素：<s:property value="users[0]"/></li>	<!-- 访问集合中的第1个元素 -->
		<li>访问List中元素某个属性集合：<s:property value="users.{age}"/></li><!-- 访问集合中age属性的集合 -->
		<li>访问List中元素某个属性集合中的特定值：<s:property value="users.{age}[0]"/>|<s:property value="users[0].age"/></li><!-- 第二种方法更常用 -->
		<li>访问Set：<s:property value="dogs"/></li>
		<li>访问Set中的某个元素：<s:property value="dogs[0]"/></li><!-- 这里什么都不输出，因为Set集合是无序的，所以根据下标找是无意义的 -->
		<li>访问Map：<s:property value="dogMap"/></li>
		<li>访问Map中的某个元素：<s:property value="dogMap.dog102"/>|<s:property value="dogMap{'dog102'}"/>|<s:property value="dogMap{\"dog102\"}"/></li>	<!-- 访问key为dog102的value -->
		<li>访问Map中所有的key：<s:property value="dogMap.keys"/></li>
		<li>访问Map中所有的value：<s:property value="dogMap.values"/></li>
		<li>访问容器的大小：<s:property value="dogMap.size()"/>|<s:property value="dogs.size"/></li>
		<hr/>
		<li>投影（过滤）：<s:property value="users.{?#this.age==1}.{age}"/></li><!-- 后面{}括起来的是过滤条件，this指过滤时循环查找的当前对象.{age}是得到当前对象的age属性的集合（因为age=1的不一定就是一个），在后面加上[0,1,...] 就表示得到这个集合中的第几个-->
		<li>投影：<s:property value="users.{^#this.age>1}.{age}"/></li><!-- 用^拿到满足此条件的第一个 -->
		<li>投影：<s:property value="users.{$#this.age>1}.{age}"/></li><!-- 用$拿到满足此条件的最后一个 -->
		<li>投影：<s:property value="users.{$#this.age>1}.{age} == null"/></li><!-- 判断是否有age>1的  返回Boolean类型 -->
		<hr/>
		<li>[]：<s:property value="[0]"/></li><!-- 访问ognl栈中从第[]个位置开始到栈底  看dubug中   可以.属性，访问action中的该属性，第一个action中找不到就会接着往下找   服务器端跳转时，会压入多个action -->															  
	</ol>
	<s:debug></s:debug>
	
	<!--    运行结果
	1.访问值栈中的action的普通属性：username = u
	2.访问值栈中对象的普通属性（get set方法）：
    3.访问值栈中对象的普通属性（get set方法）：
 	4.访问值栈中对象的普通方法：1
	5.访问值栈中对象的普通方法：
    6.访问值栈中action的普通方法：访问的是OgnlAction.java中的m方法。

    7.访问静态方法：静态方法
    8.访问静态属性：静态属性
    9.访问Math类的静态方法：5
 
    10.访问普通类的构造方法：

    11.访问集合List:[user1, user2, user3]
    12.访问List中的某个元素：user1
    13.访问List中元素某个属性集合：[1, 2, 3]
    14.访问List中元素某个属性集合中的特定值：1|1
    15.访问Set：[dogdog1, dogdog3, dogdog2]
    16.访问Set中的某个元素：
    17.访问Map：{dog100=dogdog100, dog101=dogdog101, dog102=dogdog102}
	18.访问Map中的某个元素：dogdog102||
    19.访问Map中所有的key：[dog100, dog101, dog102]
	20.访问Map中所有的value：[dogdog100, dogdog101, dogdog102]
	21.访问容器的大小：3|3

	22.投影（过滤）：[1]
    23.投影：[2]
    24.投影：[3]
    25.投影：false
 
	26.[]：[com.ypy.struts2.ognl.OgnlAction@5089a92a, com.opensymphony.xwork2.DefaultTextProvider@3716b557]
	 
[Debug] 
	 -->
</body>
</html>















