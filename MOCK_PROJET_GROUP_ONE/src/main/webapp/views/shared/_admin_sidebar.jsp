 <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="<%=request.getContextPath()%>/views/index.jsp">Group One Admin Page</a>
            </div>
            <!-- /.navbar-header -->

            <ul class="nav navbar-top-links navbar-right">
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li><a href="#"><i class="fa fa-user fa-fw"></i> User Profile</a>
                        </li>
                        <li><a href="#"><i class="fa fa-gear fa-fw"></i> Settings</a>
                        </li>
                        <li class="divider"></li>
                        <li><a href="login.html"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                        </li>
                    </ul>
                    <!-- /.dropdown-user -->
                </li>
                <!-- /.dropdown -->
            </ul>
            <!-- /.navbar-top-links -->

            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        <li class="sidebar-search">
                            <div class="input-group custom-search-form">
                                <input type="text" class="form-control" placeholder="Search...">
                                <span class="input-group-btn">
                                <button class="btn btn-default" type="button">
                                    <i class="fa fa-search"></i>
                                </button>
                            </span>
                            </div>
                            <!-- /input-group -->
                        </li>
                        <li>
                            <a href="../pages/admin-list-products.jsp"><i class="fa fa-table fa-fw"></i> List Product</a>
                        </li>
                        <li>
                            <a href="../pages/admin-list-order.jsp"><i class="fa fa-table fa-fw"></i> List Order</a>
                        </li>
                       	<li>
	                        <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne"><i class="fa fa-table fa-fw"></i> Content</a>
                    		<div id="collapseOne" class="panel-collapse collapse">
                        		<ul class="nav" id="side-menu">
                        			<li>
                        			     <a href="../pages/admin-add-product.jsp"><i class="fa fa-edit fa-fw"></i> Add Product</a>
                        			</li>
                        			<li>
  										<a href="../pages/admin-add-state.jsp"><i class="fa fa-edit fa-fw"></i> Add State</a>
                        			</li>
                        			<li>
										<a href="../pages/admin-add-manufacture.jsp"><i class="fa fa-edit fa-fw"></i> Add Manufacture</a>
                        			</li>
                        			<li>
										<a href="../pages/admin-add-country.jsp"><i class="fa fa-edit fa-fw"></i> Add Country</a>
                        			</li>
                        		</ul>
                        	</div>
                       	</li>
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>