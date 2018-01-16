测试方法：
输入链接，运行CookiesServlet后，打开浏览器，快捷键alt+t,打开internet选项->常规->设置->打开文件
就可以看到写入的cookie

测试时先将index.jsp中的String username = CookieUtil.getCookie(request, "username");注释掉，
运行，添加上cookie，然后再打开注解，读取cookie。