<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>	
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">


<title>User Profile</title>

<!-- Bootstrap Core CSS -->
<link href="<%=request.getServletContext().getContextPath()%>/views/assets/css/vendors/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="<%=request.getServletContext().getContextPath()%>/views/assets/css/admin.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="<%=request.getServletContext().getContextPath()%>/views/assets/css/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
	
</head>

<body>

	<div id="wrapper">

		<!-- Begin navigation -->
		<jsp:include page="../shared/_user_sidebar.jsp"></jsp:include>
		<!-- End navigation -->
		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">User Profile</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading" style="background-color: #7f5a83; color:orange; font-weight:bold">User Information</div>
						<div class="panel-body">
							<div class="row">
								<div class="col-lg-12">
									<form role="form" class="form" action="updateUser" method="post" enctype="multipart/form-data">
										<div class="form-group row">
											<div class="col-md-12">
												<label>Username</label>
												<p>${user.userName}</p>
											</div>
										</div>
										<div class="form-group row">
											<div class="col-md-6">
												<label>First Name</label> 
												<p>${user.userFirstName}</p>
											</div>
											<div class="col-md-6">
												<label>Last Name</label> 
												<p>${user.userLastName}</p>
											</div>
										</div>
										<div class="form-group row">
											<div class="col-md-6">
												<label>Email</label>
												<p>${user.userEmail}</p>
											</div>
										</div>
										<div class="form-group row">
											<div class="col-md-6">
												<label>Password</label>
												<p>${user.userPassword}</p>
											</div>
										</div>
										<div class="form-group row">
											<div class="col-md-6">
												<label>Create Date</label>
												<p>${user.userCreateDate}</p>
											</div>
										</div>
									</form>
								</div>
								<!-- /.col-lg-6 (nested) -->

							</div>
							<!-- /.row (nested) -->
						</div>
						<!-- /.panel-body -->
					</div>
					<!-- /.panel -->
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
		</div>
		<!-- /#page-wrapper -->

	</div>
	<!-- /#wrapper -->

	<!-- jQuery -->
	<script src="<%=request.getServletContext().getContextPath()%>/views/assets/css/vendors/jquery/jquery.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="<%=request.getServletContext().getContextPath()%>/views/assets/css/vendors/bootstrap/js/bootstrap.min.js"></script>

</body>

</html>