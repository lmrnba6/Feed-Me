<%@page import="com.journaldev.spring.model.ShoppingCart"%>
<%@page import="java.util.*,java.text.*,com.journaldev.spring.model.*"%>
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
	href="<%=request.getContextPath()%>/resources/styles/account.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/styles/header.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/styles/footer.css" />
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>

	<jsp:include page="header.jsp" />
	<c:if test="${!empty user}">
		<jsp:include page="accountSider.jsp" />
	</c:if>
	<center>
	<div class="col-sm-9">
	<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
<div class="container">
<%-- <%
ShoppingCart cart =(ShoppingCart) request.getSession().getAttribute("cart");
Set<Meal> list = cart.getMeals();
%> --%>
<c:choose>
	<c:when test="${cart.size!=0}">

	<table id="cart" class="table table-hover table-condensed">
    				<thead>
						<tr>
							<th style="width:50%">Product</th>
							<th style="width:10%">Price</th>
							<th style="width:8%">Quantity</th>
							<th style="width:22%" class="text-center">Subtotal</th>
							<th style="width:10%"></th>
						</tr>
					</thead>
					<c:forEach items="${cart.meals}" var="meal">	
					<tbody>
						<tr>
							<td data-th="Product">
								<div class="row">
									<div class="col-sm-4 hidden-xs"><img src="http://bk-ca-prd.s3.amazonaws.com/sites/burgerking.ca/files/Thumb_0000_Burgers.jpg" alt="..." class="img-responsive"/></div>
									<div class="col-sm-8">
										<h4 class="nomargin">Product 1</h4>
										<p>Quis aute iure reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Lorem ipsum dolor sit amet.</p>
									</div>
								</div>
							</td>
							<td data-th="Price">$ ${cart.price}</td>
							<td data-th="Quantity">
								<input type="number" class="form-control text-center" value="1">
							</td>
							<td data-th="Subtotal" class="text-center">${cart.price}</td>
							<td class="actions" data-th="">
								<button class="btn btn-info btn-sm"><i class="fa fa-refresh"></i></button>
								<button class="btn btn-danger btn-sm"><i class="fa fa-trash-o"></i></button>								
							</td>
						</tr>
					</tbody>
					<tfoot>
					</c:forEach>
						<tr class="visible-xs">
							<td class="text-center"><strong>Total ${cart.price}</strong></td>
						</tr>
						<tr>
							<td><a href="#" class="btn btn-warning"><i class="fa fa-angle-left"></i> Continue Shopping</a></td>
							<td colspan="2" class="hidden-xs"></td>
							<td class="hidden-xs text-center"><strong>Total $ ${cart.price}</strong></td>
							<td><a href="#" class="btn btn-success btn-block">Checkout <i class="fa fa-angle-right"></i></a></td>
						</tr>
					</tfoot>
				</table>
				</c:when>
<c:otherwise>
<h3>0 element in your cart</h3>
</c:otherwise>
	</c:choose>	
</div>
	</div>
	<jsp:include page="footer.jsp" />


</body>
</html>

