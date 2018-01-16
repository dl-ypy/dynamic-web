action的使用
1.普通的java文件。
2.实现Action接口。
3.继承ActionSupport类。

往action中传值：
1.属性驱动
	(1).直接在action中编写属性和getter、setter。
		表单中的属性名必须与action中的属性名相同。
	         测试：http://localhost:8686/Struts2_day02/login1.jsp
	(2).新建一个model，将属性都放入model中，action中写一个model的对象及getter和setter。
	         表单中的属性名必须写成"model对象.model属性"。
	         测试：http://localhost:8686/Struts2_day02/login2.jsp
2.模型驱动
	新建一个model，将属性都放入model中，action中写一个model的对象及getter和setter，而且实现一个modelDriven接口。
         表单中的属性名只须写成属性名就行。
         测试：http://localhost:8686/Struts2_day02/login3.jsp