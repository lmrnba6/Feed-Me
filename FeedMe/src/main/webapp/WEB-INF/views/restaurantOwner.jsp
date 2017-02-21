<%@page import="com.journaldev.spring.model.*"%>
<%@page import="com.journaldev.spring.util.*"%>
<%@page import="com.journaldev.spring.model.*"%>
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

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/styles/restaurant.css" />

<script
	src="<%=request.getContextPath()%>/resources/scripts/restaurant.js"></script>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/styles/header.css" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<META Http-Equiv="Cache-Control" Content="no-cache" />
<META Http-Equiv="Pragma" Content="no-cache" />
<META Http-Equiv="Expires" Content="0" />

</head>
<body>

	<jsp:include page="header.jsp" />
	<jsp:include page="restaurantOwnerSider.jsp" />
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-9">
				<div class="thumbnail">
					<div class="imgDiv well col-md-12">
						<div class="pull-left">
							<c:forEach begin="1" end="${starsOn}" varStatus="loop">
								<span class="glyphicon glyphicon-star "></span>
							</c:forEach>
							<c:forEach begin="1" end="${5-starsOn}" varStatus="loop">
								<span class="glyphicon glyphicon-star-empty"></span>
							</c:forEach>
						</div>
						<img
							class="img-rounded restImage col-md-8 col-md-offset-2 d-relative width="
							60%" src="${restaurant.restImageUrl}">
						<button type="button" class="btn btn-default" id="changePicture">
							<span class="glyphicon glyphicon-camera"></span> Change photo
						</button>
						<div class="picture">
							<c:url var="picture" value="/restaurant/addPicture"></c:url>
							<form class="form-signin" action="${picture}" method="Post">
								<input tupe="text" name="photo"
									placeholder="Paste your URL's image here" />
								<button class="btn btn-success" type="submit">Submit</button>
							</form>
						</div>
					</div>
					<c:if test="${empty update}">
						<div class="col-md-12 well" id="infoDiv">
							<div class="login-page">
								<div id="wrapper">
									<div class="container-fluid">
										
										<div class="row">
											<c:if test="${!empty messageFailed}">
												<div class="alert alert-danger">
													<strong></strong> ${messageFailed}
												</div>
											</c:if>
											<c:if test="${!empty messageSuccess}">
												<div class="alert alert-success">
													<strong></strong> ${messageSuccess}
												</div>
											</c:if>
											<h1>Account</h1>
											<hr>
											<div class="col-sm-12">
												<c:url var="name" value="/restaurant/saveName"></c:url>
												<form action="${name}" method="GET">
													<div class="row" id="name">
														<div class="col-sm-4 form-group">
															<label>Restaurant's name</label> <input type="text"
																value="${restaurant.name}"
																placeholder="Enter the retaurant Name Here.."
																name="name" class="form-control" required
																disabled="disabled">
														</div>
														<div class="col-sm-3 form-group">
															<label>Phone number 1</label> <input type="number"
																value="${restaurant.phoneNum1}"
																placeholder="Enter your phone number Here.."
																name="phone1" class="form-control" required
																disabled="disabled">
														</div>
														<div class="col-sm-3 form-group">
															<label>Phone number 2</label> <input type="number"
																value="${restaurant.phoneNum2}"
																placeholder="Enter your phone number Here.."
																name="phone2" class="form-control" required
																disabled="disabled">
														</div>
														<div class="col-sm-1 form-group">
															<button type="button" id="editName"
																class="btn btn-warning">Edit</button>
														</div>
														<div class="col-sm-1 form-group">
															<button type="submit" class="btn btn-success"
																disabled="disabled">save</button>
														</div>
													</div>
												</form>
												<c:url var="address" value="/restaurant/saveAddress"></c:url>
												<form action="${address}" method="GET">
													<div class="row" id="address">
														<div class="col-sm-5 form-group">
															<label>Description</label>
															<textarea type="text"
																placeholder="Enter the retaurant description Here.."
																name="description" class="form-control" required
																disabled="disabled" rows="2">${restaurant.description}</textarea>
														</div>
														<div class="col-sm-5 form-group">
															<label>Address</label>
															<textarea type="text"
																placeholder="Enter your address Here.." name="address"
																class="form-control" required disabled="disabled"
																rows="2">${restaurant.address}</textarea>
														</div>

														<div class="col-sm-1 form-group">
															<button type="button" id="editAddress"
																class="btn btn-warning">Edit</button>
														</div>
														<div class="col-sm-1 form-group">
															<button type="submit" class="btn btn-success"
																disabled="disabled">save</button>
														</div>
													</div>
												</form>
												<c:url var="delivery" value="/restaurant/saveDelivery"></c:url>
												<form action="${delivery}" method="GET">
													<div class="row" id="delivery">
														<div class="col-sm-2 form-group">

															<label>Home delivery?</label><br> <select
																class="form-group" name="isHomeDelivery"
																disabled="disabled">
																<c:if test="${restaurant.homeDelivery}">
																	<option value="yes" selected="selected"
																		class="form-control">Yes</option>
																	<option value="no" class="form-control">No</option>
																</c:if>
																<c:if test="${!restaurant.homeDelivery}">
																	<option value="yes" class="form-control">Yes</option>
																	<option value="no" selected="selected"
																		class="form-control">No</option>
																</c:if>

															</select>

														</div>

														<div class="col-sm-2 form-group">

															<label>charge for delivery?</label><br> <select
																class="form-group" name="isChargeDelivery"
																disabled="disabled">
																<c:if test="${restaurant.deliveryCharge}">
																	<option value="yes" selected="selected"
																		class="form-control">Yes</option>
																	<option value="no" class="form-control">No</option>
																</c:if>
																<c:if test="${!restaurant.deliveryCharge}">
																	<option value="yes" class="form-control">Yes</option>
																	<option value="no" selected="selected"
																		class="form-control">No</option>
																</c:if>

															</select>
														</div>

														<div class="col-sm-2 form-group">
															<label>Delivery charge</label><br> <input
																type="number" value="${restaurant.chargeForDelivery}"
																placeholder="Enter your delivery charge Here.."
																name="deliveryCharge" class="form-control" required
																disabled="disabled">
														</div>

														<div class="col-sm-2 form-group">
															<label>Delivery time (minutes)</label> <input
																type="number" value="${restaurant.deliveryTime}"
																placeholder="Enter your delivery time Here.."
																name="deliveryTime" class="form-control" required
																disabled="disabled">
														</div>

														<div class="col-sm-2 form-group">
															<label>Category</label><br> <select
																class="form-group" name="category" disabled="disabled">
																<c:forEach items="${category}" var="cat">
																	<c:if
																		test="${restaurant.restCategory.restCategoryId == cat.restCategoryId}">
																		<option value="${cat.restCategoryId}"
																			selected="selected" class="form-control">${cat.name}</option>
																	</c:if>
																	<c:if
																		test="${restaurant.restCategory.restCategoryId != cat.restCategoryId}">
																		<option value="${cat.restCategoryId}"
																			class="form-control">${cat.name}</option>
																	</c:if>
																</c:forEach>
															</select>
														</div>
														<div class="col-sm-1 form-group">
															<button type="button" id="editDelivery"
																class="btn btn-warning">Edit</button>
														</div>
														<div class="col-sm-1 form-group">
															<button type="submit" class="btn btn-success"
																disabled="disabled">save</button>
														</div>
													</div>
												</form>
												<c:url var="city" value="/restaurant/saveCity"></c:url>
												<form action="${city}" method="GET">
													<div class="row" id="city">
														<div class="col-sm-3 form-group">
															<label>City</label> <input type="text"
																value="${restaurant.city}"
																placeholder="Enter the retaurant city Here.."
																name="city" class="form-control" required
																disabled="disabled">
														</div>
														<div class="col-sm-3 form-group">
															<label>Zip code</label> <input type="text"
																value="${restaurant.zip}"
																placeholder="Enter your zip code Here.." name="zip"
																class="form-control" required disabled="disabled">
														</div>
														<div class="col-sm-2 form-group">
															<label>Opening</label> <input type="time"
																value="${restaurant.opening}"
																placeholder="Enter your opening time Here.."
																name="opening" class="form-control" required
																disabled="disabled">
														</div>
														<div class="col-sm-2 form-group">
															<label>Closing</label> <input type="time"
																value="${restaurant.closing}"
																placeholder="Enter your opening time Here.."
																name="closing" class="form-control" required
																disabled="disabled">
														</div>
														<div class="col-sm-1 form-group">
															<button type="button" id="editCity"
																class="btn btn-warning">Edit</button>
														</div>
														<div class="col-sm-1 form-group">
															<button type="submit" class="btn btn-success"
																disabled="disabled">save</button>
														</div>
													</div>
												</form>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</c:if>
					<c:if test="${!empty update}">

						<div class="col-md-12 well">
							<h1>Edit Meal</h1>
							<br>
							<hr>
							<div id="mealFormj">
								<c:url var="meals"
									value="/restaurant/updateMeal/${mealToUpdate.meal_id}"></c:url>
								<form action="${meals}" method="GET">
									<div class="row" id="meal">
										<div class="col-sm-2 form-group">
											<label>Name</label> <input type="text"
												value="${mealToUpdate.mealName}" placeholder="Name.."
												name="name" class="form-control" required autofocus="autofocus">
										</div>
										<div class="col-sm-2 form-group">
											<label>Price</label> <input type="number"
												placeholder="price.." value="${mealToUpdate.price}"
												name="price" class="form-control" required>
										</div>

										<div class="col-sm-3 form-group">
											<label>Description</label> <input type="text"
												placeholder="Description.." name="description"
												value="${mealToUpdate.description}" class="form-control"
												required>
										</div>
										<div class="col-sm-2 form-group">
											<label>Photo</label> <input type="text" placeholder="URL.."
												name="photo" value="${mealToUpdate.mealImageUrl}"
												class="form-control" required>
										</div>
										<div class="col-sm-1 form-group">
											<label>Available</label> <select class="form-group"
												name="isAvailable">
												<option value="yes" class="form-control">Yes</option>
												<option value="no" class="form-control">No</option>
											</select>
										</div>
										<div class="col-sm-1 form-group">
											<button type="submit" class="btn btn-lg btn-success">
												<span class="glyphicon glyphicon-ok-sign"></span>
											</button>
										</div>
										<div class="col-sm-1 form-group">
											<a href="<c:url value='/restaurantOwner'/>" type="button" class="btn btn-lg btn-danger">
												<span class="glyphicon glyphicon-ban-circle"></span>
											</a>
										</div>

									</div>
								</form>
								<hr>
							</div>
						</div>
					</c:if>
					<c:if test="${empty update}">
						<div class="col-md-12 well" id="menuDiv">
							<div class="pull-left">
								<button type="button" class="btn btn-success pull-left"
									id="addMealPicture">
									<span class="glyphicon glyphicon-plus-sign"></span> Add new
									Meal
								</button>
							</div>
						<h1>Menu</h1>
							<br>
							<div id="mealForm" hidden="true">
							<hr>
							<h3>Add new meal</h3>
							<br>
								<c:url var="meals" value="/restaurant/saveMeal "></c:url>
								<form action="${meals}" method="GET">
									<div class="row" id="meal">
										<div class="col-sm-2 form-group">
											<label>Name</label> <input type="text" placeholder="Name.."
												name="name" class="form-control" required autofocus="autofocus">
										</div>
										<div class="col-sm-2 form-group">
											<label>Price</label> <input type="number"
												placeholder="price.." name="price" class="form-control"
												required>
										</div>

										<div class="col-sm-3 form-group">
											<label>Description</label> <input type="text"
												placeholder="Description.." name="description"
												class="form-control" required>
										</div>
										<div class="col-sm-3 form-group">
											<label>Photo</label> <input type="text" placeholder="URL.."
												name="photo" class="form-control" required>
										</div>
										<div class="col-sm-1 form-group">
											<label>Available</label> <select class="form-group"
												name="isAvailable">
												<option value="yes" class="form-control">Yes</option>
												<option value="no" class="form-control">No</option>
											</select>
										</div>
										<div class="col-sm-1 form-group">
											<button type="submit" class="btn btn-lg btn-success">
												<span class="glyphicon glyphicon-plus-sign"></span>
											</button>
										</div>
										

									</div>
								</form>

							</div>
							<c:forEach items="${menu}" var="m">
								<hr>
								<div class="row">
									<div class="col-md-12">
										<br>
										<div class="pull-left MealtName lead">${m.mealName}</div>
										<div class="pull-right">
											<a href="<c:url value='/restaurant/editMeal/${m.meal_id}'/>"
												class="btn btn-info btn-lg addMeal"> <span
												class="glyphicon glyphicon-pencil"></span></a> <a
												href="<c:url value='/restaurant/deleteMeal/${m.meal_id}'/>"
												class="btn btn-info btn-lg addMeal"> <span
												class="glyphicon glyphicon-trash"></span></a>

										</div>
										<p>$ ${m.price}</p>
									</div>
									<div class="pull-left d-inline mealImg ">
										<div class=" hidden-xs pull-left d-inline mealNames">
											<img src="${m.mealImageUrl}" alt="..." class="img-rounded"
												height="100px" width="200px" />
											<p></p>
											<c:forEach begin="1" end="${m.type}" varStatus="loop">
												<span class="glyphicon glyphicon-star "></span>
											</c:forEach>
											<c:forEach begin="1" end="${5-m.type}" varStatus="loop">
												<span class="glyphicon glyphicon-star-empty"></span>
											</c:forEach>

										</div>


									</div>

									<div class="col-lg-10 d-table">

										<p>${m.description}</p>
									</div>
								</div>

							</c:forEach>
						</div>
						<!-- /.container -->


						<div class="col-md-12 well" id="ratingDiv">
						<h1>Comments</h1>
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
					</c:if>
				</div>
			</div>
		</div>
	</div>

	<!-- /.container -->
</body>
</html>

