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


</head>
<body>

	<a href="<c:url value='/addRestaurant'/>"><span
		class="glyphicon glyphicon-log-in"></span> Add Restaurant </a>
	<a href="<c:url value='/addMenu'/>"><span
		class="glyphicon glyphicon-log-in"></span> Add Menu </a>

</body>
</html>

