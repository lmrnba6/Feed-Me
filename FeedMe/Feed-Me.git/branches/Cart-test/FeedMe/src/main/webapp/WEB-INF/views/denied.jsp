<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
<title>Feed-Me!</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/styles/login.css" />
	<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/styles/header.css" />
	<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/styles/footer.css" />

</head>
<body>
	<jsp:include page="header.jsp" />

<div class="wrapper">


		<c:url var="login" value="/logged"></c:url>
		<form class="form-signin" action="${login}" method="Post">
		<div class="alert alert-danger">
				<strong>Wrong!</strong> Invalid Username or Password!!
			</div>
			<h2 class="form-signin-heading">Sign in</h2>
			<br> Username
			<p></p>
			<input type="text" class="form-control" name="userName"
				placeholder="Username" required autofocus /> <br> Password
			<p></p>
			<input type="password" class="form-control" name="password"
				placeholder="Password" required /> <label class="checkbox">
				<input type="checkbox" value="remember-me" id="rememberMe"
				name="rememberMe"> Remember me
			</label>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>
		</form>
	</div>
	<jsp:include page="footer.jsp" />

</body>
</html>

