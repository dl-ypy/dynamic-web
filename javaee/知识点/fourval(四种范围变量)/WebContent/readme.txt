四种范围变量
1.pageContext:只作用于本页面，只在当前页面有效。
2.request:只作用于转发过的页面。
     访问p1.jsp时能够得到name的值，而访问p3.jsp时就得不到name的值。
3.session:作用于同一个窗口的浏览器下的多个页面。
     访问p1.jsp和p3.jsp都能得到name的值，再打开一个浏览器访问p3.jsp就得不到name的值。
4.application:作用于一个项目下的多个用户。
     以上方法都能得到name的值。