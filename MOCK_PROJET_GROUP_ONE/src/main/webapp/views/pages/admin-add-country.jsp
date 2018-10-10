<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Add Country</title>

<!-- Bootstrap Core CSS -->
<link href="../assets/css/vendors/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom CSS -->
<link href="../assets/css/admin.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="../assets/css/vendors/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">

</head>

<body>

	<div id="wrapper">

		<!-- Begin navigation -->
		<jsp:include page="../shared/_admin_sidebar.jsp"></jsp:include>
		<!-- End navigation -->
		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">Add New Country</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">Input Country Information</div>
						<div class="panel-body">
							<div class="row">
								<div class="col-lg-12">
									<form role="form" class="form col-lg-11" action="addCountry"
										method="post">
										<div class="form-group row">
											<label>Country Name</label> <input class="form-control"
												name="country.countryName" placeholder="Country Name"
												id="country">
										</div>

										<div class="row col-lg-12" style="padding-left: 0;">
											<button type="submit" class="btn btn-default"
												id="submit-button">Submit Button</button>
											<button type="reset" class="btn btn-default">Reset
												Button</button>
										</div>

										<div class="row col-lg-12" style="padding-left: 10;">
											<span style="color: red" id="error"></span> <span
												style="color: red"><c:out value="${message}"></c:out>
											</span>
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
	<script src="../assets/css/vendors/jquery/jquery.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="../assets/css/vendors/bootstrap/js/bootstrap.min.js"></script>

	<!-- Javascript -->
	<script
		src="<%=request.getContextPath()%>/views/assets/js/modules/admin-add-country.js"></script>

</body>

</html>
