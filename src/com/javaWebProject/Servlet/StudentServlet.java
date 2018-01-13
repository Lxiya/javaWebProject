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
import com.javaWebProject.Service.StudentService;
import com.javaWebProject.Service.TeacherService;

/**
 * Servlet implementation class StudentServlet
 */
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public StudentServlet() {
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
	StudentService studentService = new StudentService();

	// 跳转到选课页面
	protected void StudentLesson(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Dusty> dusties = teacherService.dusties();

		request.setAttribute("dusties", dusties);

		request.getRequestDispatcher("/WEB-INF/student/studentLesson.jsp").forward(request, response);
	}

	// 学生选课
	protected void SelectLesson(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String term = request.getParameter("term");
		String lessonName = request.getParameter("lessonName");
		String teaName = request.getParameter("teaName");
		String stuNum = (String) request.getSession().getAttribute("stuNum");
		String grade = "暂无成绩";
		String classHour = request.getParameter("classHour");
		Dusty dusty = new Dusty(null, null, lessonName, teaName, classHour);

		studentService.SelectLesson(stuNum, dusty);
		studentService.AddStudentGrade(term, lessonName, teaName, stuNum, grade);

		request.getRequestDispatcher("/WEB-INF/student/student.jsp").forward(request, response);

	}

	// 跳转到我的课程页面
	protected void MyLesson(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String stuNum = (String) request.getSession().getAttribute("stuNum");

		List<Dusty> dusties = studentService.MyLesson(stuNum);

		request.setAttribute("dusties", dusties);
		request.getRequestDispatcher("/WEB-INF/student/myLesson.jsp").forward(request, response);
	}

	// 学生退选课
	protected void DeleteLesson(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String stuNum = (String) request.getSession().getAttribute("stuNum");
		String lessonName = request.getParameter("lessonName");

		studentService.DeleteLesson(stuNum, lessonName);
		studentService.DeleteStudentGrade(stuNum, lessonName);

		request.getRequestDispatcher("/WEB-INF/student/student.jsp").forward(request, response);
	}

	// 跳转到成绩页面
	protected void StudentGrade(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String stuNum = (String) request.getSession().getAttribute("stuNum");
		List<Grade> grades = studentService.MyGrade(stuNum);
		request.setAttribute("grades", grades);
		request.getRequestDispatcher("/WEB-INF/student/studentGrade.jsp").forward(request, response);
		System.out.println(grades);

	}
}
