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
			<form action="ModOrderServlet" method="post">    	
				订单编号<input type="text" name="OID" value="${Order.getOID()}"><br> 	
				顾客编号<input type="text" name="CID" value="${Order.getCID()}"><br>   	
				用  户  名<input type="text" name="username" value="${Order.getUsername()}"><br>   	
				送餐员编号<input type="text" name="PID" value="${Order.getPID()}"><br>
				地址编号<input type="text" name="AID" value="${Order.getAID()}"><br>
				送达时间<input type="text" name="Otime" value="${Order.getOtime()}"><br>
				期望时间<input type="text" name="Owish" value="${Order.getOwish()}"><br>
				价         格<input type="text" name="Ocount" value="${Order.getOcount()}"><br>
				到达时间<input type="text" name="Oarrival" value="${Order.getOarrival()}"><br>
				订单状态<input type="text" name="Ostatue" value="${Order.getOstatue()}"><br>
				订单信息<input type="text" name="Oinfo" value="${Order.getOinfo()}"><br>
				订单评价<input type="text" name="Opingjia" value="${Order.getOpingjia()}">
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
