<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "s" uri = "/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register page</title>
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
<s:head />
</head>
<body>	
	
	<!--Begin register section-->
	<div class="container register-form">
		<div class="row justify-content-center">
			
			<div class="col-5 mx-auto ">
				<a href="<%=request.getServletContext().getContextPath() %>/views/index.jsp">
					<img src="../assets/images/logo.svg" width="200px" height="200px" alt="Site-Logo" class="center">
				</a>
				<div class="card">
					<h4 class="card-header" style="border-top-left-radius: 20px; border-top-right-radius: 20px;">Start shopping with a Free Account</h4>
					<div class="card-body">
						<form action="registerUser" method="POST">
							<div class="form-group">
								<p class="name">Username</p>
								<s:textfield class="form-control" placeholder="Your username" name="user.userName" id="username"/>
								<span class="error-form" id="username-error">*Username is required</span>
								<span class="error-form" id="username-error-input"></span>
							</div>
							<div class="form-group">
								<p class="email">Email</p>
								<s:textfield class="form-control" placeholder="youremail@gmail.com" name="user.userEmail" id="email"/>
								<span class="error-form" id="email-error">*Email is required</span>
								<span class="error-form" id="email-error-input"></span>
							</div>
							<div class="row">
								<div class="form-group col-6">
									<p class="email">First Name</p>
									<input type="text" class="form-control" placeholder="First name" name="user.userFirstName" id="firstname">
									<span class="error-form" id="firstname-error">*First name is required</span>
								</div>
								<div class="form-group col-6">
									<p class="email">Last Name</p>
									<input type="text" class="form-control" placeholder="Last name" name="user.userLastName" id="lastname">
									<span class="error-form" id="lastname-error">*Last name is required</span>
								</div>
							</div>
							<div class="form-group">
								<p class="password">Password</p>
								<s:password class="form-control" placeholder="********" name="user.userPassword" id="password"/>
								<span class="error-form" id="password-error">*Password is required</span>
								<span class="error-form" id="password-error-input"></span>
							</div>
							<div class="form-group">
								<p class="repassword">Confirm Password</p>
								<s:password class="form-control" placeholder="********" name="userrepassword" id="repassword"/>
								<span class="error-form" id="repassword-error"></span>
							</div>
							<div class="wrapper">
                            	<button type="submit" class="button-sign-up" id="button-sign-up">Sign up</button>
                        	</div>
							<hr>
							<div class ="wrapper">
								<span class="account-existed">Already have an account? <a href="login.jsp">Sign in</a></span>
							</div>	
						</form>
					</div>

				</div>
			</div>
		</div>
	</div>
	<!--End register section-->
	
	<!-- Begin footer -->
	<jsp:include page="../shared/_footer.jsp"></jsp:include>
	<!-- End footer  -->

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
	<script src="<%=request.getContextPath()%>/views/assets/js/modules/register.js"></script>
</body>
</html>