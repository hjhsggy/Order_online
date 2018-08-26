<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>咥了么-美食图鉴</title>
<link href="src/css/order.css" rel="stylesheet" type="text/css">
<link href="src/css/head.css" rel="stylesheet" type="text/css">
<link rel="shortcut icon" type="image/x-icon" href="favicon.ico" />
<script src="src/js/jquery-1.11.1.min.js"></script>
</head>



<body>
<script type="text/javascript"> 

function openindex() {
	if($("#name").html() == ""){
	   food.style.display = "none";
	   login.style.display = "block";
	}else{
	window.location.href = "people_index";
	}
}

function quit(){
	$.ajax({                  
	    url: 'useSession',  
	    type:'GET',             
	    dataType: 'text',                  
	    data: $("form").serialize(),                  
	    success: function () {                                                   
	    var storage=window.localStorage;
		 storage.clear();  
		 window.location.href = "index.html";                                   
	    }
    });                                        
}
$(document).ready(function(){
           $.ajax({                  
			   url: 'customlogin',  
			   type:'GET',             
			   dataType: 'text',                  
			   data: $("form").serialize(),                  
			   success: function (msg) {                      
			   if (msg != "error"){   
			        $("span#name")[0].innerHTML=msg;                                                                
				}  
			   }
			});    
	 $("form").submit(function (){
	  if ($("#username").val() == '' || $("#password").val() == ''){ 
		  $("div.error").html("帐号和密码不能为空!");
		  return false; 
		  }else{   
			  login.style.display = "none"; 
			  title_1.style.display = "block";
			  title_2.style.display = "block";
			  title_3.style.display = "none"; 
			  title_4.style.display = "none";                         
		        
		 }        
	return false;  
	});
});
</script>
    
<!--版头 -->
<div class="title">
  <a href="index.html"><div class="title_logo">  </div></a>
  <div class="title_welcome">欢迎使用网上订餐系统！</div>
  <div class="title_title">
    <div class="title_title_register" id="title_1">欢迎您<span id="name"></span></div>
    <div class="title_title_login" id="title_2"><a href="javascript:void(0);" onClick="quit()">注销</a></div>
    <div class="title_title_order"><a href="chaxun.jsp">订单查询</a></div>
    <div class="title_title_collection"><a href="javascript:void(0);" onclick="AddFavorite('百度','http://www.baidu.com')" title="收藏本站到收藏夹">收藏我们</a></div>
  </div>
  <div class="title_functiongroup">
    <a href="index.html"><div class="index"><div class="txt">首　　页</div></div></a>
    <a href="menu?tID=4"><div class="index"><div class="txt">浏览菜品</div></div></a>
    <a href="javascript:void(0);" onClick="openindex()"><div class="index"><div class="txt">我的主页</div></div></a>
    <a href="help.html"><div class="index"><div class="txt">帮助中心</div></div></a>
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
<div class="line"></div>

<div class="container">

<div class="form_title">我的购物车</div>
<div class="order_form">

<div class="food_title">
<div class="food_titlename">菜品</div>
<div class="food_titlenumber">数量</div>
<div class="food_titlemoney">单价</div>
<div class="food_titleallmoney">总价</div>
</div>

</div>
<div class="form_right">不设最低起送金额，每单酌收5元外送费。为了保证食物品质，咥了么有送餐范围和服务时间限制。</div>

<div class="allmoney">合计:<span id="money"></span>元</div>
<div class="time">预约取餐</div><div class="yn"><span id="yes">√</span><span id="no">√</span></div>
<div class="time_popup">
  <select id="wish" name="wish">
    <option value="0" selected>不需要</option>
    <option value="1800">半小时后</option>
    <option value="3600">1小时后</option>
    <option value="7200">2小时后</option>
  </select>
</div>
<div class="user">
  <div class="time">输入留言</div>
  <textarea id="liuyan" name="liuyan" cols="50" rows="5"></textarea>
</div>
<div class="user">
  <div class="time">选择地址</div>
  <div class="time_address">
  
  <select id="Asaddress" name="Asaddress">
  <c:forEach var="address" items="${addressList}" varStatus="index">
     <option value="${address.getAID()}">地址：${address.getAaddress()}/电话：${address.getAtel()}</option>
  </c:forEach>
  </select>
  
  </div>
</div>

<div class="time_buttom">提交订单</div>
</div>

</div>
<script type="text/javascript">
function del(a){	
	var num=parseInt($(a).parent().find(".food_number").html())-1;
	if(num==0){
		$(a).parent().remove();
	}else{
		var count=$(a).parent().find(".food_money").html();
		$(a).parent().find(".food_number").html(num);
		$(a).parent().find(".food_allmoney").html((count*num).toFixed(2));
	}
	var money=0;
	$(".food_allmoney").each(function(){money+=parseFloat($(this).text())});
	$("#money").html((money).toFixed(2));
	var storage=window.localStorage;
		var a=$("div.food").length;
		var FID=new Array();
		var Fname=new Array();
		var Fcount=new Array();
		var Fnumber=new Array();
		for(var i=0;i<parseInt(a);i++)
		{
			FID[i]=$(".food").eq(i).attr("FID");
			Fname[i]=$(".food_name").eq(i).html();
			Fnumber[i]=$(".food_number").eq(i).html();
			Fcount[i]=parseFloat($(".food_money").eq(i).html());
		}
		var JFID = JSON.stringify(FID); 
		var JFname = JSON.stringify(Fname); 
		var JFnumber = JSON.stringify(Fnumber); 
		var JFcount = JSON.stringify(Fcount); 
            storage.FID=JFID;
			storage.Fname=JFname;
			storage.Fcount=JFcount;
			storage.Fnumber=JFnumber;
			storage.a=a;
            console.log(typeof storage["FID"]);
            console.log(typeof storage["Fname"]);
            console.log(typeof storage["Fcount"]);
			console.log(typeof storage["Fnumber"]);
			console.log(typeof storage["a"]);
	
}
function add(a){
	var num=parseInt($(a).parent().find(".food_number").html())+1;
	var count=$(a).parent().find(".food_money").html();
	$(a).parent().find(".food_number").html(num);
	$(a).parent().find(".food_allmoney").html((count*num).toFixed(2));
	var money=0;
	$(".food_allmoney").each(function(){money+=parseFloat($(this).text())});
	$("#money").html((money).toFixed(2));
	
	var storage=window.localStorage;
		var a=$("div.food").length;
		var FID=new Array();
		var Fname=new Array();
		var Fcount=new Array();
		var Fnumber=new Array();
		for(var i=0;i<parseInt(a);i++)
		{
			FID[i]=$(".food").eq(i).attr("FID");
			Fname[i]=$(".food_name").eq(i).html();
			Fnumber[i]=$(".food_number").eq(i).html();
			Fcount[i]=parseFloat($(".food_money").eq(i).html());
		}
		var JFID = JSON.stringify(FID); 
		var JFname = JSON.stringify(Fname); 
		var JFnumber = JSON.stringify(Fnumber); 
		var JFcount = JSON.stringify(Fcount); 
            storage.FID=JFID;
			storage.Fname=JFname;
			storage.Fcount=JFcount;
			storage.Fnumber=JFnumber;
			storage.a=a;
            console.log(typeof storage["FID"]);
            console.log(typeof storage["Fname"]);
            console.log(typeof storage["Fcount"]);
			console.log(typeof storage["Fnumber"]);
			console.log(typeof storage["a"]);
}
function delete1(a){	
	$(a).parent().remove();
	var money=0;
	$(".food_allmoney").each(function(){money+=parseFloat($(this).text())});
	$("#money").html((money).toFixed(2));
	var storage=window.localStorage;
		var a=$("div.food").length;
		var FID=new Array();
		var Fname=new Array();
		var Fcount=new Array();
		var Fnumber=new Array();
		for(var i=0;i<parseInt(a);i++)
		{
			FID[i]=$(".food").eq(i).attr("FID");
			Fname[i]=$(".food_name").eq(i).html();
			Fnumber[i]=$(".food_number").eq(i).html();
			Fcount[i]=parseFloat($(".food_money").eq(i).html());
		}
		var JFID = JSON.stringify(FID); 
		var JFname = JSON.stringify(Fname); 
		var JFnumber = JSON.stringify(Fnumber); 
		var JFcount = JSON.stringify(Fcount); 
            storage.FID=JFID;
			storage.Fname=JFname;
			storage.Fcount=JFcount;
			storage.Fnumber=JFnumber;
			storage.a=a;
            console.log(typeof storage["FID"]);
            console.log(typeof storage["Fname"]);
            console.log(typeof storage["Fcount"]);
			console.log(typeof storage["Fnumber"]);
			console.log(typeof storage["a"]);
}

$(document).ready(function(){
	var storage=window.localStorage;
    var JFID=storage.FID;
    var JFname=storage.Fname;
    var JFcount=storage.Fcount;
    var JFnumber=storage.Fnumber;
    var a=storage.a;
    
    var FID=JSON.parse(JFID);
    var Fname=JSON.parse(JFname);
    var Fcount=JSON.parse(JFcount);
    var Fnumber=JSON.parse(JFnumber);
	var i=0;
    for(var i=0;i<parseInt(a);i++)
    {
 	    $(".order_form").append('<div class="food" FID="'+FID[i]+'"><div class="food_name">'+Fname[i]+'</div><div class="food_del"  onClick="del(this)">-</div><div class="food_number">'+Fnumber[i]+'</div><div class="food_add"  onClick="add(this)">+</div><div class="food_money">'+(Fcount[i]).toFixed(2)+'</div><div class="food_yuan">元</div><div class="food_allmoney">'+(parseFloat(Fcount[i])*parseFloat(Fnumber[i])).toFixed(2)+'</div><div class="food_yuan">元</div><div class="food_delete " onClick="delete1(this)">×</div></div>');
    }
	var money=0;
	$(".food_allmoney").each(function(){money+=parseFloat($(this).text())});
	$("#money").html((money).toFixed(2));
	
	
	$("#yes").click(function(){
		$("#yes").css({"display":"none"});
		$("#no").css({"display":"block"});
		$(".time_popup").css({"display":"block"});
	});
	$("#no").click(function(){
		$("#no").css({"display":"none"});
		$("#yes").css({"display":"block"});
		$(".time_popup").css({"display":"none"});
	});
	$(".time_buttom").click(function(){
       var Aaddress=$("#Asaddress").val();
	    var Oinfo=$("#liuyan").val();
	    var Owish=$("#wish").val();
	    var Omoney=$("#money").html();
	   
	   var url="orderget?JFID="+JFID+"&JFnumber="+JFnumber+"&Aaddress="+Aaddress+"&Oinfo="+Oinfo+"&Owish="+Owish+"&Omoney="+Omoney+"&a="+a;
	   if(confirm("确定订单？")){
            window.location.href = url; 
            }
	    
	});
});
</script>









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
