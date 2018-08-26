<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>菜品管理</title>
<link rel="stylesheet" type="text/css" href="Src/css/style.css">
</head>
<script type="text/javascript">
function logout()
{
	var name = document.getElementById("name").text;
	alert(name+"确定要注销登录嘛？");
}
function editButton(FID)
{
    if(confirm("确定要修改吗？"))
    location.href = "ModSpecialtyServlet?id="+FID;
}
function delButton(FID)
{
    if(confirm("确定要删除嘛？"))
    location.href = "DelSpecialtyServlet?id="+FID;
}    
</script> 
<body>
<div id="container">
	<div id="header">
		<div id="pic"></div>
		<div id="manage_info">
			<div id="name"><input type="text" border="1" value="于长勋" disabled></div>
			<div id="logout"><input type="button" value="注销" onClick="logout()"></div>
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
					<td><a href="AddSpecialtyServlet">添加</a></td>
				</tr>
				<tr>
					<td width="95">菜品编号</td>
					<td width="98">菜品名称</td>
					<td width="254">菜品介绍</td>
					<td width="68">价格</td>
					<td width="235">图片源</td>
					<td width="73">备注</td>
					<td width="125">操作</td>
				</tr>
				<c:forEach var="Specialty" items="${requestScope.lists}" varStatus="status">
            	<tr <c:if test="${status.index % 2 == 1}"></c:if>>
                	<td>
                        ${Specialty.getFID()}
                	</td>
                	<td>
                        ${Specialty.getFname()}
                	</td>
                	<td>
                        ${Specialty.getFinfo()}
                	</td>
                	<td>
                        ${Specialty.getFcount()}
                	</td>
                	<td>
                        ${Specialty.getFpicture()}
                	</td>
                	<td>
                        ${Specialty.getFother()}
                	</td>
                	<td>
                    	<input type="button" value="修改" onclick="editButton('${Specialty.getFID()}')">&nbsp;&nbsp;&nbsp;
                    	<input type="button" value="删除" onclick="delButton('${Specialty.getFID()}')">
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
