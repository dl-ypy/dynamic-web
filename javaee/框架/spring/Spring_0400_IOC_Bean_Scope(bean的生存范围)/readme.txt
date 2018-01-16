Bean的生存范围（参考api 7.3 Bean scopes）

1.sinqleton（单一的）
	只生成一个对象，将单个bean定义为每个Spring实例容器的单个对象实例，测试时返回true。
	
2.prototype（原型）
	将单个bean定义为任意数量的对象实例,测试时返回false。
 
3.request
    
4.session

5.global Session

6.appliction

7.weblication


测试：执行JUnit  UserServiceTest.java