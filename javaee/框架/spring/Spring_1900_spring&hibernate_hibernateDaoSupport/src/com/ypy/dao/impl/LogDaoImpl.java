package com.ypy.dao.impl;

import org.springframework.stereotype.Component;
import com.ypy.dao.LogDao;
import com.ypy.model.Log;

/**
 * UserDaoµÄÊµÏÖ
 */

@Component
public class LogDaoImpl extends SuperDAO implements LogDao{
	@Override
	public void save(Log log) {
		this.getHibernateTemplate().save(log);
	}
}
