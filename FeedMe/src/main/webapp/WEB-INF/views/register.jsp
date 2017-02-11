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
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/styles/login.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/styles/header.css" />

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
			<h2 class="form-signin-heading">Create account</h2>
			<br> <label>Last name</label>
			<input type="text" class="form-control" name="firstName"
				placeholder="" required autofocus value= "${lastName}" /> <br> 
			<label>FirstName</label>
			<input type="text" class="form-control" name="lastName"
				placeholder="" required autofocus value= "${firstName}" /> <br> 
			<label>Username</label>
			<input type="text" class="form-control" name="userName"
				placeholder="" required autofocus value= "${userName}" /> <br> 
			<label>Email</label>
			<input type="email" class="form-control" name="email"
				placeholder="" required value ="${email}"/><br>	
			<label>Password</label>
			<input type="password" class="form-control" name="password"
				placeholder="At least 6 characters " required /> 
				<label>Password again</label>
			<input type="password" class="form-control" name="password2"
				placeholder="" required /> <br>
				
			<button class="btn btn-lg btn-danger btn-block" type="submit">Create your Feed-Me account</button>
			<br>
			<p>By creating an account, you agree to Amazon's Conditions of Use and Privacy Notice. </p>
		</form>
		
	</div>
</body>
</html>
