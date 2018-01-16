SSH框架历史四：分出抽象层和实现层

描述：将dao和service分出抽象层和实现层（因为根据不同的需求会有不同的实现方式）。

配置：
	创建dao、dao.impl、service、service.impl的包，并对相关java文件进行更改。

功能：用户注册。

测试：通过Junit测试。