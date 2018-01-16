1.ajax代码：test.jsp ajax.java

2.解决浏览器缓存问题(显示验证码的例子)：yanzm.jsp GetImages.java VerifyCodeUtils.java
	解决方法：增加时间戳。
	
3.解决中文乱码问题：test.jsp ajax.java
	解决方法：(get方式提交的在eclipse内置浏览器中还是会有乱码现象)
		客户端：username = encodeURI(encodeURI(username));
		服务器端：String name = URLDecoder.decode(old,"utf-8");
		注：服务器端要写response.setCharacterEncoding("utf-8"); 以utf-8的形式发送到客户端。
		解决机理：图片luanma.png。
		
4.解决跨域访问问题：test2.jsp Proxy.java
	解决方法：写代理代码。
	
5.DOM树，节点       testDOMApi.jsp
	调试方法：在火狐浏览器中用调试器加断点的方式进行调试
	
6.js装载xml文档和xml字符串     loadXMLTest.jsp, loadXML.js, test.xml

7.DOM操作XML(添加了一个节点)   BookTest.jsp, loadXML.js, TestBook.xml

8.将DOM对象序列化为XML字符串    BookTest.jsp, loadXML.js, TestBook.xml

9.根据xpath语句查找DOM节点、元素    XPATH.jsp, xpath.js, loadXML.js, xpath.xml

10.对象的演示   Object.jsp

11.json的演示    JSON.jsp

12.js面向对象演示    OO.jsp