<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<!-- 左侧 -->
<div class="col-md-2">
	<ul class="student-control">
		<li><a href="${APP_PATH}/AdminServlet?method=AdminClass">课程管理</a></li>
		<li><a href="${APP_PATH}/AdminServlet?method=AdminStudent">学生管理</a></li>
		<li><a href="${APP_PATH}/AdminServlet?method=AdminTeacher">教师管理</a></li>
		<li><a href="${APP_PATH}/AdminServlet?method=AdminDusty">教学任务</a></li>
	</ul>
</div>