性能优化之1+N(或N+1)问题

描述：本来只查询一个表就可以，但是因为FetchType默认为ERGER，所以会关联到其他的表，所以就会查询N个表。

解决：
	1.设置(fetch=FetchType.LAZY)，此时只有用到的时候才会查询其他关联的表。
	2.使用createCriteria。
	3.使用BatchSize。
	4.使用join fetch，改变查询语句。

测试：Junit  HibernateTest.java（如果测试出错，要删除数据库中原有的表或删除数据库重建）