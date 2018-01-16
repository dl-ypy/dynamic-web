查询语句（QBC）

描述：BBS中的版块类（Category），每个版块下有主题类（Topic），每个主题下有回复类（Msg）。
	在Topic中新加了一对多关系，能够查询到每个主题下的回复。

测试：Junit  HibernateTest.java（如果测试出错，要删除数据库中原有的表或删除数据库重建）