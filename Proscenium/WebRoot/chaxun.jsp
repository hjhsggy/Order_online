<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>无标题文档</title>
<link href="src/css/chaxun.css" rel="stylesheet" type="text/css">
<link href="src/css/head.css" rel="stylesheet" type="text/css">
</head>
<body>
<div>

<!--版头 -->
<div class="title">
  <a href="index.html"><div class="title_logo"></div></a>
  <div class="title_title">
    <div class="title_title_collection"><a href="javascript:void(0);" onclick="AddFavorite('百度','http://www.baidu.com')" title="收藏本站到收藏夹">收藏我们</a></div>
  </div>
  <div class="title_functiongroup">
    <h3>查询单号</h3>  
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

<img src="src/img/chaxun.jpg" />
<div id="position1" >

<input type="text" placehold="按订单号查询" id="sname" style="width:380px;height:40px;">
</div>
<div id="position2">
<input TYPE="button" value="搜索" onclick="seacher()" style="width:100px;height:40px;"></div>
<div id="position3">
<textarea name="content" rows="15" cols="95" onpropertychange="if(this.scrollHeight>80) this.style.posHeight=this.scrollHeight+5"></textarea>
</div>
</div>
</body>
</html>
