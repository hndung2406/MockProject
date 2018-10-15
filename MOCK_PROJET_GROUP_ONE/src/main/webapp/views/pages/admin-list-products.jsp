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

	<script
    src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

    <script type="text/javascript">

    function fetchOldRecord(that){		
    		   $("#hiddenProductId").val($(that).parent().prev().prev().prev().prev().prev().text());
    		   $("#productName").val($(that).parent().prev().prev().prev().prev().text());
    		   $("#spec").val($(that).parent().prev().prev().prev().text());
    		   $("#description").val($(that).parent().prev().prev().text());
    		   $("#condition").val($(that).parent().prev().text());
           	}

	</script>

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
						<div class="panel-heading">
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
										<th>Description</th>
										<th>Quantity</th>
										<th>Condition</th>
										<th>Date Of Manufacture</th>
										<th>Spec</th>
										<th>Properties</th>
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
                                    		<td><c:out value="${product.getDescription()}"></c:out> </td>
                                    		<td><c:out value="${product.getQuantity()}"></c:out> </td>
                                    		<td><c:out value="${product.getCondition()}"></c:out> </td>
                                    		<td><c:out value="${product.getDateOfManufacture()}"></c:out> </td>
                                    		<td><c:out value="${product.getSpec()}"></c:out> </td>
                                    		<td><c:out value="${product.getProperties()}"></c:out> </td>
                                    		<td><c:out value="${product.getManufacture().getManufactureId()}"></c:out> </td>
                                    		<td><a href="showUpdateProduct?productId=${product.getId()}">Update</a> </td>
                                    		<td></td>
                                    	</tr>
                                    </c:forEach>
                                       <!--  <tr>
                                            <td>1</td>
                                            <td>IP 6</td>
                                            <td>IP Gold</td>
                                            <td>Made in china</td>
                                            <td>New</td>
                                            <td><button onclick='fetchOldRecord(this);' type="button" class="btn btn-primary" data-toggle='modal' data-target='#updateModal'>Edit</button></td>
                                            <td><button type="button" class="btn btn-primary">Delete</button></td>
                                        </tr> -->
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
                <div class="container" id="updateBlock">
    				<div class="modal fade" id="updateModal" role="dialog">
    					<div class="modal-dialog">
    						<div class="modal-content">
    							<div class="modal-header">
    								<button type="button" class="close" data-dismiss="modal">&times;</button>
    								<h4 class="modal-title">Update New Information</h4>
    							</div>
    							<div class="modal-body">
    									<input type="hidden" id="hiddenProductId"
    										name="id">
    										
    										<div class="form-group">
    										<label>Product Name</label>
    											<input type="text" name="productName" id="productName"
    												class="form-control input-sm" placeholder="Product Name">
    										</div>
    										<div class="form-group">
    											<label>Spec</label>
    											<textarea name="spec" id="spec"
    												class="form-control" placeholder="Spec">
    												</textarea>
    										</div>
    										<div class="form-group">
    											<label>Description</label>
    											<textarea name="productDescription" id="description"
    												class="form-control" placeholder="Description">
    												</textarea>
    										</div>
    								<div class="form-group">
    								<label>Condition</label>
    									<input name="condition" id="condition"
    										class="form-control" placeholder="Condition">
    								</div>
    								<button onclick="updateNewRecord();" class="btn btn-info btn-block">Update</button>
    								<div id="resp" class="text-center" style="margin-top: 13px;"></div>
    							</div>
    						</div>
    					</div>
    				</div>
    			</div>
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
