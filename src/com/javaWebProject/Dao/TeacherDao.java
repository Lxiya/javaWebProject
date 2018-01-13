package com.javaWebProject.Dao;

import java.util.List;

import com.javaWebProject.JavaBean.Dusty;
import com.javaWebProject.JavaBean.Grade;
import com.javaWebProject.JavaBean.Student;
import com.javaWebProject.JavaBean.Teacher;
import com.javaWebProject.JavaBean.User;

public interface TeacherDao {

	// 显示所有教师
	List<Teacher> teachers();

	// 添加教师
	void AddTeacher(Teacher teacher);

	// 添加教师账户
	void AddTeachertUser(User user);

	// 检索教师
	List<Teacher> SerachTeacher(Teacher teacher);

	// 删除教师
	void DeleteTeacher(int teaId);

	// 编辑教师
	void UpdateTeacher(Teacher teacher);

	// 显示所有的教学计划
	List<Dusty> dusties();

	// 新增教学计划
	void AddDusty(Dusty dusty);

	// 教师处显示管理员安排的教学计划
	List<Dusty> ShowMydusties(String teaName);

	// 显示我的学生
	List<Student> ShowMyStudents(String teaName);

	// 教师录入成绩
	void UpdateStudentGrade(String stuNum, String lessonName, String grade);

	// 教师查看成绩
	List<Grade> ShowMyStudentsGrade(String teaName);

	// 教师检索成绩
	List<Grade> SelectStudentGrade(String stuNum);
}
