<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>æ æ é¢ææ¡£</title>
<link rel="stylesheet" type="text/css" href="Src/css/add.css">
</head>
<body>
<div class="container">
	<div class="header">
		<div></div>
	</div>
	<div class="middle">
		<div class="left">
			
		</div>
			
		<div class="right">
			<form action="ModOrderServlet" method="post">    	
				订单状态<input type="text" name="Ostatue" value="${Order.getOstatue()}"><br>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<div class="txt">
						<input type="submit" value="    修    改    " />
						<input type="reset" value="    重    置    "></div>
			</form>
		</div>
	</div>
	<div class="bottom">
		<div class="pic">版权所有  西安石油大学计算机学院</div>
		<span class="block"></span>
		<span class="block"></span>
		<span class="block">|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;法律条款</span>
		<span class="block">|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;法律条款</span>
		<span class="block">|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;法律条款</span>
		<span class="block">|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;法律条款</span>
		<span class="block"></span>
		<span class="block"></span>
	</div>
</div>
</body>
</html>
