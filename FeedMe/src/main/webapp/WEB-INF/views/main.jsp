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

<script
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDTy0ti0nAsW8BBmA8FsiPQjkigBco_GdY&callback=initMap"
	defer async type="text/javascript"></script>
</head>
<body>

	<div class="carousel slide carousel-fade" data-ride="carousel"
		data-interval="10000">

		<!-- Wrapper for slides -->
		<div class="carousel-inner" role="listbox">
			<div class="item active"></div>
			<div class="item"></div>
			<div class="item"></div>
			<div class="item"></div>
			<div class="item"></div>
			<div class="item"></div>
		</div>
	</div>

	<jsp:include page="header.jsp" />
	<div class="container" id="mainBody">
		<div class="featurette">
			<div class="featurette-inner text-center">
				<div role="form" class="search has-button">
					<h3 class="no-margin-top h1">Order food delivery online from
						your favorite local restaurants</h3>
					<br>
					<h1>Check out the restaurants near you!</h1>
					<h4>Enter you zip code!</h4>
					<div class="form-group">
						<input id="address" type="search" placeholder="Where are you!  e.g. J1K 3A9"
							class="form-control input-lg form-control-lg" required="required" autofocus="autofocus" >
						<%-- <button onclick="window.location.href='<c:url value='/test'/>'"
							class="btn btn-lg " type="button">Search</button> --%>
							<div class="submit">
							<Button class="btn btn-lg " id="enter" type="button" onclick="codeAddress()">Search</Button>
							</div>
						<!-- <button onclick="codeAddress()" class="btn btn-lg ">Search</button> -->
					</div>
					<!-- /form-group -->
				</div>
				<!-- /.max-width on this form -->
			</div>
			<!-- /.featurette-inner (display:table-cell) -->
		</div>

		
	</div>
	<script>
		var geocoder;
		var map;
		function codeAddress() {
			geocoder = new google.maps.Geocoder();
			var address = document.getElementById('address').value;

			geocoder
					.geocode(
							{
								'address' : address
							},
							function(results, status) {
								
								if (status == google.maps.GeocoderStatus.OK) {

									for ( var component in results[0]['address_components']) {
										for ( var i in results[0]['address_components'][component]['types']) {
											if (results[0]['address_components'][component]['types'][i] == "administrative_area_level_1") {
												state = results[0]['address_components'][component]['long_name'];
												/*
												 * alert(results[0]['address_components'][2]['long_name'] + ' , ' +
												 * state);
												 */

												var city = results[0]['address_components'][2]['long_name'];

												location.href = "restaurant/list/"
														+ city + "/"

												/*
												 * window .open("map/" + lat + "/" + lan +
												 * "/", null,
												 * "height=200,width=400,status=yes,toolbar=no,menubar=no,location=no");
												 */
											}
										}
									}
								} else {
									if(address!=="")
									alert('Invalid Zipcode');
								}
							});
		}
	</script>
</body>
</html>

