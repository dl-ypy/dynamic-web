package com.ypy.interceptor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;
import java.util.Properties;

import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.ReflectorFactory;
import org.apache.ibatis.reflection.SystemMetaObject;

import com.ypy.bean.Page;

/**
 * ������ʵ�ַ�ҳ
 * �ܶ�ҳ�涼��Ҫ��ҳ�����������Խ���ͬ�����������
 */
@Intercepts({ @Signature(type = StatementHandler.class, method = "prepare", args = { Connection.class,Integer.class }) })
public class PageInterceptor implements Interceptor{

	//����ִ��˳��3
	@Override
	public Object intercept(Invocation arg0) throws Throwable {
		StatementHandler statementHandler = (StatementHandler)arg0.getTarget();
		//�˴�����ʹ��ԭ����statementHandler�ܹ�����ķ���һЩ����
		MetaObject metaObject = SystemMetaObject.forObject(statementHandler);
		MappedStatement mappedStatement = (MappedStatement)metaObject.getValue("delegate.mappedStatement");
		//�����ļ���sql����ID
		String id = mappedStatement.getId();
		//��������ʽ�ж��ǲ�����Ҫ��id�������ǽ�βΪByPage��id����ʽ�Ŀ�������Ҫ����ͳһ��
		if (id.matches(".+ByPage$")) {
			BoundSql boundsql = statementHandler.getBoundSql();
			//ԭʼ��sql���
			String sql = boundsql.getSql();
			//��ѯ��������sql���
			String countSql = "select count(*) from(" + sql + ")a";//��ԭsql�����Ϊһ���Ӳ�ѯ���������
			Connection connection = (Connection)arg0.getArgs()[0];
			PreparedStatement countStatement = connection.prepareStatement(countSql);
			ParameterHandler parameterHandler = (ParameterHandler)metaObject.getValue("delegate.parameterHandler");
			parameterHandler.setParameters(countStatement);
			ResultSet rs = countStatement.executeQuery();
			Map<String,Object> parameter = (Map<String,Object>)boundsql.getParameterObject();
			Page page = (Page)parameter.get("page");
			if (rs.next()) {
				page.setTotalNumber(rs.getInt(1));
				page.count();
			}
			//����ҳ���ƴ����
			//ע�⣺limit����Ҫ���Ͽո񣬷���ͻ����
			String pageSql = sql + " limit " + page.getDbIndex() + "," + page.getDbNumber();
			//���޸ĺ��sql����ΪҪִ�е�sql
			metaObject.setValue("delegate.boundSql.sql", pageSql);
		}
		return arg0.proceed();
	}

	//����ִ��˳��2 ����
	@Override
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	////����ִ��˳��1 �õ����ԣ�����Configuration.xml�е������й�
	@Override
	public void setProperties(Properties arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
