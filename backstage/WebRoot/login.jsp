<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>后台登陆</title>
<link href="Src/css/login.css" rel="stylesheet" type="text/css">
<link rel="shortcut icon" type="image/x-icon" href="favicon.ico" />
</head>

<body>
  <div class="bg">
    <div class="login">
      <div class="name">订餐后台管理</div>
      <div class="container">
      <form action="adminlogin" method="post">
        <div class="username">
            <img src="Src/img/username.png" width="40" height="40" class="usernameimg">
            <input name="username" type="text" class="username_co">
        </div>
        <div class="password">
          <img src="Src/img/password.png" width="40" height="40" class="password_img">
          <input name="password" type="text" class="password_co">
        </div>
        <div class="error">${error}</div>
        <div class="save">
          <select name="level">
            <option value="2">后台</option>
            <option value="1">管理员</option>
          </select>
          <label>
            <input type="checkbox" name="save" value="save" id="save_0">记住账号
          </label>
        </div>
        <div class="loginbuttom">
          <input name="login" type="submit" value="登　陆" class="loginbuttom_buttom">
        </div>
      </form>
      </div>
    </div>
  </div>
</body>
</html>
