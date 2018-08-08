<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>菜品修改</title>
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
			<form action="ModSpecialtyServlet" method="post">    	
				菜品编号<input type="text" name="FID" value="${Specialty.getFID()}"><br> 	
				菜品名称<input type="text" name="Fname" value="${Specialty.getFname()}"><br>   	
				菜品介绍<input type="text" name="Finfo" value="${Specialty.getFinfo()}"><br>   	
				价    　　格<input type="text" name="Fcount" value="${Specialty.getFcount()}"><br>
				图    片    源<input type="text" name="Fpicture" value="${Specialty.getFpicture()}"><br>
				备             注<input type="text" name="Fother" value="${Specialty.getFother()}"><br>
				<div class="txt">
						<input type="submit" value="    修    改    " />
						<input type="reset" value="    重    置    ">
				</div>
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
