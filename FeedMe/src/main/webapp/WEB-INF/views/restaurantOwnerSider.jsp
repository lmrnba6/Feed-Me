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
	href="<%=request.getContextPath()%>/resources/styles/account.css" />
<script
	src="<%=request.getContextPath()%>/resources/scripts/restaurant.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>

	<div class="col-md-3 sider">
		<div class="list-group">
			<a href="#" class="list-group-item active">Home</a> 
			<a href="#" id = "info" class="list-group-item ">Account</a> 
			<a href="#"	id="menu" class="list-group-item ">Menu</a> 
			<a href="#" class="list-group-item ">Orders</a> 
			<a href="#" id="rating"	class="list-group-item">Reviews</a>
			<a href="#" class="list-group-item ">Logout</a> 

		</div>
	</div>
</body>
</html>
