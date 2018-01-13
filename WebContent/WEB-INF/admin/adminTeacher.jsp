<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教师管理</title>
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
			<form class="form-inline"
				action="${APP_PATH}/AdminServlet?method=SerachTeacher" method="POST">
				<div class="form-group">
					<label for="lessonId">教师姓名</label> <input class="form-control"
						placeholder="姓名" name="teaName" type="text">
				</div>
				<button type="submit" class="btn btn-default btn-success">查询</button>
			</form>
		</div>
		<div class="add-adminDusty pull-right">
			<button class="btn btn-default btn-success" data-toggle="modal"
				data-target="#myModal">+新增师资力量</button>
		</div>
		<table class="table table-bordered table-hover">
			<thead>
				<tr>
					<th>教师编号</th>
					<th>姓名</th>
					<th>性别</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${teachers}" var="teachers">
					<tr>
						<td>${teachers.teaId}</td>
						<td>${teachers.teaName}</td>
						<td>${teachers.teaSex}</td>
						<td>
							<div class="btn-group">
								<a type="button" class="dropdown-toggle" data-toggle="dropdown">
									操作 <span class="caret"></span>
								</a>
								<ul class="dropdown-menu">
									<li><a href="${APP_PATH}/AdminServlet?method=AdminEditor&teaName=${teachers.teaName}&teaId=${teachers.teaId}">编辑</a></li>

									<li role="separator" class="divider"></li>

									<li><a href="${APP_PATH}/AdminServlet?method=DeleteTeacher&teaId=${teachers.teaId}">删除</a></li>


								</ul>
							</div>
						</td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
	</div>
	<!--添加教师的模态框 -->
	<form action="${APP_PATH}/AdminServlet?method=AddTeacher" method="POST"
		class="form-horizontal adminex-form">
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">新增师资力量</h4>
					</div>
					<div class="modal-body">
						<!-- 填写教师名称 -->
						<div class="form-group">
							<label class="col-sm-2 col-sm-2 control-label">教师姓名</label>
							<div class="col-sm-10">
								<input name="teaName" value="" class="form-control"
									placeholder="教师姓名" type="text">
							</div>
						</div>

						<!-- 选择教师性别 -->
						<div class="form-group">
							<label class="col-sm-2 col-sm-2 control-label">性 别</label>
							<div class="col-sm-10">
								<label class="radio-inline"> <input name="teaSex"
									value="男" checked="" type="radio">男
								</label> <label class="radio-inline"> <input name="teaSex"
									value="女" type="radio">女 
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