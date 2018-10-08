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
	
	<!--Begin checkout section-->
	<div class="container payment-information checkout-container">
		<h3 class="payment-title">Enter your payment information</h3>
		<hr>
		<p style="font-weight: bold" class="credit-information">Credit or Debit Card information:</p>
		<div class="row">
			<div class="col-8">
				<div class="row justify-content-center row-max">
					<div class="col-2">
						<p>First Name</p>
					</div>
					<div class="col-6">
						<input type="text" class="form-control form-control-sm">
					</div>
				</div>
				<div class="row justify-content-center row-max">
					<div class="col-2">
						<p>Last Name</p>
					</div>
					<div class="col-6">
						<input type="text" class="form-control form-control-sm">
					</div>
				</div>
				<div class="row justify-content-center row-max">
					<div class="col-2">
						<p>Card Number</p>
					</div>
					<div class="col-6">
						<input type="text" class="form-control form-control-sm">
					</div>
				</div>
				<div class="row justify-content-center row-max">
					<div class="col-2">
						<p>Expires</p>
					</div>
					<div class="col-3">
						<select class="form-control form-control-sm">
							<option>1</option>
							<option>2</option>
							<option>3</option>
							<option>4</option>
							<option>5</option>
							<option>6</option>
							<option>7</option>
							<option>8</option>
							<option>9</option>
							<option>10</option>
							<option>11</option>
							<option>12</option>
						</select>
					</div>
					<div class="col-3">
						<select class="form-control form-control-sm">
							<option>2018</option>
							<option>2019</option>
							<option>2020</option>
							<option>2021</option>
						</select>
					</div>
				</div>
				<div class="row justify-content-center row-max">
					<div class="col-2">
						<p>Security Code</p>
					</div>
					<div class="col-3">
						<input type="text" class="form-control form-control-sm">
					</div>
					<div class="col-3">

					</div>
				</div>
			</div>
			<div class="col-4">
				<div class="card card-summary">
					<div class="card-header" style="border-top-left-radius: 20px; border-top-right-radius: 20px;">
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
					</div>
				</div>
			</div>
		</div>
		<p style="font-weight: bold" class="credit-information">Billing Information:</p>
		<div class="row">
			<div class="col-8">
				<div class="row justify-content-center row-max">
					<div class="col-2">
						<p>Country</p>
					</div>
					<div class="col-6">
						<select class="form-control form-control-sm">
							<option>Vietnam</option>
							<option>United States</option>
							<option>United Kingdom</option>
							<option>Japan</option>
						</select>
					</div>
				</div>
				<div class="row justify-content-center row-max">
					<div class="col-2">
						<p>Company</p>
					</div>
					<div class="col-6">
						<input type="text" class="form-control form-control-sm" placeholder="Optional">
					</div>
				</div>
				<div class="row justify-content-center row-max">
					<div class="col-2">
						<p>Billing Addr</p>
					</div>
					<div class="col-6">
						<input type="text" class="form-control form-control-sm" placeholder="Address line 1">
					</div>
				</div>
				<div class="row justify-content-center row-max">
					<div class="col-2">

					</div>
					<div class="col-6">
						<input type="text" class="form-control form-control-sm" placeholder="Address line 2">
					</div>
				</div>
				<div class="row justify-content-center row-max">
					<div class="col-2">
						<p>City</p>
					</div>
					<div class="col-6">
						<input type="text" class="form-control form-control-sm">
					</div>
				</div>
				<div class="row justify-content-center row-max">
					<div class="col-2">
						<p>State</p>
					</div>
					<div class="col-3">
						<select class="form-control form-control-sm">
							<option>IL</option>
							<option>AL</option>
							<option>CA</option>
							<option>FL</option>
						</select>
					</div>
					<div class="col-3">

					</div>
				</div>
				<div class="row justify-content-center row-max">
					<div class="col-2">
						<p>Postal Code</p>
					</div>
					<div class="col-3">
						<input type="text" class="form-control form-control-sm">
					</div>
					<div class="col-3">

					</div>
				</div>
				<div class="row justify-content-center row-max">
					<div class="col-2">
						<p>Phone</p>
					</div>
					<div class="col-3">
						<input type="text" class="form-control form-control-sm">
					</div>
					<div class="col-3">

					</div>
				</div>
				<div class="row justify-content-center row-max">
					<div class="col-2">
						
					</div>
					<div class="col-3">
						<button class="btn-submit" style="font-weight: bold;">Submit</button>
						<button class="btn-cancel" style="font-weight: bold;">Cancel</button>
					</div>
					<div class="col-3">
						
					</div>
				</div>
			</div>
			<div class="col-4">

			</div>
		</div>
	</div>
	<!--End checktou section-->
	
	<!-- Begin footer -->
	<jsp:include page="../shared/_footer.jsp"></jsp:include>
	<!-- End footer  -->

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
	 crossorigin="anonymous"></script>	
	
</body>
</html>