查询语句（注意：在save时要现在数据库中自己插入对应ID的数据，否则因为自增时ID混乱会出错）
	   解决办法：将每个@GeneratedValue改为@GeneratedValue(strategy=GenerationType.IDENTITY)

描述：BBS中的版块类（Category），每个版块下有主题类（Topic），每个主题下有回复类（Msg）。

测试：Junit  HibernateTest.java（如果测试出错，要删除数据库中原有的表或删除数据库重建）