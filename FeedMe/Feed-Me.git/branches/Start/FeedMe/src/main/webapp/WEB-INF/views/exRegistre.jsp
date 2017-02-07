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
	href="<%=request.getContextPath()%>/resources/styles/register.css" />
	<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/styles/header.css" />
	<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/styles/footer.css" />
<meta name="viewport" content="width=device-width, initial-scale=1"></head>
<body>
<div id="wrapper">
<div class="container-fluid">
<div class="container">

    <h1>Create account</h1>
    
	<div class="col-lg-12">
	<div class="row">
	<c:url var="login" value="/registered"></c:url>
				<form action="${login}" method="Post">
					<div class="col-sm-12">
						<div class="row">
						<c:if test="${!empty message}">
				<div class="alert alert-danger">
					<strong></strong> ${message}
				</div>
			</c:if>
							<div class="col-sm-6 form-group">
								<label>First Name</label>
								<input type="text" placeholder="Enter First Name Here.." name="firstName" class="form-control" required focus>
							</div>
							<div class="col-sm-6 form-group">
								<label>Last Name</label>
								<input type="text" placeholder="Enter Last Name Here.." name="lastName" class="form-control" required>
							</div>
						</div>					
						<div class="form-group">
							<label>Address</label>
							<textarea placeholder="Enter Address Here.." name="address" rows="3" class="form-control" required></textarea>
						</div>	
						<div class="row">
							<div class="col-sm-4 form-group">
								<label>City</label>
								<input type="text" placeholder="Enter City Name Here.." name="city" class="form-control" required>
							</div>	
							<div class="col-sm-4 form-group">
								<label>State</label>
								<input type="text" placeholder="Enter State Name Here.."  name="state" class="form-control" required>
							</div>	
							<div class="col-sm-4 form-group">
								<label>Zip</label>
								<input type="text" placeholder="Enter Zip Code Here.." name="zip" class="form-control" required>
							</div>		
						</div>
						<div class="row">
							<div class="col-sm-4 form-group">
								<label>Username</label>
								<input type="text" placeholder="Enter username Here.." name="userName" class="form-control" required>
							</div>	
							<div class="col-sm-4 form-group">
								<label>password</label>
								<input type="password" placeholder="Enter password Here.."  name="password" class="form-control" required>
							</div>	
							<div class="col-sm-4 form-group">
								<label>Confirm password</label>
								<input type="password" placeholder="confirm password Here.." name="password2" class="form-control" required>
							</div>		
						</div>						
					<div class="row">
							<div class="col-sm-6 form-group">
								<label>Phone number</label>
								<input type="text" placeholder="Enter phone number Here.." name="mobile" class="form-control" required>
							</div>
							<div class="col-sm-6 form-group">
								<label>Email</label>
								<input type="email" placeholder="Enter email Here.." name="email" class="form-control" required>
							</div>
						</div>
						<p></p>	
					<button type="submit" class="btn btn-lg btn-info">Register</button>					
					</div>
				</form> 
				</div>
				</div>
				</div>
				</div>
				

</div>
</body>
</html>
