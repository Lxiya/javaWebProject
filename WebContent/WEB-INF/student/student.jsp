<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生页</title>
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
     <p>在左侧选择对应的操作</p>
    </div>
</body>
</html>