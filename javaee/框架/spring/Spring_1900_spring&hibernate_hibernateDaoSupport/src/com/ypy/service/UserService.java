package com.ypy.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ypy.dao.LogDao;
import com.ypy.dao.UserDao;
import com.ypy.model.Log;
import com.ypy.model.User;

/**
 * 业务层，对外公开
 */
@Component("userService")
public class UserService {
	private UserDao userdao;
	private LogDao logdao;//将LogDao也加进来

	public LogDao getLogdao() {
		return logdao;
	}

	@Resource
	public void setLogdao(LogDao logdao) {
		this.logdao = logdao;
	}

	public UserDao getUserdao() {
		return userdao;
	}

	@Resource
	public void setUserdao(UserDao userdao) {
		this.userdao = userdao;
	}
	
	@Transactional(propagation=Propagation.REQUIRED)//加关于事务的业务逻辑    默认如果catch到Runtime的异常，就会自动回滚
													//propagation默认的就是REQUIRED，表示如果调用此方法的方法中有事务，则不做处理，如果没有，就会创建一个新事务
	public void add(User u) {//处理事务都交给service(业务)层
		u.setUsername("ypy");
		this.userdao.save(u);
		Log log = new Log();
		log.setMsg("a user saved!");
		logdao.save(log);
	}

}
