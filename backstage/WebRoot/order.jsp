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
<title>订单管理</title>
<link rel="stylesheet" type="text/css" href="Src/css/style.css">
</head>
<script type="text/javascript" language="javascript">
function logout()
{
	var name = document.getElementById("name").text;
	alert(name+"确定要注销登录嘛？");
}
function editButton(id)
{
	//alert(id);
    if(confirm("确定要修改吗？"))
    location.href = "ModOrderServlet?id="+id;
}
function delButton(id)
{
	//alert(id);
    if(confirm("确定要删除嘛？"))
    location.href = "DelOrderServlet?id="+id;
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
					<td width="70">订单编号</td>
					<td width="93">顾客编号</td>
					<td width="50">用户名</td>
					<td width="63">送餐员编号</td>
					<td width="50">地址编号</td>
					<td width="71">下单时间</td>
					<td width="71">预期时间</td>
					<td width="45">价格</td>
					<td width="71">到达时间</td>
					<td width="54">订单状态</td>
					<td width="75">订单信息</td>
					<td width="95">订单评价</td>
					<td width="90">操作</td>
				</tr>
				<c:forEach var="Order" items="${requestScope.lists}" varStatus="status">
            	<tr <c:if test="${status.index % 2 == 1}"></c:if>>
                	<td>
                        ${Order.getOID()}
                	</td>
                	<td>
                        ${Order.getCID()}
                	</td>
                	<td>
                        ${Order.getUsername()}
                	</td>
                	<td>
                        ${Order.getPID()}
                	</td>
                	<td>
                        ${Order.getAID()}
                	</td>
                	<td>
                        ${Order.getOtime()}
                	</td>
                	<td>
                		${Order.getOwish()}
                	</td>
                	<td>
                		${Order.getOcount()}
                	</td>
                	<td>
                		${Order.getOarrival()}
                	</td>
                	<td>
                		${Order.getOstatue()}
                	</td>
                	<td>
                		${Order.getOinfo()}
                	</td>
                	<td>
                		${Order.getOpingjia()}
                	</td>
                	<td>
                    	<input type="button" value="修改" onclick="editButton('${Order.getOID()}')">&nbsp;&nbsp;&nbsp;
                    	<input type="button" value="删除" onclick="delButton('${Order.getOID()}')">
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
