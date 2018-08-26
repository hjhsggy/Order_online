<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>æ æ é¢ææ¡£</title>
<link rel="stylesheet" type="text/css" href="Src/css/style.css">
</head>
<script type="text/javascript">
function logout()
{
	var name = document.getElementById("name").text;
	alert(name+"确定要注销登录嘛？");
}
function editButton(id)
{
	//alert(id);
    if(confirm("确定要修改吗？"))
    location.href = "ModMemberServlet?id="+id;
}
function delButton(id)
{
	//alert(id);
    if(confirm("确定要删除嘛？"))
    location.href = "DelMemberServlet?id="+id;
}    
</script> 
<body>
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
					<td width="80">用户编号</td>
					<td width="80">用户名</td>
					<td width="100">密保问题编号</td>
					<td width="100">密码</td>
					<td width="100">姓名</td>
					<td width="100">性别</td>
					<td width="120">密保答案</td>
					<td width="100">会员积分</td>
					<td width="120">操作</td>
				</tr>
				<c:forEach var="Member" items="${requestScope.lists}" varStatus="status">
            	<tr <c:if test="${status.index % 2 == 1}"></c:if>>
                	<td>
                        ${Member.getCID()}
                	</td>
                	<td>
                        ${Member.getUsername()}
                	</td>
                	<td>
                        ${Member.getqID()}
                	</td>
                	<td>
                        ${Member.getPassword()}
                	</td>
                	<td>
                        ${Member.getName()}
                	</td>
                	<td>
                        ${Member.getSex()}
                	</td>
                	<td>
                		${Member.getAnswer()}
                	</td>
                	<td>
                		${Member.getVIP()}
                	</td>
                	<td>
                    	<input type="button" value="修改" onclick="editButton('${Member.getCID()}')">&nbsp;&nbsp;&nbsp;
                    	<input type="button" value="删除" onclick="delButton('${Member.getCID()}')">
                	</td>
            	</tr>
       			</c:forEach>
			</table>
		</div>
	</div>
	<div id="footer">
		
	</div>
</div>
</body>
</html>
