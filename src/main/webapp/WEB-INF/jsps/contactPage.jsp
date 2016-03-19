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

<link href="${pageContext.request.contextPath}/resources/css/cover2.css"
	rel="stylesheet">

</head>

<body>

	<div class="site-wrapper">

		<div class="site-wrapper-inner">

			<div class="cover-container">

				<div class="masthead clearfix">
					<div class="inner">

						<nav class="nav nav-masthead">
							<a class="nav-link" href="home">主页</a> <a class="nav-link">Features</a>
							<a class="nav-link active" href="#">联系我</a>
						</nav>
						<nav class="nav nav-masthead" style="float: left">
							<i class="nav-link">${today}</i> <i class="nav-link">${time}</i><i
								id="dtime" class="nav-link"></i>
						</nav>
					</div>
				</div>
				<div class="inner cover">
					<h1 class="cover-heading" >
						<div class="input-group" >
							<span class="input-group-addon" id="basic-addon1">Name</span> <input
								type="text" class="form-control"   style="width:15%"
								aria-describedby="basic-addon1">
						</div>
					</h1>
					<h1 class="cover-heading"><div class="input-group" >
							<span class="input-group-addon" id="basic-addon1">E-mail</span> <input
								type="text" class="form-control"  style="width:15%"
								aria-describedby="basic-addon1">
						</div></h1>
					<h1 class="cover-heading"><div class="input-group" >
							<span class="input-group-addon" id="basic-addon1">Message</span> <input
								type="text" class="form-control"   style="width:15%"
								aria-describedby="basic-addon1">
						</div></h1>
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