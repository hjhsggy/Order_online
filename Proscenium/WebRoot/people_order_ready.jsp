<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<link href="src/css/people_order.css" rel="stylesheet" type="text/css">
<link href="src/css/style.css" rel="stylesheet" type="text/css">
<link rel="shortcut icon" type="image/x-icon" href="favicon.ico" />
<title>我的订单-待送达</title>
</head>

<body>

<script type="text/javascript"> 
function quit(){                                                 
	    var storage=window.localStorage;
		 storage.clear();  
		 window.location.href = "index.html";                                
}
</script>  
<div class="title">
    <div class="title_logo"><a href="index.html"><img src="src/img/logo.png" width="200" height="100"></a></div>
    <div class="title_fgroup">
      <div class="fgroup_a">
        <div class="title_welcome">欢迎使用网上订餐系统！</div>
        <div class="title_title_register" id="title_1">欢迎您<span id="name">${customistrator.name}</span></div>
        <div class="title_title_login" id="title_2"><a href="javascript:void(0);" onClick="quit()">返回首页</a></div>
        <div class="title_title_collection"><a href="javascript:void(0);" onclick="AddFavorite('百度  ','http://www.baidu.com')" title="收藏本站到收藏夹">收藏我们</a></div>
      </div>
      <div class="fgroup_b">
        <a href="people_index"><div class="index ready">个人主页</div></a>
        <a href="gerenxinxi.jsp"><div class="index">个人信息</div></a>
        <a href="people_message"><div class="index">留言</div></a>
      </div>
   </div>
</div>
  
<script type="text/javascript"> 
function AddFavorite(title, url) {
	try {window.external.addFavorite(url, title);}
	catch (e) 
	{
		try {window.sidebar.addPanel(title, url, "");}
		catch (e) 
		{
			alert("抱歉，您所使用的浏览器无法完成此操作。\n\n加入收藏失败，请使用Ctrl+D进行添加");
		}
	}
}

</script>  
  
  
<div class="container">
  
  <div class="left"> 
   功能管理
    <a href="order.jsp"><div class="left_button">购物车</div></a>
    <a href="people_order_index"><div class="left_button ready">我的订单</div></a>
    <a href="jifen.jsp"><div class="left_button">我的积分</div></a>
     <a href="collection.jsp"><div class="left_button">我的收藏</div></a>
  </div>
  
  
  
<div class="main_1">
<div class="right_under"> 
      <div class="ctitle">我的订单</div>
      <div class="right_table">
        <a href="people_order_right"><div class="right_table_style">待确认</div></a>
        <a href="people_order_arrival"><div class="right_table_style">待完成</div></a>
        <a href="people_order_ready"><div class="right_table_style bg">待送达</div></a>
        <a href="people_order_index"><div class="right_table_style">待评价</div></a>
        <a href="people_order_ok"><div class="right_table_style">已评价</div></a>
      </div>
    </div>
    <div class="right_undertable">
       <ul>
         <c:forEach var="orderform" items="${orderformlists3}" varStatus="index">
        <li class="right_list">
           <div class="right_time">${orderform.getOtime()}</div>
           <div class="right_id">订单编号：${orderform.getOID()}</div>
           <div class="right_food">
             <c:forEach var="food" items="${orderform.getorderfood()}" varStatus="index">
           </br>${food.getFname()}..........${food.getFcount()}元*${food.getNumber()}
           </c:forEach>
           </div>
            <div class="right_allmoney">
            <span>${orderform.getOcount()}</span>元
           </div>
             <div class="right_pingjia">订单未完成</div>
            <div class="right_scy">配送员：${orderform.getPname()}</div>
           <div class="right_scyphone">配送员电话：${orderform.getPtel()}</div>
           <div class="right_beizhu">备注：${orderform.getOinfo()}</div> 
           <div class="right_adress">地址：${orderform.getAaddress()}</div>
         </li>
      </c:forEach>
       </ul>
    </div>
     
       


</div></div>



<div class="last">
	<div class="pic"></div>
	<div class="tel">订餐电话：123456789</div>
	<div class="detail">咥了么宅急送不同时段产品品项及价格有所不同。工作日特惠午餐只在部分时段供应。详情以输入送餐地址后显示的实际供应的菜单为准</div>
	<span class="list">|&nbsp;&nbsp;&nbsp;&nbsp;<a href="">帮助中心</a></span>
	<span class="list">|&nbsp;&nbsp;&nbsp;&nbsp;<a href="">会员中心</a></span>
	<span class="list">|&nbsp;&nbsp;&nbsp;&nbsp;<a href="">网站条款</a></span>
	<span class="list">|&nbsp;&nbsp;&nbsp;&nbsp;<a href="">站点首页</a>&nbsp;&nbsp;&nbsp;&nbsp;|</span>
	<div class="copyright">版权所有 鄠邑区西安石油大学计算机学院</div>
</div>
</body>
</html>
