<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link type="text/css" rel="stylesheet" href="Src/css/back.css" />
<script type="javascript">
function mod(OID)
{
	if(confirm("确定要修改吗？"))
    location.href = "ModOrderStatueServlet?id="+OID;
}
function history()
{
	loaction.href = "";
}S
function count()
{
	location.href = "";
}
</script>
</head>

<body>
<div class="container">
	<div class="header">
		<div class="pic"></div>
		<div class="info"></div>
	</div>
	<div class="middle">
		<div class="left">
			<div class="menu">待完成订单
				<span class="left_title"><a href="people_order_right">未确认订单</a></span>
				<span class="left_title"><a href="people_order_arrival">已确认订单</a></span>
				<span class="left_title"><a href="people_order_ready">未处理订单</a></span>
				<span class="left_title"><a href="people_order_ok">未完成订单</a></span>
			</div>
			<div class="history" onclick="history()">历史订单</div>
			<div class="count" onclick="count()">统计</div>
		</div>
		<div class="right">
		<div class="right_title">订单查询和统计</div>
		<div class="right_bottom">
			<div id="order">
				<div>根据订单编号查询
				<input type="text" id="order_id"/><input type="button" value="查询"/>
				</div>
				<div class="show">
				
				</div>
			</div>
			<div id="count">
				统计订单数量
				<input type="text" id="count"/><input type="button" value="统计" />
			</div>
		</div>
		
		</div>
	</div>
</div>
</body>
