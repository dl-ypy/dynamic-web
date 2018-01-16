国际化
配置：
	配置struts.xml，加入<constant name="struts.custom.i18n.resources" value="zbmessage">
		其中value的值可随便写，参考源文件：/org/apache/struts2/default.properties
	配置语言的配置文件：文件名  struts.xml中配置的value值+_zh_CN.properties   英文同理
	配置action和jsp。
		