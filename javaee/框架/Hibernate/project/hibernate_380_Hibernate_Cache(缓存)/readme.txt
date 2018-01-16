缓存

描述：
	1.一级缓存：同session下查询相同记录只执行一次查询语句。
	2.二级缓存：不同的session查询相同记录只执行一次查询语句。
		需要配置：在hibernate.cfg.xml中写<property name="hibernate.cache.use_second_level_cache">true</property>
									<property name="hibernate.cache.region.factory_class">org.hibernate.cache.ehcache.EhCacheRegionFactory</property>
			       在对应的类中写注解：@Cache(usage=CacheConcurrencyStrategy.READ_WRITE) 
			       导入包：hibernate-release-5.2.4.Final\lib\optional\ehcache下所有包，struts2下的commons-logging包。
			       将hibernate-release-5.2.4.Final\project\etc下的ehcache.xml复制到src目录下。
	3.查询缓存：使用查询缓存能达到一级缓存和二级缓存的效果。
	
	缓存算法：LRU，LFU，FIFO

测试：Junit  HibernateTest.java（如果测试出错，要删除数据库中原有的表或删除数据库重建）