student_course_score（重要）

描述：score相当于student和course的中间表。

测试：Junit  HibernateTest.java（如果测试出错，要删除数据库中原有的表或删除数据库重建）

问题：中间表的主键成为了student和course的联合主键，添加数据后，自增的主键出现问题。