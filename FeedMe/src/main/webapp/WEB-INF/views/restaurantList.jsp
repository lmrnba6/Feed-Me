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
	href="<%=request.getContextPath()%>/resources/styles/restaurantList.css" />
<%-- <script
	src="<%=request.getContextPath()%>/resources/scripts/restaurantList.js"></script> --%>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/styles/header.css" />

<meta name="viewport" content="width=device-width, initial-scale=1">

<script 
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDTy0ti0nAsW8BBmA8FsiPQjkigBco_GdY&callback=initMap" defer async
	type="text/javascript"></script>

</head>

</head>
<body>
	<jsp:include page="header.jsp" />
	<jsp:include page="restaurantListSider.jsp" />

	<div class="col-sm-9">
		<div class="col-xs-12 col-md-6 bootstrap snippets">
			<c:choose>
				<c:when test="${!empty restaurantList}">
					<c:forEach items="${restaurantList}" var="restaurant">
						<!-- product -->
						<link
							href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css"
							rel="stylesheet">
						<div class="container">
							<div class="row">
								<div class="col-md-12">

									<div class="ibox">

										<div class="ibox-content product-box">
											<div class="product-imitation">
												<img src="${restaurant.restImageUrl}" width="100%"
													height="220px" class=" img-rounded">
											</div>

											<div class="product-desc">

												<a class="pull-right fbImage" href="<c:url value='/map'/>"><img
													src="data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAkGBwgHBhQIBwgKCgkLDRYPDQwMDRsUFRAWIB0iIiAdHx8kKDQsJCYxJx8fLT0tLSk3Ojo6KDE1OD9EPTQtNy4BCgoKDQwNGg8PGjclHyU3NzU1Ny0yNTQ1NzU3Ny01LS83LSs3Kzc1LTctODU3MTItNysrLTUyLi01NSsrLSsrK//AABEIACgAKAMBIgACEQEDEQH/xAAaAAACAgMAAAAAAAAAAAAAAAAABAEHAgMG/8QALRAAAQMDAgMFCQAAAAAAAAAAAQACAwQFERIhUWGRBiIxUnEHEzIzZHKxssH/xAAZAQADAQEBAAAAAAAAAAAAAAACAwQBBQD/xAAcEQADAQEAAwEAAAAAAAAAAAAAAQIRAyExYRL/2gAMAwEAAhEDEQA/AMLhVy3CqdUVjzLI9xJLjnHIcAltMfkb0Wsv3Ua12FiREbdMfkb0Rpj8jeizt8baq4R0znYbNMyMkcC4D+q2bxdrR2Spo4pKR4jly2NkEbT8OMk5I4hK6dfw0ktYUxvnSq7fVy2+qbUUbzFIxwILTjPI8QhLTTCSpdI3Ia+RzhngTlStuJry0eltehJz+8o1pZz+8fVRrRaCdz7OrjaKSsfFdGsM88kTaXVAX4dkjY4OnctVg9prnY7aIzfmRuEhd7rXTmXwxnwBx4hUr2ffm/04+sh/cLvPbK7EdL90v4YpekJ9V9HTWQzgppWPqnOj+B0ji3bG2dkJFr+8PVCoYpG262+rtdc6lrIHxyMcRuNncxxCT73AoQgitlMKljwkOe05bqBG4I2IWUk08vzpZpMeHvHl2OqEIjBm1W+rudc2lo4HySPcBsNhzPAIQhT9etTWIbEJrWf/2Q=="></a>
												<a class="pull-right instaImage"
													href="<c:url value='/map'/>"><img
													src="data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAkGBwgHBgkIBwgKCgkLDRYPDQwMDRsUFRAWIB0iIiAdHx8kKDQsJCYxJx8fLT0tMT83Ojo6Iys/RD84QzQ5OjcBCgoKDQwNGg8PGjclHyU3Nzc3Nzc3MDc3Nzc4MDcwMTgwMTAwNzc3Nzc3MDE4ODAxNy8wMDgwMDY4MC8wLzIwMP/AABEIACgAKAMBEQACEQEDEQH/xAAZAAADAQEBAAAAAAAAAAAAAAADBAYFAQL/xAA1EAABAwEFBgMECwAAAAAAAAABAgMEEQAFBhKBExQhMUFRB6GxQlJUYRUWFyImdIORlNHS/8QAGQEAAwEBAQAAAAAAAAAAAAAAAwQFAgEG/8QALhEAAQMCAwcDAwUAAAAAAAAAAQACAwQRBRIhEzFBUXGR8BQi0RUywSRhcoGh/9oADAMBAAIRAxEAPwA+McYTLzvF9lh9xqC0sobbbJGehpU05k9rejpaWOFgJHuRPTOeuwsF4lmMpfXHajIUKgSnsqtQAaa24/EIGmwN+iyIYgdSmfqFfvxN3fyFf5sH6jHyKZYIBwPZLTMEYkisqeSw1JQkVO7PZlaAgV0tptfE423dU1G+lJtu6r1g7FM26rwZaekOOwXFhDjbhJyVNKivIjtblTAyVhIGqPUUTXNJA1Q/DuG1KxcwuQkKRGbW+AR7QoAdK1sKsmOzIHFBqGFkN+eizXnLxxLfBUouypcpw7JrMcqR0AHJKQOtg52xtsFUZDHTx3OgC3Ps/fzbD6XurfqV3TOc1e1eflYXqv2QRiDLZtm7Lz8+Uu0qPhmKlaFzY2JY0kbZjMdkpuvI+yUlPXnW3C8yHXcimJ1U7SxiI0PG/wA3RPECI1GxW6thISmS2h8ge8agnWlbMUsh2djwWcPu+mF+FwnPDiMW8QPqPWG4PNNpslVtDlQcQbanHUInh7GLUi8zHA30wVCMT3rxprlssyqMpITGKWyR5vtza+d1HuRykZhn3nN+ptPXNXzt1lW12hVsAf1/lvhVHiRm3i6t5pv30eN571qKV1zWaY6ykYQAWyZftzaedl3xHH4hjfkm/VVjwOsLLGFD9O7+R/C1MHhMa/W9p91LqFNV+ZoR6W8tS1I9SGu46IeINLqY24WKUMKbdE6qc7EhhZyOAcCO47giyMkk1NLY6EJsSQ1MfNpTzuJ30K2xuu798+JKONe/fzs4zFCdS0X5pduGMIy7R2Xl58KXdiT8QXrRO0ky5DgzuZeCR3PQADpajTVBeVTzw0kPJo3DzeSm8fSW5OKnUMKCkxm0MEj3hUkaVparEk8LjcykBdxJKtplxliS4pCCppSqpI6fK3kqyhfHISB7SpUVaHsAJ1TrUqc22ElaXAOW0TU/vbbK2qYLE36hLuihcb2t0QX7xnIBytR9Wz/dt/UJ+Q7IjKeE7ye6nr4v++9kppp5DCDwJYborQ8aWPFWyvNjp0VGnoaS+Yi/UrGwvheXed5tOOsLbgtrC3HFgjPxrQV5k97Won+xMV+IRwxkA3cV/9k="></a>
												<span class="product-price"> $$$ </span>
												<h3>${restaurant.name}</h3>

												<div class="small m-t-xs">
													<p>Opening: ${restaurant.opening} Closing:
														${restaurant.closing}</p>
													<p>Phone: ${restaurant.phoneNum1}</p>
													<p>Address: ${restaurant.address} ${restaurant.city}</p>
													<p>${restaurant.discription}</p>
												</div>
												<div class="m-t text-righ">

													<%-- <a
														href="<c:url value='/restaurant/main/${restaurant.restId}'/>"
														class="btn btn-xs btn-outline btn-primary">Enter <i
														class="fa fa-long-arrow-right"></i>
													</a> --%>
													<input id="address" value="${restaurant.zip}" hidden="true">
													<input id="id" value="${restaurant.restId}" hidden="true">
													<Button
														class="pull-left btn btn-primary "
														type="button" onclick="codeAddress()">Enter</Button>
												</div>

											</div>
										</div>

									</div>

								</div>
							</div>
						</div>
						<hr>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<h3>There's no restaurant near you, Sorry</h3>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
<script>
var geocoder;
var map;
function codeAddress() {
	geocoder = new google.maps.Geocoder();
	var address = document.getElementById('address').value;
	var id = document.getElementById('id').value;
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
										var lat = results[0].geometry.location
												.lat();
										var lan = results[0].geometry.location
												.lng();
										location.href = "main/" + id + "/"
												+ lat + "/" + lan + "/";
										/*
										 * window .open("map/" + lat + "/" + lan +
										 * "/", null,
										 * "height=200,width=400,status=yes,toolbar=no,menubar=no,location=no");
										 */
									}
								}
							}
						} else {
							alert('Invalid Zipcode');
						}
					});
}

</script>
	
</body>
</html>

