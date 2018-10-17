<header id="site-header">
	<div class="container site-header__container">
		<div class="row justify-content-end site-header--top">
			<span class="site-header__icon">
				<a href="<%=request.getServletContext().getContextPath() %>/views/pages/login.jsp" class="site-header__icon--link" id="login-link">
				<i class="fa fa-users"></i><span id="login"> Login</span> </a>
			</span>
		</div>
		<div class="row site-header--main">
			<div class="col-3 site-header__brand">
				<a href="<%=request.getServletContext().getContextPath() %>/views/home">
					<img class="site-header__brand-image" src="<%=request.getServletContext().getContextPath() %>/views/assets/images/logo.svg"
					 alt="Logo site">
				</a>
			</div>

			<div class="col-6 site-search ">
				<div class="input-group site-search__body">
					<div class="input-group-prepend">
						<button class="btn btn-outline-secondary border dropdown-toggle site-search__btn--category" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Category</button>
							<div class="dropdown-menu">
								<a class="dropdown-item" href="#">Mobile</a>
								<a class="dropdown-item" href="#">Another action</a>
								<a class="dropdown-item" href="#">Something else here</a>
								<div role="separator" class="dropdown-divider"></div>
								<a class="dropdown-item" href="#">Separated link</a>
							</div>
					</div>
					<input class="site-search__input form-control py-2 border-right-0 border " type="search" placeholder="Search" id="search">
					<div class="input-group-text "><i class="fa fa-search"></i></div>
				</div>
				<div class="input-group site-search__body">
					<ul class="list-group" id="result" style="position:absolute; width:75%; margin-left:103px; box-sizing: border-box;  z-index: 1001; overflow-y: auto; max-height: 400px;"></ul>
				</div>
			</div>
			<div class="col-3 d-flex flex-column justify-content-center text-center">
				<div class="site-header__cart">
					<span>
						<a href="showCart"><i class="fa fa-cart-plus"></i>
							My cart</a>
					</span>
					<span id="number-product-in-cart" class="site-header__cart--text">(<span id="quantity">0</span> items)</span>
				</div>

			</div>

		</div>
	</div>
</header> <!-- End header-->