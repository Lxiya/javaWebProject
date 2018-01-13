<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生选课</title>
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
	<div class="col-md-10">
		<table class="table table-bordered table-hover">
			<thead>
				<tr>
				    <th>学期</th>
					<th>课程名称</th>
					<th>授课教师</th>
					<th>课时</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${dusties}" var="dusties">
					<tr>
					    <td>${dusties.term}</td>
						<td>${dusties.lessonName}</td>
						<td>${dusties.teaName}</td>
						<td>${dusties.classHour}</td>
						<td>
							<div class="btn-group">
								<a type="button" class="dropdown-toggle" data-toggle="dropdown"
									aria-haspopup="true" aria-expanded="false"> 操作 <span
									class="caret"></span>
								</a>
								<ul class="dropdown-menu">
									<li><a href="${APP_PATH}/StudentServlet?method=SelectLesson&term=${dusties.term}&lessonName=${dusties.lessonName}&teaName=${dusties.teaName}&classHour=${dusties.classHour}">选课</a></li>
								</ul>
							</div>
						</td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
	</div>
</body>
</html>