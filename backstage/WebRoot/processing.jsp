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
}
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
		<div class="right_title">tip:订单正在菜品正在处理！</div>
		<div class="right_bottom">
			<ul>
				<c:forEach var="orderform" items="${orderformlists3}" varStatus="index">
        		<li>
        		 <c:forEach var="food" items="${orderform.getorderfood()}" varStatus="index">
                 <br />${food.getFname()}..........${food.getFcount()}元*${food.getNumber()}
                </c:forEach>
                <div class="count">${orderform.getPname()}</div>
        		<div class="food_name">${orderform.getOID()}</div>
        		
        		<div class="begin">
        		<input type="button" name="" value="修改订单状态" onClick="mod('${orderform.getOID()}')"/>
        		</div>
        		</li>
        		</c:forEach>
			</ul>
		</div>
		
		</div>
	</div>
</div>
</body>
