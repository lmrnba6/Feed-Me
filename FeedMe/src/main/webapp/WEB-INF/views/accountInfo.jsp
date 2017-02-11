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

<script src="<%=request.getContextPath()%>/resources/scripts/account.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
	<jsp:include page="header.jsp" />
	<jsp:include page="accountSider.jsp" />
	<div class="col-md-9">
		<div class="login-page">
			<div id="wrapper">
				<div class="container-fluid">
					<jsp:include page="header.jsp" />
					<div class="container">

						<h1 class="well">Account</h1>

						<div class="col-lg-12">
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
								<div class="col-sm-12">
									<c:url var="name" value="/account/info/saveName"></c:url>
									<form action="${name}" method="GET">
										<div class="row" id="name">
											<div class="col-sm-5 form-group">
												<label>First name</label> <input type="text"
													value="${user.firstName}"
													placeholder="Enter First Name Here.." name="firstName"
													class="form-control" required disabled="disabled">
											</div>
											<div class="col-sm-5 form-group">
												<label>Last Name</label> <input type="text"
													value="${user.lastName}"
													placeholder="Enter Last Name Here.." name="lastName"
													class="form-control" required disabled="disabled">
											</div>
											<div class="col-sm-1 form-group">
												<button type="button" id="editName" class="btn btn-warning">Edit</button>
											</div>
											<div class="col-sm-1 form-group">
												<button type="submit" class="btn btn-success"
													disabled="disabled">save</button>
											</div>
										</div>
									</form>
									<c:url var="address" value="/account/info/saveAddress"></c:url>
									<form action="${address}" method="GET">
										<div class="row" id="address">
											<div class="col-sm-10 form-group">
												<label>Address</label>
												<textarea placeholder="Enter Address Here.." name="address"
													rows="3" class="form-control" required disabled="disabled">${user.address}</textarea>
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
									<c:url var="zip" value="/account/info/saveZip"></c:url>
									<form action="${zip}" method="GET">
										<div class="row" id="zip">
											<div class="col-sm-4 form-group">
												<label>City</label> <input type="text" value="${user.city}"
													placeholder="Enter City Name Here.." name="city"
													class="form-control" required disabled="disabled">
											</div>
											<div class="col-sm-4 form-group">
												<label>State</label> <input type="text"
													value="${user.state}" placeholder="Enter State Name Here.."
													name="state" class="form-control" required
													disabled="disabled">
											</div>
											<div class="col-sm-2 form-group">
												<label>Zip</label> <input type="text" value="${user.zip}"
													placeholder="Enter Zip Code Here.." name="zip"
													class="form-control" required disabled="disabled">
											</div>
											<div class="col-sm-1 form-group">
												<button type="button" id="editZip" class="btn btn-warning">Edit</button>
											</div>
											<div class="col-sm-1 form-group">
												<button type="submit" class="btn btn-success"
													disabled="disabled">save</button>
											</div>
										</div>
									</form>
									<c:url var="password" value="/account/info/savePassword"></c:url>
									<form action="${password}" method="GET">
										<div class="row" id="password">

											<div class="col-sm-5 form-group">
												<label>Old password</label> <input type="password"
													placeholder="Enter password Here.." name="oldPassword"
													class="form-control" required disabled="disabled">
											</div>
											<div class="col-sm-5 form-group">
												<label>New password</label> <input type="password"
													placeholder="confirm password Here.." name="newPassword"
													class="form-control" required disabled="disabled">
											</div>
											<div class="col-sm-1 form-group">
												<button type="button" id="editPassword"
													class="btn btn-warning">Edit</button>
											</div>
											<div class="col-sm-1 form-group">
												<button type="submit" class="btn btn-success"
													disabled="disabled">save</button>
											</div>
										</div>
									</form>
									<c:url var="email" value="/account/info/saveEmail"></c:url>
									<form action="${email}" method="GET">
										<div class="row" id="email">
											<div class="col-sm-5 form-group">
												<label>Phone number</label> <input type="number"
													value="${user.mobile}"
													placeholder="Enter phone number Here.." name="mobile"
													class="form-control" required disabled="disabled">
											</div>
											<div class="col-sm-5 form-group">
												<label>Email</label> <input type="email"
													value="${user.email}" placeholder="Enter email Here.."
													name="email" class="form-control" required
													disabled="disabled">
											</div>
											<div class="col-sm-1 form-group">
												<button type="button" id="editEmail" class="btn btn-warning">Edit</button>
											</div>
											<div class="col-sm-1 form-group">
												<button type="submit" class="btn btn-success"
													disabled="disabled">save</button>
											</div>
										</div>
									</form>
									<p></p>
									<div class="row">
										<div class="col-sm-12 form-group">
											<!-- <button type="submit" class="btn btn-success" id="save" disabled="disabled">Save</button> -->
											<a href="<c:url var="login" value="/account/info"></c:url>"
												class="btn btn-danger btn-lg">Cancel</a>
										</div>

									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
