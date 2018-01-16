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
 * ҵ��㣬���⹫��
 */
@Component("userService")
public class UserService {
	private UserDao userdao;
	private LogDao logdao;//��LogDaoҲ�ӽ���

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
	
	@Transactional(propagation=Propagation.REQUIRED)//�ӹ��������ҵ���߼�    Ĭ�����catch��Runtime���쳣���ͻ��Զ��ع�
													//propagationĬ�ϵľ���REQUIRED����ʾ������ô˷����ķ����������������������û�У��ͻᴴ��һ��������
	public void add(User u) {//�������񶼽���service(ҵ��)��
		u.setUsername("ypy");
		this.userdao.save(u);
		Log log = new Log();
		log.setMsg("a user saved!");
		logdao.save(log);
	}

}
