<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
		<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
		<html>

		<head>
			<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
			<title>课程管理</title>
			<jsp:include page="/cssAndjs.jsp"></jsp:include>
		</head>
		<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>

			<body>
				<jsp:include page="../common/header.jsp"></jsp:include>
				<jsp:include page="left.jsp"></jsp:include>

				<!-- 右侧 -->
				<div class="col-md-10">

					<div class="serach-adminLesson pull-left">
						<form class="form-inline" action="${APP_PATH}/AdminServlet?method=SerachLesson" method="POST">
							<div class="form-group">
								<label for="lessonId">课程号</label>
								<input type="text" class="form-control" placeholder="课程号" name="lessonId">
							</div>
							<button type="submit" class="btn btn-default btn-success">查询</button>
						</form>
					</div>

					<div class="add-adminDusty pull-right">
						<button class="btn btn-default btn-success" data-toggle="modal" data-target="#myModal">+新增课程</button>
					</div>

					<table class="table table-bordered table-hover">
						<thead>
							<tr>
								<th>课程编号</th>
								<th>课程名称</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${lessons}" var="lessons">
								<tr>
									<td name="lessonId">${lessons.lessonId}</td>
									<td>${lessons.lessonName}</td>
									<td>
										<div class="btn-group">
											<a type="button" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> 操作
												<span class="caret"></span>
											</a>
											<ul class="dropdown-menu">
												<li>
													<a href="${APP_PATH}/AdminServlet?method=AdminEditor&lessonId=${lessons.lessonId}&lessonName=${lessons.lessonName}">编辑</a>
												</li>

												<li role="separator" class="divider"></li>

												<li>
													<a href="${APP_PATH}/AdminServlet?method=DeleteLesson&lessonId=${lessons.lessonId}">删除</a>
												</li>
											</ul>
										</div>
									</td>
								</tr>
							</c:forEach>

						</tbody>
					</table>
				</div>

				<!--添加课程的模态框 -->
				<form action="${APP_PATH}/AdminServlet?method=AddLesson" method="POST" class="form-horizontal adminex-form">
					<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
						<div class="modal-dialog" role="document">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal" aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
									<h4 class="modal-title" id="myModalLabel">添加课程</h4>
								</div>
								<div class="modal-body">
								
									<!-- 填写课程名称 -->
									<div class="form-group">
										<label class="col-sm-2 col-sm-2 control-label">课程名称</label>
										<div class="col-sm-10">
											<input name="lessonName" value="" class="form-control" placeholder="课程名称" type="text">
										</div>
									</div>
									
									<div class="clearfix"></div>
								</div>
								<div class="modal-footer">
									<button type="submit" class="btn btn-default">确认</button>
									<button type="button" class="btn btn-primary" data-dismiss="modal">取消</button>
								</div>
							</div>
						</div>
					</div>
				</form>



			</body>

		</html>