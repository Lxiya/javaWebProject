<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
		<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
		<html>

		<head>
			<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
			<title>我的学生</title>
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
								<th>学号</th>
								<th>姓名</th>
								<th>专业</th>
								<th>课程</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody>

							<c:forEach items="${students}" var="students">
								<tr>
									<td>${students.stuNum}</td>
									<td>${students.stuName}</td>
									<td>${students.stuDept}</td>
									<td>${students.lessonName}</td>
									<td>
										<a type="button" class="dropdown-toggle changeGrade" data-toggle="modal" data-target="#myModal"> 录入/修改 </a>
									</td>
								</tr>
							</c:forEach>



						</tbody>
					</table>
				</div>

				<!-- 录入成绩的模态框 -->
				<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
					<div class="modal-dialog" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal" aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
								<h4 class="modal-title" id="myModalLabel">学生成绩录入</h4>
							</div>
							<form action="${APP_PATH}/TeacherServlet?method=UpdateStudentGrade" method="post" class="form-horizontal adminex-form studentInfo">
								<div class="modal-body">

									<div class="form-group">
										<label class="col-sm-2 col-sm-2 control-label">学号</label>
										<div class="col-sm-10">
											<input name="stuNum" value="" class="form-control" type="text">
										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-2 col-sm-2 control-label">姓名</label>
										<div class="col-sm-10">
											<input name="stuName" value="" class="form-control" type="text">
										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-2 col-sm-2 control-label">专业</label>
										<div class="col-sm-10">
											<input name="stuDept" value="" class="form-control" type="text">
										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-2 col-sm-2 control-label">课程</label>
										<div class="col-sm-10">
											<input name="lessonName" value="" class="form-control" type="text">
										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-2 col-sm-2 control-label">成绩</label>
										<div class="col-sm-10">
											<input name="grade" value="" class="form-control" type="text">
										</div>
									</div>

								</div>
								<div class="modal-footer">
									<button type="submit" class="btn btn-default changeGrade">录入/修改</button>
									<button type="button" class="btn btn-primary" data-dismiss="modal">取消</button>
								</div>
							</form>

						</div>
					</div>
				</div>

				<script>
					var studentInfoInput = $('.studentInfo  input');
					var studentInfo = '';
					$('.changeGrade').click(function () {
						for (var i = 0; i < $(this).parent().parent().children().length - 1; i++) {
							studentInfo = $(this).parent().parent().children('td').get(i).innerHTML;
							$(studentInfoInput[i]).val(studentInfo);
						}

					})
				</script>


			</body>

		</html>