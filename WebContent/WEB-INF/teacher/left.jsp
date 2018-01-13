<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<!-- 左侧 -->
    <div class="col-md-2">
        <ul class="student-control">
            <li><a href="${APP_PATH}/TeacherServlet?method=TeacherDusy">我的教学任务</a></li>
            <li><a href="${APP_PATH}/TeacherServlet?method=TeacherStudent">我的学生</a></li>
            <li><a href="${APP_PATH}/TeacherServlet?method=TeacherStudentGrade">学生成绩</a></li>
        </ul>
    </div>