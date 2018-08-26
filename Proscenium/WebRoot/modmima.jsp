<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>修改密码</title>
<link href="src/css/modxinxi.css" rel="stylesheet" type="text/css">
<link href="src/css/style.css" rel="stylesheet" type="text/css">
<script src="src/js/jquery-1.11.1.min.js"></script>
</head>

<body>

<script type="text/javascript"> 
function quit(){                                                 
	    var storage=window.localStorage;
		 storage.clear();  
		 window.location.href = "index.html";                                
}

$(document).ready(function(){
     $("#answer").blur(function (){
      if ($("#answer").val() == ''){ 
		  $("#a1").html("密保问题不能为空!");
	  }
	  else if($("#answer").val()!=$("#a").html())
	  {
	      $("#a1").html("密保问题答案错误!");
	  }else{
		  $("#a1").html("");
		  $("#a5").html("");
	  }
     });
     
	 $("#oldpass").blur(function (){
      if ($("#oldpass").val() == ''){ 
		  $("#a2").html("密码不能为空!");
	  }else
	  if ($("#oldpass").val().length< 6 ||$("#oldpass").val().length> 20){ 
		  $("#a2").html("密码长度应为6-20位!");
	  }
	  else
	  if($("#oldpass").val() !=$("#b").html()){
	      $("#a2").html("原密码错误!");
		  
	  }else{
	      $("#a2").html("");
	  }
     });
	 
	 $("#newpass").blur(function (){
      if ($("#newpass").val() == ''){ 
		  $("#a3").html("密码不能为空!");
	  }else
	  if ($("#newpass").val().length< 6 ||$("#newpass").val().length> 20){ 
		  $("#a3").html("密码长度应为6-20位!");
	  }
	  else{
		  $("#a3").html("");
	  }
     });
	 $("#newpass_2").blur(function (){
      if ($("#newpass_2").val() != $("#newpass").val()){ 
      alert($("#newpass_2").val());
		  $("#a4").html("二次密码不一致!");
	  }
	  else{
		  $("#a4").html("");
	  }
     });

	 $("form").submit(function (){
	  if ($("#answer").val() == ''){ 
		  $("#a1").html("密保答案不能为空!");
		  return false; 
	  }
      if ($("#oldpass").val() == ''){ 
		  $("#a2").html("原密码不能为空!");
		  return false; 
	  }
	  if ($("#newpass").val() == ''){ 
		  $("#a3").html("新密码不能为空!");
		  return false; 
	  } 	  
      if ($("#newpass_2").val() == ''){ 
		  $("#a4").html("二次密码不能为空!");
		  return false; 
	  }
	  if($("td#a1").text()!='' ||$("td#a2").text()!='' ||$("td#a3").text()!='' ||$("td#a4").text()!='' ||$("td#a5").text()!='')
	  {
		  alert("有条件未符合");
		  return false; 
	  }
	});
});
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
    <div class="main_1">
    <form action="people_modpassword" method="post">
    修改密码
      <table width="700">
        <tr>
          <td width="100">密保问题</td>
          <td width="300">${customistrator.question}</td>
          <td width="300" id="a5">请回答问题</td>
        </tr>
        <tr>
          <td>密保答案</td>
          <td ><input id="answer" name="answer" type="text"></td>
          <td id="a1">&nbsp;</td>
        </tr>
        <tr>
          <td>密　　码</td>
          <td ><input id="oldpass" name="oldpass" type="text"></td>
          <td id="a2">&nbsp;</td>
        </tr>
        <tr>
          <td>新 密 码</td>
          <td ><input id="newpass" name="newpass" type="text"></td>
          <td id="a3">&nbsp;</td>
        </tr>
        <tr>
          <td>二次密码</td>
          <td ><input id="newpass_2" name="newpass_2" type="text"></td>
          <td id="a4">&nbsp;</td>
        </tr>
        <tr>
          <td></td>
          <td><input name="register" type="submit" value="修改" id="register" class="register"></td>
          <td></td>
        </tr>
      </table>       
       <span id="a" style="display:none;">${customistrator.answer}</span>
        <span id="b" style="display:none;">${customistrator.password}</span>
    </form>
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

