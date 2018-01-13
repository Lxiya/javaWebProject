<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生成绩</title>
<jsp:include page="/cssAndjs.jsp"></jsp:include>
</head>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>

<body>
	<jsp:include page="../common/header.jsp"></jsp:include>
	<!-- 左侧 -->
	<jsp:include page="left.jsp"></jsp:include>

	<!-- 右侧 -->
	<div class="serach-adminLesson pull-left">
			<form class="form-inline" action="/javaWebProject/TeacherServlet?method=SelectStudentGrade" method="POST">
				<div class="form-group">
					<label for="lessonId">学生学号</label> <input class="form-control" placeholder="学号" name="stuNum" type="text">
				</div>
				<button type="submit" class="btn btn-default btn-success">查询</button>
			</form>
		</div>
	<div class="col-md-10">
		<table class="table table-bordered table-hover">
			<thead>
				<tr>
					<th>学期</th>
					<th>课程名</th>
					<th>学号</th>
					<th>成绩</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${myStudentsGrade}" var="myStudentsGrade">
				<tr>
					<td>${myStudentsGrade.term}</td>
					<td>${myStudentsGrade.lessonName}</td>
					<td>${myStudentsGrade.stuNum}</td>
					<td>${myStudentsGrade.grade}</td>
				</tr>
			</c:forEach>
			



			</tbody>
		</table>
	</div>
</body>

</html>