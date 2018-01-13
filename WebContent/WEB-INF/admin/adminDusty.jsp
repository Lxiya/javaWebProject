<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教学计划安排</title>
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
		<div class="add-adminDusty pull-right">
			<button class="btn btn-default btn-success" data-toggle="modal" data-target="#myModal">+新增教学计划</button>
		</div>
		<table class="table table-bordered table-hover">
			<thead>
				<tr>
					<th>学期</th>
					<th>课程</th>
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
									> 操作 <span
									class="caret"></span>
								</a>
								<ul class="dropdown-menu">
									<li><a href="">编辑</a></li>
									<li role="separator" class="divider"></li>
									<li><a href="">删除</a>
									</li>
								</ul>
							</div>
						</td>
					</tr>
					</c:forEach>
				
			</tbody>
		</table>
	</div>

	<!--添加教学计划的模态框 -->
	<form action="${APP_PATH}/AdminServlet?method=AddDusty" method="POST"
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
						<h4 class="modal-title" id="myModalLabel">新增教学计划</h4>
					</div>
					<div class="modal-body">
						<!-- 填写学期 -->
						<div class="form-group">
							<label class="col-sm-2 col-sm-2 control-label">学　　期</label>
							<div class="col-sm-10">
								<select name="term"
					class="form-control">
					<option value="一">一</option>
					<option value="二">二</option>
					<option value="三">三</option>
					<option value="四">四</option>
				</select>
							</div>
						</div>

						<!-- 选择课程名 -->
						<div class="form-group">
							<label class="col-sm-2 col-sm-2 control-label">课程名称</label>
							<div class="col-sm-10">
								<select name="lessonName"
					class="form-control">
					
					<c:forEach items="${lessons}" var="lessons">
					<option value="${lessons.lessonName}">${lessons.lessonName}</option>
					</c:forEach>
							
					
							</select>
							</div>
						</div>
						
						<!-- 选择任课教师-->
						<div class="form-group">
							<label class="col-sm-2 col-sm-2 control-label">任课教师</label>
							<div class="col-sm-10">
								<select name="teaName"
					class="form-control">
					<c:forEach items="${teachers}" var="teachers">
					<option value="${teachers.teaName}">${teachers.teaName}</option>
					</c:forEach>
							</select>
							</div>
						</div>
						
							<!-- 选择课时-->
						<div class="form-group">
							<label class="col-sm-2 col-sm-2 control-label">课　　时</label>
							<div class="col-sm-10">
								<select name="classHour"
					class="form-control">
					<option value="24">24</option>
					<option value="30">30</option>
					<option value="36">36</option>
					<option value="24">40</option>
							</select>
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