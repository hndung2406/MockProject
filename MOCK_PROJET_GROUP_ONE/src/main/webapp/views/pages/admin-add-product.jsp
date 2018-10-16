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


<title>Add New Product</title>

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
						<div class="panel-heading" style="background-color: #7f5a83; color:orange; font-weight:bold">Input Product Information</div>
						<div class="panel-body">
							<div class="row">
								<div class="col-lg-12">
								<span><c:out value="${message}"></c:out> </span>
									<form role="form" class="form" action="admin-addProduct" method="post" enctype="multipart/form-data">
										<div class="form-group row">
											<div class="col-md-6">
												<label>Product Code</label> 
												<input class="form-control" name="product.id" id="productFormId" placeholder="Example P0001" required="required" pattern="(P[A-Za-z0-9]{2,4})|(p[A-Za-z0-9]{2,4})">
											</div>
											<div class="col-md-6">
												<label>Product Name</label> 
												<input class="form-control" name="product.name" placeholder="Product Name" required="required">
											</div>
										</div>
										<div class="form-group row">
											<div class="col-md-6">
												<label>Product Price</label> <input type="number" class="form-control" name="product.price" placeholder="Product Price" required="required">
											</div>
											<div class="col-md-6">
												<label>Product Quantity</label> <input type="number" class="form-control" name="product.quantity" placeholder="Product Quantity" required="required">
											</div>
										</div>
										<div class="form-group row">
											<div class="col-md-12">
												<label>Product Image</label> <input type="file" name="image" required="required">
											</div>
										</div>
										<div class="form-group row">
											<div class="col-md-12">
												<label>Date Of Manufacture</label> <input type="date" name="dateOfManufacture" required="required">
											</div>
										</div>
										<div class="form-group row">
											<div class="col-md-6">
												<label>Product Condition</label> <input class="form-control" name="product.condition" placeholder="Condition of Product" required="required">
											</div>
										</div>
										<div class="form-group row">
											<div class="col-md-12">
												<label>Product Description</label> 
												<textarea class="form-control" name="product.description" rows="3" required="required"></textarea>
											</div>
										</div>
										
										<div class="form-group row">
											<div class="col-md-12">
												<label>Product Spec</label> 
												<textarea class="form-control" name="product.spec" rows="3" required="required"></textarea>
											</div>
										</div>
										<div class="form-group row">
											<div class="col-md-12">
												<label>Product Properties</label>
												<textarea class="form-control" name="product.properties" rows="5" required="required"></textarea>
											</div>
										</div>
										<div class="form-group col-lg-2 row" style="padding-left: 0;">
											<div class="col-md-6">
												<label>Manufacturer</label>
												<select name="manufacture.manufactureId">
													<c:forEach items = "${manufactures}" var = "manufacture">
														<option value = "${manufacture.manufactureId}">${manufacture.manufactureName}</option>
													</c:forEach>
												</select>
											</div>
										</div>
										<div class="row col-lg-12" style="padding-left: 0;">
											<div class="col-md-6">
												<button type="submit" class="btn btn-default" style="background-color:#FFA500;font-weight:bold;">Submit</button>
												<button type="reset" class="btn btn-default" style="font-weight:bold;">Reset</button>
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
	<script src="../assets/css/vendors/jquery/jquery.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="../assets/css/vendors/bootstrap/js/bootstrap.min.js"></script>

</body>

</html>