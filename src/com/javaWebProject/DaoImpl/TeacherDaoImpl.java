package com.javaWebProject.DaoImpl;

import java.sql.Connection;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.javaWebProject.Dao.TeacherDao;
import com.javaWebProject.JavaBean.Dusty;
import com.javaWebProject.JavaBean.Grade;
import com.javaWebProject.JavaBean.Student;
import com.javaWebProject.JavaBean.Teacher;
import com.javaWebProject.JavaBean.User;
import com.javaWebProject.Tools.JdbcUtil;

public class TeacherDaoImpl implements TeacherDao {
	QueryRunner queryrunner = new QueryRunner();

	// 显示教师
	public List<Teacher> teachers() {
		Connection connection = null;
		String sql = "SELECT TeaId,TeaName,TeaSex FROM teacher";
		try {
			connection = JdbcUtil.getConnection();
			return (List<Teacher>) queryrunner.query(connection, sql, new BeanListHandler(Teacher.class));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.releaseConnection(connection);
		}
		return null;
	}

	// 添加教师
	public void AddTeacher(Teacher teacher) {
		Connection connection = null;
		String sql = "INSERT INTO teacher(TeaName,TeaSex) VALUES(?,?)";
		try {
			connection = JdbcUtil.getConnection();
			queryrunner.update(connection, sql, new Object[] { teacher.getTeaName(), teacher.getTeaSex() });
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.releaseConnection(connection);
		}
	}

	// 添加教师账户
	public void AddTeachertUser(User user) {
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

	// 检索教师
	public List<Teacher> SerachTeacher(Teacher teacher) {
		Connection connection = null;
		String sql = "SELECT * FROM teacher WHERE TeaName = ?";
		try {
			connection = JdbcUtil.getConnection();
			return (List<Teacher>) queryrunner.query(connection, sql, new BeanListHandler(Teacher.class),
					new Object[] { teacher.getTeaName() });
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.releaseConnection(connection);
		}
		return null;
	}

	// 删除教师
	public void DeleteTeacher(int teaId) {
		Connection connection = null;
		String sql = "DELETE  FROM teacher WHERE TeaId = ?";
		try {
			connection = JdbcUtil.getConnection();
			queryrunner.update(connection, sql, new Object[] { teaId });
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.releaseConnection(connection);
		}

	}

	// 编辑教师
	public void UpdateTeacher(Teacher teacher) {
		Connection connection = null;
		String sql = "UPDATE teacher SET TeaName = ?,TeaSex = ? WHERE TeaId=?";
		try {
			connection = JdbcUtil.getConnection();
			queryrunner.update(connection, sql,
					new Object[] { teacher.getTeaName(), teacher.getTeaSex(), teacher.getTeaId() });
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.releaseConnection(connection);
		}

	}

	// 显示所有的教学计划
	public List<Dusty> dusties() {
		Connection connection = null;
		String sql = "SELECT DId,Term,LessonName,TeaName,ClassHour FROM dusty";
		try {
			connection = JdbcUtil.getConnection();
			return (List<Dusty>) (List<Dusty>) queryrunner.query(connection, sql, new BeanListHandler(Dusty.class));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.releaseConnection(connection);
		}
		return null;
	}

	// 新增教学计划
	public void AddDusty(Dusty dusty) {
		Connection connection = null;
		String sql = "INSERT INTO dusty(Term,LessonName,TeaName,ClassHour) VALUES(?,?,?,?)";
		try {
			connection = JdbcUtil.getConnection();
			queryrunner.update(connection, sql,
					new Object[] { dusty.getTerm(), dusty.getLessonName(), dusty.getTeaName(), dusty.getClassHour() });
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.releaseConnection(connection);
		}

	}

	// 教师处显示管理员安排的教学计划
	public List<Dusty> ShowMydusties(String teaName) {
		Connection connection = null;
		String sql = "SELECT * FROM dusty WHERE TeaName = ?";
		try {
			connection = JdbcUtil.getConnection();
			return (List<Dusty>) queryrunner.query(connection, sql, new BeanListHandler(Dusty.class),
					new Object[] { teaName });
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			JdbcUtil.releaseConnection(connection);
		}
		return null;
	}

	// 显示我的学生
	public List<Student> ShowMyStudents(String teaName) {
		Connection connection = null;
		String sql = "SELECT student.StuNum,StuName,StuDept,LessonName FROM student,sclesson WHERE sclesson.StuNum = student.StuNum AND sclesson.TeaName = ?";
		try {
			connection = JdbcUtil.getConnection();
			List<Student> students = (List<Student>) queryrunner.query(connection, sql,
					new BeanListHandler(Student.class), new Object[] { teaName });
			return students;
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			JdbcUtil.releaseConnection(connection);
		}
		return null;
	}

	// 教师录入或更改成绩
	public void UpdateStudentGrade(String grade, String stuNum, String lessonName) {
		Connection connection = null;
		String sql = "UPDATE grade SET Grade = ? WHERE StuNum = ? AND LessonName= ? ";
		try {
			connection = JdbcUtil.getConnection();
			queryrunner.update(connection, sql, new Object[] { grade, stuNum, lessonName });
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			JdbcUtil.releaseConnection(connection);
		}

	}

	// 教师查看成绩
	public List<Grade> ShowMyStudentsGrade(String teaName) {
		Connection connection = null;
		String sql = "SELECT * FROM grade WHERE TeaName=?";
		try {
			connection = JdbcUtil.getConnection();
			return (List<Grade>) queryrunner.query(connection, sql, new BeanListHandler(Grade.class),
					new Object[] { teaName });
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.releaseConnection(connection);
		}
		return null;
	}

	// 教师检索学生成绩
	public List<Grade> SelectStudentGrade(String stuNum) {
		Connection connection = null;
		String sql = "SELECT * FROM grade WHERE stuNum like '%' ? '%'";
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

}
