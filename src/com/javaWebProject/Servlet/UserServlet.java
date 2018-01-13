package com.javaWebProject.Servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaWebProject.JavaBean.User;
import com.javaWebProject.Service.UserService;

public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserServlet() {
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

	UserService userService = new UserService();

	// 验证用户身份
	protected void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		int role = Integer.parseInt(request.getParameter("role"));

		if ("".equals(userName.trim()) || "".equals(password.trim())) {
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}

		User user = new User(userName, password, role);

		Integer i = userService.login(user);

		if (i != 0) {
			switch (role) {
			case 1:
				request.getRequestDispatcher("/WEB-INF/admin/admin.jsp").forward(request, response);
				break;
			case 2:
				request.getSession().setAttribute("teaName", userName);
				request.getRequestDispatcher("/WEB-INF/teacher/teacher.jsp").forward(request, response);
				break;
			case 3:
				request.getSession().setAttribute("stuNum", userName);
				request.getRequestDispatcher("/WEB-INF/student/student.jsp").forward(request, response);
				break;
			}
		} else {
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}

	}

}
