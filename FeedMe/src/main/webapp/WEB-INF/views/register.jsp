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
<script src="https://apis.google.com/js/platform.js" async defer></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/styles/login.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/styles/header.css" />
<meta name="google-signin-client_id"
	content="422141561901-s4dahr1givvmalmh0otegv7fls62q8m7.apps.googleusercontent.com">
<!--[if lt IE 9]><script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
</head>
<body>
	<jsp:include page="header.jsp" />


	<div class="wrapper">


		<c:url var="login" value="/registered"></c:url>
		<form class="form-signin" action="${login}" method="Post">
			<c:if test="${!empty message}">
				<div class="alert alert-danger">
					<strong></strong> ${message}
				</div>
			</c:if>
			<h2 class="form-signin-heading registerTitle">Create account</h2>
			<div class="social">
				<button class="loginBtn loginBtn--facebook">Facebook</button>

				<div class="g-signin2 pull-right" data-onsuccess="onSignIn"></div>
			</div>
			<br>
			<div
				style="width: 100%; height: 20px; border-bottom: 1px solid black; text-align: center">
				<span
					style="font-size: 20px; background-color: #fff; padding: 0 10px;">
					Or <!--Padding is optional-->
				</span>
			</div>

			<br> <label>Last name</label> <input type="text"
				class="form-control" name="firstName" placeholder="" required
				autofocus value="${lastName}" /> <br> <label>FirstName</label>
			<input type="text" class="form-control" name="lastName"
				placeholder="" required autofocus value="${firstName}" /> <br>
			<label>Username</label> <input type="text" class="form-control"
				name="userName" placeholder="" required autofocus
				value="${userName}" /> <br> <label>Email</label> <input
				type="email" class="form-control" name="email" placeholder=""
				required value="${email}" /><br> <label>Password</label> <input
				type="password" class="form-control" name="password"
				placeholder="At least 6 characters " required /> <label>Password
				again</label> <input type="password" class="form-control" name="password2"
				placeholder="" required /> <br>

			<button class="btn btn-lg btn-danger btn-block" type="submit">Create
				your Feed-Me account</button>
			<br>
			<p>By creating an account, you agree to Amazon's Conditions of
				Use and Privacy Notice.</p>
		</form>

	</div>
	<a href="#" id="signOut" onclick="signOut();"></a>
	<script>
			function onSignIn(googleUser) {
				;
				var profile = googleUser.getBasicProfile();
				console.log('ID: ' + profile.getId() + ' ' + 'Name: '
						+ profile.getName()); // Do not send to your backend! Use an ID token instead.
				console.log('Name: ' + profile.getName());
				console.log('Image URL: ' + profile.getImageUrl());
				console.log('Email: ' + profile.getEmail()); // This is null if the 'email' scope is not present.
				if (confirm('Do you want to sign in using your Google account?')) {
					location.href = "googleRegister/" + profile.getEmail()
							+ "/" + profile.getName() + "/" + profile.getId()
							+ "/";
					
				} else {

					$('#signOut').trigger('click');

				}
			}
		</script>
		<script type="text/javascript">
			function signOut() {
				var auth2 = gapi.auth2.getAuthInstance();
				auth2.signOut().then(function() {
					console.log('User signed out.');
				});

			}
		</script>
</body>
</html>
