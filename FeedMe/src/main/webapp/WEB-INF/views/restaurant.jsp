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
						<c:if test="${restaurant.deliveryCharge==true}">
							<p>
								Home delivery <span class="glyphicon glyphicon-ok"></span>
							</p>
						</c:if>
						<c:if test="${restaurant.deliveryCharge==false}">
							<p>
								Home delivery <span class="glyphicon glyphicon-remove"></span>
							</p>
						</c:if>

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
						<div class="pull-left">
							<c:forEach begin="1" end="${starsOn}" varStatus="loop">
								<span class="glyphicon glyphicon-star "></span>
							</c:forEach>
							<c:forEach begin="1" end="${5-starsOn}" varStatus="loop">
								<span class="glyphicon glyphicon-star-empty"></span>
							</c:forEach>
							<div>
								<a
									href="<c:url value='/restaurant/thumbsUpRest/${restaurant.restId}'/>"
									class="btn btn-info btn thumbs"> <span
									class="glyphicon glyphicon-thumbs-up"></span></a> <a
									href="<c:url value='/restaurant/thumbsDownRest/${restaurant.restId}'/>"
									class="btn btn-info btn thumbs"> <span
									class="glyphicon glyphicon-thumbs-down"></span></a>
							</div>
						</div>
						<br> <br> <br>
					</div>

					<div class="well" id="menuDiv">
						<c:forEach items="${menu}" var="m">
							<hr>
							<div class="row">
								<div class="col-md-12">
									<div class="pull-left">${m.mealName}</div>
									<div class="pull-right">
										<a href="<c:url value='/restaurant/addCart/${m.meal_id}'/>"
											class="btn btn-info btn-lg addMeal"> <span
											class="glyphicon glyphicon-plus-sign"></span></a>
									</div>
									<p>$ ${m.price}</p>
								</div>
								<div class="pull-left">

									<c:forEach begin="1" end="${mealRating}" varStatus="loop">
										<span class="glyphicon glyphicon-star "></span>
									</c:forEach>
									<c:forEach begin="1" end="${5-mealRating}" varStatus="loop">
										<span class="glyphicon glyphicon-star-empty"></span>
									</c:forEach>
									<div>
										<a
											href="<c:url value='/restaurant/thumbsUpMeal/${m.meal_id}'/>"
											class="btn btn-info btn thumbs"> <span
											class="glyphicon glyphicon-thumbs-up"></span></a> <a
											href="<c:url value='/restaurant/thumbsDownMeal/${m.meal_id}'/>"
											class="btn btn-info btn thumbs"> <span
											class="glyphicon glyphicon-thumbs-down"></span></a>
									</div>
								</div>

								<p class="col-md-10">${m.discription}</p>
							</div>
						</c:forEach>
					</div>

					<!-- /.container -->


					<div class="well" id="ratingDiv">


						<c:url var="login" value="/restaurant/main/comment/${id}"></c:url>
						<form class="form-signin form-inline col-md-12" action="${login}"
							method="GET">

							<input type="text" class="form-control-lg col-md-10 input-lg"
								name="comment" placeholder="add a comment" required
								autocomplete="off" />

							<button class="btn btn-danger addMeal" type="submit">add
								comment</button>
						</form>

						<br>
						<hr>
						<c:forEach items="${rating}" var="rate">
							<hr>

							<div class="row ">
								<div class="col-md-12">
									<div class="pull-left">${rate.user.firstName}</div>
									<div class="pull-right">${rate.rateDate}</div>

									<p>${rate.review}</p>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- /.container -->
</body>
</html>

