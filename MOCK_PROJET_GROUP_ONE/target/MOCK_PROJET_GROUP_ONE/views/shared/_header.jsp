<header id="site-header">
	<div class="container site-header__container">
		<div class="row justify-content-end site-header--top">
			<span class="site-header__icon">
				<a href="<%=request.getServletContext().getContextPath() %>/views/pages/login.jsp" class="site-header__icon--link"><i class="fa fa-users"></i> Login</a>
			</span>					
		</div>
		<div class="row site-header--main">
			<div class="col-3 site-header__brand">

				<a href="<%=request.getServletContext().getContextPath() %>/views/index.jsp">
					<img class="site-header__brand-image" src="<%=request.getServletContext().getContextPath() %>/views/assets/images/logo.svg" alt="Logo site">
				</a>
				
			</div>

			<div class="col-6 site-search ">
				<div class="input-group site-search__body">
					<div class="input-group-prepend ">
						<button class="btn btn-outline-secondary border dropdown-toggle site-search__btn--category" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Category</button>
						<div class="dropdown-menu">
							<a class="dropdown-item" href="#">Mobile</a>
							<a class="dropdown-item" href="#">Another action</a>
							<a class="dropdown-item" href="#">Something else here</a>
							<div role="separator" class="dropdown-divider"></div>
							<a class="dropdown-item" href="#">Separated link</a>
						</div>
					</div>
					<input class="site-search__input form-control py-2 border-right-0 border " type="search" value="Search">
					<span class="input-group-append">
						<div class="input-group-text "><i class="fa fa-search"></i></div>
					</span>
				</div>
			</div>
			<div class="col-3 d-flex flex-column justify-content-center text-center">
				<div class="site-header__cart">
					<span>
						<a href="<%=request.getServletContext().getContextPath() %>/views/pages/cart.jsp" ><i class="fa fa-cart-plus" ></i> My cart</a>
					</span>
					<span class="site-header__cart--text">(0 items)</span>
				</div>
				
			</div>
			
		</div>
	</div>
</header> <!-- End header-->