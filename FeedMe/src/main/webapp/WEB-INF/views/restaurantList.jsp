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
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/styles/header.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/styles/footer.css" />
<meta name="viewport" content="width=device-width, initial-scale=1">
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
												<img
													src=https://b.zmtcdn.com/data/pictures/9/16619359/a0bbef8466850dc5493c331757614c74.jpg?fit=around%7C200%3A200&crop=200%3A200%3B*%2C*
													alt="600x300" class="img-responsive">
											</div>
											<div class="product-desc">
												<span class="product-price"> $$$ </span> 
												<h3>
													${restaurant.name}
												</h3>

												<div class="small m-t-xs">
													<p>Opening: ${restaurant.opening} Closing:
														${restaurant.closing}</p>
													<p>Phone: ${restaurant.phoneNum1}</p>
													<p>Address: ${restaurant.address} ${restaurant.city}</p>
													<p>${restaurant.discription}</p>
												</div>
												<div class="m-t text-righ">

													<a
														href="<c:url value='/restaurant/main/${restaurant.restId}'/>"
														class="btn btn-xs btn-outline btn-primary">Enter <i
														class="fa fa-long-arrow-right"></i>
													</a>
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


</body>
</html>

