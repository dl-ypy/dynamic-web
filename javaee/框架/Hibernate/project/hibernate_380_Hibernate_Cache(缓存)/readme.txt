����

������
	1.һ�����棺ͬsession�²�ѯ��ͬ��¼ִֻ��һ�β�ѯ��䡣
	2.�������棺��ͬ��session��ѯ��ͬ��¼ִֻ��һ�β�ѯ��䡣
		��Ҫ���ã���hibernate.cfg.xml��д<property name="hibernate.cache.use_second_level_cache">true</property>
									<property name="hibernate.cache.region.factory_class">org.hibernate.cache.ehcache.EhCacheRegionFactory</property>
			       �ڶ�Ӧ������дע�⣺@Cache(usage=CacheConcurrencyStrategy.READ_WRITE) 
			       �������hibernate-release-5.2.4.Final\lib\optional\ehcache�����а���struts2�µ�commons-logging����
			       ��hibernate-release-5.2.4.Final\project\etc�µ�ehcache.xml���Ƶ�srcĿ¼�¡�
	3.��ѯ���棺ʹ�ò�ѯ�����ܴﵽһ������Ͷ��������Ч����
	
	�����㷨��LRU��LFU��FIFO

���ԣ�Junit  HibernateTest.java��������Գ���Ҫɾ�����ݿ���ԭ�еı��ɾ�����ݿ��ؽ���