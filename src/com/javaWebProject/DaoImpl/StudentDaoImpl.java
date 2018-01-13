package com.javaWebProject.DaoImpl;

import java.sql.Connection;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.javaWebProject.Dao.StudentDao;
import com.javaWebProject.JavaBean.Dusty;
import com.javaWebProject.JavaBean.Grade;
import com.javaWebProject.JavaBean.Student;
import com.javaWebProject.Tools.JdbcUtil;

public class StudentDaoImpl implements StudentDao {
	QueryRunner queryrunner = new QueryRunner();

	// 管理员查看所有学生
	public List<Student> students() {
		Connection connection = null;
		String sql = "SELECT stuNum,stuName,stuSex,stuDept FROM student";
		try {
			connection = JdbcUtil.getConnection();
			return (List<Student>) queryrunner.query(connection, sql, new BeanListHandler(Student.class));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.releaseConnection(connection);
		}
		return null;
	}

	// 管理员添加学生
	public void AddStudent(Student student) {
		Connection connection = null;
		String sql = "INSERT INTO student(StuNum,StuName,StuSex,StuDept) VALUES(?,?,?,?)";
		try {
			connection = JdbcUtil.getConnection();
			queryrunner.update(connection, sql, new Object[] { student.getStuNum(), student.getStuName(),
					student.getStuSex(), student.getStuDept() });
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.releaseConnection(connection);
		}
	}

	// 管理员查找学生
	public List<Student> SerachStudent(Student student) {
		Connection connection = null;
		String sql = "select * from student WHERE StuName like '%' ? '%' ";
		try {
			connection = JdbcUtil.getConnection();
			return (List<Student>) queryrunner.query(connection, sql, new BeanListHandler(Student.class),
					new Object[] { student.getStuName() });
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.releaseConnection(connection);
		}
		return null;
	}

	// 管理员删除学生
	public void DeleteStudent(int stuId) {
		Connection connection = null;
		String sql = "DELETE FROM student WHERE StuNum = ? ";
		try {
			connection = JdbcUtil.getConnection();
			queryrunner.update(connection, sql, new Object[] { stuId });
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.releaseConnection(connection);
		}

	}

	// 管理员编辑学生
	public void UpdateStudent(Student student) {
		Connection connection = null;
		String sql = "UPDATE student SET StuName = ?,StuSex = ?,StuDept = ? WHERE StuNum = ?";
		try {
			connection = JdbcUtil.getConnection();
			queryrunner.update(connection, sql, new Object[] { student.getStuName(), student.getStuSex(),
					student.getStuDept(), student.getStuNum() });
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.releaseConnection(connection);
		}

	}

	// 学生选课
	public void SelectLesson(String stuNum, Dusty dusty) {
		Connection connection = null;
		String sql = "INSERT INTO sclesson(StuNum,LessonName,TeaName,ClassHour) VALUES(?,?,?,?)";
		try {
			connection = JdbcUtil.getConnection();
			queryrunner.update(connection, sql,
					new Object[] { stuNum, dusty.getLessonName(), dusty.getTeaName(), dusty.getClassHour() });
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.releaseConnection(connection);
		}

	}

	// 学生选课的同时在成绩表中生成一条记录
	public void AddStudentGrade(String term, String lessonName, String teaName, String stuNum, String grade) {
		Connection connection = null;
		String sql = "INSERT INTO grade (Term,LessonName,TeaName,StuNum,Grade) VALUES(?,?,?,?,?)";
		try {
			connection = JdbcUtil.getConnection();
			queryrunner.update(connection, sql, new Object[] { term, lessonName, teaName, stuNum, grade });
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.releaseConnection(connection);
		}

	}

	// 学生查看我的课程
	public List<Dusty> MyLesson(String stuNum) {
		Connection connection = null;
		String sql = "SELECT * FROM sclesson WHERE StuNum = ?";
		try {
			connection = JdbcUtil.getConnection();
			return (List<Dusty>) queryrunner.query(connection, sql, new BeanListHandler(Dusty.class),
					new Object[] { stuNum });
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.releaseConnection(connection);
		}
		return null;
	}

	// 学生查看我的成绩
	public List<Grade> MyGrade(String stuNum) {
		Connection connection = null;
		String sql = "SELECT * FROM grade WHERE StuNum=?";
		try {
			connection = JdbcUtil.getConnection();
			return (List<Grade>) queryrunner.query(connection, sql, new BeanListHandler(Grade.class),
					new Object[] { stuNum });
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.releaseConnection(connection);
		}
		return null;

	}

	// 学生退选
	public void DeleteLesson(String stuNum, String lessonName) {
		Connection connection = null;
		String sql = "DELETE FROM sclesson WHERE StuNum= ? and lessonName = ?";
		try {
			connection = JdbcUtil.getConnection();
			queryrunner.update(connection, sql, new Object[] { stuNum, lessonName });
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.releaseConnection(connection);
		}
	}

	// 学生在退选的同时成绩表中删除相应的记录
	public void DeleteStudentGrade(String stuNum, String lessonName) {
		Connection connection = null;
		String sql = "DELETE FROM grade WHERE stuNum = ? AND lessonName = ?";
		try {
			connection = JdbcUtil.getConnection();
			queryrunner.update(connection, sql, new Object[] { stuNum, lessonName });
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.releaseConnection(connection);
		}
	}

}
