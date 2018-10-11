<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
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

<title>SB Admin 2 - Bootstrap Admin Theme</title>

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
					<h1 class="page-header">Add new Product</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">Input Product Information</div>
						<div class="panel-body">
							<div class="row">
								<div class="col-lg-12">
								<span><c:out value="${message}"></c:out> </span>
									<form role="form" class="form col-lg-11" action="addProduct" method="post" enctype="multipart/form-data">
										<div class="form-group row">
											<label>Product Code</label> 
											<input class="form-control" name="productForm.id" id="productFormId" placeholder="Example P0001" required="required" pattern="(P[A-Za-z0-9]{2,4})|(p[A-Za-z0-9]{2,4})">
										</div>
										<div class="form-group row">
											<label>Product Name</label> <input class="form-control"
												name="productForm.name" placeholder="Product Name" required="required">

										</div>
										<div class="form-group row">
											<label>Product Price</label> <input type="number" class="form-control"
												name="productForm.price" placeholder="Product Price" required="required">

										</div>
										<div class="form-group row">
											<label>Product Image</label> 
											<input type="file" name="productForm.image" required="required">
										</div>
										<div class="form-group row">
											<label>Date Of Manufacture</label> 
											<input type="date" name="dateOfManufacture" required="required">
										</div>
										<div class="form-group row">
											<label>Product Quantity</label> 
											<input type="number" class="form-control" name="productForm.quantity" placeholder="Product Quantity" required="required">
										</div>
										<div class="form-group row">
											<label>Product Condition</label> 
											<input class="form-control" name="productForm.condition" placeholder="Condition of Product" required="required">
										</div>
										<div class="form-group row">
											<label>Product Spec</label> 
											<textarea class="form-control" name="productForm.spec" required="required"></textarea>
										</div>
										<div class="form-group row">
											<label>Product Description</label> 
											<textarea class="form-control" name="productForm.description" required="required"></textarea>
										</div>
										<div class="form-group row">
											<label>Product Properties</label>
											<textarea class="form-control" name="productForm.properties" rows="3" required="required"></textarea>
										</div>

										<div class="form-group col-lg-2 row" style="padding-left: 0;">
											<label>Manufacturer</label>
											<select name="manufacture.manufactureId">
												<c:forEach items = "${manufactures}" var = "manufacture">
													<option value = "${manufacture.manufactureId}">${manufacture.manufactureName}</option>
												</c:forEach>
											</select>
										</div>
										<div class="row col-lg-12" style="padding-left: 0;">
											<button type="submit" class="btn btn-default">Submit Button</button>
											<button type="reset" class="btn btn-default">Reset Button</button>
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

</body>

</html>