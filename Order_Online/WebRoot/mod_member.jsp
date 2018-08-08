<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page buffer="16kb" %> 
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
			<form action="ModMemberServlet" method="post">    	
				会员编号<input type="text" name="CID" value="${Member.getCID()}"><br> 	
				用户姓名<input type="text" name="username" value="${Member.getUsername()}"><br>   	
				密保编号<input type="text" name="qID" value="${Member.getqID()}"><br>   	
				用户密码<input type="text" name="password" value="${Member.getPassword()}"><br>
				姓	名<input type="text" name="name" value="${Member.getName()}"><br>
				性	别<input type="text" name="sex" value="${Member.getSex()}"><br>
				密保答案<input type="text" name="answer" value="${Member.getAnswer()}"><br>
				会员积分<input type="text" name="VIP" value="${Member.getVIP()}"><br>
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
