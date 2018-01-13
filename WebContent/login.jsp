<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>用户登录页面</title>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<jsp:include page="cssAndjs.jsp"></jsp:include>

</head>

<body>
	<div class="content login-content">
		<div class="container-fluid">

			<head>
<h1>高校成绩管理系统</h1>
			</head>

			<section>
				<form class="form-horizontal adminex-form" id="login-form" action="${APP_PATH}/UserServlet?method=login"
					method="POST">

					<div class="form-group">
						<div class="col-md-2">
							<label for="userName" class="control-label">用户名</label>
						</div>
						<div class="col-md-10">
							<input type="text" class="form-control" id="userName"
								placeholder="用户名" name="userName">
						</div>
						<div class="clearfix"></div>
					</div>

					<div class="form-group">
						<div class="col-md-2">
							<label for="password" class="control-label">密 码</label>
						</div>
						<div class="col-md-10">
							<input type="password" class="form-control" id="password"
								placeholder="密码" name="password">
						</div>
						<div class="clearfix"></div>
					</div>

					<div class="form-group">
						<div class="col-md-2">
							<label for="role" class="control-label">角 色</label>
						</div>
						<div class="col-md-10">
							<label class="radio-inline"> <input name="role" value="1"
								checked="" type="radio"> 管理员
							</label> <label class="radio-inline"> <input name="role"
								value="2" type="radio"> 教师
							</label> <label class="radio-inline"> <input name="role"
								value="3" type="radio"> 学生
							</label>
						</div>
						<div class="clearfix"></div>
					</div>



					<button type="submit"
						class="btn btn-default btn-primary btn-block btn-lg">登录</button>
				</form>
			</section>

			<footer></footer>
		</div>
	</div>
</body>

</html>