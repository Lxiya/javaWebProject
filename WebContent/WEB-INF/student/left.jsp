<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<!-- 左侧 -->
    <div class="col-md-2">
        <ul class="student-control">
            <li><a href="${APP_PATH}/StudentServlet?method=StudentLesson">我要选课</a></li>
            <li><a href="${APP_PATH}/StudentServlet?method=MyLesson">我的课程</a></li>
            <li><a href="${APP_PATH}/StudentServlet?method=StudentGrade">我的成绩</a></li>
        </ul>
    </div>