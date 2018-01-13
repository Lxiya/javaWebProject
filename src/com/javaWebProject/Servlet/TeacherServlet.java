package com.javaWebProject.Servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaWebProject.JavaBean.Dusty;
import com.javaWebProject.JavaBean.Grade;
import com.javaWebProject.JavaBean.Student;
import com.javaWebProject.Service.TeacherService;

public class TeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TeacherServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String methodName = request.getParameter("method");
		try {
			Method method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class,
					HttpServletResponse.class);
			// 获取私有成员变量
			method.setAccessible(true);
			method.invoke(this, request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);

		}
	}

	TeacherService teacherService = new TeacherService();

	// 跳转到我的教学任务界面
	protected void TeacherDusy(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String teaName = (String) request.getSession().getAttribute("teaName");

		List<Dusty> myDusties = teacherService.ShowMydusties(teaName);
		request.setAttribute("myDusties", myDusties);

		request.getRequestDispatcher("/WEB-INF/teacher/teacherDusty.jsp").forward(request, response);
	}

	// 跳转到我的学生页面
	protected void TeacherStudent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String teaName = (String) request.getSession().getAttribute("teaName");

		List<Student> students = teacherService.ShowMyStudents(teaName);

		request.setAttribute("students", students);

		request.getRequestDispatcher("/WEB-INF/teacher/teacherStudent.jsp").forward(request, response);
	}

	// 跳转到我的学生成绩页面
	protected void TeacherStudentGrade(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String teaName = (String) request.getSession().getAttribute("teaName");

		List<Grade> myStudentsGrade = teacherService.ShowMyStudentsGrade(teaName);

		request.setAttribute("myStudentsGrade", myStudentsGrade);

		request.getRequestDispatcher("/WEB-INF/teacher/teacherStudentGrade.jsp").forward(request, response);
	}

	// 教师检索学生成绩
	protected void SelectStudentGrade(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String stuNum = request.getParameter("stuNum");
		System.out.println(stuNum);

		List<Grade> myStudentsGrade = teacherService.SelectStudentGrade(stuNum);
		System.out.println(myStudentsGrade);
		request.setAttribute("myStudentsGrade", myStudentsGrade);

		request.getRequestDispatcher("/WEB-INF/teacher/teacherStudentGrade.jsp").forward(request, response);
	}

	// 教师录入或更改成绩
	protected void UpdateStudentGrade(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String stuNum = request.getParameter("stuNum");
		String lessonName = request.getParameter("lessonName");
		String grade = request.getParameter("grade");

		teacherService.UpdateStudentGrade(grade, stuNum, lessonName);

		request.getRequestDispatcher("/WEB-INF/teacher/teacherStudent.jsp").forward(request, response);
	}
}
