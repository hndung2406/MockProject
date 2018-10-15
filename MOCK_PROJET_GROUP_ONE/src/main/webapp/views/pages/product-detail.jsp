<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${product.name}</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
<link rel="stylesheet" href="<%=request.getServletContext().getContextPath()%>/views/assets/css/main.css"/>
</head>
<body>	
	
	<!--Begin header -->
	<jsp:include page="../shared/_header.jsp"></jsp:include>
	<!-- End header -->
	
	<!--Begin product detail section-->
	<div class="container product-detail product-detail-container">
		<h3 class="product-title">${product.name}</h3>
		<hr>
		<div class="row">
			<div class="col-6">
				<div class="product-image">
					<img src="/images/${product.getImageUrl()}" alt="" class="image" width="300px" height="400px">
				</div>
			</div>
			<div class="col-6">
				<h3>${product.name}</h3>
				<p>By ${manufacture.manufactureName}</p>
				<h4 class="product-price"><span>$</span>${product.price}</h4>
				<hr>
				<p class="description">All you need to know about the new ${product.name}:</p>
				<ul class="list-description">
					<c:forEach items = "${productProperties}" var="properties">
						<li><c:out value="${properties}"></c:out></li>
					</c:forEach>
				</ul>
				<hr>
				<div id="wrapper">
					<button class="button-cart">Add to cart</button>
				</div>
			</div>
		</div>
		<hr>
		<ul class="nav nav-pills mb-3 red" id="pills-tab" role="tablist">
			<li class="nav-item">
				<a class="nav-link active tab-header" id="pills-home-tab" data-toggle="pill" href="#pills-home" role="tab" aria-controls="pills-home"
				 aria-selected="true">Description</a>
			</li>
			<li class="nav-item">
				<a class="nav-link tab-header" id="pills-profile-tab" data-toggle="pill" href="#pills-profile" role="tab" aria-controls="pills-profile"
				 aria-selected="false">Spec</a>
			</li>
		</ul>
		<div class="tab-content mobile-specification" id="pills-tabContent">
			<div class="tab-pane fade show active" id="pills-home" role="tabpanel" aria-labelledby="pills-home-tab">
				${product.description}
			</div>
			<div class="tab-pane fade" id="pills-profile" role="tabpanel" aria-labelledby="pills-profile-tab">
				<ul class="product-spec">
					<c:forEach items = "${productSpec}" var="spec">
						<li><c:out value="${spec}"></c:out></li>
					</c:forEach>
				</ul>
			</div>
		</div>

	</div>
	<!--End product detail section-->
	
	<!-- Begin footer -->
	<jsp:include page="../shared/_footer.jsp"></jsp:include>
	<!-- End footer  -->

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>	
	<script src="<%=request.getContextPath()%>/views/assets/js/modules/header.js"></script>
	<script src="<%=request.getContextPath()%>/views/assets/js/modules/index.js"></script>
</body>
</html>