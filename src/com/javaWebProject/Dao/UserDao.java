package com.javaWebProject.Dao;

import com.javaWebProject.JavaBean.User;

public interface UserDao {

	// 验证用户登录
	Integer login(User user);

	// 添加账户信息
	void addUser(User user);
}
