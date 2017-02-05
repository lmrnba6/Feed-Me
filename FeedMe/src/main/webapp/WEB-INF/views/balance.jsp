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
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
		<jsp:include page="header.jsp" />
		<jsp:include page="accountSider.jsp" />
		
				<div class="col-sm-9">
	<div class="login-page">
		<div class="form" id="accountInfo">

			<c:url var="login" value="/account/method/save"></c:url>
			<div id="wrapper">
				<div class="container-fluid">
					<jsp:include page="header.jsp" />
					<div class="container">

						<h1 class="well">Balance</h1>

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
								<c:url var="login" value="/account/balance"></c:url>
								<form action="${login}" method="GET">
									<div class="col-sm-12">
										<div class="row">
											
											<h1>Your balance is: <h1 id="balance"> $ ${user.balance}</h1></h1>
											<br>
											<div class="col-sm-12 form-group">
												<label>Gift card number</label> <input type="text"
													
													placeholder="Enter the number Here.." name="giftCard"
													class="form-control" required disabled="disabled">
											</div>
										</div>
								
										<p></p>
										<button type="submit" class="btn btn-lg btn-info btn-block custom">Redeem</button>
									</div>
								</form>
							</div>
							<p></p>
							<button type="button" id="editCard" class="btn btn-lg btn-warning btn-block custom ">Edit</button>
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
