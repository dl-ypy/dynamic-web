OGNL表达式：和EL表达式相似，但必须和struts标签一起使用。
1.支持对象方法的访问。
2.支持类静态方法的调用和值的访问。
3.支持赋值操作和表达式串联。
4.操作集合对象。
5.访问OGNL上下文和ActionContext。

注：如果在struts.xml文件中跳转的时候写上type="redirect"，重定向就会导致作用域中的数据全没了
注：如果action中的属性与action中对象属性的属性相同，且都有值，在值栈中，对象的属性位于顶部，所以取出是对象的属性
测试：localhost:8686/Struts2_day05/ognl/OGNL_save