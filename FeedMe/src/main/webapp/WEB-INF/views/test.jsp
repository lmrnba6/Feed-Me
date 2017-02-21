<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
<title>Feed-Me!</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="<%=request.getContextPath()%>/resources/styles/test.css"
	type="text/css" rel="stylesheet">

<html>
<head>

</head>
<body>

	
		<a href="<c:url value='/addRestaurant'/>"><span
		class="glyphicon glyphicon-log-in"></span> Add Restaurant </a>
	<a href="<c:url value='/addMenu'/>"><span
		class="glyphicon glyphicon-log-in"></span> Add Menu </a>
		
</body>
</html>