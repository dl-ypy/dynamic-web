package com.ypy.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ypy.dao.UserDao;
import com.ypy.model.User;

@Repository("userDao")//@Repository��Ӧ���ݷ��ʲ�Bean,��@Component��������
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao{

	@Autowired //��@Resource����
	@Override
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	@Override
	public List<User> list() {
		return getSqlSession().selectList("com.ypy.model.User.list");
	}

}
