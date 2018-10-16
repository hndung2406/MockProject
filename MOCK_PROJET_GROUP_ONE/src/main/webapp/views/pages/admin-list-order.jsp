<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>List Order</title>

    <!-- Bootstrap Core CSS -->
	<link href="<%=request.getServletContext().getContextPath()%>/views/assets/css/vendors/bootstrap/css/bootstrap.min.css" rel="stylesheet">

	<!-- Custom CSS -->
	<link href="<%=request.getServletContext().getContextPath()%>/views/assets/css/admin.css" rel="stylesheet">

	<!-- Custom Fonts -->
	<link href="<%=request.getServletContext().getContextPath()%>/views/assets/css/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

</head>

<body>

    <div id="wrapper">

        <!-- Navigation -->
        <jsp:include page="../shared/_admin_sidebar.jsp"></jsp:include>

        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Product Management</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
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
                                        <th>Order Id</th>
                                        <th>Product Name</th>
                                        <th>Quantity</th>
                                        <th>Price</th>
                                        <th>Order Date</th>
                                        <th>Payment Status</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>1</td>
                                        <td>IP 6</td>
                                        <td>2</td>
                                        <td>120000</td>
                                        <td>1/1/1</td>
                                        <td>Paid</td>
                                    </tr>
                                    <tr>
                                        <td>2</td>
                                        <td>SamSung Galaxy</td>
                                        <td>1</td>
                                        <td>23000</td>
                                        <td>1/1/1</td>
                                        <td>Not Paid</td>
                                    </tr>
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
    <script src="<%=request.getServletContext().getContextPath()%>/views/assets/css/vendors/jquery/jquery.min.js"></script>
    
    <!-- Bootstrap Core JavaScript -->
    <script src="<%=request.getServletContext().getContextPath()%>/views/assets/css/vendors/bootstrap/js/bootstrap.min.js"></script>

    <!-- DataTables JavaScript -->
    <script src="<%=request.getServletContext().getContextPath()%>/views/assets/css/vendors/datatables/js/jquery.dataTables.min.js"></script>
         
    <script src="<%=request.getServletContext().getContextPath()%>/views/assets/css/vendors/datatables-plugins/dataTables.bootstrap.min.js"></script>
	
 
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
