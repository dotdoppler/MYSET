<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/resources/js/jquery-2.2.1.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
</head>
<body style="text-align: center; width: 100%; height: 100%;
										 margin: 0px;"  class="hold-transition login-page">

<i class="nav-link">${today}</i>&nbsp;&nbsp; <i class="nav-link">${time}</i><i id="dtime" class="nav-link"></i>
<br>
<div>
<img alt="" src="${pageContext.request.contextPath}/resources/images/keeper.jpg"><h1>OneLibary</h1>
</div>
<div class="login-box">
<div class="login-box-body">
<form action="" method="post">
<div class="form-group has-feedback">UserName&nbsp;<input type="email" placeholder="Enter Email address" ></div>
<div class="form-group has-feedback">Password&nbsp; <input type="password" placeholder="Enter Password" ></div>


<div> <button class="button" type="submit">Sign in</button>
<button class="button" type="button" onclick="window.location.href='register'">regist</button></div>
</form>
</div>
</div>

</body>
<!-- javascript -->
</html>