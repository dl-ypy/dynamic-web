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
 * 拦截器实现分页
 * 很多页面都需要分页，拦截器可以将共同代码进行整合
 */
@Intercepts({ @Signature(type = StatementHandler.class, method = "prepare", args = { Connection.class,Integer.class }) })
public class PageInterceptor implements Interceptor{

	//方法执行顺序：3
	@Override
	public Object intercept(Invocation arg0) throws Throwable {
		StatementHandler statementHandler = (StatementHandler)arg0.getTarget();
		//此代码是使得原来的statementHandler能够方便的访问一些属性
		MetaObject metaObject = SystemMetaObject.forObject(statementHandler);
		MappedStatement mappedStatement = (MappedStatement)metaObject.getValue("delegate.mappedStatement");
		//配置文件中sql语句的ID
		String id = mappedStatement.getId();
		//用正则表达式判断是不是想要的id（这里是结尾为ByPage的id，正式的开发中需要进行统一）
		if (id.matches(".+ByPage$")) {
			BoundSql boundsql = statementHandler.getBoundSql();
			//原始的sql语句
			String sql = boundsql.getSql();
			//查询总条数的sql语句
			String countSql = "select count(*) from(" + sql + ")a";//将原sql语句作为一个子查询，并起别名
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
			//将分页语句拼接上
			//注意：limit两边要加上空格，否则就会出错
			String pageSql = sql + " limit " + page.getDbIndex() + "," + page.getDbNumber();
			//将修改后的sql设置为要执行的sql
			metaObject.setValue("delegate.boundSql.sql", pageSql);
		}
		return arg0.proceed();
	}

	//方法执行顺序：2 过滤
	@Override
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	////方法执行顺序：1 拿到属性，与在Configuration.xml中的配置有关
	@Override
	public void setProperties(Properties arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
