package com.javaWebProject.DaoImpl;

import java.sql.Connection;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.javaWebProject.Dao.LessonDao;
import com.javaWebProject.JavaBean.Lesson;
import com.javaWebProject.Tools.JdbcUtil;

public class LessonDaoImpl implements LessonDao {
	QueryRunner queryrunner = new QueryRunner();

	// 显示所有课程
	public List<Lesson> lessons() {
		Connection connection = null;
		String sql = "SELECT LessonId,LessonName FROM lesson";
		try {
			connection = JdbcUtil.getConnection();
			return (List<Lesson>) queryrunner.query(connection, sql, new BeanListHandler(Lesson.class));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.releaseConnection(connection);
		}
		return null;
	}

	// 添加课程
	public List<Lesson> AddLesson(Lesson lesson) {
		Connection connection = null;
		String sql = "INSERT INTO lesson(LessonName) VALUES(?)";
		try {
			connection = JdbcUtil.getConnection();
			queryrunner.update(connection, sql, new Object[] { lesson.getLessonName() });
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.releaseConnection(connection);
		}
		return null;
	}

	// 删除课程
	public void DeleteLesson(int lessonId) {
		Connection connection = null;
		String sql = "DELETE FROM lesson WHERE lessonId = ?";
		try {
			connection = JdbcUtil.getConnection();
			queryrunner.update(connection, sql, new Object[] { lessonId });
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.releaseConnection(connection);
		}
	}

	// 检索课程
	public List<Lesson> serachLesson(Lesson lesson) {
		Connection connection = null;
		String sql = "SELECT LessonId,LessonName FROM lesson WHERE lessonId = ?";
		try {
			connection = JdbcUtil.getConnection();
			return (List<Lesson>) queryrunner.query(connection, sql, new BeanListHandler(Lesson.class),
					new Object[] { lesson.getLessonId() });
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.releaseConnection(connection);
		}
		return null;
	}

	// 编辑课程
	public void updateLesson(String lessonName, int lessonId) {
		Connection connection = null;
		String sql = "UPDATE lesson SET LessonName = ? WHERE LessonId = ?";
		try {
			connection = JdbcUtil.getConnection();
			queryrunner.update(connection, sql, new Object[] { lessonName, lessonId });
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.releaseConnection(connection);
		}
	}

}
