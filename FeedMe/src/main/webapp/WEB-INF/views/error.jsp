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
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/scripts/main.js"></script>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/styles/main.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/styles/header.css" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<style type="text/css">
body {
	background-color: #000;
}

.text {
	text-align: center;
	color: #fff;
}
</style>
</head>
<body>
	<div class="container">
		<div class="col-md-12">
			<a class="col-md-8 col-md-offset-2 col-md-12"
				href="<c:url value='/'/>"><img
				src="<%=request.getContextPath()%>/resources/images/Logo.png"
				height="300" width="600"></a>




		</div>
		<div class="col-md-12 text">
			<h1>:( Ooops Feed Me has encountered an error.</h1>
			<p>${ex}</p>
		</div>
	</div>
</body>
</html>

