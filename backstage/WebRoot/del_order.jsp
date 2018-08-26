<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>删除成功</title>
    <link type="text/css" rel="stylesheet" href="Src/css/del.css">
    <link type="text/css" rel="stylesheet" href="Src/css/add.css">
    <meta http-equiv="Refresh" content="5;url=GetFacilitiesServlet">
</head>

<body onload="run()">
<script type="text/javascript">
	var x = 5;

    function run(){
        var span = document.getElementById("spanId");
        span.innerHTML = x;
        x--;
        window.setTimeout("run()", 1000);
        }
</script>
<div class="container">
	<div class="header">
		<div></div>
	</div>
	<div class="middle">
		<div class="left">
			
		</div>
			
		<div class="right">
			<div style="height:50px;"></div>
    		<div class="textstyle">
    		<div class="txt"><span>删除成功</span></div>
    		<div class="txt"><span id="spanId">5</span>  秒后自动跳转回原界面</div>
    		<p></p>
    		<a href="GetOrderServlet">点击此处立即跳转至管理员主页</a>
    		</div>
</div>
		</div>
	</div>
	<div class="bottom">
		<div class="pic">版权所有  西安石油大学计算机学院</div>
		<span class="block"></span>
		<span class="block"></span>
		<span class="block">|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;法律条款</span>
		<span class="block">|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;法律条款</span>
		<span class="block">|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;法律条款</span>
		<span class="block">|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;法律条款</span>
		<span class="block"></span>
		<span class="block"></span>
	</div>
</div>
</body>
</html>
