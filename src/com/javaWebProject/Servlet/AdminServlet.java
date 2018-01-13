package com.javaWebProject.Servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaWebProject.JavaBean.Dusty;
import com.javaWebProject.JavaBean.Lesson;
import com.javaWebProject.JavaBean.Student;
import com.javaWebProject.JavaBean.Teacher;
import com.javaWebProject.JavaBean.User;
import com.javaWebProject.Service.LessonService;
import com.javaWebProject.Service.StudentService;
import com.javaWebProject.Service.TeacherService;
import com.javaWebProject.Service.UserService;

public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminServlet() {
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

	LessonService lessonService = new LessonService();
	StudentService studentService = new StudentService();
	TeacherService teacherService = new TeacherService();
	UserService userService = new UserService();

	// 跳转到编辑页面
	protected void AdminEditor(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Teacher> teachers = teacherService.teachers();

		request.setAttribute("teachers", teachers);

		request.getRequestDispatcher("/WEB-INF/admin/adminEditor.jsp").forward(request, response);
	}

	// 跳转到课程管理页面
	protected void AdminClass(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Lesson> lessons = lessonService.lessons();
		request.setAttribute("lessons", lessons);

		List<Teacher> teachers = teacherService.teachers();
		request.setAttribute("teachers", teachers);

		request.getRequestDispatcher("/WEB-INF/admin/adminLesson.jsp").forward(request, response);
	}

	// 管理员添加课程
	protected List<Lesson> AddLesson(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String lessonName = request.getParameter("lessonName");

		Lesson lesson = new Lesson(null, lessonName);

		lessonService.AddLesson(lesson);

		request.getRequestDispatcher("/WEB-INF/admin/admin.jsp").forward(request, response);

		return null;
	}

	// 管理员删除课程
	protected void DeleteLesson(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int lessonId = Integer.parseInt(request.getParameter("lessonId"));

		lessonService.DeleteLesson(lessonId);

		request.getRequestDispatcher("/WEB-INF/admin/admin.jsp").forward(request, response);
	}

	// 管理员检索课程
	protected List<Lesson> SerachLesson(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int lessonId = Integer.parseInt(request.getParameter("lessonId"));

		Lesson lesson = new Lesson(lessonId, null);

		List<Lesson> lessons = lessonService.serachLesson(lesson);

		request.setAttribute("lessons", lessons);
		request.getRequestDispatcher("/WEB-INF/admin/adminLesson.jsp").forward(request, response);
		return lessons;

	}

	// 管理员编辑课程
	protected void UpdateLesson(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String lessonName = request.getParameter("lessonName");

		int lessonId = Integer.parseInt(request.getParameter("lessonId"));
		System.out.println(lessonId);

		lessonService.updateLesson(lessonName, lessonId);

		request.getRequestDispatcher("/WEB-INF/admin/admin.jsp").forward(request, response);
	}

	// 跳转到教师管理页面
	protected void AdminTeacher(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Teacher> teachers = teacherService.teachers();
		request.setAttribute("teachers", teachers);
		request.getRequestDispatcher("/WEB-INF/admin/adminTeacher.jsp").forward(request, response);
	}

	// 管理员添加教师信息
	protected void AddTeacher(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String teaName = request.getParameter("teaName");
		String teaSex = request.getParameter("teaSex");

		Teacher teacher = new Teacher(null, teaName, teaSex);
		User user = new User(teaName, "123456", 2);

		teacherService.AddTeacher(teacher);
		userService.addUser(user);

		request.getRequestDispatcher("/WEB-INF/admin/admin.jsp").forward(request, response);

	}

	// 管理员检索教师信息
	protected List<Teacher> SerachTeacher(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String teaName = request.getParameter("teaName");

		Teacher teacher = new Teacher(null, teaName, null);

		List<Teacher> teachers = teacherService.SerachTeacher(teacher);

		request.setAttribute("teachers", teachers);
		request.getRequestDispatcher("/WEB-INF/admin/adminTeacher.jsp").forward(request, response);

		return teachers;
	}

	// 管理员删除教师信息
	protected void DeleteTeacher(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int teaId = Integer.parseInt(request.getParameter("teaId"));

		teacherService.DeleteTeacher(teaId);

		request.getRequestDispatcher("/WEB-INF/admin/admin.jsp").forward(request, response);
	}

	// 管理员编辑教师信息
	protected void UpdateTeacher(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String teaName = request.getParameter("teaName");
		String teaSex = request.getParameter("teaSex");
		int teaId = Integer.parseInt(request.getParameter("teaId"));

		Teacher teacher = new Teacher(teaId, teaName, teaSex);

		teacherService.UpdateTeacher(teacher);

		request.getRequestDispatcher("/WEB-INF/admin/admin.jsp").forward(request, response);
	}

	// 跳转到学生管理页面
	protected void AdminStudent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Student> students = studentService.students();
		request.setAttribute("students", students);

		request.getRequestDispatcher("/WEB-INF/admin/adminStudent.jsp").forward(request, response);
	}

	// 管理员添加学生信息
	protected void AddStudent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String stuNum = request.getParameter("stuNum");
		String stuName = request.getParameter("stuName");
		String stuSex = request.getParameter("stuSex");
		String stuDept = request.getParameter("stuDept");

		Student student = new Student(stuNum, stuName, stuSex, stuDept, null, null);
		User user = new User(stuNum, "123456", 3);

		studentService.Addstudent(student);
		userService.addUser(user);
		request.getRequestDispatcher("/WEB-INF/admin/admin.jsp").forward(request, response);
	}

	// 管理员检索学生信息
	protected List<Student> SerachStudent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String stuName = request.getParameter("stuName");
		Student student = new Student(null, stuName, null, null, null, null);

		List<Student> students = studentService.SerachStudent(student);

		request.setAttribute("students", students);
		request.getRequestDispatcher("/WEB-INF/admin/adminStudent.jsp").forward(request, response);
		return students;
	}

	// 管理员删除学生信息
	protected void DeleteStudent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int stuId = Integer.parseInt(request.getParameter("stuId"));

		studentService.Deletestudent(stuId);

		request.getRequestDispatcher("/WEB-INF/admin/admin.jsp").forward(request, response);
	}

	// 管理员编辑学生信息
	protected void Updatestudent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String stuNum = request.getParameter("stuNum");
		String stuName = request.getParameter("stuName");
		String stuSex = request.getParameter("stuSex");
		String stuDept = request.getParameter("stuDept");

		Student student = new Student(stuNum, stuName, stuSex, stuDept, null, null);

		studentService.Updatestudent(student);

		request.getRequestDispatcher("/WEB-INF/admin/admin.jsp").forward(request, response);
	}

	// 跳转到教学计划安排页面
	protected void AdminDusty(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Lesson> lessons = lessonService.lessons();
		request.setAttribute("lessons", lessons);

		List<Teacher> teachers = teacherService.teachers();
		request.setAttribute("teachers", teachers);

		List<Dusty> dusties = teacherService.dusties();

		request.setAttribute("dusties", dusties);
		request.getRequestDispatcher("/WEB-INF/admin/adminDusty.jsp").forward(request, response);
	}

	// 管理员安排教学计划
	protected void AddDusty(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String term = request.getParameter("term");
		String lessonName = request.getParameter("lessonName");
		String teaName = request.getParameter("teaName");
		String classHour = request.getParameter("classHour");

		Dusty dusty = new Dusty(null, term, lessonName, teaName, classHour);

		teacherService.AddDusty(dusty);

		request.getRequestDispatcher("/WEB-INF/admin/admin.jsp").forward(request, response);
	}
}
