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
					<h1 class="page-header">Edit User Profile</h1>
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
												<input class="form-control" name="user.userName" required="required" value="<s:property value="user.userName"/>">
											</div>
										</div>
										<div class="form-group row">
											<div class="col-md-6">
												<label>First Name</label> 
												<input class="form-control" name="user.userFirstName" placeholder="Your First Name" required="required" value="<s:property value="user.userFirstName"/>">
											</div>
											<div class="col-md-6">
												<label>Last Name</label> 
												<input class="form-control" name="user.userLastName" placeholder="Your Last Name" required="required" value="<s:property value="user.userLastName"/>">
											</div>
										</div>
										<div class="form-group row">
											<div class="col-md-6">
												<label>Old Password</label>
												<input type="password" class="form-control" placeholder="Your Old Password" required="required" id="old-password">
												<span id="old-password-error" style="color:red;font-size:13px;padding-left:10px"></span>
											</div>
										</div>
										<div class="form-group row">
											<div class="col-md-6">
												<label>Password</label>
												<input type="password" class="form-control" name="user.userPassword" placeholder="Your New Password" required="required" id="password">
												<span id="password-error" style="color:red;font-size:13px;padding-left:10px"></span>
											</div>
										</div>
										<div class="form-group row">
											<div class="col-md-6">
												<label>Confirm Password</label>
												<input type="password" class="form-control" placeholder="Confirm Password" required="required" id="confirm-password">
												<span id="confirm-password-error" style="color:red;font-size:13px;padding-left:10px"></span>
											</div>
										</div>
										<div class="form-group row">
											<div class="col-md-12">
												<input type="hidden" class="form-control" name="user.userEmail" value="<s:property value="user.userEmail"/>">
												<input type="hidden" class="form-control" name="user.userCreateDate" value="<s:property value="user.userCreateDate"/>">
												<input type="hidden" class="form-control" name="user.userId" value="<s:property value="user.userId"/>">
											</div>
										</div>
										<div class="row col-lg-12" style="padding-left: 0;">
											<div class="col-md-6">
												<button type="submit" class="btn btn-default" style="background-color:#FFA500;font-weight:bold;" id="update-button">Update</button>
												<button type="reset" class="btn btn-default" style="font-weight:bold;">Reset</button>
											</div>
										</div>
										<span style="padding-left:20px; color:red">${message}</span>
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

	<!-- Javascript-->
	<script src="<%=request.getServletContext().getContextPath()%>/views/assets/js/modules/user.js"></script>
	
</body>

</html>