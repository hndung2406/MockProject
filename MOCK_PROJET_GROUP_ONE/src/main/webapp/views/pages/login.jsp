<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login pages</title>
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
	
	
	<!--Begin login section-->
	<div class="container login-container sign-in-form">
		<div class="row ">
			<div class="col-5 mx-auto">
				<img src="../assets/images/logo.svg" width="200px" height="200px" alt="Site-Logo" class="center">			
				<div class="card">
					<h5 class="card-header" style="border-top-left-radius: 20px; border-top-right-radius: 20px;">Sign in to your account</h5>
					<div class="card-body">
						<form action="">
							<div class="form-group">
								<p class="email">Email</p>
								<input type="text" class="form-control" placeholder="youremail@gmail.com">
							</div>
							<div>
								<p class="password">Password</p>
								<input type="password" class="form-control" placeholder="********">
							</div>
						</form>
						<div class="custom-control custom-checkbox d-flex justify-content-between">
							<input type="checkbox" class="custom-control-input" id="customCheck1">
							<label class="custom-control-label" for="customCheck1">Keep me sign in</label>
							<a href="#"><span class="forgot-label">Forgot password?</span></a>
						</div>
						<div id="wrapper">
							<button type="button">Sign in</button>
						</div>
						<hr>
						<div id="wrapper">
							<span class="account-register">Don't have an account? <a href="register.jsp">Register here</a></span>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--End login section-->
	
	<!-- Begin footer -->
	<jsp:include page="../shared/_footer.jsp"></jsp:include>
	<!-- End footer  -->

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
	 crossorigin="anonymous"></script>
	
</body>
</html>