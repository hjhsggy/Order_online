<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>欢迎页</title>
<link rel="stylesheet" type="text/css" href="Src/css/style.css">
</head>
<script type="text/javascript">
function logout()
{
	var name = document.getElementById("name").value;
	alert(name+"确定要注销嘛？");
}
</script> 
<body>
<div id="container">
	<div id="header">
		<div id="pic"></div>
		<div id="manage_info">
			<div id="name"><input type="text" border="1" value="${administrator.username }" disabled></div>
			<div id="logout"><input type="button" value="æ³¨é" onClick="logout()"></div>
		</div>
	</div>
	<div id="middle">
		<div id="mid_left">
			<div class="mid_left_btn"><a href="GetSpecialtyServlet">菜品管理</a></div>
			<div class="mid_left_btn"><a href="GetOrderServlet">订单管理</a></div>
			<div class="mid_left_btn"><a href="GetMemberServlet">会员管理</a></div>
			<div class="mid_left_btn"><a href="GetSystemServlet">系统管理</a></div>
		</div>
		<div id="mid_right">
			<div class="welcom">
			
			</div>
		</div>
	</div>
	<div id="footer">
		
	</div>
</div>
</body>
</html>
