<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<!--[if lt IE 7]> <html class="lt-ie9 lt-ie8 lt-ie7" lang="en"> <![endif]-->
<!--[if IE 7]> <html class="lt-ie9 lt-ie8" lang="en"> <![endif]-->
<!--[if IE 8]> <html class="lt-ie9" lang="en"> <![endif]-->
<!--[if gt IE 8]><!-->
<html lang="en">
<!--<![endif]-->
<head>
<title>Feed-Me!</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<script src="https://apis.google.com/js/platform.js" async defer></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="google-signin-client_id"
	content="422141561901-s4dahr1givvmalmh0otegv7fls62q8m7.apps.googleusercontent.com">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/styles/login.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/styles/header.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/styles/footer.css" />

<!--[if lt IE 9]><script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
</head>
<body>
	<jsp:include page="header.jsp" />


	<div class="wrapper">

		<c:if test="${!empty ok}">
			<c:url var="login" value="/loggedMenu/${restaurant.restId}"></c:url>
		</c:if>
		<c:if test="${empty ok}">
			<c:url var="login" value="/logged"></c:url>
		</c:if>
		<form class="form-signin" action="${login}" method="Post">
			<c:if test="${!empty message}">
				<div class="alert alert-success">
					<strong></strong> ${message}
				</div>
			</c:if>
			<h2 class="form-signin-heading">Sign in</h2>
			<br> <label>Username</label> <input type="text"
				class="form-control" data-minlength="6" name="userName"
				placeholder="Username" required autofocus /> <br> <label>Password</label>
			<input type="password" class="form-control" name="password"
				placeholder="Password" data-minlength="6" required /><a href="#">Forgot
				password</a>
			<p></p>
			<button class="btn btn-lg btn-danger btn-block" type="submit">Login</button>
			<div class="g-signin2" data-onsuccess="onSignIn"></div>
		</form>
		<a href="#" onclick="signOut();">Sign out</a>
		<script>
			function signOut() {
				var auth2 = gapi.auth2.getAuthInstance();
				auth2.signOut().then(function() {
					console.log('User signed out.');
				});
			}
		</script>

	</div>

</body>
</html>
