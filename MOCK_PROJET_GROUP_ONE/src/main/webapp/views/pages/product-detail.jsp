<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cart page</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<link
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet"
	integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN"
	crossorigin="anonymous">
<link rel="stylesheet" href="<c:url value="../assets/css/main.css"/>">
</head>
<body>	
	
	<!--Begin header -->
	<jsp:include page="../shared/_header.jsp"></jsp:include>
	<!-- End header -->
	
	<!--Begin product detail section-->
	<div class="container product-detail product-detail-container">
		<h3 class="product-title">Apple iPhone XS</h3>
		<hr>
		<div class="row">
			<div class="col-6">
				<div class="product-image">
					<img src="../assets/images/xs_6_big.png" alt="" class="image">
				</div>
			</div>
			<div class="col-6">
				<h3>Apple iPhone X, Fully Unlocked 5.8", 64 GB - Silver</h3>
				<p>By <a href="https://www.apple.com/">Apple</a></p>
				<h4 class="product-price">$1200</h4>
				<hr>
				<p class="description">All you need to know about the new iPhone:</p>
				<ul class="list-description">
					<li>An all‑new 5.8‑inch Super Retina screen with all-screen OLED Multi-Touch display</li>
					<li>12MP wide-angle and telephoto cameras with Dual optical image stabilization</li>
					<li>Wireless Qi charging</li>
					<li>Splash, water, and dust resistant</li>
					<li>Sapphire crystal lens cover</li>
				</ul>
				<hr>
				<span class="description">Color: </span>
				<span>gold</span>
				<div class="row row-color">
					<div class="col-2">
						<img src="../assets/images/silver.png" alt="" class="color-show">
					</div>
					<div class="col-2">
						<img src="../assets/images/black.jpeg" alt="" class="color-show">
					</div>
					<div class="col-2">
						<img src="../assets/images/gold.jpeg" alt="" class="color-show">
					</div>
				</div>
				<div id="wrapper">
					<button class="button-cart"><img src="../assets/images/cart-2x.png"> Add to cart</button>
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
			<div class="tab-pane fade show active" id="pills-home" role="tabpanel" aria-labelledby="pills-home-tab">Our vision
				has always been to create an iPhone that is entirely screen. One so immersive the device itself disappears into the
				experience. And so intelligent it can respond to a tap, and even a glance. With iPhone X, that vision is now a
				reality. Say hello to the future.</div>
			<div class="tab-pane fade" id="pills-profile" role="tabpanel" aria-labelledby="pills-profile-tab">
				<ul class="product-spec">
					<li>Super retina display: Our vision has always been to create an iPhone that is entirely screen. One so immersive
						the device itself disappears into the experience. And so intelligent it can respond to a tap, and even a glance.
						With iPhone X, that vision is now a reality. Say hello to the future.</li>
					<li>Innovative Technology: The display employs new techniques and technology to precisely follow the curves of the
						design, all the way to the elegantly rounded corners.</li>
					<li>OLED Designed for iPhone X: The first OLED screen that rises to the standards of iPhone, with accurate,
						stunning colors, true blacks, high brightness, and a 1,000,000 to 1 contrast ratio.</li>
					<li>TrueDepth Camera: A tiny space houses some of the most sophisticated technology we’ve ever developed,
						including the cameras and sensors that enable Face ID.</li>
					<li>All-New Design: The most durable glass ever in a smartphone, front and back. Surgical‑grade stainless steel.
						Wireless charging. Water and dust resistance.</li>
					<li>Intuitive Gestures: Familiar gestures make navigation natural and intuitive. Instead of pressing a button, a
						single swipe takes you home from anywhere.</li>
				</ul>
			</div>
		</div>

	</div>
	<!--End product detail section-->
	
	<!-- Begin footer -->
	<jsp:include page="../shared/_footer.jsp"></jsp:include>
	<!-- End footer  -->

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
	 crossorigin="anonymous"></script>	
	<script src="../assets/js/modules/_cart.js"></script>
</body>
</html>