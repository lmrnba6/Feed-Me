<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
<title>Feed-Me!</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="<%=request.getContextPath()%>/resources/styles/test.css"
	type="text/css" rel="stylesheet">
<script src="<%=request.getContextPath()%>/resources/scripts/test.js"></script>
</head>
<body>
<div class="flipkart-navbar">
		<div class="container">
			<div class="row row1">
				<c:choose>
					<c:when test="${!empty user}">
						<ul class="pull-right">
							<li class="upper-links"><a class="links"
								href="logout">Logout</a></li>
							<li class="upper-links"><a class="links"
								href="#">Help</a></li>
							<li class="upper-links"><a class="links"
								href="https://github.com/chawlaaditya8/snippets"> <svg
										class="" width="16px" height="12px" style="overflow: visible;">
                            <path
											d="M8.037 17.546c1.487 0 2.417-.93 2.417-2.417H5.62c0 1.486.93 2.415 2.417 2.415m5.315-6.463v-2.97h-.005c-.044-3.266-1.67-5.46-4.337-5.98v-.81C9.01.622 8.436.05 7.735.05 7.033.05 6.46.624 6.46 1.325v.808c-2.667.52-4.294 2.716-4.338 5.98h-.005v2.972l-1.843 1.42v1.376h14.92v-1.375l-1.842-1.42z"
											fill="#fff"></path>
                        </svg>
							</a></li>
							<li class="upper-links"><a class="links"
								href="<c:url value='/account/info'/>">Hi
									${user.firstName}</a>
								</li>
						</ul>
					</c:when>
					<c:otherwise>
						<ul class="pull-right">
							<li class="upper-links"><a class="links"
								href="login">Login</a></li>
							<li class="upper-links"><a class="links"
								href="register">Register</a></li>
							<li class="upper-links"><a class="links"
								href="#">Help</a></li>
							<li class="upper-links"><a class="links"
								href="#"> <svg
										class="" width="16px" height="12px" style="overflow: visible;">
                            <path
											d="M8.037 17.546c1.487 0 2.417-.93 2.417-2.417H5.62c0 1.486.93 2.415 2.417 2.415m5.315-6.463v-2.97h-.005c-.044-3.266-1.67-5.46-4.337-5.98v-.81C9.01.622 8.436.05 7.735.05 7.033.05 6.46.624 6.46 1.325v.808c-2.667.52-4.294 2.716-4.338 5.98h-.005v2.972l-1.843 1.42v1.376h14.92v-1.375l-1.842-1.42z"
											fill="#fff"></path>
                        </svg>
							</a></li>
						</ul>
					</c:otherwise>
					</c:choose>
			</div>

			<div class="row row2">
				<div class="col-md-2">
					<a href="<c:url value='/'/>"><h1 style="margin: 0px;">Feed Me</h1></a>
				</div>
				<div class="flipkart-navbar-search col-md-8">
					<div class="row">
						<input class="flipkart-navbar-input col-md-11" type=""
							placeholder="Where are you?.." name="">
						<button class="flipkart-navbar-button col-md-1">
							<svg width="15px" height="15px">
                                <path
									d="M11.618 9.897l4.224 4.212c.092.09.1.23.02.312l-1.464 1.46c-.08.08-.222.072-.314-.02L9.868 11.66M6.486 10.9c-2.42 0-4.38-1.955-4.38-4.367 0-2.413 1.96-4.37 4.38-4.37s4.38 1.957 4.38 4.37c0 2.412-1.96 4.368-4.38 4.368m0-10.834C2.904.066 0 2.96 0 6.533 0 10.105 2.904 13 6.486 13s6.487-2.895 6.487-6.467c0-3.572-2.905-6.467-6.487-6.467 "></path>
                            </svg>
						</button>
					</div>
				</div>
				<div class="cart col-md-2">
					<a class="cart-button" href="<c:url value='/cart'/>"> <svg class="cart-svg " width="16 "
							height="16 " viewBox="0 0 16 16 ">
                            <path
								d="M15.32 2.405H4.887C3 2.405 2.46.805 2.46.805L2.257.21C2.208.085 2.083 0 1.946 0H.336C.1 0-.064.24.024.46l.644 1.945L3.11 9.767c.047.137.175.23.32.23h8.418l-.493 1.958H3.768l.002.003c-.017 0-.033-.003-.05-.003-1.06 0-1.92.86-1.92 1.92s.86 1.92 1.92 1.92c.99 0 1.805-.75 1.91-1.712l5.55.076c.12.922.91 1.636 1.867 1.636 1.04 0 1.885-.844 1.885-1.885 0-.866-.584-1.593-1.38-1.814l2.423-8.832c.12-.433-.206-.86-.655-.86 "
								fill="#fff "></path>
                        </svg> 
                        <c:if test="${!empty cart}">
                        <span class="item-number ">0 items</span>
                        </c:if>
                        <c:if test="${empty cart}">
                        <span class="item-number ">${cart.size} items</span>
                        </c:if>
					</a>
				</div>

			</div>
		</div>
	</div>

</body>
</html>