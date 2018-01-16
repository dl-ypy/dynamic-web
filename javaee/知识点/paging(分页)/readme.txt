文件结构

DataSourceConfig.java      连接数据库连接池
DB.java                    封装的数据库增删改查、查询总记录、分页查询
Util.java                  得到页面传来的当前页数、每页显示的记录数等方法
IMcDaoimpl.java            连接数据库的dao层实现类
McServlet.java             servlet
pageBar.jsp                jsp显示页
Page.java                  页面的model




思路

1、pageBar.jsp页面通过表单将“当前页数”、“每页显示的记录数”传到Servlet。
2、servlet中通过service调用到dao层实现类中的分页方法。
3、dao层实现类的分页方法中设置：查询记录数的语句、可能有的where条件查询语句、分页查询语   句的一部分、以及可能有的其他条件语句，如order by。
4、将除分页语句外其他语句的占位符(?)所对应的值放入list集合中，通过调用DB中的分页查询方法   ，将sql语句、当前页数、每页显示的记录数和list集合传过去。
5、执行DB中的分页查询，将页面的属性，以及查询到的数据的list集合放入一个Page对象中，返回   到servlet。
6、servlet通过setAttribute方法将返回的Page对象返回到pageBar.jsp页面。
7、jsp页面通过jsp:include标签将pageBar.jsp包含进去。

住：要包含pageBar.jsp的页面必须有：
    <form id="changePage" action="McServlet" method="post">
	<input id="currentPage" type="hidden" name="currentPage" value="${p.currentPage}" /> 
        <input id="pageSize" type="hidden" name="pageSize" value="${p.pageSize}" />
    </form>