SSH框架历史三：3层架构（2层架构+实体类+service业务层(用hibernate代替)）

描述：jsp页面显示层+DB数据库层+业务逻辑层。

配置：
	1.创建hibernate.cfg.xml、log4j.properties。
	2.导入hibernate的包。
	3.往实体类User.java中添加注解。
	4.更改业务层UserManager.java。
	5.创建Junit进行测试。

功能：用户注册。

测试：通过Junit测试。