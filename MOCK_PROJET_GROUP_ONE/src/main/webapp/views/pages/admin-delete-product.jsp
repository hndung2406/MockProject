<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>List Products</title>
<!-- Bootstrap Core CSS -->
<link
	href="<%=request.getServletContext().getContextPath()%>/views/assets/css/vendors/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom CSS -->
<link
	href="<%=request.getServletContext().getContextPath()%>/views/assets/css/admin.css"
	rel="stylesheet">

<!-- Custom Fonts -->
<link
	href="<%=request.getServletContext().getContextPath()%>/views/assets/css/vendors/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">

</head>

<body>

	<div id="wrapper">

		<jsp:include page="../shared/_admin_sidebar.jsp"></jsp:include>

		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">Product Management</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading"
							style="background-color: #7f5a83; color: orange; font-weight: bold">
							DataTables Advanced Tables</div>
						<!-- /.panel-heading -->
						<div class="panel-body">
							<form action="admin-deleteProduct" method="post">
								<input type="hidden" name="product.id" value="${product.id}">
								<h3 class="product-title">${product.name}</h3>
								<hr>
								<div class="row">
									<div class="col-md-4">
										<div class="product-image">
											<img src="/images/${product.getImageUrl()}" alt=""
												class="image" width="300px" height="400px">
										</div>
									</div>
									<div class="col-md-8">
										<h3>${product.name}</h3>
										<p>By ${manufacture.manufactureName}</p>
										<h4 class="product-price">
											<span>$</span>${product.price}</h4>
										<hr>
										<p class="description" style="font-weight: bold;">Information
											about ${product.name}:</p>
										<ul class="">
											<li>${product.description}</li>
											<li>${product.spec}</li>
											<li>${product.properties}</li>
										</ul>
										<hr>
										<div id="wrapper">
											<label>Are You Sure Want To Delete This Product?</label><br>
											<button class="btn btn-default button-cart"
												style="background-color: #FFA500; font-weight: bold;">Delete</button>
										</div>
									</div>
								</div>
							</form>
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
	</div>
	<!-- /#wrapper -->

	<!-- jQuery -->
	<script
		src="<%=request.getServletContext().getContextPath()%>/views/assets/css/vendors/jquery/jquery.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script
		src="<%=request.getServletContext().getContextPath()%>/views/assets/css/vendors/bootstrap/js/bootstrap.min.js"></script>

	<!-- DataTables JavaScript -->
	<script
		src="<%=request.getServletContext().getContextPath()%>/views/assets/css/vendors/datatables/js/jquery.dataTables.min.js"></script>

	<script
		src="<%=request.getServletContext().getContextPath()%>/views/assets/css/vendors/datatables-plugins/dataTables.bootstrap.min.js"></script>

</body>
</html>
