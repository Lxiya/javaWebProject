package com.javaWebProject.Service;

import com.javaWebProject.Dao.UserDao;
import com.javaWebProject.DaoImpl.UserDaoImpl;
import com.javaWebProject.JavaBean.User;

public class UserService {
	UserDao userDao = new UserDaoImpl();

	// 登录验证
	public Integer login(User user) {
		Integer i = userDao.login(user);
		return i;
	}

	// 添加账户
	public void addUser(User user) {
		userDao.addUser(user);
	}
}
