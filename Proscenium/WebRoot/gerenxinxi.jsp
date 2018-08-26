

<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>个人信息</title>
<link href="src/css/style.css" rel="stylesheet" type="text/css">
<link href="src/css/gerenxinxi.css" rel="stylesheet" type="text/css">

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
        <a href="people_index"><div class="index">个人主页</div></a>
        <a href="gerenxinxi.jsp"><div class="index ready">个人信息</div></a>
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
    <a href="modxinxi.jsp"><div class="left_button">修改个人信息</div></a>
    <a href="modmima.jsp"><div class="left_button">修改密码</div></a>
    <a href="modaddress"><div class="left_button">修改地址</div></a>
   </div>
  
   
     
      
<div class="main_2">
    <div class="main_title">个人信息</div>
        <div class="main_picture">
        <img class="picture_style" src="src/img/people.png"  width="160" height="160">
        </div>
    <div class="xinxi">账号：<span id ="count">${customistrator.username}</span></div>
    <div class="xinxi">姓名：<span id ="count">${customistrator.name}</span></div>
    <div class="xinxi">性别：<span id ="count">${customistrator.sex}</span></div>
    <div class="xinxi">积分：<span id ="count">${customistrator.VIP}</span></div>
</div>
      
        
  
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
