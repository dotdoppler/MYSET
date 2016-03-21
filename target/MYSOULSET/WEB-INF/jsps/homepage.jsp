<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- css -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
<!-- Favicon -->
<link rel="shortcut icon"
	href="${pageContext.request.contextPath}/resources/images/icon3.ico">

<link href="${pageContext.request.contextPath}/resources/css/cover.css"
	rel="stylesheet">

</head>
<body>

	<div class="site-wrapper">

		<div class="site-wrapper-inner">

			<div class="cover-container">

				<div class="masthead clearfix">
					<div class="inner">

						<nav class="nav nav-masthead">
							<a class="nav-link active" href="#">主页</a> <a class="nav-link"
								href="#">Features</a> <a class="nav-link" href="contactme">联系我</a>
						</nav>
						<nav class="nav nav-masthead" style="float: left">
							<i class="nav-link">${today}</i> <i class="nav-link">${time}</i><i id="dtime" class="nav-link"></i>
						</nav>
					</div>
				</div>




			</div>

		</div>

	</div>

</body>
<!-- javascript -->
<script
	src="${pageContext.request.contextPath}/resources/js/jquery-2.2.1.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/util/tools.js"></script>
<script type="text/javascript">
</script>	

</html>