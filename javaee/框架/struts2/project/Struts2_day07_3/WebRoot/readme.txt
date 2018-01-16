文件上传
配置：上传文件的界面、处理文件的action、struts.xml
注：上传界面要写multipart/form-data
   action中要有属性：img,imgContentType,imgFileName,属性名img要根据前台传的值确定，其他两个前面的img根据img这个属性名更改，其他不可改。
测试：http://localhost:8686/Struts2_day07_3/upload.jsp
参考：源文件/org/apache/struts2/default.properties   和    org.apache.struts2.interceptor.FileUploadInterceptor.class