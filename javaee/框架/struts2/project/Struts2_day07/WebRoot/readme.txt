拦截器
1.编写拦截器：UserInterceptor.java
2.配置struts.xml文件
	拦截多个action的方法：
	(1)配置拦截器栈，并且配置全局的拦截器，适用于所有action都需要拦截的情况。
	(2)配置拦截器栈，在需要拦截的action中配置   interceptor-ref