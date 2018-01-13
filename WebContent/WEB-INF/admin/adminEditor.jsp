<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员的编辑操作</title>
<jsp:include page="/cssAndjs.jsp"></jsp:include>
</head>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>

<script type="text/javascript">
$(function(){
	var inputs = $('input');
	for(var i = 0; i<inputs.length; i++){
		if($(inputs[i]).val() == 'null' ||$(inputs[i]).val() == ''){
			$(inputs[i]).attr('disabled','disabled');
			$(inputs[i]).val('');
		}
	}
})
</script>
<body>
	<div class="col-md-6">
		<h1>编辑课程</h1>
		<form action="${APP_PATH}/AdminServlet?method=UpdateLesson"
			method="POST">
			<div class="form-group">
				<label for="lessonName">课程号</label> <input type="text"
					class="form-control" name="lessonId"
					value="<%=request.getParameter("lessonId")%>">
			</div>
			<div class="form-group">
				<label for="lessonName">课程名称</label> <input type="text"
					class="form-control" name="lessonName"
					value="<%=request.getParameter("lessonName")%>">
			</div>
			
			<button type="submit" class="btn btn-default btn-success">确认修改</button>
		</form>
	</div>

	<div class="col-md-6">
		<h1>编辑学生</h1>
		<form action="${APP_PATH}/AdminServlet?method=Updatestudent"
			method="post">
			<div class="form-group">
				<label for="stuId">学号</label> <input type="text"
					class="form-control" placeholder="学号" name="stuNum"
					value="<%=request.getParameter("stuNum")%>">
			</div>
			<div class="form-group">
				<label for="stuName">姓名</label> <input type="text"
					class="form-control" placeholder="姓名" name="stuName"
					value="<%=request.getParameter("stuName")%>">
			</div>
			<div class="form-group">
			<label for="stuSex">性别</label>
				<label class="radio-inline"> <input type="radio"
					name="stuSex" id="inlineRadio1" value="男">
					男
				</label> <label class="radio-inline"> <input type="radio"
					name="stuSex" id="inlineRadio2" value="女">
					女
				</label>
			</div>
			<div class="form-group">
				<label for="stuDept">所在院系</label> <select name="stuDept"
					class="form-control">
					<option value="计算机系(000)">计算机系(000)</option>
					<option value="文学系(100)">文学系(100)</option>
					<option value="政法系(200)">政法系(200)</option>
					<option value="医学系(300)">医学系(300)</option>
				</select>
			</div>


			<button type="submit" class="btn btn-success">确认修改</button>
		</form>
	</div>

	<div class="col-md-6">
		<h1>编辑教师</h1>
		<form action="${APP_PATH}/AdminServlet?method=UpdateTeacher"
			method="post">
			<div class="form-group">
				<label for="teaId">教师编号 </label> <input type="text"
					class="form-control" value="<%=request.getParameter("teaId")%>"
					name="teaId">
			</div>
			<div class="form-group">
				<label for="teaName">教师姓名</label> <input type="text"
					class="form-control" value="<%=request.getParameter("teaName")%>"
					name="teaName">
			</div>

			<div class="form-group">
				<label class="col-sm-2 col-sm-2 control-label">性 别</label> <label
					class="radio-inline"> <input name="teaSex" value="男"
					checked="" type="radio">男
				</label> <label class="radio-inline"> <input name="teaSex" value="女"
					type="radio">女 
			</div>
			<button type="submit" class="btn btn-default btn-success">确认修改</button>
		</form>
	</div>
</body>

</html>