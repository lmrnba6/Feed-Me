<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="true"%>
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
<meta name="viewport" content="width=device-width, initial-scale=1">
<script
	src="<%=request.getContextPath()%>/resources/scripts/map.js"></script>
<style type="text/css">
div#map_container {
	margin-top: 20px; width : 70%;
	height: 350px;
	width: 100%;
}
</style>

<script
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDTy0ti0nAsW8BBmA8FsiPQjkigBco_GdY&callback=initMap" defer async
	type="text/javascript"></script>

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/styles/header.css" />
</head>
<body onload="loadMap()">


	<center>
		<div class="col-md-12">
			<div id="map_container"></div>
		</div>
		<input id="lan" value='${lan}' hidden="true" >
		<input id="lat" value='${lat}' hidden="true" >
	</center>
</body>

</html>