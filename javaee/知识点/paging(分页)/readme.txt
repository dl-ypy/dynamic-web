�ļ��ṹ

DataSourceConfig.java      �������ݿ����ӳ�
DB.java                    ��װ�����ݿ���ɾ�Ĳ顢��ѯ�ܼ�¼����ҳ��ѯ
Util.java                  �õ�ҳ�洫���ĵ�ǰҳ����ÿҳ��ʾ�ļ�¼���ȷ���
IMcDaoimpl.java            �������ݿ��dao��ʵ����
McServlet.java             servlet
pageBar.jsp                jsp��ʾҳ
Page.java                  ҳ���model




˼·

1��pageBar.jspҳ��ͨ����������ǰҳ��������ÿҳ��ʾ�ļ�¼��������Servlet��
2��servlet��ͨ��service���õ�dao��ʵ�����еķ�ҳ������
3��dao��ʵ����ķ�ҳ���������ã���ѯ��¼������䡢�����е�where������ѯ��䡢��ҳ��ѯ��   ���һ���֡��Լ������е�����������䣬��order by��
4��������ҳ�������������ռλ��(?)����Ӧ��ֵ����list�����У�ͨ������DB�еķ�ҳ��ѯ����   ����sql��䡢��ǰҳ����ÿҳ��ʾ�ļ�¼����list���ϴ���ȥ��
5��ִ��DB�еķ�ҳ��ѯ����ҳ������ԣ��Լ���ѯ�������ݵ�list���Ϸ���һ��Page�����У�����   ��servlet��
6��servletͨ��setAttribute���������ص�Page���󷵻ص�pageBar.jspҳ�档
7��jspҳ��ͨ��jsp:include��ǩ��pageBar.jsp������ȥ��

ס��Ҫ����pageBar.jsp��ҳ������У�
    <form id="changePage" action="McServlet" method="post">
	<input id="currentPage" type="hidden" name="currentPage" value="${p.currentPage}" /> 
        <input id="pageSize" type="hidden" name="pageSize" value="${p.pageSize}" />
    </form>