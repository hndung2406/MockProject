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
	
	<!--Begin cart section-->
	<div class="container cart-container">
		<div class="row">
			<div class="col-12">
				<div class="check-cart">
					<h2 class="shopping-cart">Shopping Cart</h2>
					<table class="table table-cart" id="table-cart">
						<thead style="background-color:#FFC550">
							<th scope="col" style="text-align: center; color: white">Items</th>
							<th scope="col" style="color: white">Price</th>
							<th scope="col" style="color: white">Quantity</th>
							<th scope="col" style="color: white">Subtotal</th>
							<th scope="col"></th>
						</thead>
						<tbody>
							<tr>
								<td>
									<div class="row">
										<div class="col-4">
											<img src="../assets/images/xs_6.png">
										</div>
										<div class="col-6">
											<p><a href="product-detail.jsp">Apple iPhone X, Fully Unlocked 5.8", 64 GB - Silver</a></p>
											<p class=" short-description">Some short description here</p>
											<span class="span-instock">Instock</span>
										</div>
									</div>
								</td>
								<td><span>$</span><span>1300</span></td>
								<td>
									<input type="number" name="quantity" min="1" max="5" value="1" class="input-drop-down">
								</td>
								<td><span>$</span><span class="price">1300</span></td>
								<td><button type="button" class="btn btn-danger btn-remove"><img src="../assets/images/trash-2x.png"></button></td>
							</tr>
							<tr>
								<td>
									<div class="row">
										<div class="col-4">
											<img src="../assets/images/bphone.png">
										</div>
										<div class="col-6">
											<p><a href="">Bphone</a></p>
											<p class=" short-description">Some short description here</p>
											<span class="span-instock">Instock</span>
										</div>
									</div>
								</td>
								<td><span>$</span><span>1300</span></td>
								<td>
									<input type="number" name="quantity" min="1" max="5" value="1" class="input-drop-down">
								</td>
								<td><span>$</span><span class="price">1300</span></td>
								<td><button type="button" class="btn btn-danger btn-remove"><img src="../assets/images/trash-2x.png"></button></td>
							</tr>
							<tr>
								<td>
									<div class="row">
										<div class="col-4">
											<img src="../assets/images/huawei.jpg">
										</div>
										<div class="col-6">
											<p><a href="">Huawei</a></p>
											<p class=" short-description">Some short description here</p>
											<span class="span-instock">Instock</span>
										</div>
									</div>
								</td>
								<td><span>$</span><span>1300</span></td>
								<td>
									<input type="number" name="quantity" min="1" max="5" value="1" class="input-drop-down">
								</td>
								<td><span>$</span><span class="price">1300</span></td>
								<td><button type="button" class="btn btn-danger btn-remove"><img src="../assets/images/trash-2x.png"></button></td>
							</tr>
						</tbody>
					</table>
					<!--End table-->
				</div>
				<!--Summary-->
			</div>
			<!--End check-->
		</div>
		<!--End row-->
		<div class="row summary-row justify-content-end">
			<div class="col-9">
				<a href="index.html"><button class="button-shopping">Continue shopping</button></a>
			</div>
			<div class="col-3">
				<div class="card card-summary">
					<div class="card-header">
						<h3><u>Summary</u></h3>
					</div>
					<div class="card-body">
						<div class="row">
							<div class="col-6">
								<p>Quantity:</p>
							</div>
							<div class="col-6">
								<p><span id="quantity">3</span> <span>items</span></p>
							</div>
						</div>
						<hr>
						<div class="row">
							<div class="col-6">
								<p>Total order:</p>
							</div>
							<div class="col-6">
								<h5><span>$</span><span id="total-order">3900</span></h5>
							</div>
						</div>
						<hr>
						<a href="checkOut"><button class="button-checkout">Check out</button></a>
					</div>
				</div>
			</div>
		</div>
		<!--End row-->
	</div>
	<!--End cart section-->
	
	<!-- Begin footer -->
	<jsp:include page="../shared/_footer.jsp"></jsp:include>
	<!-- End footer  -->

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
	 crossorigin="anonymous"></script>	
	<script src="../assets/js/modules/_cart.js"></script>
</body>
</html>