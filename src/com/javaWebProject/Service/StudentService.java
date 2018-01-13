package com.javaWebProject.Service;

import java.util.List;

import com.javaWebProject.Dao.StudentDao;
import com.javaWebProject.DaoImpl.StudentDaoImpl;
import com.javaWebProject.JavaBean.Dusty;
import com.javaWebProject.JavaBean.Grade;
import com.javaWebProject.JavaBean.Student;

public class StudentService {

	StudentDao studentDao = new StudentDaoImpl();

	// 查看所有学生
	public List<Student> students() {
		List<Student> students = studentDao.students();
		return students;
	}

	// 添加学生
	public void Addstudent(Student student) {
		studentDao.AddStudent(student);
	}

	// 查找学生
	public List<Student> SerachStudent(Student student) {
		List<Student> students = studentDao.SerachStudent(student);
		return students;
	}

	// 删除学生
	public void Deletestudent(int stuId) {
		studentDao.DeleteStudent(stuId);
	}

	// 编辑学生
	public void Updatestudent(Student student) {
		studentDao.UpdateStudent(student);
	}

	// 学生选课
	public void SelectLesson(String stuNum, Dusty dusty) {
		studentDao.SelectLesson(stuNum, dusty);
	}

	// 学生查看我的成绩
	public List<Grade> MyGrade(String stuNum) {
		List<Grade> grades = studentDao.MyGrade(stuNum);
		return grades;

	}

	// 学生选课的同时在成绩表中生成一条记录
	public void AddStudentGrade(String term, String lessonName, String teaName, String stuNum, String grade) {
		studentDao.AddStudentGrade(term, lessonName, teaName, stuNum, grade);
	}

	// 学生查看我的课程
	public List<Dusty> MyLesson(String stuNum) {
		List<Dusty> dusties = studentDao.MyLesson(stuNum);
		return dusties;
	}

	// 学生退选
	public void DeleteLesson(String stuNum, String lessonName) {
		studentDao.DeleteLesson(stuNum, lessonName);
	}

	// 学生在退选的同时成绩表中删除相应的记录
	public void DeleteStudentGrade(String stuNum, String lessonName) {
		studentDao.DeleteStudentGrade(stuNum, lessonName);
	}
}
