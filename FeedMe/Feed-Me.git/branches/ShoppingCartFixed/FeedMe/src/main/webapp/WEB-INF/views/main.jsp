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

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/styles/main.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/styles/header.css" />
<meta name="viewport" content="width=device-width, initial-scale=1">
">
</head>
<body>

	<jsp:include page="header.jsp" />
	<div class="container" id="mainBody">
		<div class="featurette">
			<div class="featurette-inner text-center">
				<form role="form" class="search has-button">
					<h3 class="no-margin-top h1">Order food delivery online from
						your favorite local restaurants</h3>
					<br>
					<h1>Check out the restaurants near you!</h1>
					<div class="form-group">
						<input type="search" placeholder="Where are you!"
							class="form-control form-control-lg">
						<button
							onclick="window.location.href='<c:url value='/restaurant/list'/>'"
							class="btn btn-lg " type="button">Search</button>
					</div>
					<!-- /form-group -->
				</form>
				<!-- /.max-width on this form -->

			</div>
			<!-- /.featurette-inner (display:table-cell) -->

		</div>
	</div>


</body>
</html>

