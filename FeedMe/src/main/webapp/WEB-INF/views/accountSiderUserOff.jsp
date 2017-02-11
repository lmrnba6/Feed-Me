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
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/styles/header.css" />
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>

	<div class="col-md-3">
                <br>
                <div class="list-group">
              		 <a href="<c:url value='/account/info'/>" class="list-group-item active ">Home</a>
                    <a href="<c:url value='/account/info'/>" class="list-group-item  ">Login</a>
                    <a href="<c:url value='/account/logout'/>" class="list-group-item">Help</a>
                </div>
            </div>
	
</body>
</html>
