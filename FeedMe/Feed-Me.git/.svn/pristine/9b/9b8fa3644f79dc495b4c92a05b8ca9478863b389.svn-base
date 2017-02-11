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
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/styles/account.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/styles/header.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/styles/footer.css" />
	<script
	src="<%=request.getContextPath()%>/resources/scripts/account.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
		<jsp:include page="header.jsp" />
		<jsp:include page="accountSider.jsp" />
<div class="col-sm-9">
	<div class="login-page">
		<div class="form" id="accountInfo">
			<div id="wrapper">
				<div class="container-fluid">
					<jsp:include page="header.jsp" />
					<div class="container">

						<h1 class="well">Payment</h1>

						<div class="col-lg-12 well">
							<div class="row">
								<c:if test="${!empty message}">
									<div class="alert alert-success">
										<strong></strong> ${message}
									</div>
								</c:if>
								<c:url var="login" value="/account/method/save"></c:url>
								<form action="${login}" method="GET">
									<div class="col-sm-12">
										<div class="row">
											<div class="col-sm-6 form-group">
												<label>First Name</label> <input type="text"
													value="${user.firstName}"
													placeholder="Enter First Name Here.." name="firstName"
													class="form-control" required focus disabled="disabled">
											</div>
											<div class="col-sm-6 form-group">
												<label>Last Name</label> <input type="text"
													value="${user.lastName}"
													placeholder="Enter Last Name Here.." name="lastName"
													class="form-control" required disabled="disabled">
											</div>
										</div>
										
										<div class="row">
											<div class="col-sm-12 form-group">
												<label>Credit card number</label> <input type="number"
													value="${card.number}"
													placeholder="Enter Last Name Here.." name="number"
													class="form-control" required disabled="disabled">
											</div>											
										</div>
										<div class="row">
											<div class="col-sm-4 form-group">
												<label>Month</label> <input type="number"
													value="${card.month}"
													placeholder="Enter Month Here.." name="month"
													class="form-control" required disabled="disabled">
											</div>
											<div class="col-sm-4 form-group">
												<label>Year</label> <input type="number"
												value="${card.year}"
													placeholder="Enter Year Here.." name="year"
													class="form-control" required disabled="disabled">
											</div>
										<div class="col-sm-4 form-group">
												<label>CVV</label> <input type="number"
												value="${card.cvv}"
													placeholder="Enter CVV Code Here.." name="cvv"
													class="form-control" required disabled="disabled">
											</div>
										</div>
										
										<p></p>
										<button type="submit" class="btn btn-lg btn-info">Save</button>
									</div>
								</form>
							</div>
							<p></p>
							<button type="button" id="editCard" class="btn btn-warning">Edit</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>
		<jsp:include page="footer.jsp" />

</body>
</html>
