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

<title>Update Product</title>

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
					<h1 class="page-header">Update Product</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading" style="background-color: #7f5a83; font-weight:bold"><a href="admin-products" style="color:orange;">Back To List Products</a></div>
						<div class="panel-body">
							<div class="row">
								<div class="col-lg-12">
								<span><c:out value="${message}"></c:out> </span>
									<form role="form" class="form" action="admin-updateProduct" method="post" enctype="multipart/form-data">
										<div class="form-group row">
											<div class="col-md-6">
												<label>Product Code</label> 
												<input class="form-control" name="product.id" value="${product.getId()}" id="productFormId" placeholder="Example P0001" readonly="readonly">
											</div>
											<div class="col-md-6">
												<label>Product Name</label> 
												<input class="form-control" name="product.name" value="${product.getName()}" placeholder="Product Name" required="required">
											</div>
										</div>
										<div class="form-group row">
											<div class="col-md-6">
												<label>Product Price</label> 
												<input type="number" class="form-control" name="product.price" value="${product.getPrice()}" placeholder="Product Price" required="required">
											</div>
											<div class="col-md-6">
												<label>Product Quantity</label> 
												<input type="number" class="form-control" name="product.quantity" value="${product.getQuantity()}" placeholder="Product Quantity" required="required">
											</div>
										</div>
										<div class="form-group row">
											<div class="col-md-12">
												<label>Product Image</label> 
											
												<input type="file" name="image" onchange="previewFile()"> <br>
												<img id="uploadImage" src = "/images/${product.getImageUrl()}" width="100px" height="100px" />
												<input type="hidden" name="product.imageUrl" value="${product.getImageUrl()}">
											</div>
										</div>
										<div class="form-group row">
											<div class="col-md-12">
												<label>Date Of Manufacture</label> 
												<input type="date" name="dateOfManufacture" value="${product.getDateOfManufacture()}" required="required">
											</div>
										</div>
										<div class="form-group row">
											<div class="col-md-6">
												<label>Product Condition</label> 
												<input class="form-control" name="product.condition" value="${product.getCondition()}" placeholder="Condition of Product" required="required">
											</div>
										</div>
										<div class="form-group row">
											<div class="col-md-12">
												<label>Product Description</label> 
												<textarea class="form-control" name="product.description" rows="4" placeholder="Product Description" required="required">${product.getDescription()}</textarea>
											</div>
										</div>
										
										<div class="form-group row">
											<div class="col-md-12">
												<label>Product Spec</label> 
												<textarea class="form-control" name="product.spec" rows="4" placeholder="Product Spec" required="required">${product.getSpec()} </textarea>
											</div>
										</div>
										<div class="form-group row">
											<div class="col-md-12">
												<label>Product Properties</label>
												<textarea class="form-control" name="product.properties" rows="5" required="required">${product.getProperties()}</textarea>
											</div>
										</div>
										<div class="form-group col-lg-2 row" style="padding-left: 0;">
											<div class="col-md-6">
												<label>Manufacturer</label>
												<select name="manufacture.manufactureId">
												<option value="${product.getManufacture().getManufactureId()}" selected>${product.getManufacture().getManufactureName()}</option>
												<c:forEach items = "${manufactures}" var = "manufacture">
													<c:if test="${manufacture.manufactureId != product.getManufacture().getManufactureId()}">
														<option value = "${manufacture.manufactureId}">${manufacture.manufactureName}</option>
													</c:if>
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
	<script src="../assets/js/modules/admin-update-product.js"></script>
	<!-- Bootstrap Core JavaScript -->
	<script src="../assets/css/vendors/bootstrap/js/bootstrap.min.js"></script>

</body>

</html>