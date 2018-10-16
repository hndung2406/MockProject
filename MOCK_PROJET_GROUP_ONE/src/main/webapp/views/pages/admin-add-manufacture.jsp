<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@page isELIgnored="false" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

    <!DOCTYPE html>
    <html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Add Manufacture</title>

        <!-- Bootstrap Core CSS -->
        <link href="../assets/css/vendors/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="../assets/css/admin.css" rel="stylesheet">

        <!-- Custom Fonts -->
        <link href="../assets/css/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    </head>

    <body>

        <div id="wrapper">

            <!-- Begin navigation -->
           <jsp:include page="../shared/_admin_sidebar.jsp"></jsp:include>
           <!-- End navigation -->
            <div id="page-wrapper">
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">Add New Manufacture</h1>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                <!-- /.row -->
                <div class="row">
                    <div class="col-lg-12">
                        <div class="panel panel-default">
                            <div class="panel-heading" style="background-color: #7f5a83; color:orange; font-weight:bold">
                                Input Manufacture Information
                            </div>
                            <div class="panel-body">
                                <div class="row">
                                    <div class="col-lg-12">
                                        <form role="form" class="form col-lg-11" action="admin-addManufacture" method="post">
                                            <div class="form-group row">
                                                <label>Manufacture Name</label>
                                                <input class="form-control" name="manufacture.manufactureName" placeholder="Manufacture Name" id="manufacture">   
                                            </div>
                                            
                                            <div class="row col-lg-12" style="padding-left:0;">
                                                <button type="submit" class="btn btn-default" id="submit-button" style="background-color:#FFA500;font-weight:bold;">Submit</button>
                                                <button type="reset" class="btn btn-default" style="font-weight:bold;">Reset</button>
                                            </div>
                                            
                                            <div class="row col-lg-12" style="padding-left:10;">
                                            	<span style="color:red" id="error"></span>
                                            	<span style="color:red"><c:out value="${message}"></c:out> </span>
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
        <script src="<%=request.getContextPath()%>/views/assets/js/modules/admin-add-manufacture.js"></script>
        
    </body>

    </html>
