package com.javaWebProject.Service;

import java.util.List;

import com.javaWebProject.Dao.TeacherDao;
import com.javaWebProject.DaoImpl.TeacherDaoImpl;
import com.javaWebProject.JavaBean.Dusty;
import com.javaWebProject.JavaBean.Grade;
import com.javaWebProject.JavaBean.Student;
import com.javaWebProject.JavaBean.Teacher;
import com.javaWebProject.JavaBean.User;

public class TeacherService {
	TeacherDao teacherDao = new TeacherDaoImpl();

	// 显示教师
	public List<Teacher> teachers() {
		List<Teacher> teachers = teacherDao.teachers();
		return teachers;
	}

	// 添加教师
	public void AddTeacher(Teacher teacher) {
		teacherDao.AddTeacher(teacher);
	}

	// 添加教师账户
	public void AddTeachertUser(User user) {
		teacherDao.AddTeachertUser(user);
	}

	// 检索教师
	public List<Teacher> SerachTeacher(Teacher teacher) {
		List<Teacher> teachers = teacherDao.SerachTeacher(teacher);
		return teachers;
	}

	// 删除教师
	public void DeleteTeacher(int teaId) {
		teacherDao.DeleteTeacher(teaId);
	}

	// 编辑教师
	public void UpdateTeacher(Teacher teacher) {
		teacherDao.UpdateTeacher(teacher);
	}

	// 显示所有的教学计划
	public List<Dusty> dusties() {
		List<Dusty> dusties = teacherDao.dusties();
		return dusties;
	}

	// 新增教学计划
	public void AddDusty(Dusty dusty) {
		teacherDao.AddDusty(dusty);
	}

	// 教师处显示管理员安排的教学计划
	public List<Dusty> ShowMydusties(String teaName) {
		List<Dusty> dusties = teacherDao.ShowMydusties(teaName);
		return dusties;
	}

	// 显示我的学生
	public List<Student> ShowMyStudents(String teaName) {
		List<Student> students = teacherDao.ShowMyStudents(teaName);
		return students;
	}

	// 教师录入或更改成绩
	public void UpdateStudentGrade(String grade, String stuNum, String lessonName) {
		teacherDao.UpdateStudentGrade(grade, stuNum, lessonName);
	}

	// 教师查看成绩
	public List<Grade> ShowMyStudentsGrade(String teaName) {
		List<Grade> myStudentsGrade = teacherDao.ShowMyStudentsGrade(teaName);
		return myStudentsGrade;
	}

	// 教师检索成绩
	public List<Grade> SelectStudentGrade(String stuNum) {
		List<Grade> myStudentsGrade = teacherDao.SelectStudentGrade(stuNum);
		return myStudentsGrade;
	}

}
