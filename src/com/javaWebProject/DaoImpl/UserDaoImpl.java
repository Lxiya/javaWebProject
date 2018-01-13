package com.javaWebProject.DaoImpl;

import java.sql.Connection;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.javaWebProject.Dao.UserDao;
import com.javaWebProject.JavaBean.User;
import com.javaWebProject.Tools.JdbcUtil;

public class UserDaoImpl implements UserDao {

	QueryRunner queryrunner = new QueryRunner();

	// 验证登录
	public Integer login(User user) {
		Connection connection = null;
		int i = 0;
		String sql = "select userId from user where userName=? and `password`=? and role=?";
		try {
			connection = JdbcUtil.getConnection();
			i = (Integer) queryrunner.query(connection, sql, new ScalarHandler(),
					new Object[] { user.getUserName(), user.getPassword(), user.getRole() });
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.releaseConnection(connection);
		}
		return i;
	}

	// 添加账户
	public void addUser(User user) {
		Connection connection = null;
		String sql = "INSERT INTO `user`(userName,password,role) VALUES(?,?,?)";
		try {
			connection = JdbcUtil.getConnection();
			queryrunner.update(connection, sql,
					new Object[] { user.getUserName(), user.getPassword(), user.getRole() });
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.releaseConnection(connection);
		}
	}

}
