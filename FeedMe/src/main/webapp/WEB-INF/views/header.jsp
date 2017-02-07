<%@page import="com.journaldev.spring.model.ShoppingCart"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="true"%>
<script src="<%=request.getContextPath()%>/resources/scripts/account.js"></script>
<html>
<head>
<body>
	<%
		ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
	if(cart==null){
		cart= new ShoppingCart();
		cart.setPrice(0d);
		cart.setSize(0);
	}
	%>
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="<c:url value='/'/>"><img
					src="<%=request.getContextPath()%>/resources/images/Logo.png" height="70" width="150" >
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<!-- <li><a href="test">Feed-Me</a></li> -->
				</ul>
				<ul class=" nav navbar-nav navbar-right navbar-collapse">
					<c:choose>
						<c:when test="${!empty user}">
							<li><a href="logout"><span
									class="glyphicon glyphicon-log-in"></span> Logout </a></li>
							<li><a href="<c:url value='/account/info'/>"><span
									class="glyphicon glyphicon-user"></span> Hi ${user.firstName}</a></li>

							<li><a href="<c:url value='/account/cart'/>"><span
									class="glyphicon glyphicon-shopping-cart"></span>
									<%=cart.getSize() %> items</a></li>
							<li><a href=""><span class="glyphicon glyphicon-book"></span>
									Help </a></li>
						</c:when>
						<c:otherwise>
							<li><a href="login"><span
									class="glyphicon glyphicon-log-in"></span> Login</a></li>
							<li><a href="register"><span
									class="glyphicon glyphicon-log-in"></span> Register</a></li>
							<li><a href="<c:url value='/account/cart'/>"><span
									class="glyphicon glyphicon-shopping-cart"></span>
									<%=cart.getSize()%> items</a></li>
							<li><a href="register"><span
									class="glyphicon glyphicon-book"></span> Help</a></li>
						</c:otherwise>
					</c:choose>
				</ul>
			</div>
		</div>
	</nav>
</body>
</html>
