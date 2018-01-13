package com.javaWebProject.Dao;

import java.util.List;

import com.javaWebProject.JavaBean.Dusty;
import com.javaWebProject.JavaBean.Grade;
import com.javaWebProject.JavaBean.Student;

public interface StudentDao {

	// 管理员查看所有学生
	List<Student> students();

	// 管理员添加学生
	void AddStudent(Student student);

	// 管理员查找学生
	List<Student> SerachStudent(Student student);

	// 管理员删除学生
	void DeleteStudent(int stuId);

	// 管理员编辑学生
	void UpdateStudent(Student student);

	// 学生选课
	void SelectLesson(String stuNum, Dusty dusty);

	// 学生选课的同时在成绩表中生成一条记录
	void AddStudentGrade(String term, String lessonName, String teaName, String stuNum, String grade);

	// 学生查看我的课程
	List<Dusty> MyLesson(String stuNum);

	// 学生查看我的成绩
	List<Grade> MyGrade(String stuNum);

	// 学生退选
	void DeleteLesson(String stuNum, String lessonName);

	// 学生在退选的同时成绩表中删除相应的记录
	void DeleteStudentGrade(String stuNum, String lessonName);

}
