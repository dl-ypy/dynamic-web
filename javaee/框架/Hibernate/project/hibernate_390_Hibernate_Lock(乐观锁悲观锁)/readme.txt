处理事务并发的两种锁

描述：事务有4个特性：ACUD
	事务并发可能的问题：脏数据、不可重复读、幻读。
	数据库事务隔离机制：1.read—uncommitted 2.read-committed 4.repeatable 8.serialized
	为了考虑效率问题，一般把级别设为2 read-committed，但解决不了不可重复读的问题，所以要用hibernate的乐观锁和悲观锁。
	悲观锁使用数据库的锁，乐观锁使用version。

测试：Junit  HibernateTest.java（如果测试出错，要删除数据库中原有的表或删除数据库重建）