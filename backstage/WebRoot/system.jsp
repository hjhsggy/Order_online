<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>系统管理</title>
<link rel="stylesheet" type="text/css" href="Src/css/style.css">
</head>
<script type="text/javascript" language="javascript">
function logout()
{
	var name = document.getElementById("name").text;
	alert(name+"确定要注销登录嘛？");
}
function editButton(FID)
{
	alert(FID);
    if(confirm("确定要修改吗？"))
    location.href = "ModSpecialtyServlet?id="+FID;
}
function delButton(FID)
{
	alert(FID);
    if(confirm("确定要删除嘛？"))
    location.href = "DelSpecialtyServlet?id="+FID;
}    
</script> 
<body onload="GetSpecialtyService">
<div id="container">
	<div id="header">
		<div id="pic"></div>
		<div id="manage_info">
			<div id="name"><input type="text" border="1" value="äºXX" disabled></div>
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
			<table width="948" border="1">
				<tr>
					<td width="95">FID</td>
					<td width="98">Fname</td>
					<td width="73">Finfo</td>
					<td width="68">Fcount</td>
					<td width="125">Fpicture</td>
					<td width="235">Fother</td>
					<td width="254">Operate</td>
				</tr>
				<c:forEach var="Specialty" items="${requestScope.lists}" varStatus="status">
            	<tr <c:if test="${status.index % 2 == 1}"></c:if>>
                	<td>
                        ${Specialty.FID}
                	</td>
                	<td>
                        ${Specialty.Fname}
                	</td>
                	<td>
                        ${Specialty.Finfo}
                	</td>
                	<td>
                        ${Specialty.Fcount}
                	</td>
                	<td>
                        ${Specialty.Fpicture}
                	</td>
                	<td>
                        ${Specialty.Fother}
                	</td>
                	<td>
                    	<input type="button" value="修改" onclick="editButton(${Specialty.FID})">&nbsp;&nbsp;&nbsp;
                    	<input type="button" value="删除" onclick="delButton(${Specialty.FID})">
                	</td>
            	</tr>
       			</c:forEach>
			</table>
		</div>
	</div>
	<div id="footer"></div>
</div>
</body>
</html>
