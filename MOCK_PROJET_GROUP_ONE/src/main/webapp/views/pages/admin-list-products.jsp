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
	<title>List Products</title>
	<!-- Bootstrap Core CSS -->
	<link href="../assets/css/vendors/bootstrap/css/bootstrap.min.css" rel="stylesheet">

	<!-- Custom CSS -->
	<link href="../assets/css/admin.css" rel="stylesheet">

	<!-- Custom Fonts -->
	<link href="../assets/css/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

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
						<div class="panel-heading" style="background-color: #7f5a83; color:orange; font-weight:bold">
							DataTables Advanced Tables
						</div>
						<!-- /.panel-heading -->
						<div class="panel-body">
							<table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
								<thead>
									<tr>
										<th>Image</th>
										<th>Id</th>
										<th>Name</th>
										<th>Price</th>
										<th>Quantity</th>
										<th>Condition</th>
										<th>Date Of Manufacture</th>
										<th>ManufactureId</th>
										<th>Update</th>
										<th>Delete</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${products}" var="product">
										<tr>
											<td><img width="50px" height="50px" alt="Product Image" src="/images/${product.getImageUrl()}" /> </td>
											<td><c:out value="${product.getId()}"></c:out> </td>
											<td><c:out value="${product.getName()}"></c:out> </td>
                                    		<td><c:out value="${product.getPrice()}"></c:out> </td>
                                    		<td><c:out value="${product.getQuantity()}"></c:out> </td>
                                    		<td><c:out value="${product.getCondition()}"></c:out> </td>
                                    		<td><c:out value="${product.getDateOfManufacture()}"></c:out> </td>
                                    		<td><c:out value="${product.getManufacture().getManufactureId()}"></c:out> </td>
                                    		<td><a href="admin-showUpdateProduct?productId=${product.getId()}">Update</a> </td>
                                    		<td><a href="admin-showDeleteProduct?productId=${product.getId()}">Delete</a></td>
                                    	</tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                                <!-- /.table-responsive -->
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

         <!-- DataTables JavaScript -->
         <script src="../assets/css/vendors/datatables/js/jquery.dataTables.min.js"></script>
         <script src="../assets/css/vendors/datatables-plugins/dataTables.bootstrap.min.js"></script>
     
     
         <!-- Page-Level Demo Scripts - Tables - Use for reference -->
         <script>
         $(document).ready(function() {
             $('#dataTables-example').DataTable({
                 responsive: true
             });
         });
         </script>

    </body>

    </html>
