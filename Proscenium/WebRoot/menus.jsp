<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>咥了么-美食图鉴</title>
<link href="src/css/menus.css" rel="stylesheet" type="text/css">
<link href="src/css/head.css" rel="stylesheet" type="text/css">
<link rel="shortcut icon" type="image/x-icon" href="favicon.ico" />
<script src="src/js/jquery-1.11.1.min.js"></script>
<script src="src/js/menus.js"></script>
</head>



<body>
<!--登陆隐藏窗 -->
<div class="title_login" id="login">
  <div class="title_login_popup">
  <a href="index.html"><div class="title_login_logo">  </div></a>
    <div class="name">用户登录　　　 　　<a href="#" onClick="login_popdown()" style="color:#339900">×</a></div>
    <form action="" method="post">
        <input name="username" type="text" class="username" placeholder="请输入账号/手机号">
        <input name="password" type="password" class="password" placeholder="请输入密码">
      <div class="save">没有账号？<a href="register.jsp">立即注册</a>　　<a href="#">忘记密码？</a>
      </div>
        <input name="login" type="submit" value="登　陆" class="loginbuttom">
    </form>
  </div>
</div>
<script type="text/javascript"> 
function login_popup() {
	login.style.display = "block";
}

function login_popdown() {
	login.style.display = "none";
}

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
	    title_1.style.display = "none";
	    title_2.style.display = "none";
	    title_3.style.display = "block"; 
	    title_4.style.display = "block";  
	    shopping.style.display = "none";    
	    var storage=window.localStorage;
		 storage.clear();                                     
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
					title_1.style.display = "block";
					title_2.style.display = "block";
					title_3.style.display = "none"; 
					title_4.style.display = "none";    
					shopping.style.display = "block";                                       
				}  
			   }
			});    





	 $("form").submit(function (){
	  if ($("#username").val() == '' || $("#password").val() == ''){ 
		  $("div.error").html("帐号和密码不能为空!");
		  return false; 
		  }else{   
		  $("div.error").html("");            
		   $.ajax({                  
			   url: 'customlogin', 
			   type:'post',      //处理测试页面,注意返回内容，成功返回OK                  
			   dataType: 'text',                  
			   data: $("form").serialize(),                  
			   success: function (msg) {                      
			   if (msg == "error"){ 
				  $("div.error").html("帐号或密码错误，请您重新输入!");
			   }else{                          
					$("div.error").html(msg);
					login.style.display = "none"; 
					$("span#name")[0].innerHTML=msg; 
					title_1.style.display = "block";
					title_2.style.display = "block";
					title_3.style.display = "none"; 
					title_4.style.display = "none"; 
					shopping.style.display = "block";                          
					}                  
				}        
			});          
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
    <div class="title_title_register" id="title_1" style="display:none;">欢迎您<span id="name"></span></div>
    <div class="title_title_login" id="title_2" style="display:none;"><a href="menu?tID=1" onClick="quit()">注销</a></div>
    <div class="title_title_register" id="title_3"><a href="register.jsp">注册</a></div>
    <div class="title_title_login" id="title_4"><a href="javascript:void(0);" onClick="login_popup()">登陆</a></div>
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
  <div class="menu">
      <ul id="menus">
        <li>
          <div class="type" id="breakfast">早餐</div>
          <div class="food none">
          <a href="menu?tID=2"><p>早餐</p></a>
          <a href="menu?tID=10"><p>粥点</p></a>
          <a href="menu?tID=9"><p>饮料</p></a>
          <a href="menu?tID=8"><p>饼类</p></a>
          </div>
        </li>
        <li>
          <div class="type" id="lunch">正餐</div>
          <div class="food none">
          <a href="menu?tID=3"><p>正餐</p></a>
          <a href="menu?tID=10"><p>粥点</p></a>
          <a href="menu?tID=7"><p>汉堡</p></a>
          <a href="menu?tID=9"><p>饮料</p></a>
          <a href="menu?tID=8"><p>饼类</p></a>
          <a href="menu?tID=6"><p>小食甜品</p></a>
          <a href="menu?tID=1"><p>超值特惠</p></a>
          </div>
        </li>
        <li>
          <div class="type" id="afternoontea">下午茶</div>
          <div class="food none">
          <a href="menu?tID=4"><p>下午茶</p></a>
          <a href="menu?tID=9"><p>饮料</p></a>
          <a href="menu?tID=6"><p>小食甜品</p></a>
          </div>
        </li>
        <li>
          <div class="type" id="supper">夜宵</div>
          <div class="food none">
          <a href="menu?tID=5"><p>夜宵</p></a>
          <a href="menu?tID=10"><p>粥点</p></a>
          </div>
        </li>
        <li>
          <div class="type" id="supper">套餐</div>
          <div class="food none">
          <a href="menu?tID=1"><p>超值特惠</p></a>
          </div>
        </li>
      <ul>
  </div>
  
  <div class="explain">不设最低起送金额，每单酌收5元外送费。为了保证食物品质，咥了么有送餐范围和服务时间限制。
  </div>
  
  <div class="dish">
    <ul>
      <c:forEach var="food" items="${lists}" varStatus="status">
        <li>
        <div class="open" 
             FID="${food.getFID()}" 
             Finfo="${food.getFinfo()}" 
             Fname="${food.getFname()}" 
             Fcount="${food.getFcount()}"
             Fpicture="${food.getFpicture()}" 
             Fother="${food.getFother()}">
             <img src="${food.getFpicture()}" width="200" height="100" />
        </div>
        <div class="food_name">${food.getFname()}</div>
        <div class="count"><span>${food.getFcount()}</span>元/份</div>
        <div class="begin">开始订餐</div>
        <div class="smallsrc" style="display:none;"><img src="${food.getFpicture()}" width="50" height="50" /></div>
      </li>
      </c:forEach>
    </ul>
  </div>

</div>


<div class="title_login" id="food">
  <div class="foodinfo_popup" FID="">
    <div class="foodinfo_popup_picture"><img src="src/img/" width="300" height="200" id="foodinfo_src"></div>
    <div class="foodinfo_popup_name"></div>　　　 　　
    <div class="foodinfo_popup_x"><a href="#" onClick="food_popdown()" style="color:#FF0000">×</a></div>
    <div class="foodinfo_popup_info"></div>
    <div class="foodinfo_popup_other"></div>
    <div class="foodinfo_popup_count"><span id="foodinfo_popup_money">3</span>元/份</div>
    <div class="foodinfo_popup_buttom">开始订餐</div>

  </div>
</div>

<div class="shopping" id="shopping" style="display:none;"></div>
<div class="shopping_list">
  <div class="shopping_title">
  总金额：<span id="money" style="color:red;"></span>元
  </div>

</div>
<div class="shopping" id="shopping_ok"><div class="car">购物车</div><div class="buy">结账</div></div>
<script type="text/javascript">
	navList(12);
function food_popdown(){
	food.style.display = "none";
}
function del(a){	
		  var num=parseInt($(a).parent().find(".shopping_foodshuliang").html())-1;
		  if(num==0){
			  $(a).parent().remove();
		  }else{
			  var count=parseFloat($(a).parent().find(".shopping_foodcount").html())/(num+1);
		      $(a).parent().find(".shopping_foodshuliang").html(num);
			  $(a).parent().find(".shopping_foodcount").html((count*num).toFixed(2));
		  }
		  var money=0;
		  $(".shopping_foodcount").each(function(){money+=parseFloat($(this).text())});
		  $("#money").html((money).toFixed(2));
		  var storage=window.localStorage;
		var a=$("div.shopping_food").length;
		var FID=new Array();
		var Fname=new Array();
		var Fcount=new Array();
		var Fnumber=new Array();
		for(var i=0;i<parseInt(a);i++)
		{
			FID[i]=$(".shopping_food").eq(i).attr("FID");
			Fname[i]=$(".shopping_foodname").eq(i).html();
			Fnumber[i]=$(".shopping_foodshuliang").eq(i).html();
			Fcount[i]=parseFloat($(".shopping_foodcount").eq(i).html())/Fnumber[i];
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
		  var num=parseInt($(a).parent().find(".shopping_foodshuliang").html())+1;
		  var count=parseFloat($(a).parent().find(".shopping_foodcount").html())/(num-1);
		      $(a).parent().find(".shopping_foodshuliang").html(num);
			  $(a).parent().find(".shopping_foodcount").html((count*num).toFixed(2));
			  var money=0;
			   $(".shopping_foodcount").each(function(){money+=parseFloat($(this).text())});
		     $("#money").html((money).toFixed(2));
		     var storage=window.localStorage;
		var a=$("div.shopping_food").length;
		var FID=new Array();
		var Fname=new Array();
		var Fcount=new Array();
		var Fnumber=new Array();
		for(var i=0;i<parseInt(a);i++)
		{
			FID[i]=$(".shopping_food").eq(i).attr("FID");
			Fname[i]=$(".shopping_foodname").eq(i).html();
			Fnumber[i]=$(".shopping_foodshuliang").eq(i).html();
			Fcount[i]=parseFloat($(".shopping_foodcount").eq(i).html())/Fnumber[i];
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
   var key=JSON.parse(localStorage.getItem("FID"));
      if(key==""||key==null){
   }else{
   var JFID=storage.FID;
   var JFname=storage.Fname;
   var JFcount=storage.Fcount;
   var JFnumber=storage.Fnumber;
   var a=storage.a;
   
   var FID=JSON.parse(JFID);
   var Fname=JSON.parse(JFname);
   var Fcount=JSON.parse(JFcount);
   var Fnumber=JSON.parse(JFnumber);
   var money=0;
   for(var i=0;i<parseInt(a);i++)
   {
	 $(".shopping_list").append('<div class="shopping_food" FID="'+FID[i]+'"><div class="shopping_foodname">'+Fname[i]+'</div><div class="shopping_fooddel" onClick="del(this)">-</div><div class="shopping_foodshuliang">'+Fnumber[i]+'</div><div class="shopping_foodadd" onClick="add(this)">+</div><div class="shopping_foodcount">'+(Fcount[i]*Fnumber[i]).toFixed(2)+'</div>元</div>');
   }
   $(".shopping_foodcount").each(function(){money+=parseFloat($(this).text())});
   $("#money").html((money).toFixed(2));

   }
   

	$("div.buy").click(function (){
		var storage=window.localStorage;
		var a=$("div.shopping_food").length;
		var FID=new Array();
		var Fname=new Array();
		var Fcount=new Array();
		var Fnumber=new Array();
		for(var i=0;i<parseInt(a);i++)
		{
			FID[i]=$(".shopping_food").eq(i).attr("FID");
			Fname[i]=$(".shopping_foodname").eq(i).html();
			Fnumber[i]=$(".shopping_foodshuliang").eq(i).html();
			Fcount[i]=parseFloat($(".shopping_foodcount").eq(i).html())/Fnumber[i];
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
			window.location.href = "order";
	  });
	  
	  
	 $("div.open").click(function (){
		 food.style.display = "block";
		 $("div.foodinfo_popup").attr("FID",$(this).attr("FID"));　
		 $("div.foodinfo_popup_name").html($(this).attr("Fname"));
		 $("img#foodinfo_src").attr('src',$(this).attr("Fpicture"));
		 $("div.foodinfo_popup_info").html($(this).attr("Finfo")); 
		 $("div.foodinfo_popup_other").html($(this).attr("Fother")); 
		 $("#foodinfo_popup_money").html($(this).attr("Fcount")); 
	});
	
	  $("div.begin").click(function (){
	  if($("#name").html() == ""){
	         food.style.display = "none";
	         login.style.display = "block";
	     }else{
		 var divTop = $(this).parent().find(".smallsrc").offset().top;
	     var divLeft = $(this).parent().find(".smallsrc").offset().left;
		 var FID=$(this).parent().find(".open").attr("FID");
		 var Fname=$(this).parent().find(".open").attr("Fname");
		 var Finfo=$(this).parent().find(".open").attr("Finfo");
		 var Fcount=$(this).parent().find(".open").attr("Fcount");
		 var Fpicture=$(this).parent().find(".open").attr("Fpicture");
		 var Fother=$(this).parent().find(".open").attr("Fother");
	     var money=0;
	     var j=0;
		 if($(".shopping_list").length!=0)
		 {
		    for(var i=0;i<parseInt($(".shopping_food").length);i++)
		    {
				if($(".shopping_foodname").eq(i).html()==Fname){
					add($(".shopping_foodname").eq(i));
					j=1;
				}
		    }
			if(j!=1){
				$(".shopping_list").append('<div class="shopping_food" FID="'+FID+'"><div class="shopping_foodname">'+Fname+'</div><div class="shopping_fooddel" onClick="del(this)">-</div><div class="shopping_foodshuliang">1</div><div class="shopping_foodadd" onClick="add(this)">+</div><div class="shopping_foodcount">'+Fcount+'</div>元</div>');
		  $(".shopping_foodcount").each(function(){money+=parseFloat($(this).text())});
		 $("#money").html((money).toFixed(2));
		 j=0;
			}
		 }else{
		 $(".shopping_list").append('<div class="shopping_food" FID="'+FID+'"><div class="shopping_foodname">'+Fname+'</div><div class="shopping_fooddel" onClick="del(this)">-</div><div class="shopping_foodshuliang">1</div><div class="shopping_foodadd" onClick="add(this)">+</div><div class="shopping_foodcount">'+Fcount+'</div>元</div>');
		  $(".shopping_foodcount").each(function(){money+=parseFloat($(this).text())});
		 $("#money").html((money).toFixed(2));
		 }
		  $(this).parent().find(".smallsrc").css({ "display":"block","position": "absolute", "z-index": "9999", "left": divLeft + "px", "top": divTop + "px" });
	     $(this).parent().find(".smallsrc").animate({ "left": ($("#shopping").offset().left - $("#shopping").width()) + "px", "top": ($(document).scrollTop() + 30) + "px", "width": "50px", "height": "50px" }, 400, function () {
		     $(this).parent().find(".smallsrc").animate({ "left": $("#shopping").offset().left + "px", "top": $("#shopping").offset().top + "px" }, 400).fadeTo(0, 0.1).hide(0);
	     });
         setTimeout(function(){$(".smallsrc").removeAttr("style").css({ "display":"none"});},1000);
	  var storage=window.localStorage;
		var a=$("div.shopping_food").length;
		var FID=new Array();
		var Fname=new Array();
		var Fcount=new Array();
		var Fnumber=new Array();
		for(var i=0;i<parseInt(a);i++)
		{
			FID[i]=$(".shopping_food").eq(i).attr("FID");
			Fname[i]=$(".shopping_foodname").eq(i).html();
			Fnumber[i]=$(".shopping_foodshuliang").eq(i).html();
			Fcount[i]=parseFloat($(".shopping_foodcount").eq(i).html())/Fnumber[i];
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
	  });
	  
	  $("div.foodinfo_popup_buttom").click(function (){
	  if($("#name").html() == ""){
	         food.style.display = "none";
	         login.style.display = "block";
	     }else{
		 var FID=$(this).parent().attr("FID");
		 var Fname=$(".foodinfo_popup_name").html();
		 var Fcount=$("#foodinfo_popup_money").html();
	     var money=0;
		 var j=0;
		 if($(".shopping_list").length!=0)
		 {
		    for(var i=0;i<parseInt($(".shopping_food").length);i++)
		    {
				if($(".shopping_foodname").eq(i).html()==Fname){
					add($(".shopping_foodname").eq(i));
					j=1;
				}
		    }
			if(j!=1){
				$(".shopping_list").append('<div class="shopping_food" FID="'+FID+'"><div class="shopping_foodname">'+Fname+'</div><div class="shopping_fooddel" onClick="del(this)">-</div><div class="shopping_foodshuliang">1</div><div class="shopping_foodadd" onClick="add(this)">+</div><div class="shopping_foodcount">'+Fcount+'</div>元</div>');
		        $(".shopping_foodcount").each(function(){money+=parseFloat($(this).text())});
		        $("#money").html((money).toFixed(2));
		        j=0;
			}
		 }else{
		    $(".shopping_list").append('<div class="shopping_food" FID="'+FID+'"><div class="shopping_foodname">'+Fname+'</div><div class="shopping_fooddel" onClick="del(this)">-</div><div class="shopping_foodshuliang">1</div><div class="shopping_foodadd" onClick="add(this)">+</div><div class="shopping_foodcount">'+Fcount+'</div>元</div>');
		    $(".shopping_foodcount").each(function(){money+=parseFloat($(this).text())});
		    $("#money").html((money).toFixed(2));
		 }
		 food.style.display = "none";
		 var storage=window.localStorage;
		var a=$("div.shopping_food").length;
		var FID=new Array();
		var Fname=new Array();
		var Fcount=new Array();
		var Fnumber=new Array();
		for(var i=0;i<parseInt(a);i++)
		{
			FID[i]=$(".shopping_food").eq(i).attr("FID");
			Fname[i]=$(".shopping_foodname").eq(i).html();
			Fnumber[i]=$(".shopping_foodshuliang").eq(i).html();
			Fcount[i]=parseFloat($(".shopping_foodcount").eq(i).html())/Fnumber[i];
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
	  });
	  
	  
	  
	  $("div#shopping").click(function (){	
	     $(this).animate({ "right": "200px", "width": "50px", "height": "50px" } , 400);
		 setTimeout(function(){
			 $("div#shopping").css({"right": "0"}),
			 $("div#shopping_ok").css({"display":"block"});
			 $("div.shopping_list").css({"display":"block"});
			 },500);
	  });
	  
	  $("div#shopping_ok").click(function (){	
	     $("div.shopping_list").css({"display":"none"});
	     $(this).animate({  "width": "50px", "height": "50px" } , 400);
		 setTimeout(function(){
			 $("div#shopping_ok").css({ "display": "none","width": "250px"}),
			 $("div#shopping").css({"display":"block"});
			 },500);
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
