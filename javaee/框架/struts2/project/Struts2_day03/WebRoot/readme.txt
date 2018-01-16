验证框架
1.编程式：
	(1).必须继承ActionSupport类。
	(2).必须实现validate方法。
	(3).要在struts.xml文件中添加一个name="input"的result标签，用来指定验证不通过后返回的页面。注：type不能写成重定向。
	(4).要在name="input"的result标签跳转的页面写上struts标签：<s:actionerror/>接受错误消息。
	测试：http://localhost:8686/Struts2_day03/user/User1_login_login1
2.配置式：
	(1).在action包下，配置一个文件，文件名为：“要验证的action文件-validation.xml”
	         文件内容:源文件中找xwork-validator-1.0.dtd文件复制：
	         <!DOCTYPE validators PUBLIC 
	  		"-//Apache Struts//XWork Validator 1.0//EN"
	  		"http://struts.apache.org/dtds/xwork-validator-1.0.dtd">
	  	然后已以下格式写：
	  	<validators>
			<field name="username">   <!-- 指定要验证的属性 -->
				<field-validator type="requiredstring">
					<message>用户名不能为空</message>
				</field-validator>
				<field-validator type="stringlength">
					<param name="maxLength">6</param>
					<param name="minLength">3</param>
					<message>字符数必须在3-6之间</message>
				</field-validator>
			</field>
		</validators>
		参考源文件中com/opensymphony/xwork2/validator/validators/default.xml文件。
	(2)(3)点与以上(3)(4)点相同。
	测试：http://localhost:8686/Struts2_day03/user/User2_login_login2