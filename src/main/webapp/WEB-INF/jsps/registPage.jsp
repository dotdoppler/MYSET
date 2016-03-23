<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css"
	rel="stylesheet">
<script
	src="${pageContext.request.contextPath}/resources/js/jquery-2.2.1.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
	<script
	src="${pageContext.request.contextPath}/resources/js/customJS.js"></script>
</head>
<body
	style="text-align: center; width: 100%; height: 100%; margin: 0px;"
	class="hold-transition register-page">
	<div class="register-box">
	<img alt="" src="${pageContext.request.contextPath}/resources/images/register.jpg">
		<div class="register-logo">
			<h1>
				<b>OneLibrary</b>
			</h1>
		</div>

		<div class="register-box-body ">
		
			<p class="login-box-msg">Register a new membership</p>

			<form action="register" method="post" id="form">
				<div class="form-group has-feedback">
					<div>
						LoginName&nbsp;&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;
						<input type="email" placeholder=" dotdoppler@yeah.net" required="required" name="loginName">
					</div>

				</div>
				<div class="form-group has-feedback">
					<div>
						name&nbsp;&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;
						<input type="text" placeholder=" enter your name" required="required" name="name">
					</div>

				</div>
				<div class="form-group has-feedback">
					<div>
						Password &nbsp;&nbsp; &nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;
						<input type="password" required="required" id="pwd"  name="password" placeholder=" enter your password">
					</div>
				</div>
				<div class="form-group has-feedback">
					<div>
						Retype password&nbsp; <input type="password" required="required" id="retype" placeholder=" retype your password">
					</div>
				</div>
				<div>
				<button type="button" onclick="validatepwd('pwd','retype','form')">commit</button>
				</div>
			</form>
		</div>
	</div>
</body>

</html>
