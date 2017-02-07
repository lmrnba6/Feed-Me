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
	href="<%=request.getContextPath()%>/resources/styles/restaurant.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/styles/header.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/styles/footer.css" />
<script
	src="<%=request.getContextPath()%>/resources/scripts/restaurant.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>

	<jsp:include page="header.jsp" />
	<jsp:include page="restaurantSider.jsp" />
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-9">

				<div class="thumbnail">
					<img class="img-responsive"
						src="http://kalustyans.com/image/cache/catalog/category/super-foods-800x200.jpg"
						alt="">
					<div class="caption-full">
						<h4>
							<a href="#">${restaurant.name}</a>
						</h4>
						<p>Opening: ${restaurant.opening} Closing:
							${restaurant.closing}</p>
						<p>delivery Charge: ${restaurant.deliveryCharge}</p>
						<p>Phone: ${restaurant.phoneNum1}</p>
						<p>Address: ${restaurant.address}</p>
						<c:if test="${restaurant.homeDelivery==true}">
							<p>
								Home delivery <span class="glyphicon glyphicon-ok"></span>
							</p>
						</c:if>
						<c:if test="${restaurant.homeDelivery==false}">
							<p>
								Home delivery <span class="glyphicon glyphicon-remove"></span>
							</p>
						</c:if>
						<p>Description: ${restaurant.discription}</p>
					</div>
					
					<div class="well" id="menuDiv" style="display: none;">

						<c:forEach items="${menu}" var="m">
							<hr>

							<div class="row">
								<div class="col-md-12">
									
									fghfghfg <span class="pull-right"><div class="text-right">
							<a href="<c:url value='/restaurant/addCart/${m.meal_id}'/>" class="btn btn-success">Add to cart</a>
						</div></span>
									<p>fhgfhfgh</p>
								</div>
							</div>
						</c:forEach>
					</div>

					<!-- /.container -->


					<div class="well" id="ratingDiv" style="display: none;">

						<div class="text-right">
							<a class="btn btn-success">Leave a Review</a>
						</div>
						<c:forEach items="${rating}" var="rate">
							<hr>

							<div class="row">
								<div class="col-md-12">

									<c:forEach begin="1" end="${rate.ratingValue}" varStatus="loop">
										<span class="glyphicon glyphicon-star"></span>
									</c:forEach>
									<c:forEach begin="1" end="${5-rate.ratingValue}"
										varStatus="loop">
										<span class="glyphicon glyphicon-star-empty"></span>
									</c:forEach>
									${rate.user.firstName} <span class="pull-right">${rate.rateDate}</span>
									<p>${rate.review}</p>
								</div>
							</div>
						</c:forEach>
					</div>

				</div>

			</div>

		</div>
		<!-- /.container -->

		<div class="container">

			<hr>

			<!-- Footer -->
			<footer>
				<div class="row">
					<div class="col-lg-12">
						<p>Copyright &copy; Your Website 2014</p>
					</div>
				</div>
			</footer>

		</div>
</body>
</html>

