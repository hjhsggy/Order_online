<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>

<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>咥了么-账号注册</title>
<link href="src/css/register.css" rel="stylesheet" type="text/css">
<link href="src/css/head.css" rel="stylesheet" type="text/css">
<link rel="shortcut icon" type="image/x-icon" href="favicon.ico" />
<script src="src/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
   
     $("#username").blur(function (){
      if ($("#username").val() == ''){ 
		  $("#tips_1").html("帐号不能为空!");
	  }else
	  if ($("#username").val().length> 20){ 
		  $("#tips_1").html("帐号长度不能超过20位!");
	  }
	  else{
	      $.ajax({                  
			   url: 'customRegister',  
			   type:'GET',             
			   dataType: 'text',                  
			   data:$("form").serialize(),                   
			   success: function (msg) {                        
			       $("#tips_1").html("帐号重复!");                             
			   },
			   error:function(){
			   $("#tips_1").html(""); 
			   }
			}); 
			  
	  
		  
	  }
     });
     
	 $("#password").blur(function (){
      if ($("#password").val() == ''){ 
		  $("#tips_2").html("密码不能为空!");
	  }else
	  if ($("#password").val().length< 6 ||$("#password").val().length> 20){ 
		  $("#tips_2").html("密码长度应为6-20位!");
	  }
	  else{
		  $("#tips_2").html("");
	  }
     });
	 
	 $("#password_2").blur(function (){
      if ($("#password_2").val() != $("#password").val()){ 
		  $("#tips_3").html("二次密码不一致!");
	  }
	  else{
		  $("#tips_3").html("");
	  }
     });
	 
	 $("#answer").blur(function (){
      if ($("#answer").val() == ''){ 
		  $("#tips_5").html("密保问题不能为空!");
	  }
	  else{
		  $("#tips_4").html("");
		  $("#tips_5").html("");
	  }
     });
	 
	 $("#tel").blur(function (){
      if ($("#tel").val() == ''){ 
		  $("#tips_8").html("电话不能为空!");
	  }else
	  if ($("#tel").val().length != 11 && $("#tel").val().length != 7){ 
		  $("#tips_8").html("电话号码有误!");
	  }
	  else{
		  $("#tips_8").html("");
	  }
     });
	 
	 $("#address").blur(function (){
      if ($("#address").val() == ''){ 
		  $("#tips_9").html("配送地址不能为空!");
	  }
	  else{
		  $("#tips_9").html("");
	  }
     });
     
	 $("form").submit(function (){
	  if ($("#username").val() == ''){ 
		  $("#tips_1").html("帐号不能为空!");
		  return false; 
	  }
	  if ($("#password").val() == ''){ 
		  $("#tips_2").html("密码不能为空!");
		  return false; 
	  }
	  if ($("#password_2").val() == ''){ 
		  $("#tips_3").html("二次密码不能为空!");
		  return false; 
	  }
	  if ($("#answer").val() == ''){ 
		  $("#tips_5").html("密保答案不能为空!");
		  return false; 
	  }
	  if ($("#tel").val() == ''){ 
		  $("#tips_8").html("电话号码不能为空!");
		  return false; 
	  }
	  if ($("#address").val() == ''){ 
		  $("#tips_9").html("地址不能为空!");
		  return false; 
	  }
	  if($("td#tips_1").text()!='' ||$("td#tips_2").text()!='' ||$("td#tips_3").text()!='' ||$("td#tips_5").text()!='' ||$("td#tips_8").text()!='' ||$("td#tips_9").text()!='')
	  {
		  alert("有条件未符合");
		  return false; 
	  }
	});
});
</script>
</head>

<body>
<!--版头 -->
<div class="title">
  <a href="index.html"><div class="title_logo">  </div></a>
  <div class="top">账号注册</div>
</div>

<div class="container">
  <form action="customRegister" method="post">
    
    <div class="userpass">
      <div class="left">
        <div class="circle">1</div>账号信息
      </div>
      <div class="middle"></div>
      <div class="right">
        <table width="650">
          <tr>
            <td class="txt">用 户 名*</td>
            <td><input name="username" type="text" id="username"></td>
            <td class="tips" id="tips_1">请填写您的账号</td>
          </tr>
          <tr>
            <td class="txt">密　　码*</td>
            <td><input name="password" type="text" id="password"></td>
            <td class="tips" id="tips_2">请输入您的密码</td>
          </tr>
          <tr>
            <td class="txt">二次密码*</td>
            <td><input name="password_2" type="text" id="password_2"></td>
            <td class="tips" id="tips_3"></td>
          </tr>
          <tr>
            <td class="txt">密保问题*</td>
            <td><select name="question">
                  <option value="1">你理想的身高是多少？</option>
                  <option value="2">你的爷爷的名字是？</option>
                  <option value="3">你的中学班主任的名字是？</option>
                  <option value="4">你最尊敬的人是？</option>
                  <option value="5">你最喜欢的食物是？</option>
                  <option value="6">你母亲的生日是哪一天？</option>
                  <option value="7">你父亲的生日是哪一天？</option>
                  <option value="8">你是什么时候上的高中？</option>
                  <option value="9">你梦想的职业是？</option>
                  <option value="10">你母亲的名字是？</option>
                </select></td>
            <td class="tips" id="tips_4">用来找回密码以及修改密码</td>    
          </tr>
          <tr>
            <td class="txt">密保答案*</td>
            <td><input name="answer" type="text" id="answer"></td>
            <td class="tips" id="tips_5"></td>
          </tr>
        </table>
      </div>
    </div>
    <div class="information">
      <div class="left">
        <div class="circle">2</div>个人信息
      </div>
      <div class="middle"></div>
      <div class="right">
        <table width="650">
          <tr>
            <td class="txt">姓　　名</td>
            <td><input name="name" type="text" id="name"></td>
            <td class="tips" id="tips_6"></td>
          </tr>
          <tr>
            <td class="txt">性　　别</td>
            <td><select name="sex" id="sex">
                  <option>男</option>
                  <option>女</option>
                </select></td>
            <td class="tips" id="tips_7"></td>
          </tr>
          <tr>
            <td class="txt">电话号码*</td>
            <td><input name="tel" type="text" id="tel"></td>
            <td class="tips" id="tips_8">您预留给配送员的电话号码</td>
          </tr>
          <tr>
            <td class="txt">配送地址*</td>
            <td><input name="address" type="text" id="address"></td>
            <td class="tips" id="tips_9">您需要配送外卖到的地址</td>
          </tr>
        </table>
      </div>
    </div>
    <div class="submit"><input name="register" type="submit" value="注册账号" id="register" class="register"></div>
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
